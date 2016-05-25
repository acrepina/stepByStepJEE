package step3.fabric;

import step3.instance.RecipiesDao;
import step3.instance.UserDao;

public class DaoFabric {
	private static volatile DaoFabric instance = null;
	private static final String DB_HOST ="127.0.0.1";
	private static final String DB_PORT ="3306";
	private static final String DB_NAME ="binome09";
	private static final String DB_USER ="binome09";
	private static final String DB_PWD ="binome09";
	
	private DaoFabric() 
	{
		super();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public final static DaoFabric getInstance()
	{
		if(DaoFabric.instance == null)
		{
			synchronized(DaoFabric.class)
			{
				if(DaoFabric.instance == null)
				{
					DaoFabric.instance = new DaoFabric();
				}
			}
		}
		return DaoFabric.instance;
	}
	
	
	
	public UserDao createUserDao()
	{
		UserDao userDao = new UserDao(DB_HOST, DB_PORT, DB_NAME, DB_USER, DB_PWD);
		return userDao;
		
	}
	
	
	public RecipiesDao createRecipiesDao()
	{
		RecipiesDao recipiesDao = new RecipiesDao(DB_HOST, DB_PORT, DB_NAME,DB_USER, DB_PWD);
		return recipiesDao;
	}
	
}
