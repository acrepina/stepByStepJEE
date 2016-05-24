package step3.instance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import step1.model.UserModel;
import step2.model.UserModelBean;

public class UserDao {

	private Connection connection;
	private String dB_HOST;
	private String dB_PORT;
	private String dB_NAME;
	private String dB_USER;
	private String dB_PWD;
	public UserDao( String dB_HOST, String dB_PORT, String dB_NAME, String dB_USER,
			String dB_PWD) {
		super();
		this.dB_HOST = dB_HOST;
		this.dB_PORT = dB_PORT;
		this.dB_NAME = dB_NAME;
		this.dB_USER = dB_USER;
		this.dB_PWD = dB_PWD;
	}


	public void addUser(UserModelBean user) 
	{
		try {

			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"+dB_HOST+":"+dB_PORT+"/"+dB_NAME, dB_USER, dB_PWD);

			String sql = "INSERT INTO `user` (`lastname`, `surname`,`age`, `login`, `pwd`)VALUES (?,?,?,?,?);";
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, user.getLastname());
			ps.setString(2, user.getSurname());
			ps.setInt(3, user.getAge());
			ps.setString(4, user.getLogin());
			ps.setString(5, user.getPwd());

			ps.executeUpdate();
			ps.executeQuery();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
	
	
	public ArrayList<UserModelBean> getAllUser()
	{
		//return vallue
		ArrayList<UserModelBean> userList=new ArrayList<UserModelBean>();
		try {
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"+dB_HOST+":"+dB_PORT+"/"+dB_NAME, dB_USER, dB_PWD);
			java.sql.Statement query= connection.createStatement();
			ResultSet rs = query.executeQuery("SELECT * FROM user");
			while (rs.next()) {
				UserModelBean usb = new UserModelBean(rs.getString("lastname") , rs.getString("surname"), rs.getInt("age"), rs.getString("login"), rs.getString("pwd"));
				userList.add(usb);
				
			}
			query.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
		

	}



}
