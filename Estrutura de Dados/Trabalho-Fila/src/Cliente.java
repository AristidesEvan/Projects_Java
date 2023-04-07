public class Cliente {
    private String nome;
    private int idade;

    public Cliente(String n, int i) {
        setNome(n);
        setIdade(i);
    }
    
    public void setNome(String nome) {this.nome = nome;}
    public boolean setIdade(int idade) {
            if (idade > 0 ) {
            this.idade = idade; 
            return true;
        } else {return false;}
    }


    public String getCliente() {
        String aux = nome + "\n";
        aux = aux + Integer.toString(idade) + "\n";
        return aux;
    }
}