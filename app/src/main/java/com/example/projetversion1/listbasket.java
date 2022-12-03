package com.example.projetversion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class listbasket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listbasket);
        Intent i = getIntent();
        String intent = i.getStringExtra("titre");
        Button btn = findViewById(R.id.btnlist);
        btn.setText(intent);
    }
}