package com.example.asgard;

import java.io.*;
import java.net.*;
import java.util.*;
public class Server {
	//public String ip;
	//public int port;
	private String Server_ADDRESS="140.116.104.209";
	private int Server_PORT = 5000;
	private InetAddress inetAddress;
	private ServerSocket serverSocket;
	
	private ArrayList<User> userList;//store users data
	private User tempUser;//receive the user data from client
	private MsgData message, ACK_Msg, READY_Msg;
	private int userIndex;//the non-changeable index of user
	private int sendIndex;
	
	
	private ArrayList <ObjectOutputStream> S_outV;
	private ArrayList <ObjectInputStream> S_inV;
	
	public Server()
	{
		userIndex = 0;
		sendIndex = 0;
		ACK_Msg = new MsgData("none","ACK","Server");
		READY_Msg = new MsgData("none","READY","Server");
	}
	/*public static String bytetoString(byte [] data1)
	  {
		  String ans = "";
		  for(int i = 0;;i++)
		  {
			  if(data1[i]==0)
				  break;
			  ans = ans + (char)data1[i];
		  }
		  return ans;
	  }*/
	public void go()
	{
		try{
			inetAddress = InetAddress.getByName(Server_ADDRESS);
			System.out.println("Server start...");
			
			serverSocket = new ServerSocket(Server_PORT, 15);
			while(true)
				waitNewUser();
		}catch(Exception e){
		}
	}
	public void waitNewUser()
	{
		MsgData userName;
		try{
			Socket socket = serverSocket.accept();
			System.out.println("Accepted");
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("TEST");
			userName = (MsgData) in.readObject();
			
			System.out.println(userName.getName());
			out.writeObject(ACK_Msg);
			out.flush();
			createNewUser(userName, socket);
			Thread.sleep(800);
			
		}catch(IOException e1){
        System.out.println("IO");
		e1.printStackTrace();
		}
		catch(ClassNotFoundException e2){
			System.out.println("ClassNotFound");
			e2.printStackTrace();
		}catch(InterruptedException e3)
		{
			System.out.println("QQ");
		}
		
		
	}
	public void createNewUser(final MsgData userName, final Socket socket)
	{
		
		Thread t = new Thread(new Runnable(){//the thread receive MsgData
			public void run(){
				try{
					tempUser = new User(userName.getName(),userIndex);
					System.out.println("userName:" + userName.getName());//debug
					System.out.println("userIndex:" + userIndex);//debug
					ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());//send MsgData
					ObjectInputStream in = new ObjectInputStream(socket.getInputStream());//receive MsgData
					
					userList.add(tempUser);
					S_inV.add(in);
					S_outV.add(out);
					userIndex++;
					
					while ((message = (MsgData) in.readObject())!=null)
					{
						if(message.getType().equals("PREBATTLE")){
							message.userList = userList;
							sendIndex = getMsgDestIndex(message.getSender());
							message.setSender("Server");
							S_outV.get(sendIndex).writeObject(message);
							S_outV.get(sendIndex).flush();
						}
						else if(message.getType().equals("BATTLE_ASK"))
						{
							sendIndex = getMsgDestIndex(message.getSender());
							S_outV.get(sendIndex).writeObject(ACK_Msg);
							S_outV.get(sendIndex).flush();//reply ack
							
							sendIndex = getMsgDestIndex(message.getReceiver());
							if(!userList.get(sendIndex).getBattleStatus())//the value is false if the user isn't in battle
							{
								//String s = message.getSender();
								//message.setName(s);
								message.setName(message.getSender());
								S_outV.get(sendIndex).writeObject(message);
								S_outV.get(sendIndex).flush();
							}
							else
							{
								sendIndex = getMsgDestIndex(message.getSender());
								message.setType("REJECT");
								S_outV.get(sendIndex).writeObject(message);
								S_outV.get(sendIndex).flush();
							}
						}
						else if(message.getType().equals("ANSWER"))
						{
							if(message.getName().equals("N"))
							{
								sendIndex = getMsgDestIndex(message.getReceiver());
								message.setType("REJECT");
								S_outV.get(sendIndex).writeObject(message);
								S_outV.get(sendIndex).flush();
							}
							else if(message.getName().equals("Y"))
							{
								message.setType("START");
								sendIndex = getMsgDestIndex(message.getReceiver());
								userList.get(sendIndex).switchBattleFlag();
								S_outV.get(sendIndex).writeObject(message);
								S_outV.get(sendIndex).flush();
								
								sendIndex = getMsgDestIndex(message.getSender());
								userList.get(sendIndex).switchBattleFlag();
								S_outV.get(sendIndex).writeObject(message);
								S_outV.get(sendIndex).flush();
							}
						}
						//else if(message.getType().equals("CARDSELECT"))
						//{
						//}
						/*else if(message.getType().equals("GETCARD"))
						{
							int cardIndex;//1~15 for temporary
							cardIndex = (int) (Math.random()*15+1);
							
							sendIndex = getMsgDestIndex(message.getSender());
							message.setName(cardIndex.toString());
							message.setReceiver(message.getSender());
							message.setSender("Server");
							S_outV.get(sendIndex).writeObject(message);
							S_outV.get(sendIndex).flush();
						}*/
						else if(message.getType().equals("ACK"))
						{
							System.out.println("The user" + message.getSender() + "gives an ACK to us.");
						}
						else if(message.getType().equals("LOGOUT"))
						{
							sendIndex = getMsgDestIndex(message.getSender());
							S_outV.get(sendIndex).writeObject(ACK_Msg);
							S_outV.get(sendIndex).flush();//reply ack
							
							userList.remove(sendIndex);
							S_outV.remove(sendIndex);
							S_inV.remove(sendIndex);
						}
					}
				}catch(Exception ex){
					System.out.println("one user disconnect");
					ex.printStackTrace();
				}
			}
		});
		t.start();
	}
	public int getMsgDestIndex(String name)//get the destination of message
	{
		for(int i = 0; i < userList.size(); i++)
		{
			if(userList.get(i).getID().equals(name))
				return i;
		}
		return -1;
	}
			
			/*while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("Ac");
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					DataOutputStream out = new
							DataOutputStream(socket.getOutputStream());
					byte[] data = new byte[2048];
					Arrays.fill(data,(byte)0);
					//in.read(data);
					String cmd = in.readLine();
					
					System.out.println(cmd);
					if(cmd.equals("connect"))
					{
						out.writeBytes("OK\n");
					}
					socket.close();
			}	
		}catch(Exception e)
		{
			
		}
	}*/
	public  static  void main(String[] args)
	{
		Server s = new Server();
		s.go();
	}
}
