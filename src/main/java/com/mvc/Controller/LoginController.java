package com.mvc.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.Model.DAOServiceImpl;

@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginController() {
        super();        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email =request.getParameter("email");
		String password = request.getParameter("password");
		
		
		DAOServiceImpl service=  new DAOServiceImpl();
		service.connectDB();
		boolean status=service.verifyLogin(email, password);
		if(status) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/CreateRegistration.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("error","Invalid Email/Password");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		}
		
	}

}
