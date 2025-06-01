import java.util.List;
//Bruno Henrique Chagas Piovan ra:2648776
public class Departamento implements Impressao{

    private Long codigo;
    private String nome;
    // Reflexividade: um departamento possui uma lista de funcionarios
    private List<Funcionario> funcionarios;

    public Departamento() {
    }

    public Departamento(Long codigo, String nome, List<Funcionario> funcionarios) {
        this.codigo = codigo;
        this.nome = nome;
        this.funcionarios = funcionarios;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override//Sobrescrita
    public String impDados() {
        return "Aluno {" +
                "\n  codigo = " + getCodigo() + '\'' +
                ",\n  nome = " + getNome() + '\'' +
                "\n}";
    }
}
