package br.edu.pucgoias.sistemaestoque.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import br.edu.pucgoias.sistemaestoque.controle.EstoqueControle;
import br.edu.pucgoias.sistemaestoque.modelo.Estoque;


@WebServlet("/servletatualizar")
public class ServletAtualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletAtualizar() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descricao = request.getParameter("descricao");
		double precounit = 0;
		double quantidade = 0;
		int id = 0;
		String strPu = request.getParameter("precounit");
		String strQt = request.getParameter("quantidade");
		String strId = request.getParameter("id");
		
		precounit = Double.parseDouble(strPu);
		quantidade = Double.parseDouble(strQt);
		id = Integer.parseInt(strId);
		
		String retorno = "ERRO";
		boolean acao = false;
		
		if((descricao == null || descricao.length() == 0) && id == 0) {
			retorno = "Descrição inválida";
		}
		else {
			Estoque estoque = new Estoque();
			if((descricao == null || descricao.length() == 0) && id != 0) {
				EstoqueControle ec = new EstoqueControle();
				acao = ec.excluir(id);
			}
			else {
				estoque.setDescricao(descricao);
				estoque.setPrecounit(precounit);
				estoque.setQuantidade(quantidade);
				estoque.setId(id);
				EstoqueControle ec = new EstoqueControle();
				estoque = ec.salvar(estoque);
			}
			if (acao) {
				estoque.setMensagem("Exclusão realizada com sucesso");
			}
			response.setContentType("text/html);charset=utf-8");
			response.getWriter().print("resposta = " + estoque.getMensagem());
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}