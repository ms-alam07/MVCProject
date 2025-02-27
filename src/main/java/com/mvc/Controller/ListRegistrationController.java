package com.mvc.Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.Model.DAOServiceImpl;

@WebServlet("/ListReg")
public class ListRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ListRegistrationController() {
        super();        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOServiceImpl service = new DAOServiceImpl();
		service.connectDB();
		ResultSet result = service.listAllReg();
		request.setAttribute("res", result);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/ListRegistration.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	}

}
