package com.example.projetversion1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Admindashboard extends AppCompatActivity {
    private RecyclerView receiver;
    private FirebaseAuth auth;

    adminadapter adapters;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admindashboard);
        receiver = findViewById(R.id.recv);
        receiver.setLayoutManager(new GridLayoutManager(this,2));
        FirebaseRecyclerOptions<Product> options = new FirebaseRecyclerOptions.Builder<Product>().setQuery(FirebaseDatabase.getInstance().getReference("").child("Product"),Product.class).build();

        adapters = new adminadapter(options);
        receiver.setAdapter(adapters);
        ImageView logout = findViewById(R.id.logoutadmin);
        ImageView home = findViewById(R.id.imageView3);
        ImageView add = findViewById(R.id.imageView4);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Admindashboard.class);
                startActivity(i);
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),addproductadmin.class);
                startActivity(i);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Intent i = new Intent(getApplicationContext(),Login.class);
                startActivity(i);
            }
        });







    }

    @Override
    protected void onStart() {
        super.onStart();
        adapters.startListening();
    }
}