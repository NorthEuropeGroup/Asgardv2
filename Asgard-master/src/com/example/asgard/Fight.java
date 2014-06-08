package com.example.asgard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Fight extends Activity {
	int card1id;
	int card2id;
	int rcard1id;
	int rcard2id;
	String ip;
	String ID;
	String rID;
	TextView T;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.fight);
       Bundle bData = this.getIntent().getExtras();
		ip = bData.getString("ip");
		ID = bData.getString("ID");
		rID = bData.getString("rID");
		card1id = bData.getInt("card1");
		card2id = bData.getInt("card2");
		rcard1id = bData.getInt("rcard1");
		rcard2id = bData.getInt("rcard2");
		T = (TextView)findViewById(R.id.textView1);
		T.setText(String.valueOf(card1id));
		T = (TextView)findViewById(R.id.textView2);
		T.setText(String.valueOf(card2id));
		T = (TextView)findViewById(R.id.textView3);
		T.setText(String.valueOf(rcard1id));
		T = (TextView)findViewById(R.id.textView4);
		T.setText(String.valueOf(rcard2id));

   };

 
}