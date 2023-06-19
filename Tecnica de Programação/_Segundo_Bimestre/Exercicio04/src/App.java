import java.util.Scanner;

import data.ProfissaoDAO;
import model.Profissao;
import data.PessoaDAO;
import model.Pessoa;

public class App {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        int flag = 1;
        do {
            
            escolher();
            flag = input.nextInt();

            switch (flag) {
                case 1:
                        incluirProfissao();
                    break;
                
                case 2:
                        alterarProfissao();
                    break;

                case 3:
                        deletarProfissao();
                    break;

                case 4:
                        listarProfissoes();
                    break;

                case 5:
                        incluirPessoa();
                    break;

                case 6:
                        alterarPessoa();
                    break;

                case 7:
                        deletarPessoa();
                    break;

                case 8:
                    
                    break;

                case 9:
                    
                    break;
            
                default:

                    while (flag < 1 || flag > 9) {
                        System.out.println("Escolha um valor valido de 1 à 9!");
                        System.out.print("Resposta: ");
                        flag = input.nextInt();
                    }

                    break;
            }

        } while (flag == 9);

    }

    public static void escolher() {
        System.out.println("Digite: ");
        System.out.println("1: Para Incluir Profissão.");
        System.out.println("2: Para Alterar Profissão.");
        System.out.println("3: Para Excluir Profissão.");
        System.out.println("4: Para Listar  Profissões.");
        System.out.println("5: Para Incluir Pessoa.");
        System.out.println("6: Para Alterar Pessoa.");
        System.out.println("7: Para Excluir Pessoa.");
        System.out.println("8: Para Listar  Pessoas.");
        System.out.println("9: Para encerrar.\n");
        System.out.print("Resposta: ");
    }

    public static void incluirProfissao() {
        Profissao profissao = new Profissao();

        System.out.print("\n\nDigite o nome da profissão: ");
        String nomeProfissao = input.nextLine();
        System.out.print("\nDigite a descrição da profissão: ");
        String descricaoProfissao = input.nextLine();

        profissao.setNomeProfissao(nomeProfissao);
        profissao.setDescricaoProfissao(descricaoProfissao);

        ProfissaoDAO.cadastrarProfissao(profissao);
    }
    public static void alterarProfissao() {
        Profissao profissao = new Profissao();

        ProfissaoDAO.listarProfissoes();

        System.out.print("\n\nDigite o nome da profissão que deseja alterar ou deixe esse campo em branco caso queira pesquisar pelo código da profissão: ");
        input.skip("\\R");
        String nomeProfissaoAux = input.nextLine();

        if (nomeProfissaoAux.equals("")) {

            do {
                System.out.print("\n\nDigite o código da profissão que deseja alterar: ");
                int codigoProfissaoAux = input.nextInt();
                profissao = ProfissaoDAO.buscarProfissoesPorId(codigoProfissaoAux);
            } while (profissao == null);

        } else {
            profissao = ProfissaoDAO.buscarProfissoesPorNome(nomeProfissaoAux);
            if (profissao == null) {

                do {
                    System.out.print("\n\nDigite o código da profissão que deseja alterar: ");
                    int codigoProfissaoAux = input.nextInt();
                    profissao = ProfissaoDAO.buscarProfissoesPorId(codigoProfissaoAux);
                } while (profissao == null);

            }
        }

        System.out.print("\n\nDigite o novo nome da profissão: ");
        String nomeProfissao = input.nextLine();
        System.out.print("\nDigite a nova descrição da profissão: ");
        String descricaoProfissao = input.nextLine();

        profissao.setNomeProfissao(nomeProfissao);
        profissao.setDescricaoProfissao(descricaoProfissao);

        ProfissaoDAO.cadastrarProfissao(profissao);
    }

    public static void deletarProfissao() {

        Profissao profissao = new Profissao();

        System.out.print("\n\nDigite o id da profissão que deseja deletar: ");
        int idProfissao = input.nextInt();

        profissao.setId_profissao(idProfissao);

        ProfissaoDAO.excluirProfissao(idProfissao);
    }

    public static void listarProfissoes() {

        Profissao profissao = new Profissao();

        ProfissaoDAO.listarProfissoes();

        System.out.print("\n\nDigite o nome da profissão que deseja pesquisar ou deixe esse campo em branco caso queira pesquisar pelo código da profissão: ");
        input.skip("\\R");
        String nomeProfissaoAux = input.nextLine();

        if (nomeProfissaoAux.equals("")) {

            do {
                System.out.print("\n\nDigite o código da profissão que deseja alterar: ");
                int codigoProfissaoAux = input.nextInt();
                profissao = ProfissaoDAO.buscarProfissoesPorId(codigoProfissaoAux);
            } while (profissao == null);

        } else {
            profissao = ProfissaoDAO.buscarProfissoesPorNome(nomeProfissaoAux);
            if (profissao == null) {

                do {
                    System.out.print("\n\nDigite o código da profissão que deseja alterar: ");
                    int codigoProfissaoAux = input.nextInt();
                    profissao = ProfissaoDAO.buscarProfissoesPorId(codigoProfissaoAux);
                } while (profissao == null);

            }
        }

        System.out.println("Para continuar, digite a proxima opcao desejada");
        escolher();
    }

    public static void incluirPessoa() {

        Pessoa pessoa = new Pessoa();

        System.out.print("\n\nDigite o nome da pessoa: ");
        String nomepessoa = input.nextLine();

        pessoa.setNome_pessoa(nomepessoa);

        PessoaDAO.cadastrarPessoa(pessoa);
    }

    public static void alterarPessoa() {
        Pessoa pessoa = new Pessoa();

        PessoaDAO.listarPessoas();

        System.out.print("\n\nDigite o nome da pessoa que deseja alterar ou deixe esse campo em branco caso queira pesquisar pelo código da pessoa: ");
        input.skip("\\R");
        String nomePessoaAux = input.nextLine();

        if (nomePessoaAux.equals("")) {

            do {
                System.out.print("\n\nDigite o código da pessoa que deseja alterar: ");
                int codigoPessoaAux = input.nextInt();
                pessoa = PessoaDAO.buscarPessoasPorId(codigoPessoaAux);
            } while (pessoa == null);

        } else {
            pessoa = PessoaDAO.buscarPessoasPorNome(nomePessoaAux);
            if (pessoa == null) {

                do {
                    System.out.print("\n\nDigite o código da pessoa que deseja alterar: ");
                    int codigoPessoaAux = input.nextInt();
                    pessoa = PessoaDAO.buscarPessoasPorId(codigoPessoaAux);
                } while (pessoa == null);

            }
        }

        System.out.print("\n\nDigite o novo nome da pessoa: ");
        String nomePessoa = input.nextLine();
        System.out.print("\nDigite a nova descrição da pessoa: ");
        String descricaoPessoa = input.nextLine();

        pessoa.setNome_pessoa(nomePessoa);

        PessoaDAO.cadastrarPessoa(pessoa);
    }

     public static void deletarPessoa() {

        Pessoa pessoa = new Pessoa();

        System.out.print("\n\nDigite o id da pessoa que deseja deletar: ");
        int idPessoa = input.nextInt();

        pessoa.setId_pessoa(idPessoa);

        PessoaDAO.excluirPessoa(idPessoa);
    }
    public static void listarPessoas() {

        Pessoa pessoa = new Pessoa();

        PessoaDAO.listarPessoas();

        System.out.print("\n\nDigite o nome da pessoa que deseja pesquisar ou deixe esse campo em branco caso queira pesquisar pelo código da pessoa: ");
        input.skip("\\R");
        String nomePessoaAux = input.nextLine();

        if (nomePessoaAux.equals("")) {

            do {
                System.out.print("\n\nDigite o código da pessoa que deseja alterar: ");
                int codigoPessoaAux = input.nextInt();
                pessoa = PessoaDAO.buscarProfissoesPorId(codigoPessoaAux);
            } while (pessoa == null);

        } else {
            pessoa = PessoaDAO.buscarProfissoesPorNome(nomePessoaAux);
            if (pessoa == null) {

                do {
                    System.out.print("\n\nDigite o código da pessoa que deseja alterar: ");
                    int codigoPessoaAux = input.nextInt();
                    pessoa = PessoaDAO.buscarProfissoesPorId(codigoPessoaAux);
                } while (pessoa == null);

            }
        }

        System.out.println("Para continuar, digite a proxima opcao desejada");
        escolher();
    }

}