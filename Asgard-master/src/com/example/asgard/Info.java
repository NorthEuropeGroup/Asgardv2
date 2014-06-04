package com.example.asgard;

public class Info {
	private String ID;
	private int[] cards;
	private int money;
	
	public Info(){
	}
	public Info(String ID, int[] cards, int money){
		this.ID=ID;
		this.cards=cards;
		this.money=money;
	}
	public void setID(String ID){
		this.ID=ID;
	}
	public void setCards(int[] cards){
		this.cards=cards;
	}
	public String getID(){
		return ID;
	}
	public int[] getCards(){
		return cards;
	}
	public int getMoney(){
		return money;
	}

}
