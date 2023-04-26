import java.util.Scanner;

public class MainTr01 {
    static Scanner leia = new Scanner(System.in);

    public static ItemCompra criarItemCompra() {
        System.out.print("Descriçao: ");
        leia.skip("\\R");
        String descricao = leia.nextLine();
        System.out.print("Quantidade: ");
        int qtd = leia.nextInt();
        System.out.print("Preço: ");
        double preco = leia.nextDouble();
        ItemCompra aux = new ItemCompra(descricao, qtd, preco);
        return aux;
    }

    public static void main(String[] args) throws Exception {
        ItemCompra aux = null;
        ListaEncadeada lista = new ListaEncadeada();
        int n = 0;

        do {
            System.out.println("Digite: ");
            System.out.println("1: Para inserir.");
            System.out.println("2: Para retirar.");
            System.out.println("3: Para mostrar lista.");
            System.out.println("4: Para encerrar.\n");
            System.out.print("Resposta: ");
            n = leia.nextInt();
            String descricao;

            switch (n) {
                case 1:
                    aux = criarItemCompra();
                    lista.inserirInicio(aux);
                    lista.getLista();
                    break;

                case 2:
                    System.out.print("\nBusque o Item pela descrição: ");
                    leia.skip("\\R");
                    descricao = leia.nextLine();
                    ItemCompra item = lista.buscar(descricao);
                    aux = lista.retirar(item);
                    if (aux == null)
                        System.out.println("\nErro: Lista vazia.");
                    else
                        System.out.println("\nItem excluido: " + aux.getItemCompra());
                    aux = null;
                    break;

                case 3:
                    System.out.println(lista.getLista());
                    break;

                case 4:
                    System.out.println("Progama encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");

            }

        } while (n != 4);

    }
}
