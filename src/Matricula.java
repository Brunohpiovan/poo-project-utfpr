import java.time.LocalDate;
//Bruno Henrique Chagas Piovan ra:2648776
public class Matricula implements Impressao{

    private Long codigo;
    private LocalDate dataMatricula;
    // Reflexividade: uma matricula possui uma turma
    private Turma turma;

    public Matricula() {
    }

    public Matricula(Long codigo, LocalDate dataMatricula, Turma turma) {
        this.codigo = codigo;
        this.dataMatricula = dataMatricula;
        this.turma = turma;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }


    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }


    @Override
    public String impDados() {
        return "  {\n" +
                "    \"codigo\": " + codigo + ",\n" +
                "    \"dataMatricula\": \"" + dataMatricula + "\",\n" +
                "    \"turma\": \"" + (turma != null ? turma.getNome() : "sem turma") + "\"\n" +
                "  }";
    }

}
