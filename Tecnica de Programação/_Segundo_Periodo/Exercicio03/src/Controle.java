import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Controle {
    private ArrayList<Jogador> jogadores;
    private int numeroDeJogadasPorJogadores; // Deixar static para jogador
    private int[] intervaloDoNumeroSortido; // Deixar static para jogador
    private int numeroSortido;

    public void iniciaJogo() {

        this.numeroDeJogadasPorJogadores = definirQntDeJogadores();
        
        this.intervaloDoNumeroSortido = definirIntervaloDoNumeroSortido();
        

    }

    public static int definirQntDeJogadores() {
        int numeroDeJogadores = 0;
        String input = "";
        int flag = 1;

        while (flag == 1) {
            try {
                flag++;
                input = JOptionPane.showInputDialog(null, "Digite a quantidade de jogadores! (Números inteiros) (Mínimo de 3 jogadores)", "Quantidade de jogadores", 1);
                numeroDeJogadores = Integer.parseInt(input);
                if(numeroDeJogadores < 3) {
                    flag--;
                    JOptionPane.showMessageDialog(null, "Erro de entrada, digite um valor válido! (Números inteiros) (Mínimo de 3 jogadores)", "Erro de entrada!", 0);;
                }
            } catch (NumberFormatException e) {
                flag--;
                JOptionPane.showMessageDialog(null, "Erro de entrada, digite um valor válido! (Números inteiros)", "Erro de entrada!", 0);;
            }
        }

        return numeroDeJogadores;
    }

    public static int[] definirIntervaloDoNumeroSortido() {
        int[] intervalo = new int[2];
        String input = "";
        int flag = 1;

        while (flag == 1) {
            try {
                flag++;
                input = JOptionPane.showInputDialog(null, "Digite o valor inicial do intervalo para o número sortido! (Números inteiros) (Mínimo 50)", "Número inicial!", 1);
                if(Integer.parseInt(input) < 50) {
                    flag--;
                    JOptionPane.showMessageDialog(null, "Erro de entrada, digite um valor maior ou igual a 50!", "Erro de entrada!", 0);
                    break;
                }
                intervalo[0] = Integer.parseInt(input);
                input = JOptionPane.showInputDialog(null, "Digite o valor final do intervalo para o número sortido! (Números inteiros)", "Número final!", 1);
                if(Integer.parseInt(input) <= 50) {
                    flag--;
                    JOptionPane.showMessageDialog(null, "Erro de entrada, digite um valor maior do que 50!", "Erro de entrada!", 0);
                    break;
                }
                intervalo[1] = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                flag--;
                JOptionPane.showMessageDialog(null, "Erro de entrada, digite um valor válido! (Números inteiros)", "Erro de entrada!", 0);
            }
        }

        return intervalo;
    }

}
