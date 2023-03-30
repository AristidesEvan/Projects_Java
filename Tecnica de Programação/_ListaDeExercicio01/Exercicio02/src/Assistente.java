public class Assistente extends Funcionario{
    
    private int numeroDeMatricula;

    public Assistente(String nome, long cpf, long rg, Double salario, int numeroDeMatricula) {
        super(nome, cpf, rg, salario);
        this.numeroDeMatricula = numeroDeMatricula;
    }

    public void exibDados() {
        System.out.println("| nome - cpf - rg - salario - Matricula |");
        System.out.print("| " + getNome() + " - ");
        System.out.print(getCpf() + " - ");
        System.out.print(getRg() + " - ");
        System.out.print(getSalario() + " - ");
        System.out.print(this.numeroDeMatricula+" |\n\n");
    }

}
