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

    public void exibirDados() {
        System.out.println("Matrícula: " + matricula);
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Salário: " + salario);
    }

    public static int lerInt(String mensagem) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensagem);
        int valor = sc.nextInt();
        return valor;
    }

    public static String lerString(String mensagem) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensagem);
        String valor = sc.nextLine();
        return valor;
    }

    public static double lerDouble(String mensagem) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mensagem);
        double valor = sc.nextDouble();
        return valor;
    }

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa(lerInt("Digite a matrícula da primeira pessoa: "),
                                     lerString("Digite o nome da primeira pessoa: "),
                                     lerString("Digite o CPF da primeira pessoa: "),
                                     lerDouble("Digite o salário da primeira pessoa: "));

        Pessoa pessoa2 = new Pessoa(lerInt("Digite a matrícula da segunda pessoa: "),
                                     lerString("Digite o nome da segunda pessoa: "),
                                     lerString("Digite o CPF da segunda pessoa: "),
                                     lerDouble("Digite o salário da segunda pessoa: "));

        Pessoa pessoa3 = new Pessoa(lerInt("Digite a matrícula da terceira pessoa: "),
                                     lerString("Digite o nome da terceira pessoa: "),
                                     lerString("Digite o CPF da terceira pessoa: "),
                                     lerDouble("Digite o salário da terceira pessoa: "));

        System.out.println("Dados das pessoas:");
        System.out.println("-------------------");
        pessoa1.exibirDados();
        System.out.println("-------------------");
        pessoa2.exibirDados();
        System.out.println("-------------------");
        pessoa3.exibirDados();
        System.out.println("-------------------");
    }
}