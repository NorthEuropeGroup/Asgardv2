package com.example.asgard;

import java.util.*;
public class BattleField
{
	public ArrayList<String> IDs;
	public ArrayList<AllCard> actionOrder;
	public ArrayList<BattleCard> team;
	public BattleField(String ID_A, String ID_B)
	{
		IDs = new ArrayList<String>();
		IDs.add(ID_A);
		IDs.add(ID_B);
		actionOrder = new ArrayList<AllCard>();
		team = new ArrayList<BattleCard>();
	}
	public BattleField(BattleCard b1, BattleCard b2)
	{
		actionOrder = new ArrayList<AllCard>();
		team = new ArrayList<BattleCard>();
		team.add(b1);
		team.add(b2);
		IDs = new ArrayList<String>();
		IDs.add(b1.getMaster());
		IDs.add(b2.getMaster());
	}
	
	public void determineOrder()
	{
		ArrayList<AllCard> temp = new ArrayList<AllCard>();
		int max_agi = 0;
		int max_index = -1;
		temp.add(team.get(0).cardSelect.get(0));
		temp.add(team.get(0).cardSelect.get(1));
		temp.add(team.get(1).cardSelect.get(0));
		temp.add(team.get(1).cardSelect.get(1));//add 4 cards into the temp array
		
		for(int i = 0; i < temp.size(); i++)
		{
			if(temp.get(i).agi > max_agi)
			{
				max_agi = temp.get(i).agi;
				max_index = i;
			}
			if(i == temp.size()-1)
			{
				actionOrder.add(temp.get(max_index));
				temp.remove(max_index);
				max_agi = 0;
				max_index = -1;
			}
		}
	}
}