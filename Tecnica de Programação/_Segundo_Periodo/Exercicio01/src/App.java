import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        
        Path caminho = Paths.get("C:/Users/aristides/Desktop/teste.txt");
        String textoEmString = "";
        try {
            
            byte[] textoEmByte = Files.readAllBytes(caminho);
            textoEmString = new String(textoEmByte);

            

        } catch (Exception e) {
            System.out.println(e);
        }

        Tratamento valor = new Tratamento(textoEmString);
        valor.tratar();
        System.out.println(valor.getFuncionarioFormatados());
        
        String titulo = "LISTA DE FUNCIOÁRIOS";
        JOptionPane.showMessageDialog(null, valor.getFuncionarioFormatados(), titulo, 1 );

    }
}
