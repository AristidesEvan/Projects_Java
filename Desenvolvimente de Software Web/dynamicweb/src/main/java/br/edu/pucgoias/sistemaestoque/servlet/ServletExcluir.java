package br.edu.pucgoias.sistemaestoque.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import br.edu.pucgoias.sistemaestoque.controle.EstoqueControle;
import br.edu.pucgoias.sistemaestoque.modelo.Estoque;

@WebServlet("/servletexcluir")
public class ServletExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletExcluir() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		String strId = request.getParameter("id");
		
		String retorno = "ERRO";
		boolean acao = false;
		
		if(id > 0) {
			EstoqueControle ec = new EstoqueControle();
			acao = ec.excluir(id);
		}
		if(acao) {
			retorno = "Exclusão realizada com sucesso";
		}
		else {
			retorno = "Exclusão não realizada";
		}
		response.setContentType("text/html);charset=utf-8");
		response.getWriter().print("resposta = " + retorno);
		
	}

}
