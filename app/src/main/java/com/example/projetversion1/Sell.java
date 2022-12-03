package com.example.projetversion1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Sell extends AppCompatActivity {
        private EditText title,description ,category,state,price;
        private Button sell;
        private ImageView img;
        private  Product p ;

        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mDbRef = mDatabase.getReference("User");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        title = findViewById(R.id.editTextTtitre);
        description = findViewById(R.id.desc);
        category = findViewById(R.id.cate);
        state = findViewById(R.id.stat);
        price = findViewById(R.id.prix);
        img = findViewById(R.id.image);
        sell=findViewById(R.id.sell);
         Intent intent = getIntent();
       title.setText(intent.getStringExtra("Tiitre"));
        description.setText(intent.getStringExtra("describe"));
        category.setText(intent.getStringExtra("Categori"));
        state.setText(intent.getStringExtra("states"));
        price.setText(intent.getStringExtra("prixe"));
        Glide.with(img.getContext()).load(intent.getStringExtra("pic")).into(img);
         sell.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent inte =new Intent(Sell.this,listbasket.class);
                 inte.putExtra("image",intent.getStringExtra("pic"));
                 inte.putExtra("titre",intent.getStringExtra("Tiitre"));
                 startActivity(inte);
             }
         });





    }


}