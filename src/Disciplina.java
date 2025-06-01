import java.util.List;
//Bruno Henrique Chagas Piovan ra:2648776
public class Disciplina implements Impressao{

    private Long codigo;
    private String nome;
    private Integer cargaHoraria;
    // Reflexividade: uma disciplina é ministrada por um professor
    private Professor professor;
    // Reflexividade: uma disciplina pode ser ministrada em varias turmas
    private List<Turma> turmas;

    public Disciplina() {
    }

    public Disciplina(Long codigo, String nome, Integer cargaHoraria, Professor professor, List<Turma> turmas) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        this.turmas = turmas;
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

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override//Sobrescrita
    public String impDados() {
        return "{" +
                "\n  codigo = " + getCodigo() + '\'' +
                ",\n  nome = " + getNome() + '\'' +
                ",\n  carga Horaria = " + getCargaHoraria() + '\'' +
                ",\n  Professor Responsável = " + (getProfessor() != null ? getProfessor().getNome(): "Nenhum Professor Responsavel") + '\'' +
                "\n}";
    }
}
