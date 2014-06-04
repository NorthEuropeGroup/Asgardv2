package com.example.asgard;

import java.util.*;
public class MsgData implements java.io.Serializable
{
	private String name;
	private String type;
	private String sender;
	private String receiver;
	private BattleCard bc;
	private Action action;
	
	public ArrayList<User> userList;
	
	/*public MsgData()
	{
		this.name = new String();
		this.type = new String();
	}*/
	public MsgData(String name, String sender)
	{
		this.name = name;
		this.type = new String();
		this.sender = sender;
		this.receiver = new String();
		this.userList = new ArrayList<User>();
		this.bc = new BattleCard();
		this.action = new Action();
	}
	public MsgData(String name, String type, String sender)
	{
		this.name = name;
		this.type = type;
		this.sender = sender;
		this.receiver = new String();
		this.userList = new ArrayList<User>();
		this.bc = new BattleCard();
		this.action = new Action();
	}
	public String getName()
	{
		return name;
	}
	public String getType()
	{
		return type;
	}
	public String getSender()
	{
		return sender;
	}
	public String getReceiver()
	{	
		return receiver;
	}
	public BattleCard getBC()
	{	
		return bc;
	}
	public Action getAction()
	{
		return action;
	}
	
	public void setName(String n)
	{	
		this.name = n;
	}
	public void setType(String t) 
	{
		this.type = t;
	}
	public void setSender(String s) 
	{
		this.sender = s;
	}
	public void setReceiver(String r) 
	{
		this.receiver = r;
	}
	public void setBC(BattleCard b) 
	{
		this.bc = b;
	}
	public void setAction(Action a) 
	{
		this.action = a;
	}
}