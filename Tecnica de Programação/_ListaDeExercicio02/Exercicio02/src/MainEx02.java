import java.util.Scanner;

public class MainEx02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê um número inteiro digitado pelo usuário
        System.out.print("Digite um número inteiro: ");
        int num = scanner.nextInt();

        // Converte o número em uma string
        String strNum = Integer.toString(num);

        // Percorre cada caractere da string e imprime o dígito correspondente por extenso
        for (int i = 0; i < strNum.length(); i++) {
            char ch = strNum.charAt(i);
            switch (ch) {
                case '0':
                    System.out.print("zero");
                    break;
                case '1':
                    System.out.print("um");
                    break;
                case '2':
                    System.out.print("dois");
                    break;
                case '3':
                    System.out.print("três");
                    break;
                case '4':
                    System.out.print("quatro");
                    break;
                case '5':
                    System.out.print("cinco");
                    break;
                case '6':
                    System.out.print("seis");
                    break;
                case '7':
                    System.out.print("sete");
                    break;
                case '8':
                    System.out.print("oito");
                    break;
                case '9':
                    System.out.print("nove");
                    break;
                default:
                    break;
            }
            // Adiciona uma vírgula se não for o último dígito
            if (i < strNum.length() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}