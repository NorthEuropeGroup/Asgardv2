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

	Button button_connect;
	TextView tt;
	Handler notify = new Handler();
	SimpleAdapter adapter;
	String ID;
	ArrayList<HashMap<String,Object>> Ulist = new ArrayList<HashMap<String,Object>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_connect1);
		Bundle bData = this.getIntent().getExtras();
		ID = bData.getString("ID");
		Eip = (EditText)findViewById(R.id.eip);
		
		button_connect = (Button)findViewById(R.id.Go);
		tt = (TextView)findViewById(R.id.textView1);
		button_connect.setOnClickListener(
				new OnClickListener()
				{

				@Override
				public void onClick(View v) {
				// TODO Auto-generated method stub
					String iip = Eip.getText().toString();
					
					//ClientReq co = new ClientReq(iip,5000,iuid);
					
					//co.start();
					//Change View
					// 建立 Bundle 物件
		            internet co = new internet(iip,5000,ID);
		            co.start();
		            
					
				}

				}
				);
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
					
					
					
					 out.writeBytes("LogIn\n");
					String response = in.readLine();
					if(response.equals("OK"))
					{
						notify.post(
								new Runnable()
								{

								@Override
								public void run() {
								// TODO Auto-generated method stub
								Intent newAct = new Intent();
								newAct.setClass(UserConnect1.this,CardChoose.class );
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
