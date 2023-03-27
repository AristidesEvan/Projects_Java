public class Animal {

    String nome, cor, ambiente, caracteristicas;
    Double comprimento;
    int patas;

    public Animal(String nome, String cor, String ambiente, String caracteristicas, Double comprimento, int patas) {
        this.nome = nome;
        this.cor = cor;
        this.ambiente = ambiente;
        this.caracteristicas = caracteristicas;
        this.comprimento = comprimento;
        this.patas = patas;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public int getPatas() {
        return patas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public void setPatas(int patas) {
        this.patas = patas;
    }


    

}
