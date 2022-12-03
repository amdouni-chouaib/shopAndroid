package com.example.projetversion1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;

public class basketadapter extends ArrayAdapter<String> {
    Intent i ;
    String titre;
    public basketadapter (@NonNull Context context , ArrayList<String> arrayList){
        super(context, 0, arrayList);

    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_listbasket, parent, false);
        }

//        // get the position of the view from the ArrayAdapter
//        String currentNumberPosition = getItem(position);

        // then according to the position of the view assign the desired TextView 1 for the same
        //TextView txt = currentItemView.findViewById(R.id.tvlist);
        Button btn = currentItemView.findViewById(R.id.btnlist);






        // then return the recyclable view
        return currentItemView;
    }



}
