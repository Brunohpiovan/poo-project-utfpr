import java.util.List;
//Bruno Henrique Chagas Piovan ra:2648776
public class Turma implements Impressao{

    private Long codigo;
    private String nome;
    private Integer cargaHorariaTotal;
    // Reflexividade: uma turma possui uma lista de alunos
    private List<Aluno> alunos;
    // Reflexividade: uma turma possui uma lista de disciplinas
    private List<Disciplina> disciplinas;

    public Turma() {
    }

    public Turma(Long codigo, String nome, Integer cargaHorariaTotal, List<Aluno> alunos, List<Disciplina> disciplinas) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHorariaTotal = cargaHorariaTotal;
        this.alunos = alunos;
        this.disciplinas = disciplinas;
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

    public Integer getCargaHorariaTotal() {
        return cargaHorariaTotal;
    }

    public void setCargaHorariaTotal(Integer cargaHorariaTotal) {
        this.cargaHorariaTotal = cargaHorariaTotal;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void atualizarCargaHorariaTotal() {
        int total = 0;

        if (disciplinas != null) {
            for (Disciplina d : disciplinas) {
                if (d != null && d.getCargaHoraria() != null) {
                    total += d.getCargaHoraria();
                }
            }
        }

        this.cargaHorariaTotal = total;
    }



    @Override//Sobrescrita
    public String impDados() {
        String resultado = "Turma {" +
                "\n  codigo = " + codigo +
                ",\n  nome = '" + nome + '\'' +
                ",\n  cargaHorariaTotal = " + cargaHorariaTotal;

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


}
