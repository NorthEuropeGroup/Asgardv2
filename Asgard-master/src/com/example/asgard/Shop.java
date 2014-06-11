package com.example.asgard;

import java.io.IOException;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class Shop extends Activity {
	 private ImageButton button_fight;
	 private ImageButton button_card;
	 private ImageButton button_shop;
	 private ImageButton button_home;
	 private ImageButton button_shop01;
	 private ImageButton button_shop02;
	 private ImageButton button_shop03;
	 private ImageButton sale;
	 private TextView shop_money;
	 private Info man=new Info("hi");
	 
	 
   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.shop);
       man=man.LoadFile(man);
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

       button_shop01 = (ImageButton)findViewById(R.id.shop01);
       button_shop01.setOnClickListener(listener9);

       button_shop02 = (ImageButton)findViewById(R.id.shop02);
       button_shop02.setOnClickListener(listener10);

       button_shop03 = (ImageButton)findViewById(R.id.shop03);
       button_shop03.setOnClickListener(listener11);
       
       sale=(ImageButton)findViewById(R.id.sale);
       sale.setOnClickListener(listener12);
       

  	 shop_money=(TextView)findViewById(R.id.shop_money);
  	shop_money.setText(Integer.toString(man.money));


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

 
           Intent intent = new Intent();
   

           intent.setClass(Shop.this,UserConnect1.class);
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
 
           Intent intent = new Intent();
           intent.setClass(Shop.this,Asgard.class);
           startActivity(intent);
           finish();
       }
   };

   
   //商店抽卡
   private ImageButton.OnClickListener listener9 = new ImageButton.OnClickListener(){
	   
       @Override
       public void onClick(View arg0) {
    	   int dr=shop_1();
    	   if(man.money>200){
    		  man.money=man.money-200;
    		 shop_money.setText(Integer.toString(man.money));
           Intent intent = new Intent();
           if (dr==0){
        	   man.card01++;
        	   intent.setClass( Shop.this, card01.class);}
   		   if(dr==1){
   			man.card02++;
   			   intent.setClass( Shop.this, card02.class);}
   		   if(dr==2){man.card03++;
   			   intent.setClass( Shop.this, card03.class);}
   		   if(dr==3){man.card04++;
   			   intent.setClass( Shop.this, card04.class);}
   		   if(dr==4){man.card05++;
   			   intent.setClass( Shop.this, card05.class);}
   		   if(dr==5){man.card06++;
   			   intent.setClass( Shop.this, card06.class);}
   		   if(dr==6){man.card07++;
   			   intent.setClass( Shop.this, card07.class);}
   		   if(dr==7){man.card08++;
   			   intent.setClass( Shop.this, card08.class);}
   		   if(dr==8){man.card09++;
   			   intent.setClass( Shop.this, card09.class);}
   		   if(dr==9){man.card10++;
   			   intent.setClass( Shop.this, card10.class);}
   		   if(dr==10){man.card11++;
   			   intent.setClass( Shop.this, card11.class);}
   		   if(dr==11){man.card12++;
   			   intent.setClass( Shop.this, card12.class);}
   		   if(dr==12){man.card13++;
   			   intent.setClass( Shop.this, card13.class);}
   		   if(dr==13){man.card14++;
   			   intent.setClass( Shop.this, card14.class);}
   		   if(dr==14){man.card15++;
   			   intent.setClass( Shop.this, card15.class);}
   		   man.SaveFile(man);
           startActivity(intent);
    	   }
    	   else{
    		   dialog();
    	   }
       }
   };
   private ImageButton.OnClickListener listener10 = new ImageButton.OnClickListener(){
	  

       @Override
       public void onClick(View arg0) {
    	   int dr=shop_2();
    	   if(man.money>=4000){
    		   man.money=man.money-4000;
    		 shop_money.setText(Integer.toString(man.money));
           Intent intent = new Intent();
   		   if(dr==0){
   			man.card01++;
   			   intent.setClass( Shop.this, card01.class);}
   		   if(dr==1){
   			man.card02++;
   			   intent.setClass( Shop.this, card02.class);}
   		   if(dr==2){
   			man.card03++;
   			   intent.setClass( Shop.this, card03.class);}
   		   if(dr==3){
   			man.card04++;
   			   intent.setClass( Shop.this, card04.class);}
   		   if(dr==4){
   			man.card05++;
   			   intent.setClass( Shop.this, card05.class);}
   		   if(dr==5){
   			man.card06++;
   			   intent.setClass( Shop.this, card06.class);}
   		   if(dr==6){
   			man.card07++;
   			   intent.setClass( Shop.this, card07.class);}
   		   if(dr==7){
   			man.card08++;
   			   intent.setClass( Shop.this, card08.class);}
   		   if(dr==8){
   			man.card09++;
   			   intent.setClass( Shop.this, card09.class);}
   		   if(dr==9){
   			man.card10++;
   			   intent.setClass( Shop.this, card10.class);}
   		   if(dr==10){
   			man.card11++;
   			   intent.setClass( Shop.this, card11.class);}
   		   if(dr==11){
   			man.card12++;
   			   intent.setClass( Shop.this, card12.class);}
   		   if(dr==12){
   			man.card13++;
   			   intent.setClass( Shop.this, card13.class);}
   		   if(dr==13){
   			man.card14++;
   			   intent.setClass( Shop.this, card14.class);}
   		   if(dr==14){
   			   
   			man.card15++;
   			   intent.setClass( Shop.this, card15.class);}
   		   if(dr==15){
   			man.card16++;
			   intent.setClass( Shop.this, card16.class);}
		   if(dr==16){
			   man.card17++;
			   intent.setClass( Shop.this, card17.class);}
		   if(dr==17){
			   man.card18++;
			   intent.setClass( Shop.this, card18.class);}
		   man.SaveFile(man);
           startActivity(intent);
    	   }
    	   else{
    		   dialog();
    	   }
       }
   };
   private ImageButton.OnClickListener listener11 = new ImageButton.OnClickListener(){


       @Override
       public void onClick(View arg0) {
 		   int dr=shop_3();
    	   if(man.money>=10000){
    		   man.money=man.money-10000;
    		 	shop_money.setText(Integer.toString(man.money));
           Intent intent = new Intent();
           if(dr==9){
        	   man.card10++;
   			   intent.setClass( Shop.this, card10.class);
   			   
   			}
   		   if(dr==10){
   			man.card11++;
   			   intent.setClass( Shop.this, card11.class);
   			
   			}
   		   if(dr==11){
   			man.card12++;
   			   intent.setClass( Shop.this, card12.class);
   			
   			}
   		
   		   if(dr==12){
   			man.card13++;
   			   intent.setClass( Shop.this, card13.class);
   			}
   		   if(dr==13){
   			man.card14++;
   			   intent.setClass( Shop.this, card14.class);
   			}
   		   if(dr==14){
   			man.card15++;
   			   intent.setClass( Shop.this, card15.class);
   			}
   		   if(dr==15){
   			man.card16++;
			   intent.setClass( Shop.this, card16.class);
   		   }
   		   if(dr==16){
   			man.card17++;
			   intent.setClass( Shop.this, card17.class);
   		   }
   		   if(dr==17){
   			man.card18++;
			   intent.setClass( Shop.this, card18.class);
			
   		   }
   		man.SaveFile(man);
           startActivity(intent);
    	   }
    	   else{
    		   dialog();
    	   }
       }
   };
   
 private ImageButton.OnClickListener listener12 = new ImageButton.OnClickListener(){
	   
       @Override
       public void onClick(View arg0) {
           Intent intent = new Intent();
    	   intent.setClass( Shop.this, Sale.class);
    	   startActivity(intent);
       }
       };
       
 //取亂數
   public int ran(){
	      Random ran = new Random();
		return (ran.nextInt(100)+1);
	}
   //抽Level 1的卡
   public int draw_1(){
	   Random ran = new Random();
	   int n=ran.nextInt(9);
	   return n;
   }
   //抽Level 2的卡
   public int draw_2(){
	   Random ran = new Random();
	   int n=ran.nextInt(6);
	   return (n+=9);
   }
   //抽Level 3的卡 9~17
   public int draw_3(){
	   Random ran = new Random();
	   int n=ran.nextInt(3);
	   return (n+=15);
   }
   //button1 onclick要直行的動作
   public int shop_1(){
	   int bag1=ran();

	   if(bag1<=90){
		   return draw_1();
	   }
	   else{
		   return draw_2();
	   }	   
   }
   //button2 onclick要直行的動作
   public int shop_2(){
	   int bag1=ran();
	   if((bag1<=40)&&(bag1>0)){
		   return draw_1();
	   }
	   else if((bag1>40)&&(bag1<=90)) {
		   return draw_2();
	   }
	   else{
		   return draw_3();
	   }
   }
   //button3 onclick要直行的動作
   public int shop_3(){
	   int bag1=ran();
	   if(bag1<=90){
		   return draw_2();
	   }
	   else{
		   return draw_3();
	   }
   }
   //金錢不夠的dialog
   protected void dialog() {
	AlertDialog.Builder builder = new Builder(Shop.this);
	builder.setMessage("您的金錢數量不足，不能購買。");
	builder.setTitle("金錢不夠！");
	builder.setPositiveButton("確認", new OnClickListener() {
	@Override
 public void onClick(DialogInterface dialog, int which) {
 dialog.dismiss();
}
});

builder.create().show();
}
   
  
}