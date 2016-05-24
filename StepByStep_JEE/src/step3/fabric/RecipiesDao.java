package step3.fabric;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import step2.model.UserModelBean;
import step3.model.RecipeModelBean;




public class RecipiesDao {
	
	private Connection connection;
	private String dB_HOST;
	private String dB_PORT;
	private String dB_NAME;
	private String dB_USER;
	private String dB_PWD;
	
	
	public RecipiesDao(String dB_HOST, String dB_PORT, String dB_NAME, String dB_USER, String dB_PWD) {
		super();
		this.dB_HOST = dB_HOST;
		this.dB_PORT = dB_PORT;
		this.dB_NAME = dB_NAME;
		this.dB_USER = dB_USER;
		this.dB_PWD = dB_PWD;
	}
	
	public void addRecipes(RecipeModelBean recipe) 
	{
		try {

			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"+dB_HOST+":"+dB_PORT+"/"+dB_NAME, dB_USER, dB_PWD);

			String sql = "INSERT INTO `recipes` (`title`, `description`,`expertise`, `duration`, `nbPeople`,`type`)VALUES (?,?,?,?,?,?);";
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, recipe.getTitle());
			ps.setString(2, recipe.getDescription());
			ps.setInt(3, recipe.getExpertise());
			ps.setInt(4, recipe.getDuration());
			ps.setInt(5, recipe.getNbpeople());
			ps.setString(6, recipe.getType());

			ps.executeUpdate();
			ps.executeQuery();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
	
	

	public ArrayList<RecipeModelBean> getAllrecipes()
	{
		//return vallue
		ArrayList<RecipeModelBean> recipeList=new ArrayList<RecipeModelBean>();
		try {
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"+dB_HOST+":"+dB_PORT+"/"+dB_NAME, dB_USER, dB_PWD);
			java.sql.Statement query= connection.createStatement();
			ResultSet rs = query.executeQuery("SELECT * FROM recipes");
			while (rs.next()) {
				RecipeModelBean rmb = new RecipeModelBean(rs.getString("title"), rs.getString("description"), rs.getInt("expertise"), rs.getInt("nbPeople"), rs.getInt("duration"), rs.getString("type"));
						//rs.getString("lastname") , rs.getString("surname"), rs.getInt("age"), rs.getString("login"), rs.getString("pwd"));
				recipeList.add(rmb);
				
			}
			query.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recipeList;
		

	}

	

}
