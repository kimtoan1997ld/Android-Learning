package com.kimtoan.advancelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends BaseAdapter {
    private Context context;

    public FruitAdapter(Context context, int layout, List<Fruits> fruitList) {
        this.context = context;
        this.layout = layout;
        this.fruitList = fruitList;
    }

    private int layout;
    private List<Fruits> fruitList;

    @Override
    public int getCount() {
        return fruitList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder
    {
        ImageView imgFruit;
        TextView txtName, txtDescription;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder = new ViewHolder();
            // reflection view
             holder.txtName = (TextView) convertView.findViewById(R.id.textviewName);
             holder.txtDescription = (TextView) convertView.findViewById(R.id.textviewDescription);
             holder.imgFruit = (ImageView) convertView.findViewById(R.id.imageviewFruitImage);

             convertView.setTag(holder);

        }else {
            holder = (ViewHolder)convertView.getTag();
        }

        // assign value
        Fruits fruit = fruitList.get(position);

        holder.txtName.setText(fruit.getName());
        holder.txtDescription.setText(fruit.getDescription());
        holder.imgFruit.setImageResource(fruit.getImage());
        return convertView;
    }
}
