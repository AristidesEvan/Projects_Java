import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        
        Path caminho = Paths.get("C:/Users/aristides/Desktop/teste.txt");

        try {
            
            byte[] textoEmByte = Files.readAllBytes(caminho);
            String textoEmString = new String(textoEmByte);

            Tratamento valor = new Tratamento(textoEmString);
            valor.tratar();
            

            JOptionPane.showMessageDialog(null, textoEmString, textoEmString, 1 );

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
