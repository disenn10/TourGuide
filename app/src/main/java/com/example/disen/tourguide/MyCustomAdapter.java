package com.example.disen.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by disen on 6/19/2017.
 */

public class MyCustomAdapter extends ArrayAdapter {
    public MyCustomAdapter(Context context, ArrayList resource) {
        super(context,0, resource);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;
        if(listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_items,parent,false);
        }
        MyArrayList current = (MyArrayList) getItem(position);
        ImageView imageView = (ImageView) listView.findViewById(R.id.image);
        TextView name = (TextView)listView.findViewById(R.id.name);
        TextView description = (TextView)listView.findViewById(R.id.desc);
        TextView location = (TextView)listView.findViewById(R.id.location);
        imageView.setImageResource(current.getImage());
        name.setText(current.getName());
        description.setText(current.getDescription());
        location.setText(current.getLocation());
        ImageView play = (ImageView)listView.findViewById(R.id.playButton);
        play.setImageResource(current.getPlay_icon());


        return listView;
    }
}
