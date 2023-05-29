import java.util.Random;

public class SorteioNumero {
    public static int sortearNumero(int inicio, int fim) {
        Random rand = new Random();
        return rand.nextInt(fim - inicio + 1) + inicio;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            int numeroSorteado = sortearNumero(50, 51);
            System.out.println("Número sorteado: " + numeroSorteado);
        }
    }
}
