package com.example.asgard;

public class User implements java.io.Serializable
{
	private String ID;
	private boolean inBattle;
	//private int index;
	
	/*public User(String ID, boolean inBattle)
	{
		this.ID = ID;
		this.inBattle = inBattle;
	}*/
	public User(String ID, int index)
	{
		this.ID = ID;
		this.inBattle = false;
		//this.index = index;
	}
	public String getID() 
	{
		return ID;
	}
	//public int getIndex() return index;
	public boolean getBattleStatus()
	{
		return inBattle;
	}
	public void switchBattleFlag()
	{
		if(inBattle == false)
			inBattle = true;
		else
			inBattle = false;
	}
}
