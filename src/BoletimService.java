import java.time.Year;
import java.util.List;

//Bruno Henrique Chagas Piovan ra:2648776
public class BoletimService {

    private Leitura leitura = new Leitura();
    private GeradorCodigoLong geradorCodigoLong = new GeradorCodigoLong();

    public Boletim cadastrarBoletim(Aluno aluno){
        Boletim boletim = new Boletim();
        boletim.setCodigo(geradorCodigoLong.gerarCodigo());
        boletim.setAno(Year.now().getValue());
        boletim.setSemestre(Integer.parseInt(leitura.entDados("Informe o semestre do Boletim:")));
        boletim.setAluno(aluno);
        boletim.setNotas(null);
        return boletim;
    }

    public void listarBoletim(List<Boletim> boletins){
        System.out.println("\n--- Lista de Bolteins ---");
        if (boletins.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Boletim boletim : boletins) {
                System.out.println(boletim.impDados());
            }
        }
    }
}
