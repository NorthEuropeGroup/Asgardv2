package com.example.asgard;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class List extends Activity {
	ListView l1;
	Button b1;
	String ip;
	String ID;
	int card1id;
	int card2id;
	int rcard1id;
	int rcard2id;
	int battleid;
	int target = 0;
	String rID;
	int  isrun= 1;
	ArrayList<String> UL;
	ArrayList<HashMap<String,Object>>Ulist ;
	Handler notify=new Handler();
	SimpleAdapter adapter;
	AlertDialog alertDialog;
	Request r1;
	String com;
	@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_list);
			Bundle bData = this.getIntent().getExtras();
			ip = bData.getString("ip");
			ID = bData.getString("ID");
			card1id = bData.getInt("C1");
			card2id = bData.getInt("C2");
			b1 = (Button)findViewById(R.id.button1);
			
			b1.setOnClickListener(
					new OnClickListener()
					{

					@Override
					public void onClick(View v) {
					// TODO Auto-generated method stub
					PREBATTLE co = new PREBATTLE(ip,5000,ID);
					co.start();
					}

					});
			
			r1 = new Request(ip,5000,ID);
			r1.start();

		}
	@Override
		public boolean onKeyDown(int keyCode, KeyEvent event) {
			if (keyCode == KeyEvent.KEYCODE_BACK) {
				LogOut co = new LogOut(ip,5000,ID);
				co.start();
				isrun = 0;
				return super.onKeyDown(keyCode, event);

			}
			return true;
		}
	public void onResume()
    {
		isrun = 1;
        super.onResume();
        
    }

	@Override
		public boolean onContextItemSelected(MenuItem item)
		{
			switch(item.getItemId()) {
				case 0:
					//connect(targetpeer);
					BATTLEASK co = new BATTLEASK(ip,5000,ID,target);
					co.start();
					break;
				default:

					break;


			}
			return super.onContextItemSelected(item);
		}
	public AlertDialog getAlertDialog(String title,String message)
	{
		Builder builder = new AlertDialog.Builder(List.this);
		builder.setTitle(title);
		builder.setMessage(message);
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {

				}
				});
		return builder.create();
	}
	public AlertDialog getBATTLEASK(String title,String user)
	{
		com = user;
		Builder builder = new AlertDialog.Builder(List.this);
		builder.setTitle(title);
		builder.setMessage(user+" want to hava a battle with you>< \nAccept or Reject");
		builder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					BATTLERES co = new BATTLERES(ip,5000,ID,com,"Y");
					co.start();
					isrun = 0;
					rID = com;
					Intent intent = new Intent();
					Bundle bData = new Bundle();
					bData.putString("ip", ip);
					bData.putString("ID", ID);
					bData.putString("rID", rID);
					bData.putInt("card1",card1id);
					bData.putInt("card2",card2id);
					bData.putInt("rcard1",rcard1id);
					bData.putInt("rcard2",rcard2id);
					bData.putInt("bid",battleid);
					// 將 Bundle 指定到 Intent
					intent.putExtras( bData );
					
			        intent.setClass(List.this,Fight.class);
			        startActivity(intent);
				}
				});
		builder.setNegativeButton("Reject", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
					BATTLERES co = new BATTLERES(ip,5000,ID,com,"N");
					co.start();
			}
			});
		return builder.create();
	}
	public class BATTLERES extends Thread
	{
		public String ip;
		public int port;
		public String uid;
		public String comm;
		public String YN;
		public BATTLERES(String tip,int tport,String tuid,String tcomm,String tYN)
		{
			ip = tip;
			port = tport;
			uid = tuid;
			comm = tcomm;
			YN = tYN;

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
				String message = uid+"\n";

				out.writeBytes(message);

				message = "BATTLERES\n";
				out.writeBytes(message);
				out.writeBytes(comm+"\n");
				out.writeBytes(YN+"\n");
				out.writeBytes(String.valueOf(card1id)+"\n");
				out.writeBytes(String.valueOf(card2id)+"\n");
				
			}
			catch( Exception e)
			{
				
			}
		}
	}
	public class BATTLEASK extends Thread
	{
		public String ip;
		public int port;
		public String uid;
		public int rival;
		public BATTLEASK(String tip,int tport,String tuid,int trival)
		{
			ip = tip;
			port = tport;
			uid = tuid;
			rival = trival;

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
					String message = uid+"\n";

					out.writeBytes(message);

					message = "BATTLEASK\n";
					out.writeBytes(message);
					String p = UL.get(rival);
					out.writeBytes(p+"\n");
					out.writeBytes(String.valueOf(card1id)+"\n");
					out.writeBytes(String.valueOf(card2id)+"\n");
					String res = in.readLine();
					if(res.equals("NO"))
					{
						notify.post(
								new Runnable()
								{

								@Override
								public void run() {
								alertDialog = getAlertDialog("No","Wrong");
								alertDialog.show();
								}
								}
							   );

					}
					else
					{
						battleid = Integer.valueOf(res);
					
					}

				}catch(Exception e)
				{

				}
			}
	}
	public class LogOut extends Thread
	{
		public String ip;
		public int port;
		public String uid;
		public LogOut(String tip,int tport,String tuid)
		{
			ip = tip;
			port = tport;
			uid = tuid;
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
					String message = uid+"\n";

					out.writeBytes(message);

					message = "LogOut\n";
					out.writeBytes(message);
					String cmd = in.readLine();


				}catch(Exception e)
				{

				}
			}
	}
	public class PREBATTLE extends Thread
	{
		public String ip;
		public int port;

		public String uid;
		public PREBATTLE(String tip,int tport,String tuid)
		{
			ip = tip;
			port = tport;
			uid = tuid;
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
					String message = uid+"\n";

					out.writeBytes(message);

					message = "PREBATTLE\n";
					out.writeBytes(message);
					String cmd = in.readLine();
					String [] tok = cmd.split("#");
					UL = new ArrayList<String>();
					for(int i = 0;i<tok.length;i++)
					{
						UL.add(tok[i]);
					}
					notify.post(
							new Runnable()
							{

							@Override
							public void run() {
							// TODO Auto-generated method stub
							l1 = (ListView)findViewById(R.id.listView1);
							Ulist= new  ArrayList<HashMap<String,Object>>();
							for(int i=0; i<UL.size(); i++){
							HashMap<String,Object> item = new HashMap<String,Object>();
							item.put("ID", UL.get(i));

							item.put("inbattle", "Not in battle");

							Ulist.add( item );
							}
							adapter = new SimpleAdapter( 
								List.this, 
								Ulist,
								R.layout.list_item,
								new String[]{"ID","inbattle"},
								new int []{R.id.ID,R.id.inbattle});
							l1.setAdapter(adapter);
							l1.setOnItemClickListener(
									new OnItemClickListener()
									{

									@Override
									public void onItemClick(AdapterView<?> parent, View view,
										int position, long id) {
									// TODO Auto-generated method stub
									target = position;
									}

									});
							registerForContextMenu(l1);
							l1.setOnItemLongClickListener(
									new OnItemLongClickListener()
									{
									@Override
									public boolean onItemLongClick(AdapterView<?> parent,
										View view, int position,long id)
									{

									l1.showContextMenu();


									return true;
									}
									}


									);
							l1.setOnCreateContextMenuListener(
									new OnCreateContextMenuListener()
									{


									@Override
									public void onCreateContextMenu(
										ContextMenu menu, View v,
										ContextMenuInfo menuInfo) {
									// TODO Auto-generated method stub
									menu.add(0,0,0,"Fight");
									menu.add(0,1,1,"Cancel");

									List.this.onCreateContextMenu(menu,v,menuInfo);
									}

									}

									);

							}});

				}
				catch(Exception e)
				{

				}
			}
	}
	public class Request extends Thread
	{
		public String ip;
		public int port;
		String rival;
		public String uid;
		public Request(String tip,int tport,String tuid)
		{
			ip = tip;
			tport = port;
			uid = tuid;
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
						Request.sleep(1000);
						socket = new Socket(ip,5000);

						out =new DataOutputStream(socket.getOutputStream());
						in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
						String message = uid+"\n";

						out.writeBytes(message);
						out.writeBytes("Request\n");
						String buf = in.readLine();
						if(buf.equals("no"))
						{
								
						}
						else if(buf.equals("BATTLEASK"))
						{
							rival = in.readLine();
							String m = in.readLine();
							rcard1id = Integer.valueOf(m);
							 m = in.readLine();
							 rcard2id = Integer.valueOf(m);
							 m = in.readLine();
							 battleid = Integer.valueOf(m);
							notify.post(
									new Runnable()
									{

									@Override
									public void run() {
									com = rival;
									alertDialog = getBATTLEASK("Fight",rival);
									alertDialog.show();
									}
									}
								   );
						}
						else if(buf.equals("BATTLERES"))
						{
							String YN = in.readLine();
							String ri = in.readLine();
							rID = ri;
							String m = in.readLine();
							rcard1id = Integer.valueOf(m);
							 m = in.readLine();
							 rcard2id = Integer.valueOf(m);
							if(YN.equals("Y"))
							{
								notify.post(
										new Runnable()
										{

										@Override
										public void run() {
											isrun = 0;
											Intent intent = new Intent();
											Bundle bData = new Bundle();
											bData.putString("ip", ip);
											bData.putString("ID", ID);
											bData.putString("rID", rID);
											bData.putInt("card1",card1id);
											bData.putInt("card2",card2id);
											bData.putInt("rcard1",rcard1id);
											bData.putInt("rcard2",rcard2id);
											bData.putInt("bid",battleid);
											// 將 Bundle 指定到 Intent
											intent.putExtras( bData );
									        intent.setClass(List.this,Fight.class);
									        startActivity(intent);
									       
										}
										}
									   );
							}
						}
						socket.close();
					}
				}
				catch(Exception e)
				{

				}
			}

	}
}


