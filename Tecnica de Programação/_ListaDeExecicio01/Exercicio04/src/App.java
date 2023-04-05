import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);
        int qntTermo;
        Double soma = 100.0, dividendo = 997.0, divisor = 2.0;


        System.out.print("Escreva a quantidade de termos a ser calculado: ");
        qntTermo = input.nextInt();

        for (int i = 1; i < qntTermo; i++) {

            if (divisor % 2 == 0) {
                soma += - (dividendo/divisor);
            } else {
                soma += (dividendo/divisor);
            }

            dividendo += -3;
            divisor += 1;

        }

        System.out.print("Soma: " + soma);

        input.close();

    }
}
