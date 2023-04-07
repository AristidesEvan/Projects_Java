import java.util.Scanner;

public class MainEx04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite um texto: ");
        String texto = input.nextLine();

        int numCaracteres = texto.length();
        int numPalavras = texto.split("\\s+").length;

        System.out.println("Número total de caracteres: " + numCaracteres);
        System.out.println("Número total de palavras: " + numPalavras);

        input.close();
    }
}
