public class Tecnico extends Assistente {
    
    Double bonusSalarial;

    public Tecnico(String nome, long cpf, long rg, Double salario, int numeroDeMatricula) {
        super(nome, cpf, rg, salario, numeroDeMatricula);
        this.bonusSalarial = 200.0;
    }

    public void exibDados() {
        System.out.println("| nome - cpf - rg - salario - bonus |");
        System.out.print("| " + getNome() + " - ");
        System.out.print(getCpf() + " - ");
        System.out.print(getRg() + " - ");
        System.out.print(getSalario() + " - ");
        System.out.print(this.bonusSalarial+" |\n\n");
    }

}
