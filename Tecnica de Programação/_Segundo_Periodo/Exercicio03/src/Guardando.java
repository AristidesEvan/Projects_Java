import java.util.Random;

public class Guardando {



    public static String gerarStringAleatoria(int tamanho) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            char caractere = (char) (random.nextInt(26) + 'A');
            sb.append(caractere);
        }

        return sb.toString();
    }
    
}
