package com.example.projetversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class addproductadmin extends AppCompatActivity {
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproductadmin);
        auth = FirebaseAuth.getInstance();
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
                Toast.makeText(addproductadmin.this, auth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}