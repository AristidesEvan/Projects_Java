public class Produto {
    private int matricula;
    private double preco;
    private String descricao;

    public Produto(int matricula, double preco, String descricao) {
        this.matricula = matricula;
        this.preco = preco;
        this.descricao = descricao;
    }

    public int getMatricula() {
        return matricula;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + "\nPreço: " + preco + "\nDescrição: " + descricao;
    }
}
