import java.util.Scanner;

public class TestaLista {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Lista obj = new Lista();
        Contato aux = null;
        int n = 0;

        do {
            System.out.print("Escreva o tamanho da lista: ");
            n = input.nextInt();
        } while (!obj.setMaxTam(n));

        do {

            System.out.println("Digite: ");
            System.out.print("1: Para inserir.\n");
            System.out.print("2: Para pesquisar.\n");
            System.out.print("3: Para retirar.\n");
            System.out.print("4: Para mostrar.\n");
            System.out.print("5: Para encerrar.\n");
            System.out.print("Resposta: ");
            n = input.nextInt();
            String cpfString;

            switch (n) {
                case 1:
                    System.out.print("Nome: ");
                    input.skip("\\R");
                    String nome = input.nextLine();
                    System.out.print("Enderço: ");
                    String endereco = input.nextLine();
                    System.out.print("Cpf: ");
                    String cpf = input.nextLine();

                    aux = criaContato(nome, endereco, cpf);

                    if (obj.insereFinal(aux))
                        System.out.println("Sucesso.");
                    else
                        System.out.println("Erro: fila cheia.");
                    aux = null;
                    break;

                case 2:
                    System.out.print("Procure pelo cpf: ");
                    input.skip("\\R");
                    cpfString = input.nextLine();
                    aux = obj.pesquisa(cpfString);
                    if (aux != null) {
                        System.out.println(aux.getContato());
                    } else {
                        System.out.println("Não encontrado.");
                    }
                    aux = null;

                    break;

                case 3:
                    System.out.print("Exclua pelo cpf: ");
                    input.skip("\\R");
                    cpfString = input.nextLine();
                    aux = obj.retira(cpfString);
                    if (aux == null)
                        System.out.println("Erro: fila vazia.");
                    else
                        System.out.println(aux.getContato());
                    aux = null;
                    break;

                case 4:
                    System.out.println(obj.getLista());

                    break;

                case 5:
                    System.out.println("Progama encerrando.");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (n != 5);

        input.close();

    }

    static Contato criaContato(String n, String e, String c) {
        Contato aux = new Contato(n, e, c);
        return aux;
    }

}
