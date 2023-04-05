import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        float marco1, marco2, tempo = 0, distancia = 0;
        int i = 1, velocidade = 0;
    
        marco1 = input.nextFloat();
        marco2 = input.nextFloat();
    
        while (marco1 != marco2) {
    
            System.out.printf("MARCO 1 = %.2f\n", marco1);
            System.out.printf("MARCO 2 = %.2f\n", marco2);
    
            i++;
            velocidade = i * 10;
            distancia = marco2 - marco1;
            tempo = distancia / velocidade;
    
            while (tempo >= 2 && i <= 8) {
                System.out.printf("VELOCIDADE = %dKm/h DECORREU O TEMPO DE %.1f HORAS\n", velocidade, tempo);
    
                i++;
                velocidade = i * 10;
                distancia = marco2 - marco1;
                tempo = distancia / velocidade;
            }
    
            i = 1;
            marco1 = input.nextFloat();
            marco2 = input.nextFloat();
    
        }
    
        input.close();
    }
}
