public class App {
    public static void main(String[] args) throws Exception {
        Arvore arvore = new Arvore();

        Item item1 = new Item("Mario", "12345678");
        Item item2 = new Item("Talita", "8765f4321");
        Item item3 = new Item("José", "56781234");
        Item item4 = new Item("Laura", "98764567");
        Item item5 = new Item("Katia", "56789876");
        Item item6 = new Item("Luan", "23458765");
        Item item7 = new Item("Nivaldo", "32148790");
        Item item8 = new Item("Vando", "35467897");
        Item item9 = new Item("Pedrina", "13467908");
        Item item10 = new Item("Wendell", "41964704");
        Item item12 = new Item("Higor", "41239678");
        Item item13 = new Item("Ivan", "91827364");
        Item item14 = new Item("Paula", "31040192");

        arvore.inserir(item1);
        arvore.inserir(item2);
        arvore.inserir(item3);
        arvore.inserir(item4);
        arvore.inserir(item5);
        arvore.inserir(item6);
        arvore.inserir(item7);
        arvore.inserir(item8);
        arvore.inserir(item9);
        arvore.inserir(item10);
        arvore.inserir(item12);
        arvore.inserir(item13);
        arvore.inserir(item14);
    }
}
