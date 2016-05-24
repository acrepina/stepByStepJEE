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
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	
    	if(getServletContext().getAttribute("DB")!=null){
    		db=(DB)getServletContext().getAttribute("DB");
    	}else{
    		db=new DB();
    		getServletContext().setAttribute("DB", db);
    	}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO
		UserModelBean user =(UserModelBean)request.getSession().getAttribute("myUser");
		
		String generalContent="<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><title>Adding User</title></head><body> ";
		String generalEnd="</body></html>";
		
		
		if((user.getPwd()!=null)&&(user.getLogin()!=null)){
			//System.out.println(user.toString());
			db.addUser(user);
			response.getWriter().write(generalContent+"Bien ajoutée"+generalEnd);

		}else{
			response.getWriter().write(generalContent+"error parameter"+generalEnd);
		}
		
		response.sendRedirect("/step2/display.jsp");
	}

}
