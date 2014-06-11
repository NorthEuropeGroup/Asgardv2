package com.example.asgard;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class CardChoose2 extends Activity {
ListView ll;
ArrayList<HashMap<String,Object>>CList;
SimpleAdapter adapter;
ArrayList<Integer> mmap ;
public Info man = new Info("CC");
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_card_choose2);
		ll = (ListView)findViewById(R.id.listView1);
		CList= new  ArrayList<HashMap<String,Object>>();
		String [] CN = {"克瓦西爾","光精靈","暗精靈","哈提","古爾法克西","耶夢加得","法亞拉",
				"恩赫里亞","尼得霍格","尤彌爾","史爾特爾","赫朗葛尼爾","密米爾","格莉德","艾格瑟",
				"瓦爾基麗","提爾","奧汀"};
		int [] CE ={
				R.drawable.menu_card1,
				R.drawable.menu_card2,
				R.drawable.menu_card3,
				R.drawable.menu_card4,
				R.drawable.menu_card5,
				R.drawable.menu_card6,
				R.drawable.menu_card7,
				R.drawable.menu_card8,
				R.drawable.menu_card9,
				R.drawable.menu_card10,
				R.drawable.menu_card11,
				R.drawable.menu_card12,
				R.drawable.menu_card13,
				R.drawable.menu_card14,
				R.drawable.menu_card15,
				R.drawable.menu_card16,
				R.drawable.menu_card17,
				R.drawable.menu_card18};
				
		man = man.LoadFile(man);
		mmap = new ArrayList<Integer>();
		calculate();
		for(int i=0; i<mmap.size(); i++){
			 HashMap<String,Object> item = new HashMap<String,Object>();
			 item.put("name", CN[mmap.get(i)]);
			 item.put("img", CE[mmap.get(i)]);
			 
			 CList.add( item );
			 }
		adapter = new SimpleAdapter( 
				 CardChoose2.this, 
				 CList,
				 R.layout.list_item2,
				 new String[]{"name","img"},
				 new int []{R.id.textView1,R.id.imageView1});
		ll.setAdapter(adapter);
		ll.setOnItemClickListener(
				new OnItemClickListener()
				{

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						// TODO Auto-generated method stub
						Intent i=new Intent();
						Bundle b=new Bundle();
						b.putInt("I", mmap.get(position));
						i.putExtras(b);
						setResult(RESULT_OK,i);
						finish();
					}
					
				});
		
	}
	public void calculate()
	{
		
	    for(int i = 0;i<man.card01;i++)
	     	mmap.add(0);
	    for(int i = 0;i<man.card02;i++)
	     	mmap.add(1);
	    for(int i = 0;i<man.card03;i++)
	     	mmap.add(2);
	    for(int i = 0;i<man.card04;i++)
	     	mmap.add(3);
	    for(int i = 0;i<man.card05;i++)
	     	mmap.add(4);
	    for(int i = 0;i<man.card06;i++)
	     	mmap.add(5);
	    for(int i = 0;i<man.card07;i++)
	     	mmap.add(6);
	    for(int i = 0;i<man.card08;i++)
	     	mmap.add(7);
	    for(int i = 0;i<man.card09;i++)
	     	mmap.add(8);
	    for(int i = 0;i<man.card10;i++)
	     	mmap.add(9);
	    for(int i = 0;i<man.card11;i++)
	     	mmap.add(10);
	    for(int i = 0;i<man.card12;i++)
	     	mmap.add(11);
	    for(int i = 0;i<man.card13;i++)
	     	mmap.add(12);
	    for(int i = 0;i<man.card14;i++)
	     	mmap.add(13);
	    for(int i = 0;i<man.card15;i++)
	     	mmap.add(14);
	    for(int i = 0;i<man.card16;i++)
	     	mmap.add(15);
	    for(int i = 0;i<man.card17;i++)
	     	mmap.add(16);
	    for(int i = 0;i<man.card18;i++)
	     	mmap.add(17);
	    
	    
	     //return list;
	}
}
