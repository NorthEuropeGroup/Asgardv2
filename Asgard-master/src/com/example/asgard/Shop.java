package com.example.asgard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Shop extends Activity {
	 private ImageButton button_fight;
	 private ImageButton button_card;
	 private ImageButton button_shop;
	 private ImageButton button_home;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.shop);
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
           intent.setClass(Shop.this,Fight.class);
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
           intent.setClass(Shop.this,Cardt.class);
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
           intent.setClass(Shop.this,Shop.class);
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
           intent.setClass(Shop.this,Asgard.class);
           startActivity(intent);
           finish();
       }
   };
 //取亂數
   public int ran(){
		return ((int) (Math.random()*10));
	}
   //抽Level 1的卡
   public int draw_1(){
	   int n=81;
	   n+=ran();
	   n=n%9;
	   return (n+=1);
   }
   //抽Level 2的卡
   public int draw_2(){
	   int n=81;
	   n+=ran();
	   n=n%6;
	   return (n+=10);
   }
   //抽Level 3的卡
   public int draw_3(){
	   int n=81;
	   n+=ran();
	   n=n%3;
	   return (n+=16);
   }
   //button1 onclick要直行的動作
   public int shop_1(){
	   int bag1=ran()+90;
	   if(bag1%100<90){
		   return draw_1();
	   }
	   else{
		   return draw_2();
	   }	   
   }
   //button2 onclick要直行的動作
   public int shop_2(){
	   int bag1=ran()+90;
	   if((bag1%100)<80){
		   return draw_1();
	   }
	   else if((bag1%100)>80 && (bag1%100)<95){
		   return draw_2();
	   }
	   else{
		   return draw_3();
	   }
   }
   //button3 onclick要直行的動作
   public int shop_3(){
	   int bag1=ran()+90;
	   if((bag1%100)<70){
		   return draw_1();
	   }
	   else if((bag1%100)>75 && (bag1%100)<90){
		   return draw_2();
	   }
	   else{
		   return draw_3();
	   }
   }
}