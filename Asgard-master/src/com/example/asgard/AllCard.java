package com.example.asgard;

public abstract class  AllCard {
	public String name=Character()[0];
	public int level=level();
	public String title=Character()[1];
	public String intro=Character()[2];
	public String skillName=Character()[3];
	public String skill_intro=Character()[4];
	//public int price=price();
	public int hp=HP();
	public int atk=ATK();
	public int def=DEF();
	public int agi=Agi();
	//public String[] src=src();

	public abstract String[] Character();
	public abstract int level();
	public abstract int HP();
	public abstract int ATK();
	public abstract int DEF();
	public abstract int Agi();
	//public abstract int price();
	//public abstract String[] src();

}
