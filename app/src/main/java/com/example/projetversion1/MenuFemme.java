package com.example.projetversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuFemme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_femme);
        Button wommen = findViewById(R.id.wom1);
        Button men = findViewById(R.id.men1);
        Button add = findViewById(R.id.addingF);
        Button clothes = findViewById(R.id.cf1);
        Button shoes = findViewById(R.id.sf1);
        Button bug = findViewById(R.id.bf1);
        Button access = findViewById(R.id.af1);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AddProduct.class);
                startActivity(i);
            }
        });

        wommen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MenuFemme.class);
                startActivity(i);
            }
        });

        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MenuHomme.class);
                startActivity(i);
            }
        });
        


    }
}