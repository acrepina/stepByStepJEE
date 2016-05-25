package step5.dao.instance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import step5.model.RecipeModel;

import com.mysql.jdbc.PreparedStatement;

public class RecipesDao {
	private Connection connection;
	private static  String dB_HOST ;
	private static  String dB_PORT;
	private static  String dB_NAME;
	private static  String dB_USER ;
	private static  String dB_PWD ;
	
	public RecipesDao(String DB_HOST,String DB_PORT,String DB_NAME, String DB_USER, String DB_PWD){
		dB_HOST= DB_HOST;
		dB_PORT= DB_PORT;
		dB_NAME= DB_NAME;
		dB_USER= DB_USER;
		dB_PWD=DB_PWD;
	}

	public void addRecipe(RecipeModel recipe){
		try{
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"+dB_HOST+":"+dB_PORT+"/"+dB_NAME, dB_USER, dB_PWD);
			
			PreparedStatement querySt = (PreparedStatement) connection.prepareStatement("INSERT INTO `recipes` ( `title`,`description`, `expertise`, `duration`, `nbPeople`, `type`)VALUES (?, ?, ?, ?, ?, ?);");
			querySt.setString(1,recipe.getTitle());
			querySt.setString(2, recipe.getDescription());
			querySt.setInt(3, recipe.getExpertise());
			querySt.setInt(4, recipe.getDuration());
			querySt.setInt(5, recipe.getNbpoeple());
			querySt.setString(6, recipe.getType());		
			
			querySt.executeUpdate();
			querySt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<RecipeModel> getAllRecipe(){
		ArrayList<RecipeModel> recipesList = new ArrayList<RecipeModel>();
		try{
			connection = java.sql.DriverManager.getConnection("jdbc:mysql://"+dB_HOST+":"+dB_PORT+"/"+dB_NAME, dB_USER, dB_PWD);
			PreparedStatement querySt = (PreparedStatement) connection.prepareStatement("SELECT * FROM recipes");
			
			ResultSet rs= querySt.executeQuery();
			
			while (rs.next()) {
				RecipeModel recip = new RecipeModel();
				recip.setTitle(rs.getString("title"));
				recip.setDescription(rs.getString("description"));
				recip.setExpertise(rs.getInt("expertise"));
				recip.setDuration(rs.getInt("duration"));
				recip.setNbpoeple(rs.getInt("nbPeople"));
				recip.setType(rs.getString("type"));

				recipesList.add(recip);
			}
			querySt.close();
			rs.close();
			//connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return recipesList;
	}

}
