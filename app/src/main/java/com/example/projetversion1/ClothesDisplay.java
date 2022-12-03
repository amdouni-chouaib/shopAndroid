package com.example.projetversion1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ClothesDisplay extends AppCompatActivity {
    private RecyclerView receiver;
    private Button but5;
    Cadapter adapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_display);
        Product p = new Product();
        receiver = findViewById(R.id.shoes);
        receiver.setLayoutManager(new GridLayoutManager(this,2));
        FirebaseRecyclerOptions<Product> options = new FirebaseRecyclerOptions.Builder<Product>().setQuery(FirebaseDatabase.getInstance().getReference("").child("random/female/clothes"),Product.class).build();

        adapters = new Cadapter(options);

        receiver.setAdapter(adapters);
    }

    @Override
    protected void onStart() {

        super.onStart();
        adapters.startListening();
    }
}