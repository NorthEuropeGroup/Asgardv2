package com.example.asgard;

import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Asgard extends Activity {
	 private ImageButton button_fight;
	 private ImageButton button_card;
	 private ImageButton button_shop;
	 private ImageButton button_home;
	 private TextView name;
	 private TextView money;
	 private ImageButton button_rename;
	 private ImageButton button_delete;
	 private Info man=new Info("貝斯特拉");
    
     
  @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_asgard);
      
       Bundle bData = this.getIntent().getExtras();
       
       
       //獲取擴展存儲設備的文件目錄  
       File SDFile=android.os.Environment.getExternalStorageDirectory();
       // 打開文件  
       File newTxt=new File(SDFile.getAbsolutePath()+File.separator+"Asgard.txt");
     // 判斷是否存在,不存在則創建  
     		if(!newTxt.exists()){
     			//新增的部分//
     			
     			   //取得Login Layout
     		       LayoutInflater inflater = LayoutInflater.from(Asgard.this);
     		       final View login_view = inflater.inflate(R.layout.login,null);
     		       //產生登入視窗
     		       AlertDialog.Builder builder = new AlertDialog.Builder(this);
     		       builder.setTitle("新增使用者");
     		       builder.setMessage("您好，第一次進入本遊戲請創立一個新的角色。");
     		       builder.setView(login_view);
     		       final AlertDialog dialog = builder.create();  
     		       dialog.show();
     		       //產生按鈕事件
     		       ((Button) login_view.findViewById(R.id.OK)).setOnClickListener(
     		    		   new OnClickListener(){
     		    			   @Override
     		    			   public void onClick(View view){
     		    			       //正確取得edittext
     		    			       EditText tmp = (EditText)login_view.findViewById(R.id.userName);
     		    			       String uName=tmp.getText().toString();
     		    			       //設定名字
     		    				   TextView name = (TextView)findViewById(R.id.name);
     		    			       name.setText(uName);
     		    			       //設定金錢
     		    			       man=new Info(uName);
     		    			       int money=man.money;
     		    			       TextView Mon = (TextView)findViewById(R.id.money);
     		    			       Mon.setText(Integer.toString(money));
     		    			       man.SaveFile(man);
     		    			       dialog.dismiss();
     		    			   }
     		    		   }
     		   );
     		       
     		       
     			
         	}
     		else{
     			man=man.LoadFile(man);
     		}
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
       money=(TextView)findViewById(R.id.money);
       money.setText(Integer.toString(man.money));
       name=(TextView)findViewById(R.id.name);
       name.setText(man.ID);
       
       //重新命名botton
       button_rename = (ImageButton)findViewById(R.id.rename);
       button_rename.setOnClickListener(listener9);
       //商除角色button
       button_delete = (ImageButton)findViewById(R.id.delete);
       button_delete.setOnClickListener(listener10);

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
           bData.putString("ID",man.ID);
           intent.putExtras(bData);
           intent.setClass(Asgard.this,UserConnect1.class);
           startActivity(intent);
           //finish();
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
           bData.putString("ID",man.ID);
           intent.putExtras(bData);
           intent.setClass(Asgard.this,Cardt.class);
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
           Bundle bData = new Bundle();
           bData.putString("ID",man.ID);
           intent.putExtras(bData);
           intent.setClass(Asgard.this,Shop.class);
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
           bData.putString("ID",man.ID);
           intent.putExtras(bData);
           intent.setClass(Asgard.this,Asgard.class);
           startActivity(intent);
           finish();
       }
   };
   private ImageButton.OnClickListener listener9 = new ImageButton.OnClickListener(){

       @Override
       public void onClick(View arg0) {
    	 //取得Login Layout
	       LayoutInflater inflater = LayoutInflater.from(Asgard.this);
	       final View login_view = inflater.inflate(R.layout.login,null);
	       //產生登入視窗
	       AlertDialog.Builder builder = new AlertDialog.Builder(Asgard.this);
	       builder.setTitle("角色名字修改");
	       builder.setMessage("請輸入新的角色名稱");
	       builder.setView(login_view);
	       final AlertDialog dialog = builder.create();  
	       dialog.show();
	       //產生按鈕事件
	       ((Button) login_view.findViewById(R.id.OK)).setOnClickListener(
	    		   new OnClickListener(){
	    			   @Override
	    			   public void onClick(View view){
	    			       //正確取得EditText
	    			       EditText tmp = (EditText)login_view.findViewById(R.id.userName);
	    			       String uName=tmp.getText().toString();
	    			       //設定名字
	    				   TextView name = (TextView)findViewById(R.id.name);
	    			       name.setText(uName);
	    			       man.ID=uName;
	    			       man.SaveFile(man);
	    			       dialog.dismiss();
	    			   }
	    		   }
	    	);       
	        
	   }
   };

   private ImageButton.OnClickListener listener10 = new ImageButton.OnClickListener(){

       @Override
       public void onClick(View arg0) {
    	   //確認刪除視窗
    	   AlertDialog.Builder builder=new AlertDialog.Builder(Asgard.this);
    	   builder.setTitle("確認刪除");
    	    builder.setMessage("你確定真的要刪除角色嗎");
    	    builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
    	        public void onClick(DialogInterface dialog, int which) { 
    	     	   //取得Login Layout
    	 	       LayoutInflater inflater = LayoutInflater.from(Asgard.this);
    	 	       final View login_view = inflater.inflate(R.layout.login,null);
    	 	       //產生登入視窗
    	 	       AlertDialog.Builder builder1 = new AlertDialog.Builder(Asgard.this);
    	 	       builder1.setTitle("新增使用者");
    	 	       builder1.setMessage("請創立一個新的角色。");
    	 	       builder1.setView(login_view);
    	 	       final AlertDialog dialog2 = builder1.create();  
    	 	       dialog2.show();
    	 	       //產生按鈕事件
    	 	       ((Button) login_view.findViewById(R.id.OK)).setOnClickListener(
    	 	    		   new OnClickListener(){
    	 	    			   @Override
    	 	    			   public void onClick(View view){
    	 	    			       //取得EditText
    	 	    			       EditText tmp = (EditText)login_view.findViewById(R.id.userName);
    	 	    			       String uName=tmp.getText().toString();
    	 	    			       //設定新名字
    	 	    				   TextView name = (TextView)findViewById(R.id.name);
    	 	    			       name.setText(uName);
    	 	    			       //設定金錢
    	 	    			       man=new Info(uName);
    	 	    			       int money=man.money;
    	 	    			       TextView Mon = (TextView)findViewById(R.id.money);
    	 	    			       Mon.setText(Integer.toString(money));
    	 	    			       //存檔
    	 	    			       man.SaveFile(man);
    	 	    			       dialog2.dismiss();
    	 	    			   }
    	 	    		   }
    	 	   );
    	        }
    	     });
    	    builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
    	        public void onClick(DialogInterface dialog, int which) { 
    	            // do nothing
    	        }
    	     });
    	    builder.setIcon(android.R.drawable.ic_dialog_alert);
    	     builder.show();
    	   
    	   
    	   

	       }
   };
}