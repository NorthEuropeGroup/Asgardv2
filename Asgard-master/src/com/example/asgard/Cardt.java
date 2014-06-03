package com.example.asgard;







import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
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
	           intent.setClass(Cardt.this,Fight.class);
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

        // =============================================================================
        // Private members
        // =============================================================================

        public int[] images = {R.drawable.card01_s,R.drawable.card02_s,R.drawable.card03_s,R.drawable.card04_s,R.drawable.card05_s,
        		R.drawable.card06_s,R.drawable.card07_s,R.drawable.card08,R.drawable.card09,R.drawable.card10,
        		R.drawable.card11,R.drawable.card12,R.drawable.card13,R.drawable.card14,R.drawable.card15,
        		R.drawable.card16,R.drawable.card17,R.drawable.card18,};

        // =============================================================================
        // Supertype overrides
        // =============================================================================

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Integer getItem(int i) {
            return images[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getCoverFlowItem(int i, View reuseableView, ViewGroup viewGroup) {
            CustomViewGroup customViewGroup = null;

            if (reuseableView != null) {
                customViewGroup = (CustomViewGroup) reuseableView;
            } else {
                customViewGroup = new CustomViewGroup(viewGroup.getContext(),i);
                customViewGroup.setLayoutParams(new FancyCoverFlow.LayoutParams(300, 600));
            }

            customViewGroup.getImageView().setImageResource(this.getItem(i));
            
            
            return customViewGroup;
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
        public  CustomViewGroup(Context context,int ar) {
            super(context);

            this.setOrientation(VERTICAL);
            tar=ar;
            this.textView = new TextView(context);
            this.imageView = new ImageView(context);
            this.button = new Button(context);

            LinearLayout.LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            this.textView.setLayoutParams(layoutParams);
            this.imageView.setLayoutParams(layoutParams);
            this.button.setLayoutParams(layoutParams);

            this.textView.setGravity(Gravity.CENTER);

            this.imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.imageView.setAdjustViewBounds(true);

            this.button.setText("Details");
            this.button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                	Intent intent =new Intent();
                		if(tar==0)
                		intent.setClass( view.getContext(), card01.class);
                		
                		if(tar==1)
                		intent.setClass( view.getContext(), card02.class);
                		if(tar==2)
                		intent.setClass( view.getContext(), card03.class);
                		if(tar==3)
                		intent.setClass( view.getContext(), card04.class);
                		if(tar==4)
                		intent.setClass( view.getContext(), card05.class);
                		if(tar==5)
                		intent.setClass( view.getContext(), card06.class);
                		if(tar==6)
                		intent.setClass( view.getContext(), card07.class);
                		if(tar==7)
                		intent.setClass( view.getContext(), card08.class);
                		if(tar==8)
                		intent.setClass( view.getContext(), card09.class);
                		if(tar==9)
                		intent.setClass( view.getContext(), card10.class);
                		if(tar==10)
                		intent.setClass( view.getContext(), card11.class);
                		if(tar==11)
                		intent.setClass( view.getContext(), card12.class);
                		if(tar==12)
                		intent.setClass( view.getContext(), card13.class);
                		if(tar==13)
                		intent.setClass( view.getContext(), card14.class);
                		if(tar==14)
                		intent.setClass( view.getContext(), card15.class);
                		if(tar==15)
                		intent.setClass( view.getContext(), card16.class);
                		if(tar==16)
                		intent.setClass( view.getContext(), card17.class);
                		if(tar==17)
                		intent.setClass( view.getContext(), card18.class);
                		
                		 view.getContext().startActivity(intent); 
                }
            });

            //this.addView(this.textView);
            this.addView(this.imageView);
            this.addView(this.button);
        }
        private TextView getTextView() {
            return textView;
        }

        private ImageView getImageView() {
            return imageView;
        }
	}
	

}
