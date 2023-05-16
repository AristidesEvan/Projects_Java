import java.util.ArrayList;

public class Funcionario {

    public String codigo;
    private int matricula;
    private String nome;
    private String salario;
    private String gratificacao;
    private ArrayList<Descendente> descendente = new ArrayList<>();
    
    public Funcionario() {}
    public Funcionario(String codigo, int matricula, String nome, String salario, String gratificacao) {
        this.codigo = codigo;
        this.matricula = matricula;
        this.nome = nome;
        this.salario = salario;
        this.gratificacao = gratificacao;
    }
    
    public String getCodigo() {return codigo;}
    public void setCodigo(String codigo) {this.codigo = codigo;}
    public int getMatricula() {return matricula;}
    public void setMatricula(int matricula) {this.matricula = matricula;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getSalario() {return salario;}
    public void setSalario(String salario) {this.salario = salario;}
    public String getGratificacao() {return gratificacao;}
    public void setGratificacao(String gratificacao) {this.gratificacao = gratificacao;}
    public ArrayList<Descendente> getDescendente() {
        return descendente;
    }
    public void setDescendente(Descendente descendente) {
        this.descendente.add(descendente);
    }

}
