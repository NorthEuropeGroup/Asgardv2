package com.example.asgard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Lose extends Activity {
	
	Button B;
	ImageButton B1;
	String ID;
	String ip;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lose);
		
		B1 = (ImageButton)findViewById(R.id.imageButton1);
		Bundle bData = this.getIntent().getExtras();
		ip = bData.getString("ip");
		ID = bData.getString("ID");
		
		B1.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				Bundle bData = new Bundle();
				bData.putString("ip", ip);
				bData.putString("ID", ID);
				bData.putString("ID", ID);
				// 將 Bundle 指定到 Intent
				intent.putExtras( bData );
				 intent.setClass(Lose.this,Asgard.class);
			      startActivity(intent);
			      finish();  
			}
				
		});
	}
}
