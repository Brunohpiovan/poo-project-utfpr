//Bruno Henrique Chagas Piovan ra:2648776
public class EnderecoService {

    private Leitura leitura = new Leitura();

    public Endereco cadastrarEndereco(){
        Endereco endereco = new Endereco();
        System.out.println("Endereço");
        endereco.setRua(leitura.entDados("Rua:"));
        endereco.setNumero(Integer.parseInt(leitura.entDados("Numero:")));
        endereco.setBairro(leitura.entDados("Bairro:"));
        endereco.setCidade(leitura.entDados("Cidade:"));
        endereco.setCep(leitura.entDados("Cep:"));
        return endereco;
    }
}
