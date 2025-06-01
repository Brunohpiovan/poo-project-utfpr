import java.util.ArrayList;
import java.util.List;
//Bruno Henrique Chagas Piovan ra:2648776
public class ProfessorService {

    private Leitura leitura = new Leitura();
    private GeradorCodigoLong geradorCodigoLong = new GeradorCodigoLong();
    private EnderecoService enderecoService = new EnderecoService();

    public Professor cadastrarProfessor(){
        Professor professor = new Professor();
        System.out.println("\n--- Cadastrar Professor ---");
        professor.setRp(geradorCodigoLong.gerarCodigo());
        professor.setNome(leitura.entDados("Nome:"));
        professor.setEmail(leitura.entDados("E-mail:"));
        professor.setCpf(leitura.entDados("Cpf:"));
        boolean dataValida = false;
        while (!dataValida) {
            String dataStr = leitura.entDados("Data de Nascimento (dd/MM/aaaa):");
            try {
                professor.setDataNascimento(DataUtils.parseData(dataStr));
                dataValida = true;
            } catch (DataInvalidaException e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Por favor, digite uma data válida no formato dd/MM/aaaa.");
            }
        }
        professor.setEndereco(enderecoService.cadastrarEndereco());
        professor.setTelefone(leitura.entDados("Telefone:"));
        professor.setSalario(Double.parseDouble(leitura.entDados("Salário")));
        professor.setFormacao(leitura.entDados("Informe a formação profissional:"));
        professor.setDisciplinas(null);
        System.out.println("Professor cadastrado com sucesso!");
        return professor;
    }

    public void listarProfessores(List<Professor> professores) {
        System.out.println("\n--- Lista de Professores ---");
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
        } else {
            for (Professor professor : professores) {
                System.out.println(professor.impDados());
            }
        }
    }

    public Professor adicionarDisciplinaProfessor(Disciplina disciplina, Professor professor) {
        List<Disciplina> disciplinasList = professor.getDisciplinas();

        if (disciplinasList == null) {
            disciplinasList = new ArrayList<>();
        }

        disciplinasList.add(disciplina);
        professor.setDisciplinas(disciplinasList);
        return professor;
    }


    public List<Professor> alterarProfessorNaLista(List<Professor> professores, Professor professor) {
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getRp().equals(professor.getRp())) {
                professores.set(i, professor);
                break;
            }
        }
        return professores;
    }

    public void pagarSalario(List<Professor> professores){
        if(professores.isEmpty() || professores == null){
            throw new RuntimeException("Nao há nenhum professor cadastrado no sistema");
        }
        System.out.println("\n--- Pagamento de Salario ---");
        listarProfessores(professores);

        Professor professorSelecionado = null;
        while (professorSelecionado == null) {
            Long codigo = Long.parseLong(leitura.entDados("Informe o RP do professor que você deseja pagar o salário:"));

            for (Professor p : professores) {
                if (p.getRp().equals(codigo)) {
                    professorSelecionado = p;
                    break;
                }
            }

            if (professorSelecionado == null) {
                System.out.println("Código inválido. Por favor, tente novamente.");
            }
        }
        System.out.println(professorSelecionado.pagarSalario());
    }
}
