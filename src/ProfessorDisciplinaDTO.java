public class ProfessorDisciplinaDTO {

    private Professor professor;
    private Disciplina disciplina;

    public ProfessorDisciplinaDTO() {
    }

    public ProfessorDisciplinaDTO(Professor professor, Disciplina disciplina) {
        this.professor = professor;
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
