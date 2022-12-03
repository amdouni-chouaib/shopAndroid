package com.example.projetversion1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class bagdisplay extends AppCompatActivity {
    private RecyclerView receiver;
    bag adapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bagdisplay);
        receiver = findViewById(R.id.ziw);
        receiver.setLayoutManager(new GridLayoutManager(this,2));
        FirebaseRecyclerOptions<Product> options = new FirebaseRecyclerOptions.Builder<Product>().setQuery(FirebaseDatabase.getInstance().getReference("").child("random/female/bag"),Product.class).build();
        adapters = new bag(options);

        receiver.setAdapter(adapters);


    }

    @Override
    protected void onStart() {

        super.onStart();
        adapters.startListening();
    }
}