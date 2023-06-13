public class App {
    public static void main(String[] args) throws Exception {
        Arvore arvore = new Arvore();

        Produto produto1 = new Produto(1, 1.0, "12345678");
        Produto produto2 = new Produto(2, 1.0, "8765f4321");
        Produto produto3 = new Produto(3, 1.0, "56781234");
        Produto produto4 = new Produto(4, 1.0, "98764567");
        Produto produto5 = new Produto(5, 1.0, "56789876");
        Produto produto6 = new Produto(6, 1.0, "23458765");
        Produto produto7 = new Produto(7, 1.0, "32148790");
        Produto produto8 = new Produto(8, 1.0, "35467897");
        Produto produto9 = new Produto(9, 1.0, "13467908");
        Produto produto10 = new Produto(10, 1.0, "41964704");
        Produto produto12 = new Produto(12, 1.0, "41239678");
        Produto produto13 = new Produto(13, 1.0, "91827364");
        Produto produto14 = new Produto(14, 1.0, "31040192");

        arvore.inserir(produto1);
        arvore.inserir(produto2);
        arvore.inserir(produto3);
        arvore.inserir(produto4);
        arvore.inserir(produto5);
        arvore.inserir(produto6);
        arvore.inserir(produto7);
        arvore.inserir(produto8);
        arvore.inserir(produto9);
        arvore.inserir(produto10);
        arvore.inserir(produto12);
        arvore.inserir(produto13);
        arvore.inserir(produto14);

    }
}