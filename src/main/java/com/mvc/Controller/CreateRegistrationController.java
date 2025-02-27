package com.mvc.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.Model.DAOServiceImpl;

@WebServlet("/CreateRegistration")
public class CreateRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateRegistrationController() {
        super();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/CreateRegistration.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		DAOServiceImpl service = new DAOServiceImpl();
		service.connectDB();
		service.createRegistration(name, email, mobile);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/CreateRegistration.jsp");
		rd.forward(request, response);
	}

}
