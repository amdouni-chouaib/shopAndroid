package com.example.projetversion1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class accessoriesmandisplay extends AppCompatActivity {

    private RecyclerView receiver;
    accessoriesman adapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessoriesmandisplay);
        receiver = findViewById(R.id.wided);
        receiver.setLayoutManager(new GridLayoutManager(this,2));
        FirebaseRecyclerOptions<Product> options = new FirebaseRecyclerOptions.Builder<Product>().setQuery(FirebaseDatabase.getInstance().getReference("").child("random/male/accessories"),Product.class).build();
        adapters = new accessoriesman(options);

        receiver.setAdapter(adapters);


    }

    @Override
    protected void onStart() {

        super.onStart();
        adapters.startListening();
    }
}