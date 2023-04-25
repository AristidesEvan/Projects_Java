public class TesteListaEncadeada {
    public static void main(String[] args) throws Exception {
        
        ListaEncadeada lista = new ListaEncadeada();

        ItemCompra item1 = new ItemCompra("ferramenta", 2, 2.2);
        ItemCompra item2 = new ItemCompra("comida", 3, 10.0);
        ItemCompra item3 = new ItemCompra("roupa", 5, 50.0);

        lista.inserirInicio(item1);
        System.out.println(lista.getLista());
        lista.inserirInicio(item2);
        System.out.println(lista.getLista());
        lista.inserirInicio(item3);
        System.out.println(lista.getLista());

        lista.retirar(item1);
        System.out.println(lista.getLista());

















    }
}
