package br.edu.pucgoias.sistemaestoque.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class ServletConsultaPorId
 */
@WebServlet("/ServletConsultaPorId")
public class ServletConsultaPorId extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultaPorId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		gson = new GsonBuilder().setPrettyPrinting().create();
		Estoque estoque = new Estoque();
		
		int id = 0;
		String strId = request.getParameter("id");
		
		id = Integer.parseInt(strId);
		
		String retorno = "ERRO";
		boolean acao = false;
		if((strId == null || strId.length() == 0 || strId.isEmpty()) && id == 0) {
			estoque.setMensagem("Informação inválida");
		}
		else {
			EstoqueControle ec = new EstoqueControle();
			estoque = ec.getEstoquePorId(id);
		}
		String retornoJsonString = this.gson.toJson(estoque);
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