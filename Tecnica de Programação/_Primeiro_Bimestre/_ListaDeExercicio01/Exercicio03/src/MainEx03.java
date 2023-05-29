import java.util.Scanner;

public class MainEx03 {
    public static void main(String[] args) throws Exception {
        
        Scanner input = new Scanner(System.in);

        int tamanho = 4;
        String[][] lista = new String[tamanho][2];
        Double[] altura = new Double[tamanho];
        String[] sexo = new String[tamanho];

        for (int i = 0; i < lista.length; i++) {
            System.out.print("Altura: ");
            altura[i] = input.nextDouble();
            System.out.print("Sexo: ");
            input.skip("\\R");
            sexo[i] = input.nextLine();
        }

        System.out.println(getMinAltura(altura));
        System.out.println(getMaxAltura(altura));
        System.out.println(getMinAlturaF(altura, sexo));
        System.out.println(getMaxAlturaM(altura, sexo));

    }

    static Double getMinAltura(Double[] lista) {
        Double minAltura = 9999.0;

        for (int i = 0; i < lista.length; i++) {
            if (minAltura > lista[i]) {
                minAltura = lista[i];
            }
        }
        if(minAltura >= 9999.0){minAltura = 0.0;}

        return minAltura;
    }

    static Double getMaxAltura(Double[] lista) {
        Double maxAltura = 0.0;

        for (int i = 0; i < lista.length; i++) {
            if (maxAltura < lista[i]) {
                maxAltura = lista[i];
            }
        }

        return maxAltura;
    }

    static Double getMinAlturaF(Double[] altura, String[] sexo) {
        Double minAltura = 9999.0;

        for (int i = 0; i < altura.length; i++) {
            if(sexo[i].equals("fem")) {
                if (minAltura > altura[i]) {
                    minAltura = altura[i];
                }
            }
        }
        if(minAltura >= 9999.0){minAltura = 0.0;}

        return minAltura;
    }

    static Double getMaxAlturaM(Double[] altura, String[] sexo) {
        Double maxAltura = 0.0;

        for (int i = 0; i < altura.length; i++) {
            if(sexo[i].equals("mas")) {
                if (maxAltura < altura[i]) {
                    maxAltura = altura[i];
                }
            }
        }

        return maxAltura;
    }

}
