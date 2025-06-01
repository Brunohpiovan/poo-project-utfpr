import java.time.Year;

//Bruno Henrique Chagas Piovan ra:2648776
public class BoletimService {

    private Leitura leitura = new Leitura();

    public Boletim cadastrarBoletim(Aluno aluno){
        Boletim boletim = new Boletim();
        boletim.setAno(Year.now().getValue());
        boletim.setSemestre(Integer.parseInt(leitura.entDados("Informe o semestre do Boletim:")));
        boletim.setAluno(aluno);
        boletim.setNotas(null);
        return boletim;
    }
}
