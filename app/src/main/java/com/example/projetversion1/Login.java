package com.example.projetversion1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    // creating variables for
    // EditText and buttons.
    private TextView signup;
    private EditText email,password;
    private Button signin;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signin =(Button)findViewById(R.id.login);
        //declaring real time database & authentication & Reference
        email= findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPersonName4);
        signin = findViewById(R.id.login);
        signup = findViewById(R.id.textView);
        //declaring real time database & authentication & Reference
        mAuth = FirebaseAuth.getInstance();
        //declaring event listener on the button so we can manage our activity

        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                login();
            }
        });


































        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(Login.this,Signup.class);
                startActivity(i);
            }
        });
    }

    public void login() {
        //converting the inputs into strings

        String Email = email.getText().toString();
        String Password = password.getText().toString();
        //testing if the variable are empty or not
        if (TextUtils.isEmpty(Email)) {
            Toast.makeText(getApplicationContext(),"Please enter email!!",Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(Password)) {Toast.makeText(getApplicationContext(),"Please enter password!!",Toast.LENGTH_LONG).show();
            return;
        }
        //------------------------admin --------------------------------
        if(Email.equals("admin@gmail.com") && Password.equals("136891aze")){
            mAuth.signInWithEmailAndPassword(Email, Password)
                    .addOnCompleteListener(
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(
                                        @NonNull Task<AuthResult> task)
                                {
                                    //test if he sussessfully loged in or not
                                    if (task.isSuccessful()) {

                                        Toast.makeText(getApplicationContext(),"Login successful as admin !!",Toast.LENGTH_LONG).show();
                                        Intent intent= new Intent(Login.this,addproductadmin.class);
                                        startActivity(intent);
                                    }

                                    else {
                                        Toast.makeText(getApplicationContext(),"Login failed!!",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
        }else{
            mAuth.signInWithEmailAndPassword(Email, Password)
                    .addOnCompleteListener(
                            new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(
                                        @NonNull Task<AuthResult> task)
                                {
                                    //test if he sussessfully loged in or not
                                    if (task.isSuccessful()) {

                                        Toast.makeText(getApplicationContext(),"Login successful!!",Toast.LENGTH_LONG).show();
                                        Intent intent= new Intent(Login.this,Accueil.class);
                                        startActivity(intent);
                                    }

                                    else {
                                        Toast.makeText(getApplicationContext(),"Login failed!!",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
        }






        //log in user information

    }
}