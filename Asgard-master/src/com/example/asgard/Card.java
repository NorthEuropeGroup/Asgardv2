package com.example.asgard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Card extends Activity {
	 private ImageButton button_fight;
	 private ImageButton button_card;
	 private ImageButton button_shop;
	 private ImageButton button_home;
	 private Button button_card01;
	 private Button button_card02;
	 private Button button_card03;
	 private Button button_card04;
	 private Button button_card05;
	 private Button button_card06;
	 private Button button_card07;
	 private Button button_card08;
	 private Button button_card09;
	 private Button button_card10;
	 private Button button_card11;
	 private Button button_card12;
	 private Button button_card13;
	 private Button button_card14;
	 private Button button_card15;
	 private Button button_card16;
	 private Button button_card17;
	 private Button button_card18;
	 String ip;
     String ID;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.card);
       Bundle bData = this.getIntent().getExtras();
       ip = bData.getString("ip");
       ID = bData.getString("ID");
       
       button_card01=(Button)findViewById(R.id.Button01);
       button_card01=(Button)findViewById(R.id.Button01);
       button_card01.setOnClickListener(new Button.OnClickListener(){
    	   public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(Card.this, card01.class);
			startActivity(intent); 
		}}
		);
       button_card02=(Button)findViewById(R.id.Button02);
       button_card02=(Button)findViewById(R.id.Button02);
       button_card02.setOnClickListener(new Button.OnClickListener(){
    	   public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(Card.this, card02.class);
			startActivity(intent); 
		}}
		);
       button_card03=(Button)findViewById(R.id.Button03);
       button_card03=(Button)findViewById(R.id.Button03);
       button_card03.setOnClickListener(new Button.OnClickListener(){
    	   public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(Card.this, card03.class);
			startActivity(intent); 
		}}
		);
       button_card04=(Button)findViewById(R.id.Button04);
       button_card04=(Button)findViewById(R.id.Button04);
       button_card04.setOnClickListener(new Button.OnClickListener(){
    	   public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(Card.this, card04.class);
			startActivity(intent); 
		}}
		);
       button_card05=(Button)findViewById(R.id.Button05);
       button_card05=(Button)findViewById(R.id.Button05);
       button_card05.setOnClickListener(new Button.OnClickListener(){
    	   public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(Card.this, card05.class);
			startActivity(intent); 
		}}
		);
       button_card06=(Button)findViewById(R.id.Button06);
       button_card06=(Button)findViewById(R.id.Button06);
       button_card06.setOnClickListener(new Button.OnClickListener(){
    	   public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(Card.this, card06.class);
			startActivity(intent); 
		}}
		);
       button_card07=(Button)findViewById(R.id.Button07);
       button_card07=(Button)findViewById(R.id.Button07);
       button_card07.setOnClickListener(new Button.OnClickListener(){
    	   public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(Card.this, card07.class);
			startActivity(intent); 
		}}
		);
       button_card08=(Button)findViewById(R.id.Button08);
       button_card08=(Button)findViewById(R.id.Button08);
       button_card08.setOnClickListener(new Button.OnClickListener(){
    	   public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(Card.this, card08.class);
			startActivity(intent); 
		}}
		);
       button_card09=(Button)findViewById(R.id.Button09);
       button_card09=(Button)findViewById(R.id.Button09);
       button_card09.setOnClickListener(new Button.OnClickListener(){
    	   public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(Card.this, card09.class);
			startActivity(intent); 
		}}
		);
       button_card10=(Button)findViewById(R.id.Button10);
       button_card10=(Button)findViewById(R.id.Button10);
       button_card10.setOnClickListener(new Button.OnClickListener(){
    	   public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(Card.this, card10.class);
			startActivity(intent); 
		}}
		);
       button_card11=(Button)findViewById(R.id.Button11);
       button_card11=(Button)findViewById(R.id.Button11);
       button_card11.setOnClickListener(new Button.OnClickListener(){
    	   public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(Card.this, card11.class);
			startActivity(intent); 
		}}
		);
       button_card12=(Button)findViewById(R.id.Button12);
       button_card12=(Button)findViewById(R.id.Button12);
       button_card12.setOnClickListener(new Button.OnClickListener(){
    	   public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(Card.this, card12.class);
			startActivity(intent); 
		}}
		);
       button_card13=(Button)findViewById(R.id.Button13);
       button_card13=(Button)findViewById(R.id.Button13);
       button_card13.setOnClickListener(new Button.OnClickListener(){
    	   public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(Card.this, card13.class);
			startActivity(intent); 
		}}
		);
       button_card14=(Button)findViewById(R.id.Button14);
       button_card14=(Button)findViewById(R.id.Button14);
       button_card14.setOnClickListener(new Button.OnClickListener(){
    	   public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(Card.this, card14.class);
			startActivity(intent); 
		}}
		);
       button_card15=(Button)findViewById(R.id.Button15);
       button_card15=(Button)findViewById(R.id.Button15);
       button_card15.setOnClickListener(new Button.OnClickListener(){
    	   public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(Card.this, card15.class);
			startActivity(intent); 
		}}
		);
       button_card16=(Button)findViewById(R.id.Button16);
       button_card16=(Button)findViewById(R.id.Button16);
       button_card16.setOnClickListener(new Button.OnClickListener(){
    	   public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(Card.this, card16.class);
			startActivity(intent); 
		}}
		);
       button_card17=(Button)findViewById(R.id.Button17);
       button_card17=(Button)findViewById(R.id.Button17);
       button_card17.setOnClickListener(new Button.OnClickListener(){
    	   public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(Card.this, card17.class);
			startActivity(intent); 
		}}
		);
       button_card18=(Button)findViewById(R.id.Button18);
       button_card18=(Button)findViewById(R.id.Button18);
       button_card18.setOnClickListener(new Button.OnClickListener(){
    	   public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(Card.this, card18.class);
			startActivity(intent); 
		}}
		);
       button_fight = (ImageButton)findViewById(R.id.imageButton1);
       button_fight.setOnTouchListener(listener);
       button_fight.setOnClickListener(listener5);

       button_card = (ImageButton)findViewById(R.id.imageButton2);
       button_card.setOnTouchListener(listener2);
       button_card.setOnClickListener(listener6);
       button_shop = (ImageButton)findViewById(R.id.imageButton3);
       button_shop.setOnTouchListener(listener3);
       button_shop.setOnClickListener(listener7);

       button_home = (ImageButton)findViewById(R.id.imageButton4);
       button_home.setOnTouchListener(listener4);
       button_home.setOnClickListener(listener8);


   };
private ImageButton.OnTouchListener listener=new ImageButton.OnTouchListener(){
       @Override
      public boolean onTouch(View arg0, MotionEvent motionEvent) {
           if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //�����霈��臬�憿
        	   button_fight.setImageResource(R.drawable.menu_click_02);

           }  
           if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //韏瑚����敺抵��航�憿
        	   button_fight.setImageResource(R.drawable.menu_02);
                          }  
       return false;
      };
   };

   private ImageButton.OnClickListener listener5 = new ImageButton.OnClickListener(){

       @Override
       public void onClick(View arg0) {
           // TODO Auto-generated method stub
           Intent intent = new Intent();
           Bundle bData = new Bundle();
           bData.putString("ip", ip);
           bData.putString("ID",ID);
           intent.putExtras(bData);
           intent.setClass(Card.this,CardChoose.class);
           startActivity(intent);
           finish();
       }
   };

   private ImageButton.OnTouchListener listener2=new ImageButton.OnTouchListener(){
       @Override
      public boolean onTouch(View arg0, MotionEvent motionEvent) {
           if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //�����霈��臬�憿
        	   button_card.setImageResource(R.drawable.menu_click_03);

           }  
           if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //韏瑚����敺抵��航�憿
        	   button_card.setImageResource(R.drawable.menu_03);
                          }  
       return false;
      };
   };
   private ImageButton.OnClickListener listener6 = new ImageButton.OnClickListener(){

       @Override
       public void onClick(View arg0) {
           // TODO Auto-generated method stub
           Intent intent = new Intent();
           Bundle bData = new Bundle();
           bData.putString("ip", ip);
           bData.putString("ID",ID);
           intent.putExtras(bData);
           intent.setClass(Card.this,Card.class);
           startActivity(intent);
           finish();
       }
   };

   private ImageButton.OnTouchListener listener3=new ImageButton.OnTouchListener(){
       @Override
      public boolean onTouch(View arg0, MotionEvent motionEvent) {
           if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //�����霈��臬�憿
        	   button_shop.setImageResource(R.drawable.menu_click_04);

           }  
           if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //韏瑚����敺抵��航�憿
        	   button_shop.setImageResource(R.drawable.menu_04);
                          }  
       return false;
      };
   };
   private ImageButton.OnClickListener listener7 = new ImageButton.OnClickListener(){

       @Override
       public void onClick(View arg0) {
           // TODO Auto-generated method stub
           Intent intent = new Intent();
           intent.setClass(Card.this,Shop.class);
           startActivity(intent);
           finish();
       }
   };

   private ImageButton.OnTouchListener listener4=new ImageButton.OnTouchListener(){
       @Override
      public boolean onTouch(View arg0, MotionEvent motionEvent) {
           if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  //�����霈��臬�憿
        	   button_home.setImageResource(R.drawable.menu_click_05);

           }  
           if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  //韏瑚����敺抵��航�憿
        	   button_home.setImageResource(R.drawable.menu_05);
                          }  
       return false;
      };
   };
   private ImageButton.OnClickListener listener8 = new ImageButton.OnClickListener(){

       @Override
       public void onClick(View arg0) {
           // TODO Auto-generated method stub
           Intent intent = new Intent();
           Bundle bData = new Bundle();
           bData.putString("ip", ip);
           bData.putString("ID",ID);
           intent.putExtras(bData);
           intent.setClass(Card.this,Asgard.class);
           startActivity(intent);
           finish();
       }
   };
}