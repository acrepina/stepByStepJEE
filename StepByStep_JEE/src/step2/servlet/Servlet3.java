package step2.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import step1.model.UserModel;
import step2.db.DB;
import step2.model.UserModelBean;

/**
 * Servlet implementation class Servlet3
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DB db;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	//vérifie si DB existe dans l'espace de mémoire partagé entre les servlets
    	//si oui on les récupère, si non on le crée et on l'ajoute dans l'éspace mémoire partagé entre les servlets
    	
    	
    	
    	
    	if (getServletContext().getAttribute("BD")!=null)
    	{
    		db = (DB)getServletContext().getAttribute("DB");
    	}
    	else
    	{
    		db=new DB();
    		getServletContext().setAttribute("DB", db);
    	}
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Nothing to do
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModelBean user = (UserModelBean)request.getSession().getAttribute("myUser");
		
		//sauvegarder l'utillisateur dans la base de donnée
		//user = new UserModel(request.getParameter("surname"),request.getParameter("pwd"),  Integer.valueOf(request.getParameter("age")), request.getParameter("lastname"), request.getParameter("login"));
		
		System.out.println("les valeurs de User : "+user.toString());
		db.addUser(user);
		
		//rediriger ver /step2/display.jsp
		response.sendRedirect("display.jsp");
	}

}
