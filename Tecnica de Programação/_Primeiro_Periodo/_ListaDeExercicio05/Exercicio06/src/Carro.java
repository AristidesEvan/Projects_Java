public class Carro extends Transporte{
    int quilometragem;

    public int getQuilometragem() {return quilometragem;}
    public void setQuilometragem(int quilometragem) {
        if (quilometragem >= 0 && quilometragem <= 99999) {
            this.quilometragem = quilometragem;
        }
    }
    public void setVelocidadeCarro(int velocidade) {
        if (velocidade >= 0 && velocidade <= 200) {
            setVelocidade(velocidade);
        }
    }
}
