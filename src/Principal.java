import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Bruno Henrique Chagas Piovan ra:2648776

public class Principal {
    static Scanner scanner = new Scanner(System.in);

    static AlunoService alunoService = new AlunoService();
    static TurmaService turmaService = new TurmaService();
    static ProfessorService professorService = new ProfessorService();
    static DisciplinaService disciplinaService = new DisciplinaService();
    static FuncionarioService funcionarioService = new FuncionarioService();
    private NotaService notaService = new NotaService();

    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();
        List<Professor> professores = new ArrayList<>();
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Turma> turmas = new ArrayList<>();
        List<Disciplina> disciplinas = new ArrayList<>();
        List<Departamento> departamentos = new ArrayList<>();

        boolean sair = false;

        while (!sair) {
            System.out.println("\n==== Menu Principal ====");
            System.out.println("1 - Aluno");
            System.out.println("2 - Professor");
            System.out.println("3 - Funcionário");
            System.out.println("4 - Turma");
            System.out.println("5 - Disciplina");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    boolean voltarAluno = false;
                    while (!voltarAluno) {
                        System.out.println("\n--- Menu Aluno ---");
                        System.out.println("1 - Cadastrar Aluno");
                        System.out.println("2 - Listar Alunos");
                        System.out.println("3 - Setar Turma a aluno");
                        System.out.println("4 - Atribuir Nota a Alunos");
                        System.out.println("0 - Voltar");
                        System.out.print("Escolha uma opção: ");
                        int opcaoAluno = Integer.parseInt(scanner.nextLine());
                        switch (opcaoAluno) {
                            case 1:
                                alunos.add(alunoService.cadastrarAluno(turmas));
                                break;
                            case 2:
                                alunoService.listarAlunos(alunos);
                                break;
                            case 3:
                                try {
                                    TurmaAlunoDTO dto = alunoService.setarTurma(turmas,alunos);
                                    turmas = turmaService.alterarTurmaNaLista(turmas,dto.getTurma());
                                    alunos = alunoService.alterarAlunoNaLista(alunos,dto.getAluno());

                                }catch (RuntimeException e){
                                    System.out.println("Erro: " + e.getMessage());
                                }

                                break;
                            case 4:
                                alunoService.listarAlunos(alunos);
                                break;
                            case 0:
                                voltarAluno = true;
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    }
                    break;

                case 2:
                    boolean voltarProfessor = false;
                    while (!voltarProfessor) {
                        System.out.println("\n--- Menu Professor ---");
                        System.out.println("1 - Cadastrar Professor");
                        System.out.println("2 - Listar Professores");
                        System.out.println("3 - Pagar Salário Professores");
                        System.out.println("0 - Voltar");
                        System.out.print("Escolha uma opção: ");
                        int opcaoProf = Integer.parseInt(scanner.nextLine());
                        switch (opcaoProf) {
                            case 1:
                                professores.add(professorService.cadastrarProfessor());
                                break;
                            case 2:
                                professorService.listarProfessores(professores);
                                break;
                            case 3:
                                try {
                                    professorService.pagarSalario(professores);
                                }catch (RuntimeException e){
                                    System.out.println("Erro: " + e.getMessage());
                                }

                                break;
                            case 0:
                                voltarProfessor = true;
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    }
                    break;

                case 3:
                    boolean voltarFuncionario = false;
                    while (!voltarFuncionario) {
                        System.out.println("\n--- Menu Funcionário ---");
                        System.out.println("1 - Cadastrar Funcionário");
                        System.out.println("2 - Listar Funcionários");
                        System.out.println("3 - Pagar Salário Funcionários");
                        System.out.println("0 - Voltar");
                        System.out.print("Escolha uma opção: ");
                        int opcaoFunc = Integer.parseInt(scanner.nextLine());
                        switch (opcaoFunc) {
                            case 1:
                                funcionarios.add(funcionarioService.cadastrarFuncionario(departamentos));
                                break;
                            case 2:
                                funcionarioService.listarFuncionarios(funcionarios);
                                break;
                            case 3:
                                try {
                                    funcionarioService.pagarSalario(funcionarios);
                                }catch (RuntimeException e){
                                    System.out.println("Erro: " + e.getMessage());
                                }

                                break;
                            case 0:
                                voltarFuncionario = true;
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    }
                    break;

                case 4:
                    boolean voltarTurma = false;
                    while (!voltarTurma) {
                        System.out.println("\n--- Menu Turma ---");
                        System.out.println("1 - Cadastrar Turma");
                        System.out.println("2 - Listar Turmas");
                        System.out.println("3 - Adicionar Disciplinas a Turma");
                        System.out.println("0 - Voltar");
                        System.out.print("Escolha uma opção: ");
                        int opcaoTurma = Integer.parseInt(scanner.nextLine());
                        switch (opcaoTurma) {
                            case 1:
                                turmas.add(turmaService.criarTurma());
                                break;
                            case 2:
                                turmaService.listarTurmasParcial(turmas);
                                break;
                            case 3:
                                try {
                                    TurmaDisciplinaDTO dto = turmaService.processaDisciplina(disciplinas, turmas);
                                    if (dto != null) {
                                        turmas = turmaService.alterarTurmaNaLista(turmas, dto.getTurma());
                                        disciplinas = disciplinaService.alterarDisciplinaNaLista(disciplinas, dto.getDisciplina());
                                    }
                                } catch (ObjetoJaExisteException e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }

                                break;
                            case 0:
                                voltarTurma = true;
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    }
                    break;

                case 5:
                    boolean voltarDisciplina = false;
                    while (!voltarDisciplina) {
                        System.out.println("\n--- Menu Disciplina ---");
                        System.out.println("1 - Cadastrar Disciplina");
                        System.out.println("2 - Listar Disciplinas");
                        System.out.println("3 - Adicionar Professor a uma disciplina");
                        System.out.println("0 - Voltar");
                        System.out.print("Escolha uma opção: ");
                        int opcaoDisc = Integer.parseInt(scanner.nextLine());
                        switch (opcaoDisc) {
                            case 1:
                                disciplinas.add(disciplinaService.cadastrarDisciplina());
                                break;
                            case 2:
                                disciplinaService.listarDisciplinas(disciplinas);
                                break;
                            case 3:
                                try {
                                    ProfessorDisciplinaDTO dto = disciplinaService.adicionarProfessorNaDisciplina(disciplinas, professores);
                                    if (dto != null) {
                                        disciplinas = disciplinaService.alterarDisciplinaNaLista(disciplinas, dto.getDisciplina());
                                        professores = professorService.alterarProfessorNaLista(professores, dto.getProfessor());
                                    }
                                } catch (ObjetoJaExisteException e) {
                                    System.out.println("Erro: " + e.getMessage());
                                }

                                break;
                            case 0:
                                voltarDisciplina = true;
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                    }
                    break;

                case 0:
                    sair = true;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }

}
