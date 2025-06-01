import java.util.List;
//Bruno Henrique Chagas Piovan ra:2648776
public class FuncionarioService {

    private Leitura leitura = new Leitura();
    private DepartamentoService departamentoService = new DepartamentoService();
    private GeradorCodigoLong geradorCodigoLong = new GeradorCodigoLong();
    private EnderecoService enderecoService = new EnderecoService();

    public Funcionario cadastrarFuncionario(List<Departamento> departamentos){
        Funcionario funcionario = new Funcionario();
        System.out.println("\n--- Cadastrar Funcionário ---");
        funcionario.setNome(leitura.entDados("Nome:"));
        funcionario.setEmail(leitura.entDados("E-mail:"));
        funcionario.setCpf(leitura.entDados("Cpf:"));
        boolean dataValida = false;
        while (!dataValida) {
            String dataStr = leitura.entDados("Data de Nascimento (dd/MM/aaaa):");
            try {
                funcionario.setDataNascimento(DataUtils.parseData(dataStr));
                dataValida = true;
            } catch (DataInvalidaException e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Por favor, digite uma data válida no formato dd/MM/aaaa.");
            }
        }
        funcionario.setTelefone(leitura.entDados("Telefone:"));
        funcionario.setEndereco(enderecoService.cadastrarEndereco());
        funcionario.setSalario(Double.parseDouble(leitura.entDados("Salário")));
        funcionario.setCargo(leitura.entDados("Informe o Cargo:"));

        if (departamentos.isEmpty()) {
            funcionario.setDepartamento(null);
            return funcionario;
        }

        System.out.println("\nDigite o código do departamento que o aluno vai pertencer:");
        departamentoService.listarDepartamentos(departamentos);

        Departamento departamento = selecionarDepartamentoPorCodigo(departamentos);
        funcionario.setDepartamento(departamento);
        return funcionario;
    }

    private Departamento selecionarDepartamentoPorCodigo(List<Departamento> departamentos) {
        Departamento departamentoSelecionado = null;

        while (departamentoSelecionado == null) {
            Long codigo = Long.parseLong(leitura.entDados("Código: "));

            for (Departamento departamento : departamentos) {
                if (departamento.getCodigo().equals(codigo)) {
                    departamentoSelecionado = departamento;
                    break;
                }
            }

            if (departamentoSelecionado == null) {
                System.out.println("Código inválido. Tente novamente.");
            }
        }

        return departamentoSelecionado;
    }

    public void listarFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("\n--- Lista de funcionarios ---");
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario.impDados());
            }
        }
    }

    public void pagarSalario(List<Funcionario> funcionarios){
        if(funcionarios.isEmpty()){
            throw new RuntimeException("Nao há nenhum funcionario cadastrado no sistema");
        }
        System.out.println("\n--- Pagamento de Salario ---");
        listarFuncionarios(funcionarios);

        Funcionario funcionarioSelecionado = null;
        while (funcionarioSelecionado == null) {
            Long codigo = Long.parseLong(leitura.entDados("Informe o registro do funcionario que você deseja pagar o salário:"));

            for (Funcionario f : funcionarios) {
                if (f.getRegistro().equals(codigo)) {
                    funcionarioSelecionado = f;
                    break;
                }
            }

            if (funcionarioSelecionado == null) {
                System.out.println("Código inválido. Por favor, tente novamente.");
            }
        }
        System.out.println(funcionarioSelecionado.pagarSalario());

    }
}
