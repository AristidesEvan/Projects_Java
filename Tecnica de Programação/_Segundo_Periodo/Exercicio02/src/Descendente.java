public class Descendente{

    //34 caracter
    
    private String nome;
    private String nascimento;
    private String tipo;
    
    public Descendente() {}
    public Descendente(String nome, String tipo, String nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.tipo = tipo;
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getNascimento() {return nascimento;}
    public void setNascimento(String nascimento) {this.nascimento = nascimento;}
    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {

    }
    
}
