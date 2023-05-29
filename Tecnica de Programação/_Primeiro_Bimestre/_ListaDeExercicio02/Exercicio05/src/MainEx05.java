import java.util.Scanner;

public class MainEx05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // letra a)
        System.out.print("Digite um valor inteiro: ");
        int num = sc.nextInt();
        char caractere = (char) num;
        System.out.println("Caractere correspondente: " + caractere);

        // letra b)
        System.out.print("Digite um caractere: ");
        char letra = sc.next().charAt(0);
        int numero = (int) letra;
        System.out.println("Número correspondente: " + numero);

        // letra c)
        System.out.print("Digite um nome em letras minúsculas: ");
        String nomeMinusculo = sc.next();
        String nomeMaiusculo = nomeMinusculo.toUpperCase();
        System.out.println("Nome em maiúsculas: " + nomeMaiusculo);

        // letra d)
        System.out.print("Digite um nome em letras minúsculas: ");
        sc.skip("\\R");
        String nomeCompletoMinusculo = sc.nextLine();
        String[] partesNome = nomeCompletoMinusculo.split(" ");
        String nomeCompletoMaiusculo = "";
        for (String parte : partesNome) {
            String primeiraLetra = parte.substring(0, 1).toUpperCase();
            String restante = parte.substring(1);
            nomeCompletoMaiusculo += primeiraLetra + restante + " ";
        }
        System.out.println("Nome com a primeira letra de cada parte em maiúscula: " + nomeCompletoMaiusculo.trim());

        // letra e)
        System.out.print("Digite um nome em letras maiúsculas: ");
        String nomeCompletoMaiusculo2 = sc.nextLine();
        partesNome = nomeCompletoMaiusculo2.split(" ");
        String nomeCompletoMisto = "";
        for (String parte : partesNome) {
            String primeiraLetra = parte.substring(0, 1).toUpperCase();
            String restante = parte.substring(1).toLowerCase();
            nomeCompletoMisto += primeiraLetra + restante + " ";
        }
        System.out.println("Nome com a primeira letra de cada parte em maiúscula e as demais em minúscula: " + nomeCompletoMisto.trim());

        sc.close();
    }
}