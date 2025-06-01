import java.time.LocalDate;
import java.util.List;
//Bruno Henrique Chagas Piovan ra:2648776
public class Professor extends Pessoa implements Salario{

    private Long rp;
    private String formacao;
    private Double salario;
    // Reflexividade: um professor possui uma lista de disciplinas
    private List<Disciplina> disciplinas;

    public Professor() {
    }

    public Professor(String nome, String email, String cpf, String telefone, Endereco enderecos, LocalDate dataNascimento, Long rp, String formacao, Double salario, List<Disciplina> disciplinas) {
        super(nome, email, cpf, telefone, enderecos, dataNascimento);
        this.rp = rp;
        this.formacao = formacao;
        this.salario = salario;
        this.disciplinas = disciplinas;
    }

    public String getFormacao() {
        return formacao;
    }

    public Long getRp() {
        return rp;
    }

    public void setRp(Long rp) {
        this.rp = rp;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override //Sobrescrita
    public String impDados() {
        String resultado = "Professor {" +
                "\n  rp = '" + getRp() + '\'' +
                ",\n  nome = '" + getNome() + '\'' +
                ",\n  email = '" + getEmail() + '\'' +
                ",\n  cpf = '" + getCpf() + '\'' +
                ",\n  telefone = '" + getTelefone() + '\'' +
                ",\n  dataNascimento = " + getDataNascimento() +
                ",\n  endereco = " + getEndereco().impDados() + '\'' +
                ",\n  formacao = '" + formacao + '\'' +
                ",\n  salario = R$" + salario;

        if (disciplinas != null && !disciplinas.isEmpty()) {
            resultado += ",\n  disciplinas = [";
            for (Disciplina d : disciplinas) {
                resultado += "\n    " + d.getNome();
            }
            resultado += "\n  ]";
        } else {
            resultado += ",\n  disciplinas = nenhum";
        }

        resultado += "\n}";
        return resultado;
    }

    @Override
    public String pagarSalario() {
        return "O salário do Professor " + this.getNome() + ", no valor de R$ " + this.salario + ", foi pago com sucesso.";

    }
}
