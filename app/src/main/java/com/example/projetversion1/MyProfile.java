package com.example.projetversion1;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyProfile extends AppCompatActivity {
    private EditText firstname,secandname,phone,em1,pwd3;
    private Button update;
    private User user;

    FirebaseUser auth = FirebaseAuth.getInstance().getCurrentUser();
    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mDbRef = mDatabase.getReference("User");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        firstname = findViewById(R.id.f1);
        secandname = findViewById(R.id.s1);
        phone = findViewById(R.id.ph1);
        em1 = findViewById(R.id.em1);
        pwd3 = findViewById(R.id.pwd3);
        update = findViewById(R.id.Update);



        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userdataupdate(firstname.getText().toString(),secandname.getText().toString(),em1.getText().toString(),phone.getText().toString(),pwd3.getText().toString());
                authdataupdate();

            }
        });




    }

    private void authdataupdate() {

        AuthCredential credential = EmailAuthProvider
                .getCredential(em1.getText().toString(), pwd3.getText().toString());
        auth.reauthenticate(credential)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Log.d(TAG, "User re-authenticated.");
                        auth.updateEmail(em1.getText().toString())
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Log.d(TAG, "User email address updated.");
                                        }
                                    }
                                });
                        //----------------------------------------------------------\\
                        auth.updatePassword(pwd3.getText().toString())
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Log.d(TAG, "User password address updated.");
                                        }
                                    }
                                });

                    }
                });
    }

    private void userdataupdate(String firstn,String lastn,String eMail,String Phone, String Pwd) {

        HashMap users = new HashMap();
        users.put("firstname",firstn);
        users.put("lastname",lastn);
        users.put("email",eMail);
        users.put("phone",Phone);
        users.put("password",Pwd);
        users.put("rePassword",Pwd);


        mDbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot sp : snapshot.getChildren()){
                    if(sp.child("email").getValue().equals(auth.getEmail())){
                        mDbRef.child(sp.getKey()).updateChildren(users).addOnCompleteListener(new OnCompleteListener() {
                            @Override
                            public void onComplete(@NonNull Task task) {
                                    if (task.isSuccessful()){
                                        firstname.setText("");
                                        secandname.setText("");
                                        phone.setText("");
                                        em1.setText("");
                                        pwd3.setText("");

                                        Toast.makeText(MyProfile.this,"successfull",Toast.LENGTH_LONG).show();
                                    }else{
                                        Toast.makeText(MyProfile.this,"failed",Toast.LENGTH_LONG).show();
                                    }
                            }
                        });
                    }


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    protected void onStart() {

    super.onStart();
        mDbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot sp : snapshot.getChildren()){
                        if(sp.child("email").getValue().equals(auth.getEmail())){
                            mDbRef.child(sp.getKey()).addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    user = snapshot.getValue(User.class);
                                    firstname.setText(user.getFirstname());
                                    secandname.setText(user.getLastname());
                                    phone.setText(user.getPhone());
                                    em1.setText(user.getEmail());
                                    pwd3.setText(user.getPassword());

                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });
                        }


                    }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





    }
}