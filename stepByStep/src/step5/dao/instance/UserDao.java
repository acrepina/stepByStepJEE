package step5.dao.instance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import step5.model.UserModelBean;

public class UserDao {

	private Connection connection;
	private static  String dB_HOST ;
	private static  String dB_PORT;
	private static  String dB_NAME;
	private static  String dB_USER ;
	private static  String dB_PWD ;
	
	public UserDao(String DB_HOST,String DB_PORT,String DB_NAME, String DB_USER, String DB_PWD){
		dB_HOST= DB_HOST;
		dB_PORT= DB_PORT;
		dB_NAME= DB_NAME;
		dB_USER= DB_USER;
		dB_PWD=DB_PWD;
	}
	
	public void addUser(UserModelBean user1){
		java.sql.Statement query;
		try{
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"+dB_HOST+":"+dB_PORT+"/"+dB_NAME, dB_USER, dB_PWD);
			
			//query = connection.createStatement();
			PreparedStatement querySt = (PreparedStatement) connection.prepareStatement("INSERT INTO `user` (`lastname`, `surname`,`age`, `login`, `pwd`)VALUES (?, ?, ?, ?, ?);");
			// Définition de la valeur du premier paramètre
			querySt.setString(1, user1.getLastname());
			querySt.setString(2, user1.getSurname());
			querySt.setInt(3, user1.getAge());
			querySt.setString(4, user1.getLogin());
			querySt.setString(5, user1.getPwd());
			// Exécution
			querySt.executeUpdate();
			
			querySt.close();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<UserModelBean> getAllUser(){
		ArrayList<UserModelBean> userList= new ArrayList<UserModelBean>();
		try{
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"+dB_HOST+":"+dB_PORT+"/"+dB_NAME, dB_USER, dB_PWD);
			PreparedStatement querySt = (PreparedStatement) connection.prepareStatement("SELECT * FROM user");
			
			ResultSet rs= querySt.executeQuery();
			
			while (rs.next()) {
				UserModelBean us = new UserModelBean();
				us.setAge(rs.getInt("age"));
				us.setLastname(rs.getString("lastname"));
				us.setLogin(rs.getString("login"));
				us.setPwd(rs.getString("pwd"));
				us.setSurname(rs.getString("surname"));
				userList.add(us);
			}
			querySt.close();
			rs.close();
			//connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return userList;

	}

	public UserModelBean checkUser(String login, String pwd) {
		UserModelBean user= new UserModelBean();
		try{
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"+dB_HOST+":"+dB_PORT+"/"+dB_NAME, dB_USER, dB_PWD);
			PreparedStatement querySt = (PreparedStatement) connection.prepareStatement("SELECT * FROM user AS u WHERE u.login=? AND u.pwd=?");
			querySt.setString(1, login);
			querySt.setString(2, pwd);
			
			ResultSet rs= querySt.executeQuery();
			
			if(rs.next()){
				user.setAge(rs.getInt("age"));
				user.setLastname(rs.getString("lastname"));
				user.setLogin(rs.getString("login"));
				user.setPwd(rs.getString("pwd"));
				user.setSurname(rs.getString("surname"));
			}
			else{
				user=null;
			}
			querySt.close();
			rs.close();
			//connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return user;
	}
}
