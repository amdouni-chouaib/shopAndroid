package com.example.projetversion1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Basket extends AppCompatActivity {
      private ListView liste;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        Intent i = getIntent();
        String titre= i.getStringExtra("titre");
        ListView ls;
        final ArrayList<String> arrayList = new ArrayList<String>();
        System.out.println(titre);


        ls = findViewById(R.id.lst);
        arrayList.add(titre);
        basketadapter adapter = new basketadapter(getApplicationContext(),arrayList);
        System.out.println(adapter.getContext());
        ls.setAdapter(adapter);



    }
}