package com.thangLaStudio.petdealsdeals;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBPetDeals  extends SQLiteOpenHelper{
	
	private static final String DB_NAME="petdeals";
	private static final int SCHEME_VERSION=1;
	
	
	private SQLiteDatabase db;

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
		
	}

}
