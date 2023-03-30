public class Funcionario extends Pessoa{
    private int matricula;
    private Double salario;

    public Funcionario(String nome, String sobrenome, int matricula, Double salario) {
        super(nome, sobrenome);
        this.matricula = matricula;
        setSalario(salario);
    }
    public int getMatricula() {return matricula;}
    public void setMatricula(int matricula) {this.matricula = matricula;}
    public Double getSalario() {return salario;}
    public void setSalario(Double salario) {if(salario >= 0){this.salario = salario;}}

    public Double getSalarioPrimeiraParcela() {
        return this.salario * 0.6;
    }
    public Double getSalarioSegundaParcela() {
        return this.salario * 0.4;
    }
    
}
