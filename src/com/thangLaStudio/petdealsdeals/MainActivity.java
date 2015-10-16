package com.thangLaStudio.petdealsdeals;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button save,view;
	EditText name_et,breed_et;
	DBPetDeals helper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 helper=new DBPetDeals(this);
		
		save=(Button) findViewById(R.id.save);
		view=(Button) findViewById(R.id.view);
		name_et=(EditText) findViewById(R.id.name);
		breed_et=(EditText) findViewById(R.id.breed);
		
		adddata();
		viewAll();
		
		
	
	}
	public void adddata(){
		
		save.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		   
			String _name=name_et.getText().toString();
			String _breed=breed_et.getText().toString();
			
			Pet p=new Pet();
			p.setName(_name);
			p.setBreed(_breed);
			
			boolean isinserted=helper.insertData(p.getName(), p.getBreed());
			if(isinserted=true){
				
				Toast.makeText(MainActivity.this, "Data Inserted!!", Toast.LENGTH_LONG).show();
			}
			else
				Toast.makeText(MainActivity.this, "Data Not Inserted!!", Toast.LENGTH_LONG).show();
			
				
			
			
		}
	});
		
		
	}
	
	public void viewAll(){
		view.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Cursor res=helper.getAllData();
				
				if(res.getCount()==0){
					showMessage("Erroe", "No data found");
				}
				StringBuffer buffer= new StringBuffer();
				while(res.moveToNext()){
					
					buffer.append("Id:"+res.getString(0)+"\n"+
							"Name:"+res.getString(1)+"\n"+
							"Breed:"+res.getString(2)+"\n\n"
					);
					
					showMessage("data", buffer.toString());
					
					
				}
				
			}
		});
	}
	
	public void showMessage(String title,String message){
		
		AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
		builder.setCancelable(true);
		builder.setTitle(title);
		builder.setMessage(message);
		builder.show();
		
		
		
	}

}
