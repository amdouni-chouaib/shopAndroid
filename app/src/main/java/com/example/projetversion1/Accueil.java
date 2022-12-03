package com.example.projetversion1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Accueil extends AppCompatActivity {
    private RecyclerView receiver;
    private Button but5;
    myAdapter adapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        but5 = findViewById(R.id.button5);
        Button menu = findViewById(R.id.mn);
menu.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i = new Intent(getApplicationContext(),Cadapter.class);
        startActivity(i);
    }
});
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Accueil.this,MyProfile.class);
                startActivity(i);
            }
        });
        receiver = findViewById(R.id.recycler);
        receiver.setLayoutManager(new GridLayoutManager(this,2));
        FirebaseRecyclerOptions<Product> options = new FirebaseRecyclerOptions.Builder<Product>().setQuery(FirebaseDatabase.getInstance().getReference("").child("Product"),Product.class).build();

        adapters = new myAdapter(options);
        receiver.setAdapter(adapters);
    }



    @Override
    protected void onStart() {

        super.onStart();
        adapters.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapters.stopListening();
    }
}