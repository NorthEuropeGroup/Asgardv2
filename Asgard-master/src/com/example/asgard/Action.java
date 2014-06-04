package com.example.asgard;

public class Action implements java.io.Serializable
{
	private String attacker;
	private String act;
	private String target;
	public Action()
	{
		attacker = new String();
		act = new String();
		target = new String();
	}
	public Action(String atker, String act, String t)
	{
		this.attacker = atker;
		this.act = act;
		this.target = t;
	}
	public String getAttacker()
	{
		return attacker;
	}
	public String getAct() 
	{
		return act;
	}
	public String getTarget() 
	{
		return target;
	}
}