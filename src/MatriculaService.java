import java.time.LocalDate;
import java.util.List;
//Bruno Henrique Chagas Piovan ra:2648776
public class MatriculaService {

    private GeradorCodigoLong geradorCodigoLong = new GeradorCodigoLong();
    private TurmaService turmaService = new TurmaService();
    private Leitura leitura = new Leitura();

    public Matricula criarMatricula(List<Turma> turmas) {
        Matricula matricula = new Matricula();
        matricula.setCodigo(geradorCodigoLong.gerarCodigo());
        matricula.setDataMatricula(LocalDate.now());

        if (turmas.isEmpty()) {
            matricula.setTurma(null);
            return matricula;
        }

        System.out.println("\nDigite o código da turma que o aluno vai pertencer:");
        turmaService.listarTurmasParcial(turmas);

        Turma turmaSelecionada = selecionarTurmaPorCodigo(turmas);
        matricula.setTurma(turmaSelecionada);

        return matricula;
    }

    private Turma selecionarTurmaPorCodigo(List<Turma> turmas) {
        Turma turmaSelecionada = null;

        while (turmaSelecionada == null) {
            Long codigo = Long.parseLong(leitura.entDados("Código: "));

            for (Turma turma : turmas) {
                if (turma.getCodigo().equals(codigo)) {
                    turmaSelecionada = turma;
                    break;
                }
            }

            if (turmaSelecionada == null) {
                System.out.println("Código inválido. Tente novamente.");
            }
        }

        return turmaSelecionada;
    }
}
