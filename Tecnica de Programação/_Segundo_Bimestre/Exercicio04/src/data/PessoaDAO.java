package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.Conexao;
import model.Pessoa;

public class PessoaDAO {

    public static void cadastrarPessoa(Pessoa pessoa) {

        String sql = "INSERT INTO pessoas (nome_pessoa, id_lista_de_profissao_fk, id_lista_de_telefones_fk) VALUES (?, ?, ?);";

        PreparedStatement ps = null;

        try {

            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, pessoa.getNome_pessoa());
            ps.setInt(2, pessoa.getId_lista_de_profissao_fk());
            ps.setInt(3, pessoa.getId_lista_de_telefones_fk());

            int rowsAffected = ps.executeUpdate();
            ps.close();

            if (rowsAffected > 0) {
                System.out.println(rowsAffected);
                System.out.println("Inserção realizada com sucesso!");
            } else {
                System.out.println("Nenhum registro inserido!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void listarPessoas() {

        String sql = "SELECT * FROM pessoas";

        PreparedStatement ps = null;

        try {

            ps = Conexao.getConexao().prepareStatement(sql);
            
            ResultSet resultSet = ps.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id_pessoa");
                String nome = resultSet.getString("nome_pessoa");

                System.out.println("ID: " + id + ", Nome: " + nome);
            }

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public static void atualizarPessoa(Pessoa pessoa, int id) {

        String sql = "UPDATE pessoas SET nome_pessoa = ? WHERE id_pessoa = ?";

        PreparedStatement ps = null;

        try {

            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, pessoa.getNome_pessoa());
            ps.setInt(2, id);

            int rowsAffected = ps.executeUpdate();
            ps.close();

            if (rowsAffected > 0) {
                System.out.println(rowsAffected);
                System.out.println("Atualização realizada com sucesso!");
            } else {
                System.out.println("Nenhum registro atualizado!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void excluirProfissao(int id) {

        String sql = "DELETE FROM profissoes WHERE id_pessoa = ?";

        PreparedStatement ps = null;

        try {

            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            ps.close();

            if (rowsAffected > 0) {
                System.out.println(rowsAffected);
                System.out.println("Exclusão realizada com sucesso!");
            } else {
                System.out.println("Nenhum registro excluído!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void buscarProfissoesPorId(int identificador) {

        String sql = "SELECT * FROM profissoes WHERE id_pessoa = ?";

        PreparedStatement ps = null;

        try {

            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, identificador);
            
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_pessoa");
                String nome = resultSet.getString("nome_pessoa");
                String descricao = resultSet.getString("descricao");

                System.out.println("ID: " + id + ", Nome: " + nome + ", Descrição: " + descricao);
            }

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public static void buscarProfissoesPorNome(String nomeProfissao) {

        String aux = "%"+nomeProfissao+"%";
        String sql = "SELECT * FROM profissoes WHERE nome_pessoa LIKE ?";

        PreparedStatement ps = null;

        try {

            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, aux);
            
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_pessoa");
                String nome = resultSet.getString("nome_pessoa");
                String descricao = resultSet.getString("descricao");

                System.out.println("ID: " + id + ", Nome: " + nome + ", Descrição: " + descricao);
            }

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    
}
