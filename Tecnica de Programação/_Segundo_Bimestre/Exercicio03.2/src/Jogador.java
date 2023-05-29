import java.util.Random;

public class Jogador {

    private String nome;
    private int[] palpites;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public void palpitar(int[] intervalo, int numeroDePalpites) {
        int[] palpites = new int[numeroDePalpites];
        for (int i = 0; i < palpites.length; i++) {
            palpites[i] = 0;
        }

        Random rand = new Random();

        for (int i = 0; i < numeroDePalpites; i++) {
            int aux = 0;
            
            int flag = 0;
            do {
                flag = 0;
                aux = rand.nextInt(intervalo[1] - intervalo[0] + 1) + intervalo[0];

                for (int j = 0; j < palpites.length; j++) {
                    if (palpites[j] == aux) {
                        flag = 1;
                    }
                }

            } while (flag == 1);

            palpites[i] = aux;
        }
        
        this.palpites = palpites;
    }

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public int[] getPalpites() {return palpites;}
    public void setPalpites(int[] palpites) {this.palpites = palpites;}

}
