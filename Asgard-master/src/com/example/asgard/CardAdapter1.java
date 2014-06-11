package com.example.asgard;




import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
 
public class CardAdapter1 extends BaseAdapter{
    public static class Item{
        public String text;
        public String price;
        public int resId;
    }
 
    private List<Item> mItems = new ArrayList<CardAdapter1.Item>();
    private Context mContext;
    public CardAdapter1(Context context,Info man) {
    	int count=man.Cardcount(man);
    	
        //測試數據
        for (int i = 0; i < count; i++) {
            Item object = new Item();
            object.text = man.getCardName(man)[i];
            object.price = "$"+Integer.toString(man.getPrice(object.text));
            object.resId = man.getCardIcon(man).get(i);
            mItems.add(object);
        }
        mContext = context;
    }
 
    @Override
    public int getCount() {
        return mItems.size();
    }
 
    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item, null);
        }
        ImageView image = (ImageView) convertView.findViewById(R.id.icon);
        TextView text = (TextView) convertView.findViewById(R.id.text);
        TextView price = (TextView) convertView.findViewById(R.id.price);
        Item item = (Item) getItem(position);
        image.setImageResource(item.resId);
        text.setText(item.text);
        price.setText(item.price);
        return convertView;
    }

}
