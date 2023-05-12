import java.util.Scanner;

public class Pessoa {
    private int matricula;
    private String nome;
    private String cpf;
    private double salario;

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

    public static int leInt(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        return sc.nextInt();
    }

    public static String leString(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        return sc.nextLine();
    }

    public static double leDouble(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print(msg);
        return sc.nextDouble();
    }
}