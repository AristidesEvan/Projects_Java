package br.edu.pucgoias.sistemaestoque.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.edu.pucgoias.sistemaestoque.controle.EstoqueControle; 
import br.edu.pucgoias.sistemaestoque.modelo.Estoque;

/**
 * Servlet implementation class ServletAll 
 */

@WebServlet("/servletall")
public class ServletAll extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private Gson gson;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAll() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#Get(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        gson = new GsonBuilder().setPrettyPrinting().create();
        Estoque estoque;
        List<Estoque> lista = new ArrayList<>();

        String retorno = "ERRO";
        boolean acao=false;
        EstoqueControle ec = new EstoqueControle();
        lista = ec.getEstoque();

        String retornoJsonoString = this.gson.toJson(lista);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(retornoJsonoString);
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
