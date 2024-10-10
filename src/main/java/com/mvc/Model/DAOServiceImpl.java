package com.mvc.Model;

import java.sql.*;

public class DAOServiceImpl implements DAOService {
	private Connection con;
	private Statement st;
	
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvcdemo","root","root");
			st =con.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

	@Override
	public boolean verifyLogin(String email, String password) {
		try {
			ResultSet rs = st.executeQuery("select * from login where email='"+email+"' and password= '"+password+"'  ");
			return rs.next();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}	
	

	@Override
	public void createRegistration(String name, String email, String mobile) {
		try {
			st.executeUpdate("insert into registration values('"+name+"','"+email+"','"+mobile+"')");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRegistration(String email) {
		try {
			
			st.executeUpdate("delete from registration where email ='"+email+"' ");			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void updateRegistration(String email, String mobile) {		
		try {
			st.executeUpdate("update registraion set mobile='"+mobile+"' where email='"+email+"' ");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet listAllReg() {		
		try {
			return st.executeQuery("select * from registration");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
