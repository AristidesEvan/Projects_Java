import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

public class App {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/tecnicasprog";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "pr777";

    public static void main(String[] args) {
        try {

            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);// Conecta ao bd

            ProfissaoDAO profissaoDAO = new ProfissaoDAO(conn);
            PessoaDAO pessoaDAO = new PessoaDAO(conn);
            TelefoneDAO telefoneDAO = new TelefoneDAO(conn);
            System.out.println("conectado com sucesso!");

            boolean sair = false;
            Scanner scanner = new Scanner(System.in);

            while (!sair) {
                exibirMenu();
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        incluirProfissao(scanner, profissaoDAO);
                        break;
                    case 2:
                        alterarProfissao(scanner, profissaoDAO);
                        break;
                    case 3:
                        excluirProfissao(scanner, profissaoDAO);
                        break;
                    case 4:
                        listarProfissoes(profissaoDAO);
                        break;
                    case 5:
                        incluirPessoa(scanner, pessoaDAO, telefoneDAO);
                        break;
                    case 6:
                        alterarPessoa(scanner, pessoaDAO, telefoneDAO);
                        break;
                    case 7:
                        excluirPessoa(scanner, pessoaDAO, telefoneDAO);
                        break;
                    case 8:
                        listarPessoasTelefones(pessoaDAO, telefoneDAO);
                        break;
                    case 9:
                        sair = true;
                        break;
                    default:
                        System.out.println("Opçao invalida! Tente novamente.");
                        break;
                }
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private static void exibirMenu() {
        System.out.println("Menu de opçoes:");
        System.out.println("1 - Incluir Profissao");
        System.out.println("2 - Alterar Profissao");
        System.out.println("3 - Excluir Profissao");
        System.out.println("4 - Listar Profissoes");
        System.out.println("5 - Incluir Pessoa");
        System.out.println("6 - Alterar Pessoa");
        System.out.println("7 - Excluir Pessoa");
        System.out.println("8 - Listar Pessoas/Telefones");
        System.out.println("9 - Fim");
        System.out.print("Escolha uma opçao: ");
    }

    private static void incluirProfissao(Scanner scanner, ProfissaoDAO profissaoDAO) {
        System.out.print("Digite o nome da profissao: ");
        String nomeProfissao = scanner.nextLine();

        try {
            profissaoDAO.inserirProfissao(nomeProfissao);
            System.out.println("Profissao inserida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir profissao: " + e.getMessage());
        }
    }

    private static void alterarProfissao(Scanner scanner, ProfissaoDAO profissaoDAO) {
        System.out.print("Digite o nome completo ou parte do nome da profissao: ");
        String buscaProfissao = scanner.nextLine();

        try {
            profissaoDAO.listarProfissoes(buscaProfissao);
            System.out.print("Digite o codigo da profissao que deseja alterar: ");
            int codigoProfissao = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Digite o novo nome da profissao: ");
            String novoNomeProfissao = scanner.nextLine();

            profissaoDAO.alterarProfissao(codigoProfissao, novoNomeProfissao);
            System.out.println("Profissao alterada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao alterar profissao: " + e.getMessage());
        }
    }

    private static void excluirProfissao(Scanner scanner, ProfissaoDAO profissaoDAO) {
        System.out.print("Digite o nome completo ou parte do nome da profissao: ");
        String buscaProfissao = scanner.nextLine();

        try {
            profissaoDAO.listarProfissoes(buscaProfissao);
            System.out.print("Digite o codigo da profissao que deseja excluir: ");
            int codigoProfissao = scanner.nextInt();
            scanner.nextLine();

            profissaoDAO.excluirProfissao(codigoProfissao);
            System.out.println("Profissao excluida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir profissao: " + e.getMessage());
        }
    }

    private static void listarProfissoes(ProfissaoDAO profissaoDAO) {
        try {
            profissaoDAO.listarProfissoes("");
        } catch (SQLException e) {
            System.out.println("Erro ao listar profissoes: " + e.getMessage());
        }
    }

    private static void incluirPessoa(Scanner scanner, PessoaDAO pessoaDAO, TelefoneDAO telefoneDAO) {
        System.out.print("Digite o nome da pessoa: ");
        String nomePessoa = scanner.nextLine();

        System.out.print("Digite o codigo da profissao da pessoa: ");
        int codigoProfissao = scanner.nextInt();
        scanner.nextLine();

        try {
            pessoaDAO.inserirPessoa(nomePessoa, codigoProfissao);

            System.out.print("Digite a quantidade de telefones da pessoa: ");
            int quantidadeTelefones = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < quantidadeTelefones; i++) {
                System.out.print("Digite o número do telefone " + (i + 1) + ": ");
                String numeroTelefone = scanner.nextLine();

                telefoneDAO.inserirTelefone(nomePessoa, numeroTelefone);
            }

            System.out.println("Pessoa e telefones inseridos com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir pessoa: " + e.getMessage());
        }
    }

    private static void alterarPessoa(Scanner scanner, PessoaDAO pessoaDAO, TelefoneDAO telefoneDAO) {
        System.out.print("Digite o nome completo ou parte do nome da pessoa: ");
        String buscaPessoa = scanner.nextLine();

        try {
            pessoaDAO.listarPessoas(buscaPessoa);
            System.out.print("Digite o codigo da pessoa que deseja alterar: ");
            int codigoPessoa = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Digite o novo nome da pessoa: ");
            String novoNomePessoa = scanner.nextLine();

            pessoaDAO.alterarPessoa(codigoPessoa, novoNomePessoa);

            telefoneDAO.excluirTelefonesPessoa(codigoPessoa);

            System.out.print("Digite a quantidade de telefones da pessoa: ");
            int quantidadeTelefones = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < quantidadeTelefones; i++) {
                System.out.print("Digite o numero do telefone " + (i + 1) + ": ");
                String numeroTelefone = scanner.nextLine();

                telefoneDAO.inserirTelefone(novoNomePessoa, numeroTelefone);
            }

            System.out.println("Pessoa e telefones alterados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao alterar pessoa: " + e.getMessage());
        }
    }

    private static void excluirPessoa(Scanner scanner, PessoaDAO pessoaDAO, TelefoneDAO telefoneDAO) {
        System.out.print("Digite o nome completo ou parte do nome da pessoa: ");
        String buscaPessoa = scanner.nextLine();

        try {
            pessoaDAO.listarPessoas(buscaPessoa);
            System.out.print("Digite o codigo da pessoa que deseja excluir: ");
            int codigoPessoa = scanner.nextInt();
            scanner.nextLine();

            telefoneDAO.excluirTelefonesPessoa(codigoPessoa);

            pessoaDAO.excluirPessoa(codigoPessoa);

            System.out.println("Pessoa e telefones excluidos com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir pessoa: " + e.getMessage());
        }
    }

    private static void listarPessoasTelefones(PessoaDAO pessoaDAO, TelefoneDAO telefoneDAO) {
        try {
            pessoaDAO.listarPessoasTelefones();
        } catch (SQLException e) {
            System.out.println("Erro ao listar pessoas/telefones: " + e.getMessage());
        }
    }
}

class ProfissaoDAO {
    private Connection conn;

    public ProfissaoDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserirProfissao(String nomeProfissao) throws SQLException {
        String sql = "INSERT INTO Profissao (Nome) VALUES (?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nomeProfissao);
        stmt.executeUpdate();
        stmt.close();
    }

    public void alterarProfissao(int codigoProfissao, String novoNomeProfissao) throws SQLException {
        String sql = "UPDATE Profissao SET Nome = ? WHERE ID = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, novoNomeProfissao);
        stmt.setInt(2, codigoProfissao);
        stmt.executeUpdate();
        stmt.close();
    }

    public void excluirProfissao(int codigoProfissao) throws SQLException {
        String sql = "DELETE FROM Profissao WHERE ID = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codigoProfissao);
        stmt.executeUpdate();
        stmt.close();
    }

    public void listarProfissoes(String buscaProfissao) throws SQLException {
        String sql = "SELECT ID, Nome FROM Profissao WHERE Nome LIKE ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + buscaProfissao + "%");
        ResultSet rs = stmt.executeQuery();

        System.out.println("Profissoes encontradas:");

        while (rs.next()) {
            int codigoProfissao = rs.getInt("ID");
            String nomeProfissao = rs.getString("Nome");
            System.out.println("Codigo: " + codigoProfissao + " - Descriçao: " + nomeProfissao);
        }

        rs.close();
        stmt.close();
    }
}

class PessoaDAO {
    private Connection conn;

    public PessoaDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserirPessoa(String nomePessoa, int codigoProfissao) throws SQLException {
        String sql = "INSERT INTO Pessoa (Nome, profissaoid) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nomePessoa);
        stmt.setInt(2, codigoProfissao);
        stmt.executeUpdate();
        stmt.close();
    }

    public void alterarPessoa(int codigoPessoa, String novoNomePessoa) throws SQLException {
        String sql = "UPDATE Pessoa SET Nome = ? WHERE ID = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, novoNomePessoa);
        stmt.setInt(2, codigoPessoa);
        stmt.executeUpdate();
        stmt.close();
    }

    public void excluirPessoa(int codigoPessoa) throws SQLException {
        String sql = "DELETE FROM Pessoa WHERE ID = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codigoPessoa);
        stmt.executeUpdate();
        stmt.close();
    }

    public void listarPessoas(String buscaPessoa) throws SQLException {
        String sql = "SELECT ID, Nome FROM Pessoa WHERE Nome LIKE ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + buscaPessoa + "%");
        ResultSet rs = stmt.executeQuery();

        System.out.println("Pessoas encontradas:");

        while (rs.next()) {
            int codigoPessoa = rs.getInt("ID");
            String nomePessoa = rs.getString("Nome");
            System.out.println("Codigo: " + codigoPessoa + " - Nome: " + nomePessoa);
        }

        rs.close();
        stmt.close();
    }

    public void listarPessoasTelefones() throws SQLException {
        String sql = "SELECT p.ID, p.Nome, t.Numero FROM Pessoa p LEFT JOIN Telefone t ON p.ID = t.PessoaID";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        System.out.println("Pessoas/Telefones encontrados:");

        int codigoPessoaAnterior = -1;

        while (rs.next()) {
            int codigoPessoa = rs.getInt("ID");
            String nomePessoa = rs.getString("Nome");
            String telefone = rs.getString("numero");

            if (codigoPessoa != codigoPessoaAnterior) {
                System.out.println("Codigo: " + codigoPessoa + " - Nome: " + nomePessoa);
                codigoPessoaAnterior = codigoPessoa;
            }

            if (telefone != null) {
                System.out.println("Telefone: " + telefone);
            }
        }

        rs.close();
        stmt.close();
    }
}

class TelefoneDAO {
    private Connection conn;

    public TelefoneDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserirTelefone(String nomePessoa, String numeroTelefone) throws SQLException {
        String sql = "INSERT INTO Telefone (PessoaID, Numero) VALUES ((SELECT ID FROM Pessoa WHERE Nome = ?), ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nomePessoa);
        stmt.setString(2, numeroTelefone);
        stmt.executeUpdate();
        stmt.close();
    }

    public void excluirTelefonesPessoa(int codigoPessoa) throws SQLException {
        String sql = "DELETE FROM Telefone WHERE PessoaID = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, codigoPessoa);
        stmt.executeUpdate();
        stmt.close();
    }
}