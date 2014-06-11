package com.example.asgard;

import java.io.IOException;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.ClipData.Item;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class Sale extends Activity {
	 private ImageButton button_fight;
	 private ImageButton button_card;
	 private ImageButton button_shop;
	 private ImageButton button_home;

	 private TextView sale_money;
	 private Info man=new Info("hi");
	 private ImageButton saleButton;
	 private int[] flag={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	 
	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.sale);
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
	  	 sale_money=(TextView)findViewById(R.id.sale_money);
	  	sale_money.setText(Integer.toString(man.money));
	  saleButton=(ImageButton)findViewById(R.id.sale_button);
	  saleButton.setOnClickListener(listener_sale);

	  	
	      GridView view = (GridView) findViewById(R.id.gridView);
	        view.setAdapter(new CardAdapter1(getBaseContext(),man));
	        view.setOnItemClickListener(new OnItemClickListener() 
	        {
	        	
	        	
	        	//閮�(蝚砍嗾撘萄��or��
	        @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	        	//GridView gridview=(GridView) parent;
	        	
	        	CardAdapter1.Item item = (CardAdapter1.Item) parent.getItemAtPosition(position);
	        	ImageView changeImage = (ImageView) v.findViewById(R.id.icon);
	        	String name=item.text;
	        	int cardID=man.getCardIDuseName(name)-1;    
	        	            if(flag[cardID]==0){
	        	            	changeImage.setImageResource(man.ChangeCardIcon(cardID));
	        	            	flag[cardID]=1;
	        	            }else{
	        	            	changeImage.setImageResource(man.getCardIcon(man).get(position));
	        	            	flag[cardID]=0;
	        	            }        
	        	    
	        	            
	        	           
	        	
         
    
	   }
	        });}
 
	 
	 
private ImageButton.OnTouchListener listener=new ImageButton.OnTouchListener(){
       @Override
      public boolean onTouch(View arg0, MotionEvent motionEvent) {
           if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  
        	   button_fight.setImageResource(R.drawable.menu_click_02);

           }  
           if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  
        	   button_fight.setImageResource(R.drawable.menu_02);
                          }  
       return false;
      };
   };

   private ImageButton.OnClickListener listener5 = new ImageButton.OnClickListener(){

       @Override
       public void onClick(View arg0) {

 
           Intent intent = new Intent();
   

           intent.setClass(Sale.this,Fight.class);
           startActivity(intent);
           finish();
       }
   };

   private ImageButton.OnTouchListener listener2=new ImageButton.OnTouchListener(){
       @Override
      public boolean onTouch(View arg0, MotionEvent motionEvent) {
           if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  
        	   button_card.setImageResource(R.drawable.menu_click_03);

           }  
           if (motionEvent.getAction() == MotionEvent.ACTION_UP) { 
        	   button_card.setImageResource(R.drawable.menu_03);
                          }  
       return false;
      };
   };
   private ImageButton.OnClickListener listener6 = new ImageButton.OnClickListener(){

       @Override
       public void onClick(View arg0) {
  
           Intent intent = new Intent();
   

           intent.setClass(Sale.this,Cardt.class);

           startActivity(intent);
           finish();
       }
   };

   private ImageButton.OnTouchListener listener3=new ImageButton.OnTouchListener(){
       @Override
      public boolean onTouch(View arg0, MotionEvent motionEvent) {
           if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  
        	   button_shop.setImageResource(R.drawable.menu_click_04);

           }  
           if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  
        	   button_shop.setImageResource(R.drawable.menu_04);
                          }  
       return false;
      };
   };
   private ImageButton.OnClickListener listener7 = new ImageButton.OnClickListener(){

       @Override
       public void onClick(View arg0) {
  
 
           Intent intent = new Intent();
           intent.setClass(Sale.this,Shop.class);
     
           startActivity(intent);
           finish();
       }
   };

   private ImageButton.OnTouchListener listener4=new ImageButton.OnTouchListener(){
       @Override
      public boolean onTouch(View arg0, MotionEvent motionEvent) {
           if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {  
        	   button_home.setImageResource(R.drawable.menu_click_05);

           }  
           if (motionEvent.getAction() == MotionEvent.ACTION_UP) {  
        	   button_home.setImageResource(R.drawable.menu_05);
                          }  
       return false;
      };
   };
   private ImageButton.OnClickListener listener8 = new ImageButton.OnClickListener(){

       @Override
       public void onClick(View arg0) {
 
           Intent intent = new Intent();
           intent.setClass(Sale.this,Asgard.class);
           startActivity(intent);
           finish();
       }
   };
   
   



    private ImageButton.OnClickListener listener_sale = new ImageButton.OnClickListener() {
       
        public void onClick(View v) {

       
        	int sa=flag[0]*100+flag[1]*100+flag[2]*100+flag[3]*120+flag[4]*130+flag[5]*140+flag[6]*150+flag[7]*150+flag[8]*150+flag[9]*1500+flag[10]*1700+flag[11]*1800+flag[12]*2000+flag[13]*2100+flag[14]*2500+flag[15]*8000+flag[16]*9000+flag[17]*10000;
        	man.money=man.money+sa;
        	sale_money.setText(Integer.toString(man.money));
        	man.card01=man.card01-flag[0];
        	man.card02=man.card02-flag[1];
        	man.card03=man.card03-flag[2];
        	man.card04=man.card04-flag[3];
        	man.card05=man.card05-flag[4];
        	man.card06=man.card06-flag[5];
        	man.card07=man.card07-flag[6];
        	man.card08=man.card08-flag[7];
        	man.card09=man.card09-flag[8];
        	man.card10=man.card10-flag[9];
        	man.card11=man.card11-flag[10];
        	man.card12=man.card12-flag[11];
        	man.card13=man.card13-flag[12];
        	man.card14=man.card14-flag[13];
        	man.card15=man.card15-flag[14];
        	man.card16=man.card16-flag[15];
        	man.card17=man.card17-flag[16];
        	man.card18=man.card18-flag[17];
        	man.SaveFile(man);
        	
            Intent intent = new Intent();
            intent.setClass(Sale.this,Sale.class);
            startActivity(intent);
        	        
        }
};


   
   


   protected void dialog() {
	AlertDialog.Builder builder = new Builder(Sale.this);
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
  
