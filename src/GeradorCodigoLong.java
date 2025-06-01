import java.security.SecureRandom;
//Bruno Henrique Chagas Piovan ra:2648776
public class GeradorCodigoLong {
    private static final SecureRandom random = new SecureRandom();

    public long gerarCodigo() {
        return 10000 + random.nextInt(90000);
    }
}