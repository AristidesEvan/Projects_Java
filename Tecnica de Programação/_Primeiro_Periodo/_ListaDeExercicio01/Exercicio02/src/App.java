import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int tamanho = 10;
        Double[] lista = new Double[tamanho];
        Double media;
        int positivos;
        int negativos;
        Double positivosPorCem;
        Double negativosPorCem;

        for (int i = 0; i < lista.length; i++) {
            lista[i] = input.nextDouble(); 
        }

        media = media(lista);

        positivos = qntPositivo(lista);
        negativos = qntNegativo(lista);

        positivosPorCem = porcetagem(positivos, tamanho);
        negativosPorCem = porcetagem(negativos, tamanho);

        System.out.println("Lista: ");
        for (int i = 0; i < lista.length; i++) {
            System.out.print("| "+lista[i]+" |");
        }
        System.out.println("\n");

        System.out.println("Média: " + media + "\n");
        System.out.println("Quantidade de número positivos: " + positivos + "\n");
        System.out.println("Quantidade de número negativos: " + negativos + "\n");
        System.out.println("Porcentagem de números positivos: " + positivosPorCem + "%" + "\n");
        System.out.println("Porcentagem de números negativos: " + negativosPorCem + "%" + "\n");

        input.close();
    }

    static Double media(Double[] lista) {
        Double media = 0.0;

        for (int i = 0; i < lista.length; i++) {
            media += lista[i];
        }

        media = media/lista.length;

        return media;
    }

    static int qntPositivo(Double[] lista) {
        int qntPositivo = 0;

        for (int i = 0; i < lista.length; i++) {
            if(lista[i] >= 0) {
                qntPositivo++;
            }
        }

        return qntPositivo;
    }

    static int qntNegativo(Double[] lista) {
        int qntNegativo = 0;

        for (int i = 0; i < lista.length; i++) {
            if(lista[i] < 0) {
                qntNegativo++;
            }
        }

        return qntNegativo;
    }

    static Double porcetagem(int qnt, int totalInt) {
        Double porcentagem = 0.0;
        Double total = new Double(totalInt);

        porcentagem = (qnt/total) * 100;

        return porcentagem;
    }
}
