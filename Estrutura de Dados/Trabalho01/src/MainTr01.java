import java.util.Scanner;

public class MainTr01 {
    static Scanner leia = new Scanner(System.in);

    public static Cliente criarCliente() {
        System.out.println("Nome: ");
        leia.skip("\\R");
        String n = leia.nextLine();
        System.out.println("Idade: ");
        int i = leia.nextInt();
        Cliente aux = new Cliente(n, i);
        return aux;
    }

    public static void main(String[] args) throws Exception {
        Cliente aux = null;
        Fila obj = new Fila();
        int n = 0;

        do {
            System.out.print("Tamanho: ");
            n = leia.nextInt();
        } while (!obj.setMaxTam(n));

        do {
            System.out.println("Digite: ");
            System.out.println("1: Para enfileirar.");
            System.out.println("2: Para desenfileirar.");
            System.out.println("3: Para encerrar.\n");
            System.out.print("Resposta: ");
            n = leia.nextInt();

            switch (n) {
                case 1:
                    aux = criarCliente();
                    if (obj.enfileirar(aux))
                        System.out.println("Sucesso.");
                    else
                        System.out.println("Erro: fila cheia.");
                    aux = null;
                    break;

                case 2:
                    aux = obj.desenfileirar();
                    if (aux == null)
                        System.out.println("Erro: fila vazia.");
                    else
                        System.out.println(aux.getCliente());
                    aux = null;
                    break;

                case 3:
                    System.out.println("Progama encerrando.");
                    break;

                default:
                    System.out.println("Opção inválida.");

            }

        } while (n != 3);

    }
}