package step1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step1.db.DB;
import step1.model.UserModel;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DB db;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet2() {
		super();
		db=new DB();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Crée un utilisateur depuis des informations transmises
		//ATtention Erreur si les infos transmises sont inéxacte
		//UserModel user = new UserModel("Marcel", "pwddeMarcel", 87, "Pinot", "PinPindu93");
		UserModel user = new UserModel(request.getParameter("surname"),request.getParameter("pwd"),  Integer.valueOf(request.getParameter("age")), request.getParameter("lastname"), request.getParameter("login"));
		//http://localhost:8080/stepByStep/servlet2?lastname=babar&surname=leRoi&age=55&login=babar&pwd=celeste
		//demandde à DB d'ajouter l'utilisateur
		db.addUser(user);
		
		
		PrintWriter wr = response.getWriter();
		wr.println("<! DOCTYPE html>");
		wr.println("<html>");
		wr.println("<head>");
		wr.println("<title>Ma Page</title>");
		wr.println("</head>");
		wr.println("<body>");
	

		
		wr.println("<h1>Utilisateur bien ajouté</h1>");

		
		wr.println("</body>");
		wr.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
