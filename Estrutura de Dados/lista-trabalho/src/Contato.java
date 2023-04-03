public class Contato {
    private String nome, endereco;
    private String cpf;

    public Contato(String n, String e, String c) {
        nome = n;
        endereco = e;
        cpf = c;
    }

    public String getContato() {
        String aux = "\n" + nome + " ";
        aux = aux + endereco + " ";
        aux = aux + cpf + "\n";
        return aux;
    }
}