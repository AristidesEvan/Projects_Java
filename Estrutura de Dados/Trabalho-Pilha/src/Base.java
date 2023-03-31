import java.util.Scanner;

public class Base {
    static Scanner leia = new Scanner(System.in);

    static Contato criarContato() {
        System.out.println("Nome: ");
        leia.skip("\\R");
        String n = leia.nextLine();
        System.out.println("Endereço: ");
        String e = leia.nextLine();
        System.out.println("CPF: ");
        long c = leia.nextLong();
        Contato aux = new Contato(n, e, c);
        return aux;
    }

    public static void main(String[] args) {
        Pilha obj = new Pilha();
        Contato aux = null;
        int n = 0;
        do {
            System.out.println("Tamanho: ");
            n = leia.nextInt();
        } while (!obj.setMaxTam(n));
        do {
            System.out.println("Digite: ");
            System.out.println("1: Para empilhar.");
            System.out.println("2: Para desempilhar.");
            System.out.println("3: Para encerrar.");
            n = leia.nextInt();
            switch (n) {
                case 1:
                    aux = criarContato();
                    if (obj.push(aux))
                        System.out.println("Sucesso.");
                    else
                        System.out.println("Erro: pilha cheia.");
                    aux = null;
                    break;
                case 2:
                    aux = obj.pop();
                    if (aux == null)
                        System.out.println("Erro: pilha vazia.");
                    else
                        System.out.println(aux.getContato());
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