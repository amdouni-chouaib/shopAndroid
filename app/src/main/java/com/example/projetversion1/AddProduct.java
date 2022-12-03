package com.example.projetversion1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddProduct extends AppCompatActivity {
    private EditText gender,title,category,description,piclink,price ,state;
    private Button btn;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    Map<String,String> arrayList = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        gender = findViewById(R.id.genderP);
        title = findViewById(R.id.TitleP);
        category = findViewById(R.id.CatP);
        description = findViewById(R.id.DescP);
        piclink = findViewById(R.id.PicP);
        price = findViewById(R.id.PriceP);
        state = findViewById(R.id.StateP);
        btn = findViewById(R.id.AddP);
        Button Home = findViewById(R.id.button8);

        Button menu = findViewById(R.id.button9);
        Button favorite = findViewById(R.id.button10);
        Button basket = findViewById(R.id.button11);
        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Accueil.class);
                startActivity(i);
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),clothesFemme.class);
                startActivity(i);
            }
        });
        basket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Basket.class);
                startActivity(i);
            }
        });
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Wishlist.class);
                startActivity(i);
            }
        });



        //getting real time database & authentication instances
        firebaseDatabase = FirebaseDatabase.getInstance();
        mAuth=FirebaseAuth.getInstance();
        //referencing the path where we will push data into


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                databaseReference = firebaseDatabase.getReference().child("random/"+gender.getText().toString()+"/"+category.getText().toString()).push();
                System.out.println(gender.getText().toString());
               arrayList.put("gender",gender.getText().toString());
                arrayList.put("Title",title.getText().toString());
                arrayList.put("category",category.getText().toString());
                arrayList.put("description",description.getText().toString());
                arrayList.put("picLink",piclink.getText().toString());
                arrayList.put("price",price.getText().toString());
                arrayList.put("state",state.getText().toString());




                System.out.println(arrayList);

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.setValue(arrayList);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

        });

    }


}