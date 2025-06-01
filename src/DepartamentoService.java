import java.util.List;
//Bruno Henrique Chagas Piovan ra:2648776
public class DepartamentoService {

    private Leitura leitura = new Leitura();
    private GeradorCodigoLong geradorCodigoLong = new GeradorCodigoLong();

    public Departamento cadastrarDepartamento(){
        Departamento departamento = new Departamento();
        System.out.println("\n--- Cadastrar Departamento ---");

        departamento.setCodigo(geradorCodigoLong.gerarCodigo());
        departamento.setNome(leitura.entDados("Nome:"));
        System.out.println("Departamento cadastrado com sucesso!");
        return departamento;
    }

    public void listarTurmasParcial(List<Departamento> departamentos) {
        System.out.println("\n--- Lista de Departamentos ---");
        if (departamentos.isEmpty()) {
            System.out.println("Nenhum departamento cadastrado.");
        } else {
            for (Departamento departamento : departamentos) {
                System.out.println(departamento.impDados());
            }
        }
    }

}
