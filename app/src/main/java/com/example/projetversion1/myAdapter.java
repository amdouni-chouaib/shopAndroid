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

public class myAdapter extends FirebaseRecyclerAdapter<Product,myAdapter.myviewHolder> {

    public myAdapter(@NonNull FirebaseRecyclerOptions<Product> options) {
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
        TextView mTitle,mcategory,mdescription,mprice,mstate,mpicture;
        ImageView img;
        Button btne;
        public myviewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.restitre);
//             mcategory = itemView.findViewById(R.id.cat);
//            mdescription = itemView.findViewById(R.id.desc);
            //mprice = itemView.findViewById(R.id.prix);
//             mstate = itemView.findViewById(R.id.state);
            // btne = itemView.findViewById(R.id.button2);
            img = itemView.findViewById(R.id.imgs);
                img.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        mDbRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot spt) {
                                for (DataSnapshot sp : spt.getChildren()){
                                    if(sp.child("Title").getValue().equals(mTitle.getText().toString())){
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
