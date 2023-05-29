// Importa a classe Scanner do pacote java.util
import java.util.Scanner;

// Declaração da classe MainEx03
public class MainEx03 {
    // Método principal da classe
    public static void main(String[] args) {
        // Cria um objeto da classe Scanner para leitura de entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita que o usuário digite o nome completo
        System.out.print("Digite o nome completo: ");

        // Lê a entrada do usuário, converte para minúsculas e armazena na variável 'nome'
        String nome = scanner.nextLine().toLowerCase();

        // Divide o nome completo em palavras e armazena em um array de strings 'palavras'
        String[] palavras = nome.split(" ");

        // Inicializa uma string vazia para armazenar as iniciais
        String iniciais = "";

        // Loop que itera sobre cada palavra no array 'palavras'
        for (String palavra : palavras) {
            // Verifica se a palavra é uma preposição ou conjunção que não deve ser considerada na formação das iniciais
            if (!palavra.matches("(e|do|da|dos|das|de|di|du)")) {
                // Adiciona a inicial da palavra na string 'iniciais'
                iniciais += palavra.charAt(0);
            }
        }

        // Converte a string 'iniciais' para maiúsculas e imprime na saída padrão
        System.out.println(iniciais.toUpperCase());

        // Fecha o objeto da classe Scanner
        scanner.close();
    }
}