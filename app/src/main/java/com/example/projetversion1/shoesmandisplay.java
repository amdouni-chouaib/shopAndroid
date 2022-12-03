package com.example.projetversion1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class shoesmandisplay extends AppCompatActivity {
    private RecyclerView receiver;
    shoesman adapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoesmandisplay);
        receiver = findViewById(R.id.shoesman);
        receiver.setLayoutManager(new GridLayoutManager(this,2));
        FirebaseRecyclerOptions<Product> options = new FirebaseRecyclerOptions.Builder<Product>().setQuery(FirebaseDatabase.getInstance().getReference("").child("random/male/shoes"),Product.class).build();
        adapters = new shoesman(options);

        receiver.setAdapter(adapters);


    }

    @Override
    protected void onStart() {

        super.onStart();
        adapters.startListening();
    }
}