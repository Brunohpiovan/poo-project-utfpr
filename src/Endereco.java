//Bruno Henrique Chagas Piovan ra:2648776
public class Endereco implements Impressao{

    private String cep;
    private String cidade;
    private String bairro;
    private String rua;
    private Integer numero;

    public Endereco() {
    }

    public Endereco(String cep, String cidade, String bairro, String rua, Integer numero) {
        this.cep = cep;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String impDados() {
        return "  {\n" +
                "    \"rua\": " + rua + ",\n" +
                "    \"numeri\": " + numero + ",\n" +
                "    \"bairro\": " + bairro + ",\n" +
                "    \"cidade\": \"" + cidade + "\",\n" +
                "    \"cep\": \"" + cep + "\",\n" +
                "  }";
    }
}
