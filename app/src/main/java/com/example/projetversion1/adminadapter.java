package com.example.projetversion1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class adminadapter extends FirebaseRecyclerAdapter<Product,adminadapter.myviewHolder> {

    public adminadapter(@NonNull FirebaseRecyclerOptions<Product> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewHolder holder, int position, @NonNull Product model) {
        holder.mTitle.setText(model.getTitle());
        Glide.with(holder.img.getContext()).load(model.getPicture()).into(holder.img);

    }

    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product,parent,false);
        return new myviewHolder(view);

    }

    class myviewHolder extends RecyclerView.ViewHolder{

        FirebaseUser auth = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference mDbRef = mDatabase.getReference("Product");
        TextView mTitle;
        ImageView img;

        public myviewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.restitre);
            img = itemView.findViewById(R.id.imgs);



        }

    }

}
