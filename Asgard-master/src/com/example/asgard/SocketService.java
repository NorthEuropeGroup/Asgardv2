package com.example.asgard;

import java.io.*;
import java.net.*;

import android.util.Log;

public class SocketService
{
	public Socket clientSocket;
	public ObjectOutputStream toServer;
	public ObjectInputStream msgFromServer;
	private static SocketService mySocket = new SocketService();
	private SocketService()
	{
		try
		{
			clientSocket = new Socket();
		}
	   			
	   	catch(Exception e)
	   	{
	   		Log.e("ThisIsMyTag", "error",e);
	   	}
	}
	public static SocketService getSocket()
	{
		return mySocket;
	}
}