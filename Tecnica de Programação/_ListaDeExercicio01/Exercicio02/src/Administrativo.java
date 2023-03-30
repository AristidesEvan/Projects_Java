public class Administrativo extends Assistente {

    String turno;
    Double adicionalNoturno = 0.0;

    public Administrativo(String nome, long cpf, long rg, Double salario, int numeroDeMatricula, String turno) {
        super(nome, cpf, rg, salario, numeroDeMatricula);
        this.turno = turno;

        if (this.turno == "noturno") {
            this.adicionalNoturno = 100.0;
        }
    }

    public void exibDados() {
        System.out.println("| nome - cpf - rg - salario - turno - adicional |");
        System.out.print("| " + getNome() + " - ");
        System.out.print(getCpf() + " - ");
        System.out.print(getRg() + " - ");
        System.out.print(getSalario() + " - ");
        System.out.print(this.turno + " - ");
        System.out.print(this.adicionalNoturno+" |\n\n");
    }

}
