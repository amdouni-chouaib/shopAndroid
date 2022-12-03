package com.example.projetversion1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class clothesmandisplay extends AppCompatActivity {

    private RecyclerView receiver;
    private Button but5;
    clothesman adapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothesmandisplay);
        Product p = new Product();
        receiver = findViewById(R.id.ali);
        receiver.setLayoutManager(new GridLayoutManager(this,2));
        FirebaseRecyclerOptions<Product> options = new FirebaseRecyclerOptions.Builder<Product>().setQuery(FirebaseDatabase.getInstance().getReference("").child("random/male/clothes"),Product.class).build();

        adapters = new clothesman(options);

        receiver.setAdapter(adapters);
    }

    @Override
    protected void onStart() {

        super.onStart();
        adapters.startListening();
    }
}