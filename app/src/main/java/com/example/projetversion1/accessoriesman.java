package com.example.projetversion1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import com.bumptech.glide.Glide;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
import com.squareup.picasso.Picasso;

public class accessoriesman extends FirebaseRecyclerAdapter<Product,accessoriesman.viewHolder>{

    public accessoriesman(@NonNull FirebaseRecyclerOptions<Product> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull accessoriesman.viewHolder holder, int position, Product model) {
        holder.Title.setText(model.getTitle());
        Glide.with(holder.img.getContext()).load(model.getPicture()).into(holder.img);
    }

    @NonNull
    @Override
    public accessoriesman.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bag,parent,false);
        return new accessoriesman.viewHolder(view);
    }

    class viewHolder extends  RecyclerView.ViewHolder{


        TextView Title;
        ImageView img;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.name);
            img = itemView.findViewById(R.id.imaga);

            img.setOnClickListener(new View.OnClickListener() {
                FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
                DatabaseReference mDbRef = mDatabase.getReference("random/male/accessories");
                @Override
                public void onClick(View view) {
                    mDbRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot spt) {
                            for (DataSnapshot sp : spt.getChildren()){
                                if(sp.child("Title").getValue().equals(Title.getText().toString())){
                                    mDbRef.child(sp.getKey()).addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot data) {

                                            Product p = data.getValue(Product.class);
                                            Intent inte =new Intent(itemView.getContext(),Sell.class);
                                            inte.putExtra("Tiitre",p.getTitle());
                                            inte.putExtra("Categori",p.getCategory());
                                            inte.putExtra("describe",p.getDescription());
                                            inte.putExtra("pic",p.getPicture());
                                            inte.putExtra("states",p.getState());
                                            inte.putExtra("prixe",p.getPrice());
                                            view.getContext().startActivity(inte);
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError error) {

                                        }
                                    });
//
//


                                }

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            });




        }





    }
}
