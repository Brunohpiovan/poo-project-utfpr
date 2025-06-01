import java.time.LocalDateTime;
import java.util.List;

//Bruno Henrique Chagas Piovan ra:2648776
public class NotaService {

    private AlunoService alunoService = new AlunoService();
    private Leitura leitura = new Leitura();
    private BoletimService boletimService = new BoletimService();
    private DisciplinaService disciplinaService = new DisciplinaService();

    public Aluno atribuirNota(List<Aluno> alunos){
        if(alunos.isEmpty()){
            throw new RuntimeException("Não há nenhum aluno cadastrado no sistema");
        }
        System.out.println("\n--- Atribuição de notas ---");
        alunoService.listarAlunos(alunos);

        Aluno alunoSelecionado = null;
        while (alunoSelecionado == null) {
            Long codigo = Long.parseLong(leitura.entDados("Informe o RA do aluno que você deseja atribuir a nota:"));

            for (Aluno a : alunos) {
                if (a.getRa().equals(codigo)) {
                    alunoSelecionado = a;
                    break;
                }
            }

            if (alunoSelecionado == null) {
                System.out.println("Código inválido. Por favor, tente novamente.");
            }
        }
        if(alunoSelecionado.getMatricula().getTurma()==null){
            throw new RuntimeException("Esse aluno nao esta cadastrado em nenhuma turma,portanto,nao pode ser atribuida notas ao mesmo");

        }
        if(alunoSelecionado.getBoletins().isEmpty()){
            Boletim boletim = boletimService.cadastrarBoletim(alunoSelecionado);
            alunoSelecionado.getBoletins().add(boletim);
            Boletim retornado = dadosNota(alunoSelecionado,boletim);
            alunoSelecionado = encontrarBoletim(alunoSelecionado,retornado);
            return alunoSelecionado;
        }else{
            Boletim retornado = dadosNota(alunoSelecionado,processarBoletim(alunoSelecionado));
            alunoSelecionado = encontrarBoletim(alunoSelecionado,retornado);
            return alunoSelecionado;
        }
    }

    private Aluno encontrarBoletim(Aluno aluno, Boletim boletim) {
        List<Boletim> boletins = aluno.getBoletins();

        for (int i = 0; i < boletins.size(); i++) {
            if (boletins.get(i).getCodigo().equals(boletim.getCodigo())) {
                boletins.set(i, boletim);
                break;
            }
        }

        aluno.setBoletins(boletins);
        return aluno;
    }


    private Boletim processarBoletim(Aluno aluno){
        boletimService.listarBoletim(aluno.getBoletins());
        Boletim boletimSelecionado = null;
        while (boletimSelecionado == null) {
            Long codigo = Long.parseLong(leitura.entDados("Informe o codigo do boletim que sera atribuida a nota"));

            for (Boletim b : aluno.getBoletins()) {
                if (b.getCodigo().equals(codigo)) {
                    boletimSelecionado = b;
                    break;
                }
            }

            if (boletimSelecionado == null) {
                System.out.println("Código inválido. Por favor, tente novamente.");
            }
        }
        return boletimSelecionado;
    }

    private Boletim dadosNota(Aluno aluno,Boletim boletim){
        List<Disciplina> disciplinas = aluno.getMatricula().getTurma().getDisciplinas();
        if(disciplinas.isEmpty()){
            throw new RuntimeException("Não há nenhuma disciplina cadastrada na turma "+aluno.getMatricula().getTurma().getNome()+" sistema,portando nao sera possivel prosseguir com a atribuicao de notas");
        }
        disciplinaService.listarDisciplinas(disciplinas);
        Disciplina disciplinaSelecionada = null;
        while (disciplinaSelecionada == null) {
            Long codigo = Long.parseLong(leitura.entDados("Informe o codigo da disciplina que sera atribuida a nota"));

            for (Disciplina d : disciplinas) {
                if (d.getCodigo().equals(codigo)) {
                    disciplinaSelecionada = d;
                    break;
                }
            }

            if (disciplinaSelecionada == null) {
                System.out.println("Código inválido. Por favor, tente novamente.");
            }
        }
        Nota nota = new Nota();
        nota.setDisciplina(disciplinaSelecionada);
        nota.setBoletim(boletim);
        nota.setValor(Double.parseDouble(leitura.entDados("Informe o valor da nota:")));
        nota.setDataLancamento(LocalDateTime.now());
        boletim.getNotas().add(nota);
        return boletim;
    }

}
