package step5.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import step5.model.RecipeModel;

@ManagedBean
@ApplicationScoped
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
