import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        
        Path caminho = Paths.get("C:/Users/arist/Desktop/teste.txt"); // Pega o caminho do arquivo;
        String textoEmString = "";

        try {
            
            byte[] textoEmByte = Files.readAllBytes(caminho); // Guarda o arquivo do caminho em bytes;
            textoEmString = new String(textoEmByte); // transforma os bytes em String;
            
        } catch (Exception e) {
            System.out.println(e);
        }

        Tratamento valor = new Tratamento(textoEmString); // Guarda a String (o texto) na classe Tratamento;
        valor.tratar(); // Trata o texto e guarda-os no sistema em beans;

        System.out.println(valor.getFuncionarioFormatados()); // Mostra os funcionarios e descendentes pelo terminal;
        
        String titulo = "LISTA DE FUNCIOÁRIOS";
        JOptionPane.showMessageDialog(null, valor.getFuncionarioFormatados(), titulo, 1 ); // Mostra os funcionários e descendentes pelo JOptionPane;

    }
}
