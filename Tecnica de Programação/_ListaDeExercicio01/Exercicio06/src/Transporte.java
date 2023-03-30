public class Transporte {

    boolean ligado;
    int velocidade;

    public boolean isLigado() {return ligado;}
    public void setLigado(boolean ligado) {this.ligado = ligado;}
    public int getVelocidade() {return velocidade;}
    public void setVelocidade(int velocidade) {if(velocidade >= 0){this.velocidade = velocidade;}}

    public void liga() {
        setLigado(true);
    }
    public void desliga() {
        setLigado(false);
        setVelocidade(0);
    }
    
}
