package step1.servlet;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step1.db.DB;
import step1.model.UserModel;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DB db;

    /**
     * Default constructor. 
     */
    public Servlet1() {
    	super();
		db=new DB();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException{
		// TODO 
			String generalContent="<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Data Display</title></head><body> <table><tr><th>surname</th><th>lastname</th><th>age</th><th>login</th><th>pwd</th></tr>";
			String generalEnd="</table> </body></html>";
			
			ArrayList<UserModel> data = db.getData();

			response.getWriter().write(generalContent);

			for (UserModel i : data) {
				response.getWriter().write("<tr><td>"+i.getSurname()+"</td><td>"+i.getLastname()+"</td><td>"+i.getAge()+"</td><td>"+i.getLogin()+"</td><td>"+i.getPwd()+"</td></tr>");
			}	
			response.getWriter().write(generalEnd);

		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
