import java.util.Scanner;

public class Pessoa {
    private int matricula;
    private String nome;
    private String cpf;
    private double salario;

    Scanner input = new Scanner(System.in);

    public Pessoa(){}

    public Pessoa(int matricula, String nome, String cpf, double salario) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    public void imprimeDados() {
        System.out.println("Matrícula: " + matricula);
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Salário: " + salario);
    }

    public void setMatricula(String aux) {
        System.out.print(aux);
        this.matricula = input.nextInt();
    }

    public void setNome(String aux) {
        System.out.print(aux);
        input.skip("\\R");
        this.nome = input.nextLine();
    }

    public void setCpf(String aux) {
        System.out.print(aux);
        this.cpf = input.nextLine();
    }

    public void setSalario(String aux) {
        System.out.print(aux);
        this.salario = input.nextDouble();
    }


}