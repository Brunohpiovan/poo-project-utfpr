import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Bruno Henrique Chagas Piovan ra:2648776
public class Nota implements Impressao{

    private Double valor;
    private LocalDateTime dataLancamento;
    // Reflexividade: uma nota pertence a um boletim
    private Boletim boletim;
    // Reflexividade: uma bota pertence a uma disciplina
    private Disciplina disciplina;

    public Nota() {
    }

    public Nota(Double valor, LocalDateTime dataLancamento, Boletim boletim, Disciplina disciplina) {
        this.valor = valor;
        this.dataLancamento = dataLancamento;
        this.boletim = boletim;
        this.disciplina = disciplina;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDateTime dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Boletim getBoletim() {
        return boletim;
    }

    public void setBoletim(Boletim boletim) {
        this.boletim = boletim;
    }

    @Override
    public String impDados() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataFormatada = (dataLancamento != null) ? dataLancamento.format(formatter) : "data não informada";

        return disciplina+"{" +
                "valor = " + valor +
                ", dataLancamento = " + dataFormatada +
                "}";
    }
}
