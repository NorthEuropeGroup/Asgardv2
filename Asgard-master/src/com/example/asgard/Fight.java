package com.example.asgard;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;



import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
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
	int battleid;
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
	int IsUrTurn;
	int isrun;
	int m1hp;
	int m2hp;
	int r1hp;
	int r2hp;
	Handler notify = new Handler();
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
			battleid = bData.getInt("bid");
			CreateView();
			r1 = getCardById(rcard1id);
			r2 = getCardById(rcard2id);
			m1 = getCardById(card1id);
			m2 = getCardById(card2id);
			m1hp = m1.HP();
			m2hp = m2.HP();
			r1hp = r1.HP();
			r2hp = r2.HP();
			tmp = "";
			IsUrTurn = 0;
			isrun = 1;
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
			BATTLEQ Q = new BATTLEQ(ip,ID,battleid);
			Q.start();
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
		rBl1.setMax(100);
		rBl2 = (ProgressBar)findViewById(R.id.rB2);
		rBl2.setMax(100);
		Bl1 = (ProgressBar)findViewById(R.id.B1);
		Bl1.setMax(100);
		Bl2 = (ProgressBar)findViewById(R.id.B2);
		Bl2.setMax(100);
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
		A1.setOnClickListener(nolistener);
		D1.setOnClickListener(nolistener);
		S1.setOnClickListener(nolistener);
		A2.setOnClickListener(nolistener);
		D2.setOnClickListener(nolistener);
		S2.setOnClickListener(nolistener);
		B1.setOnClickListener(nolistener);
		B2.setOnClickListener(nolistener);

	}
	public void ATKView(int c1,int c2)
	{
		if(c1==0)
		{
			if(c2==0)
			{
				r1hp-=m1.ATK();
				if(r1hp<0)
					r1hp = 0;
				int tl = r1hp*100/r1.HP();
				rBl1.setProgress(tl);
			}
			else
			{
				r2hp-=m1.ATK();
				if(r2hp<0)
					r2hp = 0;
				int tl = r2hp*100/r2.HP();
				rBl2.setProgress(tl);
			}
		}
		else
		{
			if(c2==0)
			{
				r1hp-=m2.ATK();
				if(r1hp<0)
					r1hp = 0;
				int tl = r1hp*100/r1.HP();
				rBl1.setProgress(tl);
			}
			else
			{
				r2hp-=m2.ATK();
				if(r2hp<0)
					r2hp = 0;
				int tl = r2hp*100/r2.HP();
				rBl2.setProgress(tl);
			}
		}
	}
	//c1:my card num , c2:rival card num
	public void BeATKView(int c1,int c2)
	{
		if(c1==0)
		{
			if(c2==0)
			{
				m1hp-=m1.ATK();
				if(m1hp<0)
					m1hp = 0;
				int tl = m1hp*100/m1.HP();
				Bl1.setProgress(tl);
			}
			else
			{
				m1hp-=m2.ATK();
				if(m1hp<0)
					m1hp = 0;
				int tl = m1hp*100/m1.HP();
				Bl1.setProgress(tl);
			}
		}
		else
		{
			if(c2==0)
			{
				m2hp-=m1.ATK();
				if(m2hp<0)
					m2hp = 0;
				int tl = m2hp*100/m2.HP();
				Bl2.setProgress(tl);
			}
			else
			{
				m2hp-=m2.ATK();
				if(m2hp<0)
					m2hp = 0;
				int tl = m2hp*100/m2.HP();
				Bl2.setProgress(tl);
			}
		}
	}
	public void EnableChoose(int cmd)
	{
		B1.setVisibility(View.VISIBLE);
		B2.setVisibility(View.VISIBLE);
		if(cmd==0)
		{
			B1.setOnClickListener(
					new OnClickListener()
					{

					@Override
					public void onClick(View v) {
					// TODO Auto-generated method stub
					BATTLEATK a = new BATTLEATK(ip,ID,battleid,0,0);
					a.start();
					ATKView(0,0);
					B1.setVisibility(View.INVISIBLE);
					B2.setVisibility(View.INVISIBLE);
					B1.setOnClickListener(nolistener);
					B2.setOnClickListener(nolistener);
					}

					});
			B2.setOnClickListener(
					new OnClickListener()
					{

					@Override
					public void onClick(View v) {
					// TODO Auto-generated method stub
					BATTLEATK a = new BATTLEATK(ip,ID,battleid,1,0);
					a.start();
					ATKView(0,1);
					B1.setVisibility(View.INVISIBLE);
					B2.setVisibility(View.INVISIBLE);
					B1.setOnClickListener(nolistener);
					B2.setOnClickListener(nolistener);
					}

					});
		}
		else if(cmd==1)
		{
			B1.setOnClickListener(
					new OnClickListener()
					{

					@Override
					public void onClick(View v) {
					// TODO Auto-generated method stub
					BATTLEATK a = new BATTLEATK(ip,ID,battleid,0,1);
					a.start();
					ATKView(1,0);
					B1.setVisibility(View.INVISIBLE);
					B2.setVisibility(View.INVISIBLE);
					B1.setOnClickListener(nolistener);
					B2.setOnClickListener(nolistener);
					}

					});
			B2.setOnClickListener(
					new OnClickListener()
					{

					@Override
					public void onClick(View v) {
					// TODO Auto-generated method stub
					BATTLEATK a = new BATTLEATK(ip,ID,battleid,1,1);
					a.start();
					ATKView(1,1);
					B1.setVisibility(View.INVISIBLE);
					B2.setVisibility(View.INVISIBLE);
					B1.setOnClickListener(nolistener);
					B2.setOnClickListener(nolistener);
					}

					});
		}

	}
	public void Enable(int p)
	{
		if(p==0)
		{
			A1.setVisibility(View.VISIBLE);
			D1.setVisibility(View.VISIBLE);
			S1.setVisibility(View.VISIBLE);
			A1.setOnClickListener(
					new OnClickListener()
					{

					@Override
					public void onClick(View v) {
					// TODO Auto-generated method stub
					EnableChoose(0);
					A1.setVisibility(View.INVISIBLE);
					D1.setVisibility(View.INVISIBLE);
					S1.setVisibility(View.INVISIBLE);
					A1.setOnClickListener(nolistener);
					D1.setOnClickListener(nolistener);
					S1.setOnClickListener(nolistener);
					}

					});
			D1.setOnClickListener(
					new OnClickListener()
					{

					@Override
					public void onClick(View v) {
					// TODO Auto-generated method stub
					A1.setVisibility(View.INVISIBLE);
					D1.setVisibility(View.INVISIBLE);
					S1.setVisibility(View.INVISIBLE);
					A1.setOnClickListener(nolistener);
					D1.setOnClickListener(nolistener);
					S1.setOnClickListener(nolistener);
					}

					});
			S1.setOnClickListener(
					new OnClickListener()
					{

					@Override
					public void onClick(View v) {
					// TODO Auto-generated method stub
					A1.setVisibility(View.INVISIBLE);
					D1.setVisibility(View.INVISIBLE);
					S1.setVisibility(View.INVISIBLE);
					A1.setOnClickListener(nolistener);
					D1.setOnClickListener(nolistener);
					S1.setOnClickListener(nolistener);
					}

					});
		}
		else
		{
			A2.setVisibility(View.VISIBLE);
			D2.setVisibility(View.VISIBLE);
			S2.setVisibility(View.VISIBLE);
			A2.setOnClickListener(
					new OnClickListener()
					{

					@Override
					public void onClick(View v) {
					// TODO Auto-generated method stub
					EnableChoose(1);
					A2.setVisibility(View.INVISIBLE);
					D2.setVisibility(View.INVISIBLE);
					S2.setVisibility(View.INVISIBLE);
					A2.setOnClickListener(nolistener);
					D2.setOnClickListener(nolistener);
					S2.setOnClickListener(nolistener);
					}

					});
			D2.setOnClickListener(
					new OnClickListener()
					{

					@Override
					public void onClick(View v) {
					// TODO Auto-generated method stub
					A2.setVisibility(View.INVISIBLE);
					D2.setVisibility(View.INVISIBLE);
					S2.setVisibility(View.INVISIBLE);
					A2.setOnClickListener(nolistener);
					D2.setOnClickListener(nolistener);
					S2.setOnClickListener(nolistener);
					}

					});
			S2.setOnClickListener(
					new OnClickListener()
					{

					@Override
					public void onClick(View v) {
					// TODO Auto-generated method stub
					A2.setVisibility(View.INVISIBLE);
					D2.setVisibility(View.INVISIBLE);
					S2.setVisibility(View.INVISIBLE);
					A2.setOnClickListener(nolistener);
					D2.setOnClickListener(nolistener);
					S2.setOnClickListener(nolistener);
					}

					});
		}
	}
	public class BATTLEATK extends Thread
	{
		String ip;
		String uID;
		int port;
		int BID;
		int target;
		int atker;
		public BATTLEATK(String tip,String tID,int tBID,int ttarget,int tatker)
		{
			port = 5000;
			ip = tip;
			uID = tID;
			BID = tBID;
			target = ttarget;
			atker = tatker;
		}
		@Override
			public void run()
			{
				Socket socket = null;
				try {

					// 宣告輸出至Server的Stream
					DataOutputStream out ;//=new DataOutputStream(socket.getOutputStream());; 
					// 宣告讀取自Server的物件
					BufferedReader in;//= new BufferedReader(new InputStreamReader(socket.getInputStream()));;





					socket = new Socket(ip,5000);
					out =new DataOutputStream(socket.getOutputStream());
					in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String message = uID;
					out.writeBytes(message+"\n");
					out.writeBytes("BATTLEATK\n");
					out.writeBytes(String.valueOf(battleid)+"\n");
					out.writeBytes(String.valueOf(atker)+"\n");
					out.writeBytes(String.valueOf(target)+"\n");


				}
				catch(Exception e)
				{

				}
			}
	}
	public class BATTLEQ extends Thread
	{
		String ip;
		String uID;
		int port;
		int BID;
		int atker;
		int beatker;
		public BATTLEQ(String tip,String tID,int tBID)
		{
			port = 5000;
			ip = tip;
			uID = tID;
			BID = tBID;
		}
		@Override
			public void run()
			{
				Socket socket = null;
				try {

					// 宣告輸出至Server的Stream
					DataOutputStream out ;//=new DataOutputStream(socket.getOutputStream());; 
					// 宣告讀取自Server的物件
					BufferedReader in;//= new BufferedReader(new InputStreamReader(socket.getInputStream()));;


					while(isrun==1)
					{
						BATTLEQ.sleep(1000);
						socket = new Socket(ip,5000);
						out =new DataOutputStream(socket.getOutputStream());
						in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
						String message = uID;
						out.writeBytes(message+"\n");
						out.writeBytes("BATTLEQ\n");
						out.writeBytes(String.valueOf(battleid)+"\n");
						String buf = in.readLine();
						if(buf.equals("no"))
						{

						}
						else if(buf.equals("DEX"))
						{
							out.writeBytes(String.valueOf(m1.Agi())+"\n");
							out.writeBytes(String.valueOf(m2.Agi())+"\n");
						}
						else if(buf.equals("TURN"))
						{
							String sn = in.readLine();
							int ns = Integer.valueOf(sn);
							
							if(ns==0)
							{
								if(m1hp!=0)
								{
									out.writeBytes("OK\n");
									notify.post(new Runnable()
									{

										@Override
										public void run() {
											// TODO Auto-generated method stub
											Enable(0);
										}
										
									});
									
									
								}
								else
								{
									out.writeBytes("DEAD\n");
								}
							}
							else
							{
								if(m2hp!=0)
								{
									out.writeBytes("OK\n");
									notify.post(new Runnable()
									{

										@Override
										public void run() {
											// TODO Auto-generated method stub
											Enable(1);
										}
										
									});
									
								}
								else
								{
									out.writeBytes("DEAD\n");
								}
							}
						}
						else if(buf.equals("BATTLEATK"))
						{
							String satk = in.readLine();
							String sta = in.readLine();
							int atk = Integer.valueOf(satk);
							int ta = Integer.valueOf(sta);
							atker = atk;
							beatker = ta;
							notify.post(
									new Runnable()
									{

										@Override
										public void run() {
											// TODO Auto-generated method stub
											BeATKView(beatker,atker);
										}
										
									}
									);
						}
						socket.close();
					}
				}
				catch(Exception e)
				{

				}
			}
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
	public OnClickListener nolistener = new OnClickListener()
	{

		@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}

	};
}
