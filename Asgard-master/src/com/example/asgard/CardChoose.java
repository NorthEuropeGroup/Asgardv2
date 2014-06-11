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
	public Info man = new Info("test");
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
		FirstCard();
		SecondCard();
		
	}
	public void FirstCard()
	{
		card2id = -1;
		
		man = man.LoadFile(man);
		if(man.card01!=0&&card1id!=0)
		{
			card2id = 0;
			I2.setImageResource(R.drawable.card01_s);
			return ;
		}
		if(man.card02!=0&&card1id!=1)
		{
			card2id = 1;
			I2.setImageResource(R.drawable.card02_s);
			return ;
		}
		if(man.card03!=0&&card1id!=2)
		{
			card2id = 2;
			I2.setImageResource(R.drawable.card03_s);
			return ;
		}
		if(man.card04!=0&&card1id!=3)
		{
			card2id = 3;
			I2.setImageResource(R.drawable.card04_s);
			return ;
		}
		if(man.card05!=0&&card1id!=4)
		{
			card2id = 4;
			I2.setImageResource(R.drawable.card05_s);
			return ;
		}
		if(man.card06!=0&&card1id!=5)
		{
			card2id = 5;
			I2.setImageResource(R.drawable.card06_s);
			return ;
		}
		if(man.card07!=0&&card1id!=6)
		{
			card2id = 6;
			I2.setImageResource(R.drawable.card07_s);
			return ;
		}
		if(man.card08!=0&&card1id!=7)
		{
			card2id = 7;
			I2.setImageResource(R.drawable.card08_s);
			return ;
		}
		if(man.card09!=0&&card1id!=8)
		{
			card2id = 8;
			I2.setImageResource(R.drawable.card09_s);
			return ;
		}
		if(man.card10!=0&&card1id!=9)
		{
			card2id = 9;
			I2.setImageResource(R.drawable.card10_s);
			return ;
		}
		if(man.card11!=0&&card1id!=10)
		{
			card2id = 10;
			I2.setImageResource(R.drawable.card11_s);
			return ;
		}
		if(man.card12!=0&&card1id!=11)
		{
			card2id = 11;
			I2.setImageResource(R.drawable.card12_s);
			return ;
		}
		if(man.card13!=0&&card1id!=12)
		{
			card2id = 12;
			I2.setImageResource(R.drawable.card13_s);
			return ;
		}
		if(man.card14!=0&&card1id!=13)
		{
			card2id = 13;
			I2.setImageResource(R.drawable.card14_s);
			return ;
		}
		if(man.card15!=0&&card1id!=14)
		{
			card2id = 14;
			I2.setImageResource(R.drawable.card15_s);
			return ;
		}
		if(man.card16!=0&&card1id!=15)
		{
			card2id = 15;
			I2.setImageResource(R.drawable.card16_s);
			return ;
		}
		if(man.card17!=0&&card1id!=16)
		{
			card2id = 16;
			I2.setImageResource(R.drawable.card17_s);
			return ;
		}
		if(man.card18!=0&&card1id!=17)
		{
			card2id = 17;
			I2.setImageResource(R.drawable.card18_s);
			return ;
		}
		
	}
	public void SecondCard()
	{
		card1id = -1;
		
		man = man.LoadFile(man);
		if(man.card01!=0)
		{
			card1id = 0;
			I1.setImageResource(R.drawable.card01_s);
		}
		if(man.card02!=0)
		{
			card1id = 1;
			I1.setImageResource(R.drawable.card02_s);
		}
		if(man.card03!=0)
		{
			card1id = 2;
			I1.setImageResource(R.drawable.card03_s);
		}
		if(man.card04!=0)
		{
			card1id = 3;
			I1.setImageResource(R.drawable.card04_s);
		}
		if(man.card05!=0)
		{
			card1id = 4;
			I1.setImageResource(R.drawable.card05_s);
		}
		if(man.card06!=0)
		{
			card1id = 5;
			I1.setImageResource(R.drawable.card06_s);
		}
		if(man.card07!=0)
		{
			card1id = 6;
			I1.setImageResource(R.drawable.card07_s);
		}
		if(man.card08!=0)
		{
			card1id = 7;
			I1.setImageResource(R.drawable.card08_s);
		}
		if(man.card09!=0)
		{
			card1id = 8;
			I1.setImageResource(R.drawable.card09_s);
		}
		if(man.card10!=0)
		{
			card1id = 9;
			I1.setImageResource(R.drawable.card10_s);
		}
		if(man.card11!=0)
		{
			card1id = 10;
			I1.setImageResource(R.drawable.card11_s);
		}
		if(man.card12!=0)
		{
			card1id = 11;
			I1.setImageResource(R.drawable.card12_s);
		}
		if(man.card13!=0)
		{
			card1id = 12;
			I1.setImageResource(R.drawable.card13_s);
		}
		if(man.card14!=0)
		{
			card1id = 13;
			I1.setImageResource(R.drawable.card14_s);
		}
		if(man.card15!=0)
		{
			card1id = 14;
			I1.setImageResource(R.drawable.card15_s);
		}
		if(man.card16!=0)
		{
			card1id = 15;
			I1.setImageResource(R.drawable.card16_s);
		}
		if(man.card17!=0)
		{
			card1id = 16;
			I1.setImageResource(R.drawable.card17_s);
		}
		if(man.card18!=0)
		{
			card1id = 17;
			I1.setImageResource(R.drawable.card18_s);
		}
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
				I1.setImageResource(R.drawable.card08_s);
			}
			if(id==8)
			{
				I1.setImageResource(R.drawable.card09_s);
			}
			if(id==9)
			{
				I1.setImageResource(R.drawable.card10_s);
			}
			if(id==10)
			{
				I1.setImageResource(R.drawable.card11_s);
			}
			if(id==11)
			{
				I1.setImageResource(R.drawable.card12_s);
			}
			if(id==12)
			{
				I1.setImageResource(R.drawable.card13_s);
			}
			if(id==13)
			{
				I1.setImageResource(R.drawable.card14_s);
			}
			if(id==14)
			{
				I1.setImageResource(R.drawable.card15_s);
			}
			if(id==15)
			{
				I1.setImageResource(R.drawable.card16_s);
			}
			if(id==16)
			{
				I1.setImageResource(R.drawable.card17_s);
			}
			if(id==17)
			{
				I1.setImageResource(R.drawable.card18_s);
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
				I2.setImageResource(R.drawable.card08_s);
			}
			if(id==8)
			{
				I2.setImageResource(R.drawable.card09_s);
			}
			if(id==9)
			{
				I2.setImageResource(R.drawable.card10_s);
			}
			if(id==10)
			{
				I2.setImageResource(R.drawable.card11_s);
			}
			if(id==11)
			{
				I2.setImageResource(R.drawable.card12_s);
			}
			if(id==12)
			{
				I2.setImageResource(R.drawable.card13_s);
			}
			if(id==13)
			{
				I2.setImageResource(R.drawable.card14_s);
			}
			if(id==14)
			{
				I2.setImageResource(R.drawable.card15_s);
			}
			if(id==15)
			{
				I2.setImageResource(R.drawable.card16_s);
			}
			if(id==16)
			{
				I2.setImageResource(R.drawable.card17_s);
			}
			if(id==17)
			{
				I2.setImageResource(R.drawable.card18_s);
			}
			break;
		}
	}
}
