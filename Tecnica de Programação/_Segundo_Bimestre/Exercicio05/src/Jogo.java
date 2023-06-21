import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jogo {

    private static final String[] NAIPES = { "♠", "♥", "♦", "♣" };
    private static final String[] VALORES = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
    private List<String> nomesJogadores;
    private List<List<String>> cartasJogadores;
    private List<String> baralho;
    private int numJogadores;
    private int numCartas;

    public void menu() {
        boolean flag = false;

        while (!flag) {
            String opcaoStr = JOptionPane.showInputDialog("MENU:\n" +
                    "1 - Iniciar jogo - nomes aleatórios\n" +
                    "2 - Iniciar jogo - nomes informados pelo usuário\n" +
                    "3 - Mostrar resultado do jogo anterior\n" +
                    "4 - Buscar resultado por jogador\n" +
                    "5 - Terminar jogo");

            int opcao;
            try {
                opcao = Integer.parseInt(opcaoStr);
            } catch (NumberFormatException e) {
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    iniciarJogoNomesAleatorios();
                    break;
                case 2:
                    iniciarJogoNomesPreDefinidos();
                    break;
                case 3:
                    mostrarResultadoNovamente();
                    break;
                case 4:
                    consultarInformacoesJogador();
                    break;
                case 5:
                    flag = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }

    // Inicia um jogo gerando nomes aleatórios para os jogadores

    private void iniciarJogoNomesAleatorios() {
        quantidadeJogadores();
        quantidadeCartas();
        gerarNomesAleatorios();
        iniciarJogo();
    }

    // Inicia um exigindo a criação de para os jogadores
    private void iniciarJogoNomesPreDefinidos() {
        quantidadeJogadores();
        quantidadeCartas();
        NomesJogadores();
        iniciarJogo();
    }

    private void quantidadeJogadores() {
        String quantidadeStr = JOptionPane.showInputDialog("Informe a quantidade de jogadores (3 a 6):");

        boolean quantidadeValida = false;
        while (!quantidadeValida) {
            try {
                numJogadores = Integer.parseInt(quantidadeStr);
                if (numJogadores < 3 || numJogadores > 6) {
                    throw new IllegalArgumentException();
                }
                quantidadeValida = true;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Quantidade inválida! Por favor, informe um número entre 3 e 6.");
                quantidadeStr = JOptionPane.showInputDialog("Informe a quantidade de jogadores (3 a 6):");
            }
        }
    }

    private void quantidadeCartas() {
        String quantidadeStr = JOptionPane.showInputDialog("Informe a quantidade de cartas por jogador (3 ou 4):");

        boolean quantidadeValida = false;
        while (!quantidadeValida) {
            try {
                numCartas = Integer.parseInt(quantidadeStr);
                if (numCartas != 3 && numCartas != 4) {
                    throw new IllegalArgumentException();
                }
                quantidadeValida = true;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Quantidade inválida! Por favor, informe 3 ou 4.");
                quantidadeStr = JOptionPane.showInputDialog("Informe a quantidade de cartas por jogador (3 ou 4):");
            }
        }
    }

    private void NomesJogadores() {
        nomesJogadores = new ArrayList<>();

        for (int i = 0; i < numJogadores; i++) {
            String nome = JOptionPane.showInputDialog("Informe o nome do jogador: " + (i + 1) + ":");
            nomesJogadores.add(nome);
        }
    }

    private void gerarNomesAleatorios() {
        nomesJogadores = new ArrayList<>();

        int tamanhoNome = obterTamanhoNomeAleatorio();

        for (int i = 0; i < numJogadores; i++) {
            String nome = gerarNomeAleatorio(tamanhoNome);
            nomesJogadores.add(nome);
        }
    }


    private void mostrarResultadoNovamente() {
        if (nomesJogadores == null || cartasJogadores == null) {
            JOptionPane.showMessageDialog(null, "Nenhum jogo foi processado anteriormente.");
            return;
        }

        StringBuilder resultado = new StringBuilder();
        List<Jogador> jogadores = criarListaJogadores();
        Collections.sort(jogadores);
        resultado.append("Jogador - Cartas - Pontos\n");

        for (Jogador jogador : jogadores) {
            resultado.append(jogador.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(null, resultado.toString());
    }

    private void consultarInformacoesJogador() {
        if (nomesJogadores == null || cartasJogadores == null) {
            JOptionPane.showMessageDialog(null, "Nenhum jogo foi processado anteriormente.");
            return;
        }

        String nome = JOptionPane.showInputDialog("Informe o nome do jogador:");
        Jogador jogador = null;

        for (int i = 0; i < nomesJogadores.size(); i++) {
            if (nomesJogadores.get(i).equalsIgnoreCase(nome)) {
                jogador = new Jogador(nomesJogadores.get(i), cartasJogadores.get(i));
                break;
            }
        }

        if (jogador == null) {
            JOptionPane.showMessageDialog(null, "Jogador não encontrado.");
        } else {
            JOptionPane.showMessageDialog(null, jogador.toString());
        }
    }

    private int obterTamanhoNomeAleatorio() {
        String tamanhoStr = JOptionPane.showInputDialog("Informe a quantidade de caracteres para cada nome (6 a 10):");

        boolean tamanhoValido = false;
        while (!tamanhoValido) {
            try {
                int tamanho = Integer.parseInt(tamanhoStr);
                if (tamanho < 6 || tamanho > 10) {
                    throw new IllegalArgumentException();
                }
                return tamanho;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Quantidade inválida! Por favor, informe um número entre 6 e 10.");
                tamanhoStr = JOptionPane.showInputDialog("Informe a quantidade de caracteres para cada nome (6 a 10):");
            }
        }
        return -1;
    }

    private String gerarNomeAleatorio(int tamanho) {
        StringBuilder nome = new StringBuilder();

        String[] vogais = { "a", "e", "i", "o", "u" };
        String[] consoantes = { "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v",
                "w", "x", "y", "z" };

        boolean vogalAnterior = false;

        for (int i = 0; i < tamanho; i++) {
            String letra;

            if (vogalAnterior) {
                // Seleciona uma consoante aleatoriamente
                letra = consoantes[(int) (Math.random() * consoantes.length)];
            } else {
                // Seleciona uma vogal aleatoriamente
                letra = vogais[(int) (Math.random() * vogais.length)];
            }

            nome.append(letra);
            vogalAnterior = !vogalAnterior;
        }

        return nome.toString();
    }

    private void iniciarJogo() {
        baralho = criarBaralho();

        cartasJogadores = new ArrayList<>();
        for (int i = 0; i < numJogadores; i++) {
            List<String> cartas = gerarCartas();
            cartasJogadores.add(cartas);
        }

        mostrarResultadoNovamente();
    }

    private List<String> criarBaralho() {
        List<String> baralho = new ArrayList<>();

        for (String valor : VALORES) {
            for (String naipe : NAIPES) {
                baralho.add(valor + naipe);
            }
        }
        Collections.shuffle(baralho);

        return baralho;
    }

    private List<String> gerarCartas() {
        List<String> cartas = new ArrayList<>();

        int numCartasGeradas = 0;
        int numCartasGrupo1 = numCartas / 2;
        int numCartasGrupo2 = numCartas - numCartasGrupo1;

        while (numCartasGeradas < numCartas) {
            String carta = baralho.remove(0);

            if (!cartas.contains(carta)) {
                cartas.add(carta);
                numCartasGeradas++;
            }

            if (numCartasGeradas == numCartasGrupo1 && numCartasGrupo2 > 0) {
                numCartasGeradas--;
                numCartasGrupo2--;
            }
        }

        return cartas;
    }

    private List<Jogador> criarListaJogadores() {
        List<Jogador> jogadores = new ArrayList<>();

        for (int i = 0; i < numJogadores; i++) {
            Jogador jogador = new Jogador(nomesJogadores.get(i), cartasJogadores.get(i));
            jogadores.add(jogador);
        }

        return jogadores;
    }

    private class Jogador implements Comparable<Jogador> {
        private String nome;
        private List<String> cartas;
        private double pontos;

        public Jogador(String nome, List<String> cartas) {
            this.nome = nome;
            this.cartas = cartas;
            calcularPontos();
        }

        private int getValorCarta(String carta) {
            if (carta.equals("A")) {
                return 1;
            } else if (carta.equals("J") || carta.equals("Q") || carta.equals("K")) {
                return 10;
            } else {
                return Integer.parseInt(carta);
            }
        }

        private void calcularPontos() {
            for (String carta : cartas) {
                String valor = carta.substring(0, 1);
                String naipe = carta.substring(1);

                try {
                    int valorInt = getValorCarta(valor);
                    pontos += valorInt;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Erro de formato na carta: " + carta);
                    pontos = 0;
                    break;
                }
            }
        }

        public String getNome() {
            return nome;
        }

        public double getPontos() {
            return pontos;
        }

        @Override
        public int compareTo(Jogador outroJogador) {
            return Double.compare(outroJogador.getPontos(), pontos);
        }

        @Override
        public String toString() {
            StringBuilder cartaStr = new StringBuilder();

            for (String carta : cartas) {
                cartaStr.append(carta).append(" ");
            }

            return nome + " " + cartaStr.toString() + String.format("%.2f", pontos);
        }
    }
}