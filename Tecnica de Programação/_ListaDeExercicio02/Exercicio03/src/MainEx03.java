import java.util.Scanner;

public class MainEx03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome completo: ");
        String nome = scanner.nextLine().toLowerCase();
        String[] palavras = nome.split(" ");
        String iniciais = "";

        for (String palavra : palavras) {
            if (!palavra.matches("(e|do|da|dos|das|de|di|du)")) {
                iniciais += palavra.charAt(0);
            }
        }

        System.out.println(iniciais.toUpperCase());

        scanner.close();
    }
}
