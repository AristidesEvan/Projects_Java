package br.edu.pucgoias.sistemaestoque.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.edu.pucgoias.sistemaestoque.controle.EstoqueControle;
import br.edu.pucgoias.sistemaestoque.modelo.Estoque;

/**
 * Servlet implementation class ServletConsultaPorDescricao
 */
@WebServlet("/servletconsultapordescricao")
public class ServletConsultaPorDescricao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultaPorDescricao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pesquisar = request.getParameter("pesquisar");
		
		gson = new GsonBuilder().setPrettyPrinting().create();
		Estoque estoque;
		List<Estoque> lista = new ArrayList<>();
		
		String retorno = "ERRO";
		boolean acao = false;
		EstoqueControle ec = new EstoqueControle();
		lista = ec.buscaEstoquePorNome(pesquisar);
		
		String retornoJsonString = this.gson.toJson(lista);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(retornoJsonString);
		out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}