package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CadastroDao;

/**
 * Servlet implementation class CadastroDelete
 */
@WebServlet("/cadastrodelete")
public class CadastroDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastroDelete() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cadastrocodCliente = Integer.parseInt(request.getParameter("cadastrocodCliente"));
		CadastroDao.delete(cadastrocodCliente);
		
		CadastroCreateAndFind cadastroCreateAndFind = new CadastroCreateAndFind();
		cadastroCreateAndFind.doGet(request, response);
	}

}
