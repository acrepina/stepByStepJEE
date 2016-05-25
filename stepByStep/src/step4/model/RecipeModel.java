package step4.model;

import java.io.Serializable;

public class RecipeModel implements Serializable {
	private String title;
	private String description;
	private int expertise;
	private int nbpoeple;
	private int duration;
	private String type;
	
	public RecipeModel(){
		
	}
	
	public RecipeModel(String title, String description, int expertise,
			int nbpoeple, int duration, String type) {
		super();
		this.title = title;
		this.description = description;
		this.expertise = expertise;
		this.nbpoeple = nbpoeple;
		this.duration = duration;
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getExpertise() {
		return expertise;
	}

	public void setExpertise(int expertise) {
		this.expertise = expertise;
	}

	public int getNbpoeple() {
		return nbpoeple;
	}

	public void setNbpoeple(int nbpoeple) {
		this.nbpoeple = nbpoeple;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "RecipeModel [title=" + title + ", description=" + description
				+ ", expertise=" + expertise + ", nbpoeple=" + nbpoeple
				+ ", duration=" + duration + ", type=" + type + "]";
	}
	
	

}
