import java.util.ArrayList;

public class Funcionario {

    private int codigo;
    private int matricula;
    private String nome;
    private Double salario;
    private Double gratificacao;
    private ArrayList<Descendente> descendente = new ArrayList<>();
    
    public Funcionario() {}
    public Funcionario(int codigo, int matricula, String nome, Double salario, Double gratificacao) {
        this.codigo = codigo;
        this.matricula = matricula;
        this.nome = nome;
        this.salario = salario;
        this.gratificacao = gratificacao;
    }
    
    public int getCodigo() {return codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}
    public int getMatricula() {return matricula;}
    public void setMatricula(int matricula) {this.matricula = matricula;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public Double getSalario() {return salario;}
    public void setSalario(Double salario) {this.salario = salario;}
    public Double getGratificacao() {return gratificacao;}
    public void setGratificacao(Double gratificacao) {this.gratificacao = gratificacao;}
    public ArrayList<Descendente> getDescendente() {
        return descendente;
    }
    public void setDescendente(Descendente descendente) {
        this.descendente.add(descendente);
    }

}
