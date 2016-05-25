package step4.model;

import java.util.ArrayList;
import java.util.List;

public class RecipeListModelBean {
	private List<RecipeModel> recipesList;
	
	public RecipeListModelBean() {
		recipesList = new ArrayList<RecipeModel>();
	}
	
	public void addRecipeList(RecipeModel recipe){
		this.recipesList.add(recipe);
	}
	
	public List<RecipeModel> getRecipeList(){
		return recipesList;
	}
	
}
