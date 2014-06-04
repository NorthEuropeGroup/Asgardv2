package com.example.asgard;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserConnect1 extends Activity {
	EditText Eip;
	EditText Euid;
	Button button_connect;
	TextView tt;
	public SocketService connectService;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_connect1);
		connectService = SocketService.getSocket();
		Eip = (EditText)findViewById(R.id.eip);
		Euid = (EditText)findViewById(R.id.euid);
		button_connect = (Button)findViewById(R.id.connect);
		tt = (TextView)findViewById(R.id.textView1);
		button_connect.setOnClickListener(
				new OnClickListener()
				{

				@Override
				public void onClick(View v) {
				// TODO Auto-generated method stub
					String iip = Eip.getText().toString();
					String iuid = Euid.getText().toString();
					internet co = new internet(iip,5000,iuid);
					tt.setText(iuid);
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
		
		MsgData msg;
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
					//³]©wServer IP¦ì¸m
					 InetSocketAddress isa = new InetSocketAddress(ip,5000);
				
					// connectService.clientSocket = new Socket();
					//connectService.clientSocket.connect(isa);
					socket = new Socket(ip,5000);
					//socket.connect(isa);
					
					//BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					//PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
					   
					//BufferedOutputStream dout = new
						//	BufferedOutputStream(socket.getOutputStream());
					//connectService.toServer = new ObjectOutputStream(connectService.clientSocket.getOutputStream());
					ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());//send MsgData
					ObjectInputStream in = new ObjectInputStream(socket.getInputStream());//receive MsgData
					MsgData mmsg = new MsgData(uid,uid);
				
					out.writeObject(mmsg);
					out.flush();
					MsgData ok = (MsgData) in.readObject();
					
					//out.flush();
					//out.println(uid);
					//String cmd = in.readLine();
					//out.flush();
					

				}catch(Exception e)
				{

				}


			}




	}
}
