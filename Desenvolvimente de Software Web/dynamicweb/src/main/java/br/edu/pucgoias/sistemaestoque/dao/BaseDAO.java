package br.edu.pucgoias.sistemaestoque.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDAO {
	public BaseDAO(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
			
		}
	}
	
	public Connection getConnection() throws SQLException{
		String url="jdbc:mysql://localhost/sistema_estoque_web";
		
		Connection conn = DriverManager.getConnection(url, "root", "caiky");
		
		return conn;
	}
	
	public static void main(String[] args) throws SQLException{
		BaseDAO bd = new BaseDAO();
		Connection conn = bd.getConnection();
		
		if(conn != null) {
			System.out.println("Conectou!!");
		}else {
			System.out.println("Não conectou!");
		}
	}
}