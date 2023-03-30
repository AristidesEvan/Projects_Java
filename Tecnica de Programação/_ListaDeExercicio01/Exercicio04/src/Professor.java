public class Professor extends Funcionario{

    public Professor(String nome, String sobrenome, int matricula, Double salario) {
        super(nome, sobrenome, matricula, salario);
    }
    
    public Double getSalarioPrimeiraParcela() {
        return getSalario();
    }
    public Double getSalarioSegundaParcela() {
        return getSalario();
    }
    
}
