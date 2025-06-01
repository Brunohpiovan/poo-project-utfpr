//Bruno Henrique Chagas Piovan ra:2648776
public class TurmaDisciplinaDTO {
    private Turma turma;
    private Disciplina disciplina;

    public TurmaDisciplinaDTO() {
    }

    public TurmaDisciplinaDTO(Turma turma, Disciplina disciplina) {
        this.turma = turma;
        this.disciplina = disciplina;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
}
