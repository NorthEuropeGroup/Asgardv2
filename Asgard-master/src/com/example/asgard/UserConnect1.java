package com.example.asgard;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class UserConnect1 extends Activity {
	EditText Eip;
	EditText Euid;
	Button button_connect;
	TextView tt;
	Handler notify = new Handler();
	SimpleAdapter adapter;
	
	ArrayList<HashMap<String,Object>> Ulist = new ArrayList<HashMap<String,Object>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_connect1);
		
		Eip = (EditText)findViewById(R.id.eip);
		Euid = (EditText)findViewById(R.id.euid);
		button_connect = (Button)findViewById(R.id.Go);
		tt = (TextView)findViewById(R.id.textView1);
		button_connect.setOnClickListener(
				new OnClickListener()
				{

				@Override
				public void onClick(View v) {
				// TODO Auto-generated method stub
					String iip = Eip.getText().toString();
					String iuid = Euid.getText().toString();
					//ClientReq co = new ClientReq(iip,5000,iuid);
					
					//co.start();
					//Change View
					// 建立 Bundle 物件
		            internet co = new internet(iip,5000,iuid);
		            co.start();
		            
					
				}

				}
				);
	}
	public class ClientReq extends Thread
	{
		public String ip;
		public int port;
		public String text;
		public String uid;
		public ClientReq()
		{
			ip = null;
			port = 0;
			uid = null;
		}
		public ClientReq(String tip,int tport,String tuid)
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
				while(true)
				{
					ClientReq.sleep(100);
					socket = new Socket(ip,5000);
					
					out =new DataOutputStream(socket.getOutputStream());
					in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String message = uid+"#R\n";
					
					out.writeBytes(message);
					String response = in.readLine();
					if(response.charAt(0)=='Y')
					{
						
					}
					
					socket.close();
				}
				
				
			}catch(Exception e)
			{
				
			}
		}
	}
	public class internet extends Thread{
		public String ip;
		public int port;
		public String text;
		public String uid;
		
	
		public internet()
		{
			ip = null;
			port = 0;
			uid = null;
		}
		public internet(String tip,int tport,String tuid)
		{
			ip = tip;
			port = tport;
			uid = tuid;
		}
	

		@Override
			public void run()
			{
				InetAddress serverAddr = null;
				SocketAddress sc_add = null;
				Socket socket = null;
				

				try {
					//設定Server IP位置
					 InetSocketAddress isa = new InetSocketAddress(ip,5000);
				
					// connectService.clientSocket = new Socket();
					//connectService.clientSocket.connect(isa);
					socket = new Socket(ip,5000);
					//socket.connect(isa);

					// 宣告輸出至Server的Stream
					DataOutputStream out=new DataOutputStream(socket.getOutputStream());; 
					// 宣告讀取自Server的物件
					BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream()));;
					
					 out.writeBytes(uid+"\n");
					
					
					/*notify.post(
							new Runnable()
							{

								@Override
								public void run() {
									// TODO Auto-generated method stub
									setContentView(R.layout.activity_list);
									Ulist = new  ArrayList<HashMap<String,Object>>();
									for(int i=0; i<userList1.size(); i++){
										 HashMap<String,Object> item = new HashMap<String,Object>();
										 item.put("ID", userList1.get(i).getID());
										 if(userList1.get(i).getBattleStatus())
											 item.put("inbattle", "In battle");
										 else
											 item.put("inbattle", "Not in battle");
										 
										 Ulist.add( item );
										 }
									adapter = new SimpleAdapter( 
											 UserConnect1.this, 
											 Ulist,
											 R.layout.list_item,
											 new String[]{"ID","inbattle"},
											 new int []{R.id.ID,R.id.inbattle});
									
								}
								
							}
							);
					*/
					 String y = in.readLine();
					 out.writeBytes("test\n");
					 if(y.equals("none"))
					 {
					 notify.post(
								new Runnable()
								{

									@Override
									public void run() {
										// TODO Auto-generated method stub
										Intent newAct = new Intent();
							            newAct.setClass(UserConnect1.this, Asgard.class );
										Bundle bData = new Bundle();
							            bData.putString("ip", ip);
							            bData.putString("ID", uid);
							            // 將 Bundle 指定到 Intent
							            newAct.putExtras( bData );
							            // 呼叫新的 Activity Class
							            startActivity( newAct );
									}
									
								});
					 }
					 
				}catch(Exception e)
				{

				}


			}




	}
}
