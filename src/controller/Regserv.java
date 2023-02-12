package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Emp;
import model.EmpDao;

@WebServlet("/reg")
public class Regserv extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name  = request.getParameter("fname");
		String address = request.getParameter("address");
		
		Emp e = new Emp(id, name, address);
		
	 
		try
		{
			int a = new EmpDao().save(e);

			if(a>0)
			{
				System.out.println("Data is entered");
			}
		
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}

}
