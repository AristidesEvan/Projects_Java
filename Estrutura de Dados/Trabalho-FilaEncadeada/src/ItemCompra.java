public class ItemCompra {
    private String descricao;
    private int qtd;
    private double preco;

    public ItemCompra(String descricao, int qtd, double preco) {
        setDescricao(descricao);
        setQtd(qtd);
        setPreco(preco);
    }

    public boolean setQtd(int qtd) {
        // qtd >= 0
        if (qtd >= 0) {
            this.qtd = qtd;
            return true;
        }
        return false;
    }

    public boolean setPreco(double preco) {
        //preco > 0.0
        if (preco > 0.0) {
            this.preco = preco;
            return true;
        }
        return false;
    }

    public void setDescricao(String descricacao) {
        this.descricao = descricacao;
    }

    public String getItemCompra() {
        String aux;
        aux = "|"+ this.descricao + " - " + this.qtd + " - " + this.preco +"|" ;
        return aux;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
