package com.thangLaStudio.petdealsdeals;

public class Pet {

	
	public int id;
	public String name;
	public String breed;
	public static final String DB_TABLE = "Pet";
	public static final String FIELD_ID = "_id";
	public static final String FIELD_NAME = "_name";
	public static final String FIELD_BREED = "_breed";
	public static String CREATE_DB_TABLE= "create table" + DB_TABLE
			+ "(" +

			FIELD_ID + "integer primary key autoincrement," +

			FIELD_NAME + "text," +

			FIELD_BREED + "text" +

			");";


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

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

}