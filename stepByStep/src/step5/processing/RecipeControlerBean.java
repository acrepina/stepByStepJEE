package step5.processing;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import step5.dao.fabric.DaoFabric;
import step5.dao.instance.RecipesDao;
import step5.model.RecipeListModelBean;
import step5.model.RecipeModel;

@ManagedBean (name="step5RecipeControlerBean")
@ApplicationScoped
public class RecipeControlerBean {

	private RecipesDao recipeDao;
	
	public RecipeControlerBean(){
		this.recipeDao=DaoFabric.getInstance().createRecipesDao();
	}
	
	public void loadAllRecipes(){
		ArrayList<RecipeModel> list = this.recipeDao.getAllRecipe();
		RecipeListModelBean recipesList = new RecipeListModelBean();
		for(RecipeModel recipe:list){
			recipesList.addRecipeList(recipe);
		}
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("recipeList", recipesList);
	}
	
	public String  addRecipe(RecipeModel recipe){
		
		recipeDao.addRecipe(recipe);
		
		return "successfulRegister.xhtml";
	}
	
	public String searchRecipe(RecipeModel recipe){
		
		
		SearchRecipeBean mySchRecipe = new SearchRecipeBean();
		RecipeListModelBean listRecipesBean = new RecipeListModelBean();
		ArrayList<RecipeModel> listRecipes= recipeDao.getAllRecipe();
		
		Boolean added;
		for(RecipeModel recipeTmp:listRecipes){
			if(recipeTmp.getDescription().compareTo(recipe.getDescription())==0){
				//if not all but description is equal
				//listRecipesBean.addRecipeList(recipeTmp);
			}
			else if(recipeTmp.getTitle().compareTo(recipe.getTitle())==0){
			}
			else if (recipeTmp.getType().compareTo(recipe.getType())==0){
			}
			else if(recipeTmp.getExpertise()== recipe)
			
			// si tout a all=add recipe
		}
		
		return "recipeResultList.xhtml";
	}
	
	public String displayRecipeDetail(RecipeModel recipe){
		return "recipeDetail.xhtml";
	}
}
