package com.example.asgard;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


public class card01 extends Activity{
	  @Override
	   protected void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.card01);
	       TextView textView = (TextView)findViewById(R.id.title);
	       textView.setText(title);
	       textView = (TextView)findViewById(R.id.intro);
	       textView.setText(intro);
	       textView = (TextView)findViewById(R.id.atk);
	       textView.setText(atk);
	       textView = (TextView)findViewById(R.id.def);
	       textView.setText(def);
	       textView = (TextView)findViewById(R.id.agi);
	       textView.setText(agi);
	       textView = (TextView)findViewById(R.id.hp);
	       textView.setText(hp);
	       textView = (TextView)findViewById(R.id.skill);
	       textView.setText(skillName);
	       textView = (TextView)findViewById(R.id.skill_intro);
	       textView.setText(skill_intro);    
	       ImageView img= (ImageView) findViewById(R.id.imageView1);
	       img.setImageResource(R.drawable.card01);

	  }
	  info info =new info();
	  String title=info.Character()[1];
	  String intro=info.Character()[2];
	  String atk=Integer.toString(info.atk);
	  String hp=Integer.toString(info.hp);
	  String def=Integer.toString(info.def);
	  String agi=Integer.toString(info.agi); 
	  String skillName=info.Character()[3]; 
	  String skill_intro=info.Character()[4];
	  String price=Integer.toString(info.price);
	  public class info extends AllCard{
			public String name=Character()[0];
			public int level=level();
			public String title=Character()[1];
			public String intro=Character()[2];
			public String skillName=Character()[3];
			public String skill_intro=Character()[4];
			public int price=price();
			public int hp=HP();
			public int atk=ATK();
			public int def=DEF();
			public int agi=Agi();
			public skill Skill = oneskill();
			public String[] src=src();

			public  String[] Character(){
				String[] arr={"克瓦西爾","智者","由眾神的創造，擁有天下最高的智慧。","心靈爆破","直接攻擊對手心靈，造成傷害100"};
				return arr; 
			};
			public  int level(){
				int level=1;
				return level;
			};
			public  int HP(){
				int HP=40;
				return HP;
			};

			public int ATK(){
				int ATK=6;
				return ATK;
			};
			public int DEF(){
				int DEF=8;
				return DEF;
			};
			public int Agi(){
				int Agi=4;
				return Agi;
			};
			public int price(){
				int price=100;
				return price;
			};
			
			public String[] src(){
				String[] src={"@drawable/card01.jpg"};
				return src;
			}
			
			public skill oneskill() {
				
				skill s = new skill(0,100);
				return s;
				
			};
			
	  }
}
