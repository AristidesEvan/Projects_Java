import java.util.Scanner;

public class MainEx07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int canal, audiencia;
        int totalAudiencia = 0;
        int[] audienciaCanal = new int[4]; // índice 0 não é utilizado
        double[] percentualAudiencia = new double[4]; // índice 0 não é utilizado

        // leitura dos dados
        System.out.println("Digite os dados da pesquisa de audiência (0 para sair): ");
        do {
            System.out.print("Canal (4, 5, 7, 12): ");
            canal = input.nextInt();
            if (canal == 0)
                break; // sair do loop se o usuário digitar 0

            System.out.print("Audiência: ");
            audiencia = input.nextInt();
            totalAudiencia += audiencia;

            // adicionar audiência ao canal correspondente
            switch (canal) {
                case 4:
                    audienciaCanal[0] += audiencia;
                    break;
                case 5:
                    audienciaCanal[1] += audiencia;
                    break;
                case 7:
                    audienciaCanal[2] += audiencia;
                    break;
                case 12:
                    audienciaCanal[3] += audiencia;
                    break;
                default:
                    System.out.println("Canal inválido.");
            }
        } while (canal != 0);

        // cálculo do percentual de audiência de cada canal
        for (int i = 0; i <= 3; i++) {
            percentualAudiencia[i] = (double) audienciaCanal[i] / totalAudiencia * 100;
        }

        // exibição dos resultados
        System.out.println("Resultados da pesquisa de audiência:");

        for (int i = 0; i <= 3; i++) {
            
            switch (i) {
                case 0:
                    canal = 4;
                    break;

                case 1:
                    canal = 5;
                    break;

                case 2:
                    canal = 7;
                    break;

                case 3:
                    canal = 12;
                    break;

                default:
                    break;
            }

            System.out.printf("Canal %d: %.2f%%\n", canal, percentualAudiencia[i]);
        }

    }

}
