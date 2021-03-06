package step3.dao.fabric;

import step3.dao.instance.RecipesDao;
import step3.dao.instance.UserDao;

public class DaoFabric {
	private static volatile DaoFabric instance = null;
	
	private static final String DB_HOST ="db-tp.cpe.fr";
	private static final String DB_PORT ="3306";
	private static final String DB_NAME ="binome09";
	private static final String DB_USER ="binome09";
	private static final String DB_PWD ="binome09";
	
	private DaoFabric(){
		super();
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public final static DaoFabric getInstance(){
		if(DaoFabric.instance == null){
			synchronized (DaoFabric.class) {
				if(DaoFabric.instance== null){
					DaoFabric.instance=new DaoFabric();
				}
			}
		}
		return DaoFabric.instance;
	}
	
	public UserDao createUserDao(){
		UserDao userDao =new UserDao(this.DB_HOST, this.DB_PORT,this.DB_NAME, this.DB_USER, this.DB_PWD);
		return userDao;
	}
	
	public RecipesDao createRecipesDao(){
		RecipesDao receipesDao = new RecipesDao(this.DB_HOST, this.DB_PORT,this.DB_NAME, this.DB_USER, this.DB_PWD);
		return receipesDao;
	}

	public step4.dao.instance.UserDao checkUser(String login, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

}
