package br.edu.pucgoias.sistemaestoque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.pucgoias.sistemaestoque.modelo.Estoque;

public class EstoqueDAO {
	
	BaseDAO bd = new BaseDAO();
	
	public Estoque obtemEstoqueViaId(int id) throws SQLException{
		Estoque estoque = new Estoque();
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = bd.getConnection();
			
			pstmt = conn.prepareStatement("select * from estoque where id=?");
			
			pstmt.setInt(1,  id);
			
			ResultSet rs = pstmt.executeQuery();		
			if(rs.next()) {
				estoque = this.criaEstoque(rs);
			}
		}
		finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(pstmt != null) {
				conn.close();
			}
		}
		return estoque;
	}

	public String nameFun(String name) {
		name += "string adicional";
		return name;
	}

	private Estoque criaEstoque(ResultSet rs) throws SQLException{
		Estoque estoque = new Estoque();
		estoque.setDescricao(rs.getString("descricao"));
		estoque.setId(rs.getInt("id"));
		estoque.setPrecounit(rs.getDouble("precounit"));
		estoque.setQuantidade(rs.getDouble("quantidade"));
		return estoque;
	}
	
	public List<Estoque> obtemEstoquesGetNome(String nome) throws SQLException{
		List<Estoque> estoques = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Estoque estoque = null;
		try {
			conn = bd.getConnection();
			pstmt = conn.prepareStatement("select * from estoque wherer lower(descricao) like ?");
			pstmt.setString(1, "%" + nome.toLowerCase() + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				estoque = this.criaEstoque(rs);
				estoques.add(estoque);
			}
		}
		finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(pstmt != null) {
				conn.close();
			}
		}
		return estoques;
	}

	public Estoque salvarEstoque(Estoque estoque) {
		String sql="";
		PreparedStatement pstm = null;
		Connection conn = null;
		String opcao = "";

		try {
			conn = bd.getConnection();
			if (estoque.getId() == 0) {
				sql = "insert into estoque (descricao, precounit, quantidade) ";
				sql += "values (?, ?, ?)";
				pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				opcao = "inclusão";
			}
			else {
				sql = "update estoque set descricao = ?, precounit = ?, quantidade = ? ";
				sql+= "where id = ?";
				pstm = conn.prepareStatement(sql);
				opcao = "alteração";
			}
			pstm.setString(1, estoque.getDescricao());
			pstm.setDouble(2, estoque.getPrecounit());
			pstm.setDouble(3, estoque.getQuantidade());

			if (estoque.getId() != 0) {
				pstm.setInt(4, estoque.getId());
			}

			int idAux = pstm.executeUpdate();
			if (idAux >= 0) {
				if (opcao.equals("inclusão")) {
					int idInserir = getGeneratedId(pstm);
					estoque.setId(idInserir);
					estoque.setMensagem("Inclusão efetuada com sucesso!!");
					estoque.setControle(1);
				}
				if (opcao.equals("alteração")) {
					estoque.setMensagem("Alteração efetuadacom sucesso!!");
					estoque.setControle(2);
				}
			} 
			else {
				if (opcao.equals("inclusaõ")) {
					estoque.setMensagem("Inclusão não foi realizada!");
				}
				if (opcao.equals("alteração")) {
					estoque.setMensagem("Alteração não foi realizada!");
				}
			}
		} catch(SQLException e) {
			String msg = "Erro de"+opcao;
			msg = "/n"+e.getMessage();
			estoque.setMensagem(msg); 
		}
		return estoque;
	}
	
	public List<Estoque> getTodos(){
		
		List<Estoque> lista = new ArrayList<>();
		Estoque estoque = new Estoque();
		PreparedStatement pstm = null;
		ResultSet rs;
		Connection conn = null;
		try {
			conn = bd.getConnection();
			String sql = "select * from estoque order by descricao";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				estoque = criaEstoque(rs);
				lista.add(estoque);
			}
		}
		catch(SQLException e) {
			return lista;
		}
		return lista;
	}

	public static Integer getGeneratedId(Statement stmt) throws SQLException{
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			Integer id = rs.getInt(1);
			return id;
		}
		return 0;
	}
	
	public boolean excluir (int id) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = bd.getConnection();
			pstmt = conn.prepareStatement("delete from estoque where id = ?");
			
			pstmt.setInt(1, id);
			int conta = pstmt.executeUpdate();
			boolean retorno = conta > 0;
			return retorno;
		}
		finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (pstmt != null) {
				conn.close();
			}
		}
	}
}