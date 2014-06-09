package com.example.asgard;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Fight extends Activity {
	int card1id;
	int card2id;
	int rcard1id;
	int rcard2id;
	String ip;
	String ID;
	String rID;
	TextView Time;
	ImageView rC1;
	ImageView rC2;
	ImageView C1;
	ImageView C2;
	Button B1;
	Button B2;
	ImageButton A1;
	ImageButton D1;
	ImageButton S1;
	ImageButton A2;
	ImageButton D2;
	ImageButton S2;
	ProgressBar rBl1;
	ProgressBar rBl2;
	ProgressBar Bl1;
	ProgressBar Bl2;
	AllCard r1;
	AllCard r2;
	AllCard m1;
	AllCard m2;
	String tmp;
	String tmp1;
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
		CreateView();
		r1 = getCardById(rcard1id);
		r2 = getCardById(rcard2id);
		m1 = getCardById(card1id);
		m2 = getCardById(card2id);
		tmp = "";
		Resources resources =Fight.this.getResources();
		if(card1id<9)
			tmp1 = "card0"+String.valueOf(card1id+1);
		else
			tmp1 = "card"+String.valueOf(card1id+1);
		int num = resources.getIdentifier(tmp1, "drawable", "com.example.asgard");
		C1.setImageResource(num);
		if(card2id<9)
			tmp1 = "card0"+String.valueOf(card2id+1);
		else
			tmp1 = "card"+String.valueOf(card2id+1);
		num = resources.getIdentifier(tmp1, "drawable", "com.example.asgard");
		C2.setImageResource(num);
		if(rcard1id<9)
			tmp1 = "card0"+String.valueOf(rcard1id+1);
		else
			tmp1 = "card"+String.valueOf(rcard1id+1);
		num = resources.getIdentifier(tmp1, "drawable", "com.example.asgard");
		rC1.setImageResource(num);
		if(rcard2id<9)
			tmp1 = "card0"+String.valueOf(rcard2id+1);
		else
			tmp1 = "card"+String.valueOf(rcard2id+1);
		num = resources.getIdentifier(tmp1, "drawable", "com.example.asgard");
		rC2.setImageResource(num);
   };
   public void CreateView()
   {
	   Time = (TextView)findViewById(R.id.Time);
	   rC1 = (ImageView)findViewById(R.id.rC1);
	   rC2 = (ImageView)findViewById(R.id.rC2);
	   C1 = (ImageView)findViewById(R.id.C1);
	   C2 = (ImageView)findViewById(R.id.C2);
	   B1 = (Button)findViewById(R.id.rCB1);
	   B2 = (Button)findViewById(R.id.rCB2);
	   rBl1 = (ProgressBar)findViewById(R.id.rB1);
	   rBl2 = (ProgressBar)findViewById(R.id.rB2);
	   Bl1 = (ProgressBar)findViewById(R.id.B1);
	   Bl2 = (ProgressBar)findViewById(R.id.B2);
	   A1 = (ImageButton)findViewById(R.id.atk1);
	   D1 = (ImageButton)findViewById(R.id.def1);
	   S1 = (ImageButton)findViewById(R.id.skill1);
	   A2 = (ImageButton)findViewById(R.id.atk2);
	   D2 = (ImageButton)findViewById(R.id.def2);
	   S2 = (ImageButton)findViewById(R.id.skill2);
	   B1.setVisibility(View.INVISIBLE);
	   B2.setVisibility(View.INVISIBLE);
	   A1.setVisibility(View.INVISIBLE);
	   D1.setVisibility(View.INVISIBLE);
	   S1.setVisibility(View.INVISIBLE);
	   A2.setVisibility(View.INVISIBLE);
	   D2.setVisibility(View.INVISIBLE);
	   S2.setVisibility(View.INVISIBLE);
	   
   }
   public AllCard getCardById(int id)
   {
	   AllCard t = new card01().new info();
	   switch(id)
	   {
	   case 0:
		   t = new card01().new info();
		   break;
	   case 1:
		   t = new card02().new info();
		   break;
	   case 2:
		   t = new card03().new info();
		   break;
	   case 3:
		   t = new card04().new info();
		   break;
	   case 4:
		   t = new card05().new info();
		   break;
	   case 5:
		   t = new card06().new info();
		   break;
	   case 6:
		   t = new card07().new info();
		   break;
	   case 7:
		   t = new card08().new info();
		   break;
	   case 8:
		   t = new card09().new info();
		   break;
	   case 9:
		   t = new card10().new info();
		   break;
	   case 10:
		   t = new card11().new info();
		   break;
	   case 11:
		   t = new card12().new info();
		   break;
	   case 12:
		   t = new card13().new info();
		   break;
	   case 13:
		   t = new card14().new info();
		   break;
	   case 14:
		   t = new card15().new info();
		   break;
	   case 15:
		   t = new card16().new info();
		   break;
	   case 16:
		   t = new card17().new info();
		   break;
	   case 17:
		   t = new card18().new info();
		   break;
		   
	   }
	   return t;
   }
}