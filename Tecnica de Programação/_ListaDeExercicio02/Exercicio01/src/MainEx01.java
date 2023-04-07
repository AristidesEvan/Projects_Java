import java.util.Scanner;

public class MainEx01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê a string digitada pelo usuário
        System.out.print("Digite uma string: ");
        String str = scanner.nextLine();

        // Conta o número de caracteres
        int numCaracteres = str.length();
        System.out.println("Número de caracteres: " + numCaracteres);

        // Converte a string para maiúsculas
        String strMaiuscula = str.toUpperCase();
        System.out.println("String em maiúsculo: " + strMaiuscula);

        // Conta o número de vogais
        int numVogais = 0;
        for (int i = 0; i < numCaracteres; i++) {
            char ch = Character.toUpperCase(str.charAt(i));
            if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                numVogais++;
            }
        }
        System.out.println("Número de vogais: " + numVogais);

        // Verifica se a string começa com "UNI" (ignorando maiúsculas/minúsculas)
        if (str.toUpperCase().startsWith("UNI")) {
            System.out.println("A string começa com UNI");
        } else {
            System.out.println("A string não começa com UNI");
        }

        // Verifica se a string termina com "RIO" (ignorando maiúsculas/minúsculas)
        if (str.toUpperCase().endsWith("RIO")) {
            System.out.println("A string termina com RIO");
        } else {
            System.out.println("A string não termina com RIO");
        }

        // Conta o número de dígitos (0 a 9)
        int numDigitos = 0;
        for (int i = 0; i < numCaracteres; i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                numDigitos++;
            }
        }
        System.out.println("Número de dígitos: " + numDigitos);

        scanner.close();
    }
}
