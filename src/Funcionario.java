import java.time.LocalDate;
import java.util.List;
//Bruno Henrique Chagas Piovan ra:2648776
public class Funcionario extends Pessoa implements Salario{

    private Long registro;
    private Double salario;
    private String cargo;
    private String turno;
    // Reflexividade: um funcionario pertence a um departamento
    private Departamento departamento;

    public Funcionario() {
    }

    public Funcionario(String nome, String email, String cpf, String telefone, Endereco enderecos, LocalDate dataNascimento, Long registro, Double salario, String cargo, String turno, Departamento departamento) {
        super(nome, email, cpf, telefone, enderecos, dataNascimento);
        this.registro = registro;
        this.salario = salario;
        this.cargo = cargo;
        this.turno = turno;
        this.departamento = departamento;
    }

    public Long getRegistro() {
        return registro;
    }

    public void setRegistro(Long registro) {
        this.registro = registro;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override //Sobrescrita
    public String impDados() {
        return "Funcionario {" +
                "\n  registro = '" + getRegistro() + '\'' +
                ",\n  nome = '" + getNome() + '\'' +
                ",\n  email = '" + getEmail() + '\'' +
                ",\n  cpf = '" + getCpf() + '\'' +
                ",\n  telefone = '" + getTelefone() + '\'' +
                ",\n  dataNascimento = " + getDataNascimento() +
                ",\n  endereco = " + getEndereco().impDados() + '\'' +
                ",\n  salario = R$" + salario +
                ",\n  cargo = '" + cargo + '\'' +
                ",\n  turno = '" + turno + '\'' +
                ",\n  departamento = " + (departamento != null ? departamento.getNome() : "departamento = nenhum") +
                "\n}";
    }

    @Override
    public String pagarSalario() {
        return "O salário do Funcionário " + this.getNome() + ", no valor de R$ " + this.salario + ", foi pago com sucesso.";

    }
}
