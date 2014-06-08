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
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_card_choose2);
		ll = (ListView)findViewById(R.id.listView1);
		CList= new  ArrayList<HashMap<String,Object>>();
		String [] CN = {"�J�˦躸","�����F","�t���F","����","�j���k�J��","�C�ڥ[�o","�k�ȩ�",
				"��������","���o�N��","������","�v���S��","���Ը�����","�K�̺�","����w","����",
				"�˺����R","����","����"};
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
				
		
		for(int i=0; i<18; i++){
			 HashMap<String,Object> item = new HashMap<String,Object>();
			 item.put("name", CN[i]);
			 item.put("img", CE[i]);
			 
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
						b.putInt("I", position);
						i.putExtras(b);
						setResult(RESULT_OK,i);
						finish();
					}
					
				});
		
	}
}
