package com.example.projetversion1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Signup extends AppCompatActivity {
    // creating variables for
    // EditText and buttons.
    Button signup,login;
    private EditText firstname,lastname, email , phone,password,password1;
    //declaring real time database & authentication & Reference
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth mAuth;
    DatabaseReference databaseReference;

    //daclaring user object
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //getting all input informations
        firstname=findViewById(R.id.editFirstName);
        lastname=findViewById(R.id.editSecondName);
        email=findViewById(R.id.editEmail);
        phone = findViewById(R.id.editPhone);
        password = findViewById(R.id.editPassword);
        password1 = findViewById(R.id.editConfirmPassword);
        String Email = email.getText().toString();
        //getting real time database & authentication instances
        firebaseDatabase = FirebaseDatabase.getInstance();
        mAuth=FirebaseAuth.getInstance();
        //referencing the path where we will push data into

        databaseReference = firebaseDatabase.getReference().child("User").push();

        user = new User();






        signup =(Button)findViewById(R.id.button);
        login =(Button)findViewById(R.id.button2);
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                //converting the inputs into strings
                String Firstname = firstname.getText().toString();
                String Lastname = lastname.getText().toString();
                String Email = email.getText().toString();
                String Phone = phone.getText().toString();
                String Password = password.getText().toString();
                String Password1 = password1.getText().toString();
                //testing if the inputs are not empty all of them
                if (TextUtils.isEmpty(Firstname) || TextUtils.isEmpty(Lastname) || TextUtils.isEmpty(Email) || TextUtils.isEmpty(Phone) || TextUtils.isEmpty(Password) || TextUtils.isEmpty(Password1)) {

                    Toast.makeText(getApplicationContext(),"you are obligated to type all the form",Toast.LENGTH_LONG).show();
                }else{



                    //call for the method that insert data into realtime database & authentication
                    SendData(Firstname,Lastname,Email,Phone,Password,Password1);
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(Signup.this,Login.class);
                startActivity(i);
            }
        });
    }
    private void SendData(String Fname, String Lname, String Mail,String Phon,String Pwd1,String Pwd2){
        //inserting data into our object user

        user.setFirstname(Fname);
        user.setLastname(Lname);
        user.setEmail(Mail);
        user.setPhone(Phon);
        user.setPassword(Pwd1);
        user.setRePassword(Pwd2);
        //listener for data changes in the data at this referenced location
        databaseReference.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                //inerting data into realtime database
                databaseReference.setValue(user);
                //creating user information into authentication firebase
                mAuth .createUserWithEmailAndPassword(Mail, Pwd1)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task)
                            {
                                if (task.isSuccessful()) {
                                    //testing if the data inserted or not in authentication
                                    Toast.makeText(getApplicationContext(),"Registration successful!",Toast.LENGTH_LONG).show();
                                    Intent intent= new Intent(Signup.this, Login.class);
                                    startActivity(intent);
                                }
                                else {
                                    Toast.makeText(getApplicationContext(),"Registration failed!!"+ " Please try again later",Toast.LENGTH_LONG) .show();

                                }
                            }
                        });

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Signup.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });

    }
}