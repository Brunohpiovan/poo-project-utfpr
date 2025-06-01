import java.util.ArrayList;
import java.util.List;
//Bruno Henrique Chagas Piovan ra:2648776
public class Boletim implements Impressao{

    private Long codigo;
    private Integer semestre;
    private Integer ano;
    // Reflexividade: um boletim pertence a um aluno
    private Aluno aluno;
    private List<Nota> notas = new ArrayList<>();

    public Boletim() {
    }

    public Boletim(Long codigo, Integer semestre, Integer ano, Aluno aluno, List<Nota> notas) {
        this.codigo = codigo;
        this.semestre = semestre;
        this.ano = ano;
        this.aluno = aluno;
        this.notas = notas;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    @Override
    public String impDados() {
        String notasStr = "";

        if (notas != null && !notas.isEmpty()) {
            notasStr = "\n    Notas:";
            for (Nota n : notas) {
                notasStr += "\n      " + n.impDados();
            }
        } else {
            notasStr = "\n    Notas: nenhuma nota cadastrada";
        }

        return "  Boletim {" +
                "\n    codigo = " + codigo +
                ",\n    semestre = " + semestre +
                ",\n    ano = " + ano +
                // Evita loop recursivo imprimindo apenas o nome do aluno
                ",\n    aluno = " + (aluno != null ? aluno.getNome() : "sem aluno") +
                notasStr +
                "\n  }";
    }

}
