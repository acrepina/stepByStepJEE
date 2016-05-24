package step2.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import step1.model.UserModel;
import step2.model.UserModelBean;

public class DB {
	private static final String DB_HOST ="db-tp.cpe.fr";
	private static final String DB_PORT ="3306";
	private static final String DB_NAME ="binome09";
	private static final String DB_USER ="binome09";
	private static final String DB_PWD ="binome09";
	private Connection connection;
	
	public DB(){
		try{          
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"+DB_HOST+":"+DB_PORT+"/"+DB_NAME, DB_USER, DB_PWD);
		}catch (SQLException e){
			e.printStackTrace();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	//public ~DB(){
//		connection.close();
	//}
	
	public ArrayList<UserModelBean> getData(){
		ArrayList<UserModelBean> userList= new ArrayList<UserModelBean>();
		
		try{
			java.sql.Statement query= connection.createStatement();

			///TODO:
			ResultSet rs = query.executeQuery("SELECT * FROM user");
			while (rs.next()) {
				UserModelBean us = new UserModelBean();
				us.setAge(rs.getInt("age"));
				us.setLastname(rs.getString("lastname"));
				us.setLogin(rs.getString("login"));
				us.setPwd(rs.getString("pwd"));
				us.setSurename(rs.getString("surname"));
				userList.add(us);
			}
			query.close();
			rs.close();
			//connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return userList;
	}
	
	public void addUser(UserModelBean user){
		java.sql.Statement query;
		try{
			query = connection.createStatement();
			///TODO
			//System.out.println(user.toString());
			int rs = query.executeUpdate("INSERT INTO `user` (`lastname`, `surname`,`age`, `login`, `pwd`)VALUES ('"+ user.getLastname()+"', '"+user.getSurename()+"', "+user.getAge()+", '"+user.getLogin()+"', '"+user.getPwd()+"');");			
			query.close();
			connection.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

}
