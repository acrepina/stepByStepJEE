package step4.processing;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import step4.dao.fabric.DaoFabric;
import step4.dao.instance.RecipesDao;
import step4.model.RecipeListModelBean;
import step4.model.RecipeModel;

@ManagedBean
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

}
