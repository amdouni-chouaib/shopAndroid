package com.example.projetversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class Welcome extends AppCompatActivity {

 Button b1 ;
 Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(Welcome.this,Login.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(Welcome.this,Signup.class);
                startActivity(i);
            }
        });

    }


}