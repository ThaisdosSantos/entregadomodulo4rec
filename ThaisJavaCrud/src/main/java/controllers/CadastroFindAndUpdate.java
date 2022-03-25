package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CadastroDao;
import pacote.model.Cadastro;

/**
 * Servlet implementation class CadastroFindAndUpdate
 */
@WebServlet("/cadastroupdate")
public class CadastroFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CadastroFindAndUpdate() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int codCadastro = Integer.parseInt(request.getParameter("cadastrocodCliente"));
		Cadastro cadastro = CadastroDao.findByPk(codCadastro);
		
		request.setAttribute("cadastro", cadastro);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("update.jsp");
		requestDispatcher.forward(request,response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cadastro cadastro = new Cadastro();
		
		cadastro.setCodCliente(Integer.parseInt(request.getParameter("codCliente")));
		cadastro.setNome(request.getParameter("nome"));
        cadastro.setCpf(Long.parseLong(request.getParameter("cpf")));
        cadastro.setRg(Long.parseLong(request.getParameter("rg")));
        cadastro.setNascimento(request.getParameter("nascimento"));
        cadastro.setSexo(request.getParameter("sexo"));
        cadastro.setEmail(request.getParameter("email"));
        cadastro.setSenha(request.getParameter("senha"));
		
		CadastroDao.update(cadastro);
		
		CadastroCreateAndFind cadatroCreateAndFind = new CadastroCreateAndFind();
		cadatroCreateAndFind.doGet(request, response);
	}

}
