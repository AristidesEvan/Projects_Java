package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.Conexao;
import model.Profissao;

public class ProfissaoDAO {

    public static void cadastrarProfissao(Profissao profissao) {

        String sql = "INSERT INTO profissoes (nome_profissao, descricao) VALUES (?, ?);";

        PreparedStatement ps = null;

        try {

            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, profissao.getNomeProfissao());
            ps.setString(2, profissao.getDescricaoProfissao());

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

    public static void listarProfissoes() {

        String sql = "SELECT * FROM profissoes";

        PreparedStatement ps = null;

        try {

            ps = Conexao.getConexao().prepareStatement(sql);

            ResultSet resultSet = ps.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id_profissao");
                String nome = resultSet.getString("nome_profissao");
                String descricao = resultSet.getString("descricao");

                System.out.println("ID: " + id + ", Nome: " + nome + ", Descrição: " + descricao);
            }

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void atualizarProfissao(int id, String nome, String descricao) {

        String sql = "UPDATE profissoes SET nome_profissao = ?, descricao = ? WHERE id_profissao = ?";

        PreparedStatement ps = null;

        try {

            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, nome);
            ps.setString(2, descricao);
            ps.setInt(3, id);

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

        String sql = "DELETE FROM profissoes WHERE id_profissao = ?";

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

    public static Profissao buscarProfissoesPorId(int identificador) {
        Profissao profissao = new Profissao();

        String sql = "SELECT * FROM profissoes WHERE id_profissao = ?";

        PreparedStatement ps = null;

        try {

            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, identificador);

            ResultSet resultSet = ps.executeQuery();

            System.out.println(resultSet.getString("nome_profissao"));

            profissao.setNomeProfissao(resultSet.getString("nome_profissao"));
            profissao.setDescricaoProfissao(resultSet.getString("descricao"));

            ps.close();

            return profissao;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static Profissao buscarProfissoesPorNome(String nomeProfissao) {
        Profissao profissao = new Profissao();

        String aux = "%"+nomeProfissao+"%";
        String sql = "SELECT * FROM profissoes WHERE nome_profissao LIKE ?";

        PreparedStatement ps = null;

        try {

            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, aux);
            
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_profissao");
                String nome = resultSet.getString("nome_profissao");
                String descricao = resultSet.getString("descricao");

                System.out.println("ID: " + id + ", Nome: " + nome + ", Descrição: " + descricao);

                if(profissao.equals(nome)) {
                    profissao.setId_profissao(resultSet.getInt("id_profissao"));
                    profissao.setNomeProfissao(resultSet.getString("nome_profissao"));
                    profissao.setDescricaoProfissao(resultSet.getString("descricao"));
    
                    ps.close();
                    return profissao;
                }
            }

            ps.close();
            return null;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        
    }

}
