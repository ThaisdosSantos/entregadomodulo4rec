package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CadastroDao;
import pacote.model.Cadastro;

/**
 * Servlet implementation class CadastroCreateAndFind
 */
@WebServlet("/cadastrofind")
public class CadastroCreateAndFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CadastroCreateAndFind() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String pesquisa = request.getParameter("pesquisa");

        if(pesquisa == null) {

            pesquisa = " ";
        }

        List<Cadastro> cadastros = CadastroDao.find(pesquisa);

        request.setAttribute("cadastros", cadastros);
        RequestDispatcher d = request.getRequestDispatcher("listacadastro.jsp");
        d.forward(request, response);
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cadastro cadastro = new Cadastro();
		
        cadastro.setNome(request.getParameter("nome"));
        cadastro.setCpf(Long.parseLong(request.getParameter("cpf")));
        cadastro.setRg(Long.parseLong(request.getParameter("rg")));
        cadastro.setNascimento(request.getParameter("nascimento"));
        cadastro.setSexo(request.getParameter("sexo"));
        cadastro.setEmail(request.getParameter("email"));
        cadastro.setSenha(request.getParameter("senha"));

        CadastroDao.create(cadastro);
		
		doGet(request, response);
	}

}
