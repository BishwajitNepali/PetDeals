package com.thangLaStudio.petdealsdeals;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBPetDeals  extends SQLiteOpenHelper{
	
	private static final String DB_NAME="petdeals";
	private static final int SCHEME_VERSION=1;
	
	
	private SQLiteDatabase db;
	
	Pet pet=new Pet();
	
	String pet_name=pet.getName();
	String pet_breed=pet.getBreed();
	
	public DBPetDeals(Context context) {
		super(context, DB_NAME, null, SCHEME_VERSION);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(Pet.CREATE_DB_TABLE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS"+Pet.DB_TABLE);
		onCreate(db);
		
	}
	
	public boolean insertData(String pet_name,String pet_breed){
		db=this.getWritableDatabase();
		ContentValues contentvalues=new ContentValues();
		contentvalues.put(Pet.FIELD_NAME, pet_name);
		contentvalues.put(Pet.FIELD_BREED, pet_breed);
		long result=db.insert(Pet.DB_TABLE, null, contentvalues);
		if(result== -1){
			return false;
		}else
		return true;
		
	}
	public Cursor getAllData(){
		
		db=this.getWritableDatabase();
		
		Cursor result=db.rawQuery("select *from "+Pet.DB_TABLE,null );
		
		
		return result;
		
	}

}
