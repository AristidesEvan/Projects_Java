public class Contato {
    private String nome, endereco;
    private long cpf;

    public Contato(String n, String e, long c) {
        nome = n;
        endereco = e;
        cpf = c;
    }

    public String getContato() {
        String aux = nome + "\n";
        aux = aux + endereco + "\n";
        aux = aux + Long.toString(cpf) + "\n";
        return aux;
    }
}