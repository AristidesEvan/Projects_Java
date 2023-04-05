
import java.util.Scanner;

public class MainEx10 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] temposPadrao = new double[3];
        double pontos;

        for (int i = 0; i < temposPadrao.length; i++) {
            System.out.print("Digite o tempo-padrão para a etapa " + (i + 1) + ": ");
            temposPadrao[i] = sc.nextDouble();
        }

        int inscricao = 0;
        double[] pontosEtapa = new double[3];
        double pontosTotal = 0; // Inicializando a variável pontosTotal com 0

        while (inscricao != 9999) {
            System.out.print("Digite o número de inscrição da equipe (ou 9999 para encerrar): ");
            inscricao = sc.nextInt();

            if (inscricao != 9999) {
                pontosTotal = 0; // Zerando a variável pontosTotal para cada equipe

                for (int i = 0; i < pontosEtapa.length; i++) {
                    System.out.print("Digite o tempo gasto pela equipe na etapa " + (i + 1) + ": ");
                    double tempo = sc.nextDouble();

                    double diferenca = Math.abs(tempo - temposPadrao[i]);

                    if (diferenca < 3) {
                        pontos = 100;
                    } else if (diferenca <= 5) {
                        pontos = 80;
                    } else {
                        pontos = 80 - (diferenca - 5) / 5;
                    }

                    pontosEtapa[i] = pontos;
                    pontosTotal += pontos;
                }

                System.out.println("Equipe " + inscricao + ":");
                for (int i = 0; i < pontosEtapa.length; i++) {
                    System.out.println("  Pontos na etapa " + (i + 1) + ": " + pontosEtapa[i]);
                }
                System.out.println("  Pontos totais: " + pontosTotal);
            }
        }

        sc.close();
    }
}
