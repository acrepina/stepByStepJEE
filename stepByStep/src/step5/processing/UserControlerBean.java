package step5.processing;

import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import step5.dao.fabric.DaoFabric;
import step5.dao.instance.UserDao;
import step5.model.LoginBean;
import step5.model.UserModelBean;
import step5.model.UserSubmissionModelBean;

@ManagedBean(name="step5UserControlerBean")
@ApplicationScoped
public class UserControlerBean {
	private UserDao userDao;
	

	public  UserControlerBean() {
		this.userDao=DaoFabric.getInstance().createUserDao();
		
	}
	
	public String checkUser(LoginBean loginBean){
		UserModelBean user = this.userDao.checkUser(loginBean.getLogin(), loginBean.getPwd());
		if(user!=null){
			ExternalContext externalContex = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContex.getSessionMap();
			
			sessionMap.put("loggedUser", user);
			
			return "userdisplay.xhtml";
		}else{
			return "userLogin.xhtml";
		}
	}
	
	public void checkAndAddUser(UserSubmissionModelBean userSubmitted){
		//TODO verifie propriete utilisateur userSubmittedBean extand userModelBean
		UserModelBean user = this.userDao.checkUser(userSubmitted.getLogin(), userSubmitted.getPwd());
		if((user.getLogin()==userSubmitted.getLogin())&&(user.getPwd()==userSubmitted.getPwd())){
			this.userDao.addUser(userSubmitted);
		}else{
			System.out.println("\n error \n");
		}
	}

}
