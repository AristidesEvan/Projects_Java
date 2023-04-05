public class MAinEx09 {

    public static void main(String[] args) {
        int total = 0; // total de grãos
        int grãos = 1; // quantidade de grãos na casa atual

        for (int i = 1; i <= 64; i++) {
            total += grãos;
            grãos *= 2;
        }

        System.out.printf("O total de grãos inseridos no tabuleiro de xadrez é: %d", total);
    }

}
