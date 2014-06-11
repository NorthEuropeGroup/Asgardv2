package com.example.asgard;

public  class skill {
	public int type;//0:damage , 1:%damage
	public int hpvalue;
	public int heal;
	public int abs;
	public int natk;
	int all;
	int ref;
	public skill(int ttype,int n)
	{
		type = ttype;
		hpvalue = n;
		heal = 0;
		abs = 0;
		natk = 0;
		all = 0;
		ref = 0;
	}
}
