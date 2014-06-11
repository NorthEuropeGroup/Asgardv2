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

public class Win extends Activity {
	Button B;
	ImageButton B1;
	String ID;
	String ip;
	public Info man = new Info("I");
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_win);
		
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
				man = man.LoadFile(man);
				man.money+=1000;
				man.SaveFile(man);
				// 將 Bundle 指定到 Intent
				intent.putExtras( bData );
				 intent.setClass(Win.this,Asgard.class);
			      startActivity(intent);
			      finish();  
			}
				
		});
	}
}
