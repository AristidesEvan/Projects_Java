public class ListaEncadeada {
    private No primeiro = null;
    private int qtd = 0;

    public void inserirInicio(ItemCompra item) {
        No no = new No(item);

        if (this.primeiro == null) {
            this.primeiro = no;
            qtd++;
        } else {
            No aux = this.primeiro;
            this.primeiro = no;
            this.primeiro.setNo(aux);
            qtd++;
        }
    }

    public ItemCompra retirar(ItemCompra item) {
        No aux = null;
        No no = this.primeiro;
        while (no != null) {
            if (no.getItem().getDescricao() == item.getDescricao()) {
                aux = no.getNo();
                this.primeiro = no.getNo();
                return aux.getItem();
            }
            if(no.getNo().getItem().getDescricao() == item.getDescricao()) {
                aux = no.getNo();
                no.setNo(no.getNo().getNo());
                return aux.getItem();
            }
            no = no.getNo();
        }
        return null;
    }

    public ItemCompra buscar(String descricao) {
        No no = this.primeiro;
        while (no != null) {
            if(no.getItem().getDescricao() == descricao) {
                return no.getItem();
            }
            no = no.getNo();
        }
        return null;
    }

    public boolean vazia() {
        return this.primeiro == null;
    }

    public int getQtd() {
        return qtd;
    }

    public String getLista() {
        if (vazia()) {
            return "Lista vazia!";
        } else {
            String aux = "| Descrição - Quantidade - Preço |\n";
            No no = this.primeiro;
            while (no != null) {
                aux += no.getItem().getItemCompra()+"\n";
                no = no.getNo();
            }
            return aux;
        }
    }

}
