package com.example.asgard;

import com.example.asgard.R.id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class CardChoose extends Activity {
	ImageView I1;
	ImageView I2;
	Button b1;
	Button b2;
	Button b3;
	String ip;
	String ID;
	int card1id=0;
	int card2id=1;
	int rr=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_card_choose);
		 Bundle bData = this.getIntent().getExtras();
	     ip = bData.getString("ip");
	     ID = bData.getString("ID");
		I1 = (ImageView)findViewById(R.id.BattleCard1);
		I2 = (ImageView)findViewById(R.id.BattleCard2);
		b1 = (Button)findViewById(R.id.button1);
		b2 = (Button)findViewById(R.id.button2);
		b3 = (Button)findViewById(R.id.fight);
		b1.setOnClickListener(
				new OnClickListener()
				{

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent();
						Bundle bData = new Bundle();
				           bData.putString("ip", ip);
				           bData.putString("ID",ID);
				           intent.putExtras(bData);
			            intent.setClass(CardChoose.this, CardChoose2.class );
			            startActivityForResult( intent,0 );
					}
					
				});
		b2.setOnClickListener(
				new OnClickListener()
				{

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent intent = new Intent();
						Bundle bData = new Bundle();
				           bData.putString("ip", ip);
				           bData.putString("ID",ID);
				           intent.putExtras(bData);
			            intent.setClass(CardChoose.this, CardChoose2.class );
			            startActivityForResult( intent, 1 );
						
					}
					
				});
		b3.setOnClickListener(
				new OnClickListener()
				{

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent newAct = new Intent();
			            newAct.setClass(CardChoose.this, List.class );
						//co.start();
						//Change View
						// 建立 Bundle 物件
			            Bundle bData = new Bundle();
			            bData.putString("ip", ip);
			            bData.putString("ID", ID);
			            bData.putInt("C1", card1id);
			            bData.putInt("C2", card2id);
			            // 將 Bundle 指定到 Intent
			            newAct.putExtras( bData );
			            // 呼叫新的 Activity Class
			            startActivity( newAct );
					}
					
				});
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	super.onActivityResult(requestCode, resultCode, data);
		int id = data.getExtras().getInt("I");
		switch(requestCode)
		{
		case 0:
			card1id = id;
			if(id==0)
			{
				I1.setImageResource(R.drawable.card01_s);
			}
			if(id==1)
			{
				I1.setImageResource(R.drawable.card02_s);
			}
			if(id==2)
			{
				I1.setImageResource(R.drawable.card03_s);
			}
			if(id==3)
			{
				I1.setImageResource(R.drawable.card04_s);
			}
			if(id==4)
			{
				I1.setImageResource(R.drawable.card05_s);
			}
			if(id==5)
			{
				I1.setImageResource(R.drawable.card06_s);
			}
			if(id==6)
			{
				I1.setImageResource(R.drawable.card07_s);
			}
			if(id==7)
			{
				I1.setImageResource(R.drawable.card01_s);
			}
			if(id==8)
			{
				I1.setImageResource(R.drawable.card01_s);
			}
			if(id==9)
			{
				I1.setImageResource(R.drawable.card01_s);
			}
			if(id==10)
			{
				I1.setImageResource(R.drawable.card01_s);
			}
			if(id==11)
			{
				I1.setImageResource(R.drawable.card01_s);
			}
			if(id==12)
			{
				I1.setImageResource(R.drawable.card01_s);
			}
			if(id==13)
			{
				I1.setImageResource(R.drawable.card01_s);
			}
			if(id==14)
			{
				I1.setImageResource(R.drawable.card01_s);
			}
			if(id==15)
			{
				I1.setImageResource(R.drawable.card01_s);
			}
			if(id==16)
			{
				I1.setImageResource(R.drawable.card01_s);
			}
			if(id==17)
			{
				I1.setImageResource(R.drawable.card01_s);
			}
			break;
		case 1:
			card2id = id;
			if(id==0)
			{
				I2.setImageResource(R.drawable.card01_s);
			}
			if(id==1)
			{
				I2.setImageResource(R.drawable.card02_s);
			}
			if(id==2)
			{
				I2.setImageResource(R.drawable.card03_s);
			}
			if(id==3)
			{
				I2.setImageResource(R.drawable.card04_s);
			}
			if(id==4)
			{
				I2.setImageResource(R.drawable.card05_s);
			}
			if(id==5)
			{
				I2.setImageResource(R.drawable.card06_s);
			}
			if(id==6)
			{
				I2.setImageResource(R.drawable.card07_s);
			}
			if(id==7)
			{
				I2.setImageResource(R.drawable.card01_s);
			}
			if(id==8)
			{
				I2.setImageResource(R.drawable.card01_s);
			}
			if(id==9)
			{
				I2.setImageResource(R.drawable.card01_s);
			}
			if(id==10)
			{
				I2.setImageResource(R.drawable.card01_s);
			}
			if(id==11)
			{
				I2.setImageResource(R.drawable.card01_s);
			}
			if(id==12)
			{
				I2.setImageResource(R.drawable.card01_s);
			}
			if(id==13)
			{
				I2.setImageResource(R.drawable.card01_s);
			}
			if(id==14)
			{
				I2.setImageResource(R.drawable.card01_s);
			}
			if(id==15)
			{
				I2.setImageResource(R.drawable.card01_s);
			}
			if(id==16)
			{
				I2.setImageResource(R.drawable.card01_s);
			}
			if(id==17)
			{
				I2.setImageResource(R.drawable.card01_s);
			}
			break;
		}
	}
}
