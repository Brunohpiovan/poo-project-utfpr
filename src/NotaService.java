import java.util.List;

//Bruno Henrique Chagas Piovan ra:2648776
public class NotaService {

    private AlunoService alunoService = new AlunoService();
    private Leitura leitura = new Leitura();


    public void atribuirNota(List<Aluno> alunos){
        if(alunos.isEmpty()){
            throw new RuntimeException("Não há nenhum aluno cadastrado no sistema");
        }
        System.out.println("\n--- Atribuição de notas ---");
        alunoService.listarAlunos(alunos);

        Aluno alunoSelecionado = null;
        while (alunoSelecionado == null) {
            Long codigo = Long.parseLong(leitura.entDados("Informe o RA do aluno que você deseja atribuir a nota:"));

            for (Aluno a : alunos) {
                if (a.getRa().equals(codigo)) {
                    alunoSelecionado = a;
                    break;
                }
            }

            if (alunoSelecionado == null) {
                System.out.println("Código inválido. Por favor, tente novamente.");
            }
        }

    }

}
