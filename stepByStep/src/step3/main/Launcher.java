package step3.main;

import java.util.List;

import step3.model.UserModelBean;
import step3.dao.fabric.DaoFabric;
import step3.dao.instance.RecipesDao;
import step3.dao.instance.UserDao;
import step3.model.RecipeModelBean;

public class Launcher {
	
	public static void main(String[] args){
		UserDao userDao=DaoFabric.getInstance().createUserDao();
		RecipesDao recipesDao=DaoFabric.getInstance().createRecipesDao();
		
		UserModelBean user1= new UserModelBean("Doe","John",55,"jloe", "pwd");
		RecipeModelBean recipe1 = new RecipeModelBean("Fish Salad", "bla bla bla", 5, 180, 10, "salad");
		RecipeModelBean recipe2 = new RecipeModelBean("Fresh Meat", "bla bla bla", 1, 20, 1, "meat");
		userDao.addUser(user1);
		recipesDao.addRecipe(recipe1);
		recipesDao.addRecipe(recipe2);
		
		List<UserModelBean> userList=userDao.getAllUser();
		List<RecipeModelBean> recipesList= recipesDao.getAllRecipe();
		
		for(UserModelBean userTmp:userList){
			System.out.println("User added:"+userTmp);
		}
		for(RecipeModelBean recipeTmp:recipesList){
			System.out.println("Recipes added:"+recipeTmp);
		}
	}

}
