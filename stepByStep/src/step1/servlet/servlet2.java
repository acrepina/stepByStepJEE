package step1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step1.db.DB;
import step1.model.UserModel;

/**
 * Servlet implementation class servlet2
 */
@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DB db;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet2() {
        super();
        db=new DB();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String generalContent="<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Adding User</title></head><body> ";
		String generalEnd="</body></html>";
		
		String sur = request.getParameter("surname");
		String pass = request.getParameter("pwd");
		int age =  Integer.valueOf(request.getParameter("age"));
		String last =request.getParameter("lastname");
		String log =request.getParameter("login");
		
		if((pass!=null)&&(log!=null)){
			UserModel user=new UserModel(sur, pass, age, last, log);
			//System.out.println(user.toString());
			db.addUser(user);
			response.getWriter().write(generalContent+"Bien ajoutée"+generalEnd);

		}else{
			response.getWriter().write(generalContent+"error parameter"+generalEnd);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
