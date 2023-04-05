public class Gerente extends Funcionario{

    String nivelGerencia;

    public Gerente(String nome, long cpf, long rg, Double salario, String nivelGerencia) {
        super(nome, cpf, rg, salario);
        this.nivelGerencia = nivelGerencia;
    }

    public void aumento() {
        setSalario(getSalario() + getSalario() * 0.15); 
    }

    public void exibDados() {
        System.out.println("| nome - cpf - rg - salario - nivelGerencia |");
        System.out.print("| " + getNome() + " - ");
        System.out.print(getCpf() + " - ");
        System.out.print(getRg() + " - ");
        System.out.print(getSalario() + " - ");
        System.out.print(this.nivelGerencia+" |\n\n");
    }
}
