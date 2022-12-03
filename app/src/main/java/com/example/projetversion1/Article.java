package com.example.projetversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Article extends AppCompatActivity {
    Button buy ;
    Button add ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);


        buy =(Button)findViewById(R.id.button3);

        buy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(Article.this,Sell.class);
                startActivity(i);
            }
        });


        add =(Button)findViewById(R.id.button4);

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(Article.this,Basket.class);
                startActivity(i);
            }
        });
    }
}