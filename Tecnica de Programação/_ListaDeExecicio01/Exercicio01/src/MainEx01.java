import java.util.Scanner;

public class MainEx01 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int[] listaNum;
        int tamanho;
        int num;
        int qntPrimo;

        int flag = 1;
        do {

            System.out.print("Determine o tamanho da lista de números: ");
            tamanho = input.nextInt();
            listaNum = new int[tamanho];

            for (int i = 0; i < listaNum.length; i++) {
                System.out.print("Escreva o número da "+(i+1)+"ª posição: ");
                num = input.nextInt();
                listaNum[i] = num;
            }

            qntPrimo = qntPrimo(listaNum);

            System.out.println("--------------------------------------------");
            System.out.print("Na lista possui "+qntPrimo+" número(s) primo(s).\n");
            System.out.println("--------------------------------------------\n");

            System.out.print("Deseja terminar o programa?\n");
            System.out.print("0 para sim e 1 para não: ");
            flag = input.nextInt();

        } while (flag != 0);

        input.close();
    }

    static public int qntPrimo(int[] lista) {
        int qntPrimo = 0;

            for (int i = 0; i < lista.length; i++) {
                if( isPrimo(lista[i]) ) qntPrimo++; 
            }

        return qntPrimo;
    }

    static public boolean isPrimo(int num) {

        for (int j = 2; j < num; j++) {
            if ( num % j == 0 ) return false;   
        }

        return true;

    }
}
