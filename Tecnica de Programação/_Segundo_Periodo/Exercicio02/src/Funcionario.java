import java.util.ArrayList;

public class Funcionario {

    private String matricula;
    private String nome;
    private String nascimento;
    private String cpf;
    private ArrayList<Descendente> descendente = new ArrayList<>();
    
    public Funcionario() {}
    public Funcionario(String matricula, String nome, String nascimento, String cpf) {
        this.matricula = matricula;
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
    }
    
    public String getMatricula() {return matricula;}
    public void setMatricula(String matricula) {this.matricula = matricula;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getNascimento() {return nascimento;}
    public void setNascimento(String nascimento) {this.nascimento = nascimento;}
    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public ArrayList<Descendente> getDescendente() {
        return descendente;
    }
    public void setDescendente(Descendente descendente) {
        this.descendente.add(descendente);
    }

}
