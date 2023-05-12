import javax.swing.JOptionPane;

public class JOptionpaneUtil {

    public static String pgtQtName(){ 
        String mensage;
        mensage = "Quanto nomes deseja criar? : "; 

        return JOptionPane.showInputDialog(null, mensage, "Quantidade de nomes!", 1);
    }

    public static void qtdWrong() {
        String erro = "O valor deve ser maior que 4 e menor que 31!\n";
        JOptionPane.showMessageDialog(null, erro, "erro", 0);
    }

    public static void showList(String listaDeNomes) {
        JOptionPane.showMessageDialog(null, listaDeNomes, "Lista de nomes!", 1);
    }

    public static void error() {
        String erro = "O valor inserido é inválido\n";
        JOptionPane.showMessageDialog(null, erro, "erro", 0);
    }

}
