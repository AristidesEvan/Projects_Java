import java.util.Random;

public class Generator {
    public static String generateName(int numOfChar) {
        String aux = "";
        
        for (int i = 0; i < numOfChar; i++) {
            int x = 0;
            Random rand = new Random();
            x = rand.nextInt(26) + 65;

            aux += (char)x;
        }

        return aux;
    }
}
