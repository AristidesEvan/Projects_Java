package connection;

// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static final String url = "jdbc:mysql://localhost:3306/_atividade04";
    private static final String user = "root";
    private static final String password = "";

    private static Connection conn;

    public static Connection getConexao() {
        
        try {
            if(conn == null) {
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            } else {
                return conn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}

// public class Conexao {
//     private static final String URL = "jdbc:mysql://localhost:3306/devsbook";
//     private static final String USUARIO = "root";
//     private static final String SENHA = "";

//     private Connection conexao;

//     public Connection getConexao() {
//         if (conexao == null) {
//             try {
//                 conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
//                 System.out.println("Conexão estabelecida com sucesso!");
//             } catch (SQLException e) {
//                 System.out.println("Erro ao conectar-se ao banco de dados: " + e.getMessage());
//             }
//         }
//         return conexao;
//     }

//     public void fecharConexao() {
//         if (conexao != null) {
//             try {
//                 conexao.close();
//                 System.out.println("Conexão fechada com sucesso!");
//             } catch (SQLException e) {
//                 System.out.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
//             }
//         }
//     }
// }