package step3.main;

import java.util.List;

import step1.model.UserModel;
import step3.fabric.DaoFabric;
import step3.instance.RecipiesDao;
import step3.instance.UserDao;
import step3.model.RecipeModelBean;
import step3.model.UserModelBean;

public class Launcher {

	public static void main(String[] args) {
		UserDao userDao=DaoFabric.getInstance().createUserDao();
		RecipiesDao recipiesDao=DaoFabric.getInstance().createRecipiesDao();
		
		//UserModelBean user1=new UserModelBean("Doe", "Jhon", 55, "jdoe", "pwd");
		//RecipeModelBean recipe1= new RecipeModelBean("Pates", "Des boooones pates", 1, 1, 10, "Pates");
		//RecipeModelBean recipe2 = new RecipeModelBean("Frites", "Des frites ! Des frites ! Des frites des frites des frites !!!!", 1, 1, 30, "Frites");
		/*
		userDao.addUser(user1);
		recipiesDao.addRecipes(recipe1);
		recipiesDao.addRecipes(recipe2);*/
		
		
		List<UserModelBean> userList=userDao.getAllUser();
		List<RecipeModelBean> recipeList=recipiesDao.getAllrecipes();
		
		
		for(UserModelBean userTmp:userList)
		{
			System.out.println("User added : "+userTmp);
		}
		for(RecipeModelBean recipeTmp:recipeList)
		{
			System.out.println("Recipe added : "+recipeTmp);
		}

	}

}
