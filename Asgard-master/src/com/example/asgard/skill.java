package com.example.asgard;

public  class skill {
	public int type;
	public int value;
	public skill(int ttype,int n)
	{
		type =ttype;
		//純傷害
		if(type==0)
		{
			value = n;
		}
		//無視防禦傷害
		else if(type==1)
		{
			value = n;
		}
		//造成%數傷害
		else if(type==2)
		{
			value = n;
		}
		//連續攻擊
		else if(type==3)
		{
			value = n;
		}
		//迴避並造成傷害
		else if(type==4)
		{
			value=n;
		
		}
	}
}
