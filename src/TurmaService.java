import java.util.ArrayList;
import java.util.List;
//Bruno Henrique Chagas Piovan ra:2648776
public class TurmaService {

    private GeradorCodigoLong geradorCodigoLong = new GeradorCodigoLong();

    private Leitura leitura = new Leitura();

    private DisciplinaService disciplinaService = new DisciplinaService();

    public Turma criarTurma(){
        Turma turma = new Turma();
        turma.setCodigo(geradorCodigoLong.gerarCodigo());
        turma.setNome(leitura.entDados("Nome da turma"));
        turma.setCargaHorariaTotal(null);
        turma.setDisciplinas(null);
        turma.setAlunos(null);
        return turma;
    }

    public void listarTurmasParcial(List<Turma> turmas) {
        System.out.println("\n--- Lista de Turmas ---");
        if (turmas.isEmpty()) {
            throw  new RuntimeException("Nenhuma turma cadastrada.");
        } else {
            for (Turma turma : turmas) {
                System.out.println(turma.impDados());
            }
        }
    }

    public TurmaDisciplinaDTO processaDisciplina(List<Disciplina> disciplinas, List<Turma> turmas){
        Turma turmaSalvar = null;
        Disciplina disciplinaSalvar = null;
        if(disciplinas.isEmpty() || turmas.isEmpty()){
            System.out.println("Nao existem disciplinas ou turmas cadastradas");
            return null;
        }
        try{
            listarTurmasParcial(turmas);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        while (turmaSalvar == null) {
            Long codigoTurma = Long.parseLong(leitura.entDados("Informe o código da turma que você quer adicionar disciplinas:"));

            for (Turma turma : turmas) {
                if (turma.getCodigo().equals(codigoTurma)) {
                    turmaSalvar = turma;
                    break;
                }
            }

            if (turmaSalvar == null) {
                System.out.println("Código de turma inválido. Tente novamente.");
            }
        }

        disciplinaService.listarDisciplinas(disciplinas);
        while (disciplinaSalvar == null) {
            Long codigoDisciplina = Long.parseLong(leitura.entDados("Informe o código da disciplina que você quer adicionar a turma:"));

            for (Disciplina disciplina : disciplinas) {
                if (disciplina.getCodigo().equals(codigoDisciplina)) {
                    disciplinaSalvar = disciplina;
                    break;
                }
            }

            if (disciplinaSalvar == null) {
                System.out.println("Código de disciplina inválido. Tente novamente.");
            }
        }
        TurmaDisciplinaDTO dto = new TurmaDisciplinaDTO();
        dto.setDisciplina(disciplinaService.adicionarTurmaDisciplina(disciplinaSalvar,turmaSalvar));
        dto.setTurma(adicionarDisciplinas(disciplinaSalvar,turmaSalvar));
        return dto;
    }

    private Turma adicionarDisciplinas(Disciplina disciplina, Turma turma) {
        List<Disciplina> disciplinaList = turma.getDisciplinas();

        if (disciplinaList == null) {
            disciplinaList = new ArrayList<>();
            turma.setDisciplinas(disciplinaList);
        }

        boolean existe = disciplinaList.stream()
                .anyMatch(d -> d.getCodigo().equals(disciplina.getCodigo()));

        if (existe) {
            throw new ObjetoJaExisteException(
                    "A disciplina com código " + disciplina.getCodigo() + " já existe nesta turma.");
        }

        disciplinaList.add(disciplina);
        turma.atualizarCargaHorariaTotal();
        return turma;
    }


    public List<Turma> alterarTurmaNaLista(List<Turma> turmas, Turma turma) {
        for (int i = 0; i < turmas.size(); i++) {
            if (turmas.get(i).getCodigo().equals(turma.getCodigo())) {
                turmas.set(i, turma);
                break;
            }
        }
        return turmas;
    }

    public Turma adicionaAluno(Turma turma,Aluno aluno){
        List<Aluno> alunoList = turma.getAlunos();
        if (alunoList == null) {
            alunoList = new ArrayList<>();
            turma.setAlunos(alunoList);
        }

        boolean existe = alunoList.stream()
                .anyMatch(d -> d.getRa().equals(aluno.getRa()));

        if (existe) {
            throw new ObjetoJaExisteException(
                    "O aluno com ra " + aluno.getRa() + " já existe nesta turma.");
        }

        alunoList.add(aluno);
        return turma;
    }


}
