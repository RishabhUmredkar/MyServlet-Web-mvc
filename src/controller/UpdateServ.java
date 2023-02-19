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


@WebServlet("/update")
public class UpdateServ extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		int id=Integer.parseInt(request.getParameter("id"));
		String fname=request.getParameter("fname");
		String address=request.getParameter("address");
		
		
		Emp e=new Emp(id, fname, address);


		try {
			int a = new EmpDao().update(e);
			if(a>0)
			{
				System.out.println("user Update");
				response.sendRedirect("show");
			}
			else 
				out.print("User not Delete");
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
