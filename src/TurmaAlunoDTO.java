public class TurmaAlunoDTO {
    private Aluno aluno;
    private Turma turma;

    public TurmaAlunoDTO() {
    }

    public TurmaAlunoDTO(Aluno aluno, Turma turma) {
        this.aluno = aluno;
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
