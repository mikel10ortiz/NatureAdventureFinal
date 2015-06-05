package es.uji.natureadventure.domain;

public class Activity {

	private int id;
	private String name;
	private String description;
	private int duration;
	private String kind;
	private String difficulty;
	private int minPersons;
	private boolean enabled;
	private double price;
	private int maxPersons;
	
	
	public Activity() {
		super();
	}

	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public String getKind() {
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}


	public String getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}


	public int getMinPersons() {
		return minPersons;
	}


	public void setMinPersons(int minPersons) {
		this.minPersons = minPersons;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getMaxPersons() {
		return maxPersons;
	}


	public void setMaxPersons(int maxPersons) {
		this.maxPersons = maxPersons;
	}
	
	

	
}
