package com.example.asgard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Info {
	String ID="130";
	int card01=0;
	int card02=0;
	int card03=0;
	int card04=0;
	int card05=0;
	int card06=0;
	int card07=0;
	int card08=0;
	int card09=0;
	int card10=0;
	int card11=0;
	int card12=0;
	int card13=0;
	int card14=0;
	int card15=0;
	int card16=0;
	int card17=0;
	int card18=0;
	int money=0;
	
	public Info(){
	}
	public Info(String id){
		int get1=ran();
		get1=get1%3;
		if (get1==0){
			this.card01=1;
			this.card02=1;
		}
		else if (get1==1){
			this.card04=1;
			this.card05=1;
		}
		else {
			this.card03=1;
			this.card06=1;
		}
		this.ID=id;
		this.money=1000000;
		
	}


	public int getMoney(){
		return money;
	}
	 //���ü�
	public int ran(){
		return ((int) (Math.random()*10));
	}
	public void SaveFile(Info man){
		try{
			FileWriter fw = new FileWriter("/sdcard/Asgard.txt", false);
			BufferedWriter bw = new BufferedWriter(fw); //�NBufferedWeiter�PFileWrite���󰵳s��
	           bw.write(man.ID);
	           bw.newLine();
	           bw.write(Integer.toString(man.money));
	           bw.newLine();
	           
	        	   bw.write(Integer.toString(man.card01));
    	           bw.newLine();
    	           bw.write(Integer.toString(man.card02));
    	           bw.newLine();
    	           bw.write(Integer.toString(man.card03));
    	           bw.newLine();
    	           bw.write(Integer.toString(man.card04));
    	           bw.newLine();
    	           bw.write(Integer.toString(man.card05));
    	           bw.newLine();
    	           bw.write(Integer.toString(man.card06));
    	           bw.newLine();
    	           bw.write(Integer.toString(man.card07));
    	           bw.newLine();
    	           bw.write(Integer.toString(man.card08));
    	           bw.newLine();
    	           bw.write(Integer.toString(man.card09));
    	           bw.newLine();
    	           bw.write(Integer.toString(man.card10));
    	           bw.newLine();
    	           bw.write(Integer.toString(man.card11));
    	           bw.newLine();
    	           bw.write(Integer.toString(man.card12));
    	           bw.newLine();
    	           bw.write(Integer.toString(man.card13));
    	           bw.newLine();
    	           bw.write(Integer.toString(man.card14));
    	           bw.newLine();
    	           bw.write(Integer.toString(man.card15));
    	           bw.newLine();
    	           bw.write(Integer.toString(man.card16));
    	           bw.newLine();
    	           bw.write(Integer.toString(man.card17));
    	           bw.newLine();
    	           bw.write(Integer.toString(man.card18));
    	           bw.newLine();
    	           
	           
	           bw.close();
	           }
		 catch(IOException e){
	          e.printStackTrace();
	       }
		
	}
public Info LoadFile(Info man){
	try{
    // �إ�FileReader����A�]�wŪ�����ɮ׬�SD�d����output.txt
	     FileReader fr = new FileReader( "/sdcard/Asgard.txt" );
         // �إ�fr��Input Buffer
	    BufferedReader br = new BufferedReader( fr );
	    String[] load=new String[20];
	    for(int j=0;j<20;j++)
			load[j]=br.readLine();
		fr.close();
	    man.ID=load[0];
	    man.money=Integer.parseInt(load[1]);
	    man.card01=Integer.parseInt(load[2]);
	    man.card02=Integer.parseInt(load[3]);
	    man.card03=Integer.parseInt(load[4]);
	    man.card04=Integer.parseInt(load[5]);
	    man.card05=Integer.parseInt(load[6]);
	    man.card06=Integer.parseInt(load[7]);
	    man.card07=Integer.parseInt(load[8]);
	    man.card08=Integer.parseInt(load[9]);
	    man.card09=Integer.parseInt(load[10]);
	    man.card10=Integer.parseInt(load[11]);
	    man.card11=Integer.parseInt(load[12]);
	    man.card12=Integer.parseInt(load[13]);
	    man.card13=Integer.parseInt(load[14]);
	    man.card14=Integer.parseInt(load[15]);
	    man.card15=Integer.parseInt(load[16]);
	    man.card16=Integer.parseInt(load[17]);
	    man.card17=Integer.parseInt(load[18]);
	    man.card18=Integer.parseInt(load[19]);
	    
  		
  } 
   catch (Exception e) {
        e.printStackTrace();
	}

	 return man;
}
public int ChangeCardIcon(int CardID){
	
	int src=20;
	 if(CardID==0)
     	src=R.drawable.menu_card1_c;
	 if(CardID==1)
	     	src=R.drawable.menu_card2_c;
	 if(CardID==2)
	     	src=R.drawable.menu_card3_c;
	 if(CardID==3)
	     	src=R.drawable.menu_card4_c;
	 if(CardID==4)
	     	src=R.drawable.menu_card5_c;
	 if(CardID==5)
	     	src=R.drawable.menu_card6_c;
	 if(CardID==6)
	     	src=R.drawable.menu_card7_c;
	 if(CardID==7)
	     	src=R.drawable.menu_card8_c;
	 if(CardID==8)
	     	src=R.drawable.menu_card9_c;
	 if(CardID==9)
	     	src=R.drawable.menu_card10_c;
	 if(CardID==10)
	     	src=R.drawable.menu_card11_c;
	 if(CardID==11)
	     	src=R.drawable.menu_card12_c;
	 if(CardID==12)
	     	src=R.drawable.menu_card13_c;
	 if(CardID==13)
	     	src=R.drawable.menu_card14_c;
	 if(CardID==14)
	     	src=R.drawable.menu_card15_c;
	 if(CardID==15)
	     	src=R.drawable.menu_card16_c;
	 if(CardID==16)
	     	src=R.drawable.menu_card17_c;
	 if(CardID==17)
	     	src=R.drawable.menu_card18_c;
     return src;
}
public ArrayList<Integer> getCardIcon(Info man){
	ArrayList<Integer> list = new ArrayList<Integer>();
	 if(man.card01!=0)
     	list.add(R.drawable.menu_card1);
     if(man.card02!=0)
     	list.add(R.drawable.menu_card2);
     if(man.card03!=0)
     	list.add(R.drawable.menu_card3);
     if(man.card04!=0)
     	list.add(R.drawable.menu_card4);
     if(man.card05!=0)
     	list.add(R.drawable.menu_card5);
     if(man.card06!=0)
     	list.add(R.drawable.menu_card6);
     if(man.card07!=0)
     	list.add(R.drawable.menu_card7);
     if(man.card08!=0)
     	list.add(R.drawable.menu_card8);
     if(man.card09!=0)
     	list.add(R.drawable.menu_card9);
     if(man.card10!=0)
     	list.add(R.drawable.menu_card10);
     if(man.card11!=0)
     	list.add(R.drawable.menu_card11);
     if(man.card12!=0)
     	list.add(R.drawable.menu_card12);
     if(man.card13!=0)
    	list.add(R.drawable.menu_card13);
     if(man.card14!=0)
     	list.add(R.drawable.menu_card14);
     if(man.card15!=0)
     	list.add(R.drawable.menu_card15);
     if(man.card16!=0)
     	list.add(R.drawable.menu_card16);
     if(man.card17!=0)
     	list.add(R.drawable.menu_card17);
     if(man.card18!=0)
     	list.add(R.drawable.menu_card18);
     return list;
}
public ArrayList<Integer> getSmallImage(Info man){
	ArrayList<Integer> list = new ArrayList<Integer>();
	 if(man.card01!=0)
     	list.add(R.drawable.card01_s);
     if(man.card02!=0)
     	list.add(R.drawable.card02_s);
     if(man.card03!=0)
     	list.add(R.drawable.card03_s);
     if(man.card04!=0)
     	list.add(R.drawable.card04_s);
     if(man.card05!=0)
     	list.add(R.drawable.card05_s);
     if(man.card06!=0)
     	list.add(R.drawable.card06_s);
     if(man.card07!=0)
     	list.add(R.drawable.card07_s);
     if(man.card08!=0)
     	list.add(R.drawable.card08_s);
     if(man.card09!=0)
     	list.add(R.drawable.card09_s);
     if(man.card10!=0)
     	list.add(R.drawable.card10_s);
     if(man.card11!=0)
     	list.add(R.drawable.card11_s);
     if(man.card12!=0)
     	list.add(R.drawable.card12_s);
     if(man.card13!=0)
    	list.add(R.drawable.card13_s);
     if(man.card14!=0)
     	list.add(R.drawable.card14_s);
     if(man.card15!=0)
     	list.add(R.drawable.card15_s);
     if(man.card16!=0)
     	list.add(R.drawable.card16_s);
     if(man.card17!=0)
     	list.add(R.drawable.card17_s);
     if(man.card18!=0)
     	list.add(R.drawable.card18_s);
     return list;
}
public int[] ArraylistToInt(int[] a,ArrayList<Integer> list){
    a = new int[list.size()];
    int count=0;
    for (Integer n : list)	
    {
    	a[count++] = n.intValue();
    };
    return a;
}
public String[] ArraylistToString(ArrayList<String> list){
    String[] a = new String[list.size()];
   
    for (int i=0;i<list.size();i++)	
    {
    	a[i] = list.get(i);
    };
    return a;
}
//get card name
public String[] getCardName(Info man){
	ArrayList<String> list = new ArrayList<String>();
	 if(man.card01!=0)
     	list.add("�J�˦躸");
     if(man.card02!=0)
     	list.add("�����F");
     if(man.card03!=0)
     	list.add("�t���F");
     if(man.card04!=0)
     	list.add("����");
     if(man.card05!=0)
     	list.add("�j���k�J��");
     if(man.card06!=0)
     	list.add("�C�ڥ[�o");
     if(man.card07!=0)
     	list.add("�k�ȩ�");
     if(man.card08!=0)
     	list.add("��������");
     if(man.card09!=0)
     	list.add("���o�N��");
     if(man.card10!=0)
     	list.add("������");
     if(man.card11!=0)
     	list.add("�v���S��");
     if(man.card12!=0)
     	list.add("���Ը�����");
     if(man.card13!=0)
    	list.add("�K�̺�");
     if(man.card14!=0)
     	list.add("����w");
     if(man.card15!=0)
     	list.add("����");
     if(man.card16!=0)
     	list.add("�˺����R");
     if(man.card17!=0)
     	list.add("����");
     if(man.card18!=0)
     	list.add("����");
     String[] name=ArraylistToString(list);
     return name;
}
public int getPrice(String name){
	int price=0;
	 if(name.equals("�J�˦躸")==true)
		 
     	price=100;
	 if(name.equals("�����F")==true)
		 price=100;
	 if(name.equals("�t���F")==true)
		 price=100;
	 if(name.equals("����")==true)
		 price=120;
	 if(name.equals("�j���k�J��")==true)
		 price=130;
	 if(name.equals("�C�ڥ[�o")==true)
		 price=140;
	 if(name.equals("�k�ȩ�")==true)
		 price=150;
	 if(name.equals("��������")==true)
		 price=150;
	 if(name.equals("���o�N��")==true)
		 price=150;
	 if(name.equals("������")==true)
		 price=1500;
	 if(name.equals("�v���S��")==true)
		 price=1700;
	 if(name.equals("���Ը�����")==true)
		 price=1800;
	 if(name.equals("�K�̺�")==true)
		 price=2000;
	 if(name.equals("����w")==true)
		 price=2100;
	 if(name.equals("����")==true)
		 price=2500;
	 if(name.equals("�˺����R")==true)
		 price=8000;
	 if(name.equals("����")==true)
		 price=9000;
	 if(name.equals("����")==true)
		 price=10000;
	 return price;
}
public int getCardIDuseName(String name){
	int ID=0;
	 if(name.equals("�J�˦躸")==true)
		 
     	ID=1;
	 if(name.equals("�����F")==true)
		 ID=2;
	 if(name.equals("�t���F")==true)
		 ID=3;
	 if(name.equals("����")==true)
		 ID=4;
	 if(name.equals("�j���k�J��")==true)
		 ID=5;
	 if(name.equals("�C�ڥ[�o")==true)
		 ID=6;
	 if(name.equals("�k�ȩ�")==true)
		 ID=7;
	 if(name.equals("��������")==true)
		 ID=8;
	 if(name.equals("���o�N��")==true)
		 ID=9;
	 if(name.equals("������")==true)
		 ID=10;
	 if(name.equals("�v���S��")==true)
		 ID=11;
	 if(name.equals("���Ը�����")==true)
		 ID=12;
	 if(name.equals("�K�̺�")==true)
		 ID=13;
	 if(name.equals("����w")==true)
		 ID=14;
	 if(name.equals("����")==true)
		 ID=15;
	 if(name.equals("�˺����R")==true)
		 ID=16;
	 if(name.equals("����")==true)
		 ID=17;
	 if(name.equals("����")==true)
		 ID=18;
	 return ID;
}


public ArrayList<Integer> getCardID(Info man){
	ArrayList<Integer> list2 = new ArrayList<Integer>();
	 if(man.card01!=0)
     	list2.add(1);
     if(man.card02!=0)     	
     	list2.add(2);     
     if(man.card03!=0)     
     	list2.add(3);    
     if(man.card04!=0)     
     	list2.add(4); 
     if(man.card05!=0)    
     	list2.add(5);     
     if(man.card06!=0)     
     	list2.add(6);     
     if(man.card07!=0)
     	list2.add(7);   
     if(man.card08!=0)
     	list2.add(8);
     if(man.card09!=0)
     	list2.add(9);
     if(man.card10!=0)
     	list2.add(10);
     if(man.card11!=0)
     	list2.add(11);
     if(man.card12!=0)
     	list2.add(12);   
     if(man.card13!=0)
     	list2.add(13);
     if(man.card14!=0)
     	list2.add(14); 
     if(man.card15!=0)
     	list2.add(15); 
     if(man.card16!=0)    
     	list2.add(16);
     if(man.card17!=0)
     	list2.add(17);
     if(man.card18!=0)
     	list2.add(18);    
     return list2;
}

public int Cardcount(Info man){
    man.LoadFile(man);
    int number=0;
      if(man.card01!=0){
      	number++;
      };
      if(man.card02!=0){
      	number++;
      };
      if(man.card03!=0){
      	number++;
      };
      if(man.card04!=0){
      	number++;
      };
      if(man.card05!=0){
      	number++;
      };
      if(man.card06!=0){
      	number++;
      };
      if(man.card07!=0){
      	number++;
      };
      if(man.card08!=0){
      	number++;
      };
      if(man.card09!=0){
      	number++;
      };
      if(man.card10!=0){
      	number++;
      };
      if(man.card11!=0){
      	number++;
      };
      if(man.card12!=0){
      	number++;
      };
      if(man.card13!=0){
      	number++;
      };
      if(man.card14!=0){
      	number++;
      };
      if(man.card15!=0){
      	number++;
      };
      if(man.card16!=0){
      	number++;
      };
      if(man.card17!=0){
      	number++;
      };
      if(man.card18!=0){
      	number++;
      };
      
	
	return number;
}
}
