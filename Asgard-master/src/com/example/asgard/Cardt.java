package com.example.asgard;







import java.util.ArrayList;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.os.Build;

public class Cardt extends Activity {
	FancyCoverFlow fcf;
	 private ImageButton button_fight;
	 private ImageButton button_card;
	 private ImageButton button_shop;
	 private ImageButton button_home;
	 private Info man=new Info("hi");
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cardt);
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

		this.fcf =(FancyCoverFlow) findViewById(R.id.fcf);
		
		this.fcf.setMaxRotation(45);
		this.fcf.setUnselectedAlpha(0.3f);
		this.fcf.setUnselectedSaturation(0.0f);
		this.fcf.setUnselectedScale(0.4f);
		this.fcf.setAdapter(new ViewGroupExampleAdapter());
		
		
	}
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
	           man = man.LoadFile(man);
	           Bundle BData  = new Bundle();
	           BData.putString("ID", man.ID);
	           intent.putExtras(BData);
	           intent.setClass(Cardt.this,UserConnect1.class);
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
	           intent.setClass(Cardt.this,Cardt.class);
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
	           intent.setClass(Cardt.this,Shop.class);
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
	           intent.setClass(Cardt.this,Asgard.class);
	           startActivity(intent);
	           finish();
	       }
	   };

	public static class ViewGroupExampleAdapter extends FancyCoverFlowAdapter {

		 private Info man=new Info("貝斯特拉");
		 
	        // =============================================================================
	        // Private members
	        // =============================================================================
			ArrayList<Integer> list = new ArrayList<Integer>();
			ArrayList<Integer> list2 = new ArrayList<Integer>();
			int a[]=new int[man.Cardcount(man)];
				
	    
	        // =============================================================================
	        // Supertype overrides
	        // =============================================================================
	       
	        


	        @Override
	        public View getCoverFlowItem(int i, View reuseableView, ViewGroup viewGroup) {
	            CustomViewGroup customViewGroup = null;
	            
		          
		          list =man.getSmallImage(man);
		          list2 =man.getCardID(man);
		          a=man.ArraylistToInt(a,list);
	          
	            if (reuseableView != null) {
	                customViewGroup = (CustomViewGroup) reuseableView;
	            } else {
	                customViewGroup = new CustomViewGroup(viewGroup.getContext(),i,man,list2);
	                customViewGroup.setLayoutParams(new FancyCoverFlow.LayoutParams(300, 600));
	            }

	            customViewGroup.getImageView().setImageResource(this.getItem(i));
	            
	            
	            return customViewGroup;
	        
	        }
	        

	        
	        @Override
	        public int getCount() {
	            return a.length;
	        }
	        

	        @Override
	        public Integer getItem(int i) {
	            return a[i];
	        }

	        @Override
	        public long getItemId(int i) {
	            return i;
	        }
    }
	public static class CustomViewGroup extends LinearLayout {

		// =============================================================================
        // Child views
        // =============================================================================

        public TextView textView;

        public ImageView imageView;

        public Button button;

        // =============================================================================
        // Constructor
        // =============================================================================
        int tar=0;
        public int[] convertIntegers(ArrayList<Integer> integers)
        {
            int[] ret = new int[integers.size()];
            for (int i=0; i < ret.length; i++)
            {
                ret[i] = integers.get(i).intValue();
            }
            return ret;
        }
        public  CustomViewGroup(Context context,int ar,Info man,ArrayList<Integer> list) {
            super(context);

            this.setOrientation(VERTICAL);
            
            final int[] but=convertIntegers(list);
            tar=ar;
            
            this.textView = new TextView(context);
            this.imageView = new ImageView(context);
            this.button = new Button(context);

            DisplayMetrics displaymetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context
                    .getSystemService(Context.WINDOW_SERVICE);
    windowManager.getDefaultDisplay().getMetrics(displaymetrics);
   
            LinearLayout.LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            this.textView.setLayoutParams(layoutParams);
            this.imageView.setLayoutParams(layoutParams);
            this.button.setLayoutParams(layoutParams);
            int s=cardtoInt(man,but[tar]);
            	
            	
            this.textView.setText("卡片數量："+s+"張");
            this.textView.setGravity(Gravity.CENTER);

            this.imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.imageView.setAdjustViewBounds(true);

            this.button.setText("卡片內容");
            this.button.setTextColor(Color.rgb(255, 210, 30));
            this.button.setBackgroundResource(R.drawable.card_button);
           
            this.button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                	Intent intent =new Intent();
                		if(but[tar]==1)
                		intent.setClass( view.getContext(), card01.class);                		
                		if(but[tar]==2)
                		intent.setClass( view.getContext(), card02.class);
                		if(but[tar]==3)
                		intent.setClass( view.getContext(), card03.class);
                		if(but[tar]==4)
                		intent.setClass( view.getContext(), card04.class);
                		if(but[tar]==5)
                		intent.setClass( view.getContext(), card05.class);
                		if(but[tar]==6)
                		intent.setClass( view.getContext(), card06.class);
                		if(but[tar]==7)
                		intent.setClass( view.getContext(), card07.class);
                		if(but[tar]==8)
                		intent.setClass( view.getContext(), card08.class);
                		if(but[tar]==9)
                		intent.setClass( view.getContext(), card09.class);
                		if(but[tar]==10)
                		intent.setClass( view.getContext(), card10.class);
                		if(but[tar]==11)
                		intent.setClass( view.getContext(), card11.class);
                		if(but[tar]==12)
                		intent.setClass( view.getContext(), card12.class);
                		if(but[tar]==13)
                		intent.setClass( view.getContext(), card13.class);
                		if(but[tar]==14)
                		intent.setClass( view.getContext(), card14.class);
                		if(but[tar]==15)
                		intent.setClass( view.getContext(), card15.class);
                		if(but[tar]==16)
                		intent.setClass( view.getContext(), card16.class);
                		if(but[tar]==17)
                		intent.setClass( view.getContext(), card17.class);
                		if(but[tar]==18)
                		intent.setClass( view.getContext(), card18.class);
                		
                		 view.getContext().startActivity(intent); 
                }
            });

            this.addView(this.textView);
            this.addView(this.imageView);
            this.addView(this.button);
        }
        private TextView getTextView() {
            return textView;
        }

        private ImageView getImageView() {
            return imageView;
        }
        private int cardtoInt(Info man,int i){
        	int[] ar=new int[18];
        	ar[0]=man.card01;
        	ar[1]=man.card02;
        	ar[2]=man.card03;
        	ar[3]=man.card04;
        	ar[4]=man.card05;
        	ar[5]=man.card06;
        	ar[6]=man.card07;
        	ar[7]=man.card08;
        	ar[8]=man.card09;
        	ar[9]=man.card10;
        	ar[10]=man.card11;
        	ar[11]=man.card12;
        	ar[12]=man.card13;
        	ar[13]=man.card14;
        	ar[14]=man.card15;
        	ar[15]=man.card16;
        	ar[16]=man.card17;
        	ar[17]=man.card18;


        	return ar[i-1];
        	
        }
	}
	

}
