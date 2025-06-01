import java.time.LocalDate;
import java.util.List;
//Bruno Henrique Chagas Piovan ra:2648776
public class Aluno extends Pessoa{

    private Long ra;
    private String nomeResponsavel;
    private Double mensalidade;
    private Boolean bolsaEstudos;
    // Reflexividade: um aluno possui uma matrícula
    private Matricula matricula;
    // Reflexividade: um aluno possui uma lista de boletins
    private List<Boletim> boletins;

    public Aluno() {
    }

    public Aluno(String nome, String email, String cpf, String telefone, Endereco enderecos, LocalDate dataNascimento, Long ra, String nomeResponsavel, Double mensalidade, Boolean bolsaEstudos, Matricula matricula, List<Boletim> boletins) {
        super(nome, email, cpf, telefone, enderecos, dataNascimento);
        this.ra = ra;
        this.nomeResponsavel = nomeResponsavel;
        this.mensalidade = mensalidade;
        this.bolsaEstudos = bolsaEstudos;
        this.matricula = matricula;
        this.boletins = boletins;
    }

    public Long getRa() {
        return ra;
    }

    public void setRa(Long ra) {
        this.ra = ra;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public List<Boletim> getBoletins() {
        return boletins;
    }

    public void setBoletins(List<Boletim> boletins) {
        this.boletins = boletins;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public Double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(Double mensalidade) {
        this.mensalidade = mensalidade;
    }

    public Boolean getBolsaEstudos() {
        return bolsaEstudos;
    }

    public void setBolsaEstudos(Boolean bolsaEstudos) {
        if(bolsaEstudos){
            mensalidade = 0.00;
            this.bolsaEstudos = true;
            return;
        }
        this.bolsaEstudos = false;
    }

    @Override //Sobrescrita
    public String impDados() {
        return "Aluno {" +
                "\n  ra = " + getRa() + '\'' +
                ",\n  nome = " + getNome() + '\'' +
                ",\n  email = " + getEmail() + '\'' +
                ",\n  cpf = " + getCpf() + '\'' +
                ",\n  telefone = " + getTelefone() + '\'' +
                ",\n  dataNascimento = " + getDataNascimento() +
                ",\n  endereco = " + getEndereco().impDados() + '\'' +
                ",\n  nomeResponsavel = " + nomeResponsavel + '\'' +
                ",\n  mensalidade = R$" + mensalidade +
                ",\n  bolsaEstudos = " + (bolsaEstudos ? "Sim" : "Não") +
                ",\n  matricula = " + (matricula != null ? matricula.impDados() : "sem matrícula") +
                ",\n  boletins = " + (boletins != null ? boletins.size() + " boletins" : "nenhum boletim") +
                "\n}";
    }
}
