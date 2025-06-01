import java.util.ArrayList;
import java.util.List;
//Bruno Henrique Chagas Piovan ra:2648776
public class DisciplinaService {

    private Leitura leitura = new Leitura();

    private GeradorCodigoLong geradorCodigoLong = new GeradorCodigoLong();
    private ProfessorService professorService = new ProfessorService();

    public Disciplina cadastrarDisciplina(){
        Disciplina disciplina = new Disciplina();
        System.out.println("\n--- Cadastrar disciplina ---");
        disciplina.setCodigo(geradorCodigoLong.gerarCodigo());
        disciplina.setNome(leitura.entDados("Nome"));
        disciplina.setCargaHoraria(Integer.parseInt(leitura.entDados("Carga Horária:")));
        disciplina.setProfessor(null);
        disciplina.setTurmas(null);
        System.out.println("Disciplina cadastrado com sucesso!");
        return disciplina;
    }

    public void listarDisciplinas(List<Disciplina> disciplinas){
        System.out.println("\n--- Lista de Disciplinas ---");
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrado.");
        } else {
            for (Disciplina disciplina : disciplinas) {
                System.out.println(disciplina.impDados());
            }
        }
    }
    public Disciplina adicionarTurmaDisciplina(Disciplina disciplina, Turma turma) {
        List<Turma> turmaList = disciplina.getTurmas();

        if (turmaList == null) {
            turmaList = new ArrayList<>();
        }

        turmaList.add(turma);
        disciplina.setTurmas(turmaList);
        return disciplina;
    }


    public List<Disciplina> alterarDisciplinaNaLista(List<Disciplina> disciplinas, Disciplina disciplina) {
        for (int i = 0; i < disciplinas.size(); i++) {
            if (disciplinas.get(i).getCodigo().equals(disciplina.getCodigo())) {
                disciplinas.set(i, disciplina);
                break;
            }
        }
        return disciplinas;
    }


    public ProfessorDisciplinaDTO adicionarProfessorNaDisciplina(List<Disciplina> disciplinas, List<Professor> professores) {
        if (disciplinas.isEmpty() || professores.isEmpty()) {
            System.out.println("Não existem disciplinas ou professores cadastrados");
            return null;
        }

        listarDisciplinas(disciplinas);

        Disciplina disciplinaSelecionada = null;
        while (disciplinaSelecionada == null) {
            Long codigoDisciplina = Long.parseLong(leitura.entDados("Informe o código da disciplina para adicionar o professor:"));

            for (Disciplina d : disciplinas) {
                if (d.getCodigo().equals(codigoDisciplina)) {
                    disciplinaSelecionada = d;
                    break;
                }
            }

            if (disciplinaSelecionada == null) {
                System.out.println("Código de disciplina inválido. Tente novamente.");
            }
        }

        professorService.listarProfessores(professores);

        Professor professorSelecionado = null;
        while (professorSelecionado == null) {
            Long codigoProfessor = Long.parseLong(leitura.entDados("Informe o código do professor para adicionar à disciplina:"));

            for (Professor p : professores) {
                if (p.getRp().equals(codigoProfessor)) {
                    professorSelecionado = p;
                    break;
                }
            }

            if (professorSelecionado == null) {
                System.out.println("Código de professor inválido. Tente novamente.");
            }
        }
        ProfessorDisciplinaDTO dto = new ProfessorDisciplinaDTO();
        try {
            disciplinaSelecionada = adicionarProfessor(professorSelecionado, disciplinaSelecionada);
            professorSelecionado = professorService.adicionarDisciplinaProfessor(disciplinaSelecionada,professorSelecionado);
            dto.setProfessor(professorSelecionado);
            dto.setDisciplina(disciplinaSelecionada);
        } catch (ObjetoJaExisteException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }

        return dto;
    }


    private Disciplina adicionarProfessor(Professor professor, Disciplina disciplina) {
        if (disciplina.getProfessor() != null) {
            throw new ObjetoJaExisteException(
                    "Esta disciplina já possui um professor associado.");
        }

        disciplina.setProfessor(professor);
        return disciplina;
    }




}
