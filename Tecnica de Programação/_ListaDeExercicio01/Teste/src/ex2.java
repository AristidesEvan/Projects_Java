import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int tamanho = 5, positivos = 0, negativos = 0;
        double media = 0, porcentPositivos, porcentNegativos;
        double lista[] = new double[tamanho];

        for (int i = 0; i < lista.length; i++) {
            lista[i] = sc.nextDouble();
            media = media + lista[i];

            if(lista[i]%2==0){
                positivos = positivos + 1;
            } else {
                negativos = negativos + 1;
            }

        }
        media = media / tamanho;

        porcentPositivos = positivos/tamanho;
        porcentPositivos = porcentPositivos * 100;
        porcentNegativos = (negativos/tamanho);

        System.out.println("Média: " + media + "\n");
        System.out.println("Quantidade de número positivos: " + positivos + "\n");
        System.out.println("Quantidade de número negativos: " + negativos + "\n");
        System.out.println("Porcentagem de números positivos: " + porcentPositivos + "%" + "\n");
        System.out.println("Porcentagem de números negativos: " + porcentNegativos + "%" + "\n");
        sc.close();
    }
}