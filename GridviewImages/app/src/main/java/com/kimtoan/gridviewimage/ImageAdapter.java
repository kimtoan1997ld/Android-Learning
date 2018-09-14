package com.kimtoan.gridviewimage;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

public class ImageAdapter extends BaseAdapter {

    private Context context;
    private  int layout;
    private List<Images> listImage;

    public ImageAdapter(Context context, int layout, List<Images> listImage) {
        this.context = context;
        this.layout = layout;
        this.listImage = listImage;
    }

    @Override
    public int getCount() {
        return listImage.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class Viewholder{
        ImageView imgFlags;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Viewholder holder;

        if(convertView == null){
            holder = new Viewholder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService((Context.LAYOUT_INFLATER_SERVICE));
            convertView = inflater.inflate(layout, null);
            holder.imgFlags = (ImageView) convertView.findViewById(R.id.imageviewFlags);
            convertView.setTag(holder);
        }else
        {
            holder = (Viewholder) convertView.getTag();
        }

        Images img = listImage.get(position);

        holder.imgFlags.setImageResource(img.getImage());
        return convertView;
    }
}
