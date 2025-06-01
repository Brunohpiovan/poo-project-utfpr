import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
//Bruno Henrique Chagas Piovan ra:2648776
public class DataUtils {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);

    public static LocalDate parseData(String input) throws DataInvalidaException {
        try {
            return LocalDate.parse(input, FORMATTER);
        } catch (DateTimeParseException e) {
            throw new DataInvalidaException("Data inválida ou no formato errado (use dd/MM/aaaa): " + input);
        }
    }
}
