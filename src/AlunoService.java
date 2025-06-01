import java.util.List;
//Bruno Henrique Chagas Piovan ra:2648776
public class AlunoService {

    private Leitura leitura = new Leitura();
    private MatriculaService matriculaService = new MatriculaService();
    private GeradorCodigoLong geradorCodigoLong = new GeradorCodigoLong();
    private EnderecoService enderecoService = new EnderecoService();
    private TurmaService turmaService = new TurmaService();

    public Aluno cadastrarAluno(List<Turma> turmas) {
        Aluno aluno = new Aluno();
        System.out.println("\n--- Cadastrar Aluno ---");

        aluno.setRa(geradorCodigoLong.gerarCodigo());
        aluno.setNome(leitura.entDados("Nome:"));
        aluno.setEmail(leitura.entDados("E-mail:"));
        aluno.setCpf(leitura.entDados("Cpf:"));
        boolean dataValida = false;
        while (!dataValida) {
            String dataStr = leitura.entDados("Data de Nascimento (dd/MM/aaaa):");
            try {
                aluno.setDataNascimento(DataUtils.parseData(dataStr));
                dataValida = true;
            } catch (DataInvalidaException e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Por favor, digite uma data válida no formato dd/MM/aaaa.");
            }
        }

        aluno.setTelefone(leitura.entDados("Telefone:"));
        aluno.setEndereco(enderecoService.cadastrarEndereco());
        aluno.setNomeResponsavel(leitura.entDados("Nome do Responsavel:"));
        String mensalidade = leitura.entDados("Bolsa de Estudos?(s/n)");
        aluno.setBolsaEstudos(mensalidade.equalsIgnoreCase("s"));
        if(!aluno.getBolsaEstudos()){
            aluno.setMensalidade(Double.parseDouble(leitura.entDados("Mensalidade:")));
        }
        aluno.setMatricula(matriculaService.criarMatricula(turmas));
        aluno.setBoletins(null);
        System.out.println("Aluno cadastrado com sucesso!");
        return aluno;
    }

    public void listarAlunos(List<Aluno> alunos) {
        System.out.println("\n--- Lista de Alunos ---");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : alunos) {
                System.out.println(aluno.impDados());
            }
        }
    }

    public TurmaAlunoDTO setarTurma(List<Turma> turmas,List<Aluno> alunos){
        if(alunos.isEmpty()){
            throw new RuntimeException("Não há nenhum aluno e/ou turmas cadastradas no sistema");
        }
        System.out.println("\n--- Cadastro de Aluno a Turma ---");
        listarAlunos(alunos);

        Aluno alunoSelecionado = null;
        while (alunoSelecionado == null) {
            Long codigo = Long.parseLong(leitura.entDados("Informe o RA do aluno que você deseja atribuir uma turma:"));

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
        turmaService.listarTurmasParcial(turmas);
        Turma turmaSelecionado = null;
        while (turmaSelecionado == null) {
            Long codigo = Long.parseLong(leitura.entDados("Informe o codigo da turma:"));

            for (Turma t : turmas) {
                if (t.getCodigo().equals(codigo)) {
                    turmaSelecionado = t;
                    break;
                }
            }

            if (turmaSelecionado == null) {
                System.out.println("Código inválido. Por favor, tente novamente.");
            }
        }
        TurmaAlunoDTO dto =  new TurmaAlunoDTO();
        alunoSelecionado.getMatricula().setTurma(turmaSelecionado);
        dto.setAluno(alunoSelecionado);
        dto.setTurma(turmaService.adicionaAluno(turmaSelecionado,alunoSelecionado));
        System.out.println("Aluno adicionado a turma com sucesso!");
        return dto;
    }


    public List<Aluno> alterarAlunoNaLista(List<Aluno> alunos, Aluno aluno) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getRa().equals(aluno.getRa())) {
                alunos.set(i, aluno);
                break;
            }
        }
        return alunos;
    }

}
