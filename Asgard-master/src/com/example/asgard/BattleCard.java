package com.example.asgard;

import java.util.*;
public class BattleCard implements java.io.Serializable
{
	private String master;
	public ArrayList<AllCard> cardSelect;
	public BattleCard()
	{
		master = new String();
		cardSelect = new ArrayList<AllCard>();
	}
	public BattleCard(String m, AllCard c1, AllCard c2)
	{
		master = m;
		cardSelect = new ArrayList<AllCard>();
		cardSelect.add(c1);
		cardSelect.add(c2);
	}
	public String getMaster() 
	{
		return master;
	}
}
