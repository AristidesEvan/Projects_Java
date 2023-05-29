import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Controle {
    private ArrayList<Jogador> jogadores = new ArrayList<>();
    private int numeroDeJogadasPorJogadores; // Deixar static para jogador
    private int[] intervaloDoNumeroSortido; // Deixar static para jogador]
    private int numeroDePalpites;
    private int numeroSortido;

    public void iniciaJogo() {
        this.numeroDeJogadasPorJogadores = definirQntDeJogadores();

        for (int i = 0; i < numeroDeJogadasPorJogadores; i++) {
            Jogador jogador = new Jogador(gerarStringAleatoria(10)); 

            this.jogadores.add(jogador);
        }
        
        this.intervaloDoNumeroSortido = definirIntervaloDoNumeroSortido();

        this.numeroDePalpites = definirQntDePalpites(this.intervaloDoNumeroSortido);

        for (int i = 0; i < this.jogadores.size(); i++) {
            this.jogadores.get(i).palpitar(this.intervaloDoNumeroSortido, this.numeroDePalpites);
        }

        this.numeroSortido = definirNumeroSortido(this.intervaloDoNumeroSortido);

        definirPossiveisGanhadores(this.jogadores, this.numeroSortido);
    }

    public static String gerarStringAleatoria(int tamanho) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tamanho; i++) {
            char caractere = (char) (random.nextInt(26) + 'A');
            sb.append(caractere);
        }

        return sb.toString();
    }

    public static int definirQntDeJogadores() {
        int numeroDeJogadores = 0;
        String input = "";
        int flag = 1;

        while (flag == 1) {
            try {

                flag++;

                input = JOptionPane.showInputDialog(null, "Digite a quantidade de jogadores! (Números inteiros) (Mínimo de 3 jogadores)", "Quantidade de jogadores", 1);

                while(Integer.parseInt(input) < 3) {
                    JOptionPane.showMessageDialog(null, "Erro de entrada, digite um valor válido! (Números inteiros) (Mínimo de 3 jogadores)", "Erro de entrada!", 0);

                    input = JOptionPane.showInputDialog(null, "Digite a quantidade de jogadores! (Números inteiros) (Mínimo de 3 jogadores)", "Quantidade de jogadores", 1);
                }

                numeroDeJogadores = Integer.parseInt(input);

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

                while(Integer.parseInt(input) < 50) {
                    JOptionPane.showMessageDialog(null, "Erro de entrada, digite um valor maior ou igual a 50!", "Erro de entrada!", 0);

                    input = JOptionPane.showInputDialog(null, "Digite o valor inicial do intervalo para o número sortido! (Números inteiros) (Mínimo 50)", "Número inicial!", 1);
                }

                intervalo[0] = Integer.parseInt(input);

                input = JOptionPane.showInputDialog(null, "Digite o valor final do intervalo para o número sortido! (Números inteiros)", "Número final!", 1);

                while(Integer.parseInt(input) <= intervalo[0]) {
                    JOptionPane.showMessageDialog(null, "Erro de entrada, digite um valor maior do que "+intervalo[0]+"!", "Erro de entrada!", 0);

                    input = JOptionPane.showInputDialog(null, "Digite o valor final do intervalo para o número sortido! (Números inteiros)", "Número final!", 1);
                }

                intervalo[1] = Integer.parseInt(input);

            } catch (NumberFormatException e) {
                flag--;
                JOptionPane.showMessageDialog(null, "Erro de entrada, digite um valor válido! (Números inteiros)", "Erro de entrada!", 0);
            }
        }

        return intervalo;
    }

    public static int definirQntDePalpites(int[] intervalo) {
        int numeroDePalpites = 0;
        String input = "";
        int flag = 1;

        int limitador = (intervalo[1] - intervalo[0] + 1);

        while (flag == 1) {
            try {
                int aux = 0;
                flag++;
                if (limitador < 4) {aux = limitador;} else { aux = 4;}
                input = JOptionPane.showInputDialog(null, "Digite a quantidade de palpites! (Números inteiros) (Mínimo de 1 e máximo de "+aux+")", "Quantidade de jogadores", 1);
                
                while(Integer.parseInt(input) < 1 || Integer.parseInt(input) > aux) {
                    JOptionPane.showMessageDialog(null, "Erro de entrada, digite um valor válido! (Números inteiros) (Mínimo de 1 e máximo de "+aux+")", "Erro de entrada!", 0);

                    input = JOptionPane.showInputDialog(null, "Digite a quantidade de palpites! (Números inteiros) (Mínimo de 1 e máximo de "+aux+")", "Quantidade de jogadores", 1);
                }

                numeroDePalpites = Integer.parseInt(input);

            } catch (NumberFormatException e) {
                flag--;
                JOptionPane.showMessageDialog(null, "Erro de entrada, digite um valor válido! (Números inteiros)", "Erro de entrada!", 0);;
            }
        }

        return numeroDePalpites;
    }

    public int definirNumeroSortido(int[] intervalo) {
        int numeroSortido = 0;

        Random rand = new Random();
        
        numeroSortido = rand.nextInt(intervalo[1] - intervalo[0] + 1) + intervalo[0];

        return numeroSortido;
    }

    public void definirPossiveisGanhadores(ArrayList<Jogador> jogadores, int numeroSortido) {
        String possiveisGanhadores = "NÚMERO SORTIDO: "+numeroSortido+"\n\n";

        for (int i = 0; i < jogadores.size(); i++) {
            int[] palpites = jogadores.get(i).getPalpites();
            for (int j = 0; j < palpites.length; j++) {
                if (palpites[j] == numeroSortido) {
                    possiveisGanhadores += "Jogador "+(i+1)+" "+jogadores.get(i).getNome()+"\n\n";
                }
            }
        }

        JOptionPane.showMessageDialog(null, possiveisGanhadores, "Possíveis ganhadores!", 1);
    }
}
