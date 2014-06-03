package com.example.asgard;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class showCard extends Activity{
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
	       img.setImageResource(R.drawable.repeat_bk);

	  }
	  card01 card = new card01();
	  //String title = card.Character()[1];
	  String title="智者"; 
	  String intro="由眾神創造，擁有天下最高的智慧。"; String skillName="心靈爆破"; String skill_intro="直接攻擊對手心靈，造成傷害100";
	  String hp="40"; String atk="6"; String def="8"; String agi="4"; String price="100"; String src="@drawable/card01.jpg";
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
			};
	  }
	  public  String[] Character(){
			String[] arr={"克瓦西爾","智者","由眾神的創造，擁有天下最高的智慧。","心靈爆破","直接攻擊對手心靈，造成傷害100"};
			return arr; 
		};
}