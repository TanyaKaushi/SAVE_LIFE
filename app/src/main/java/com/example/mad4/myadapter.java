package com.example.mad4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myadapter extends FirebaseRecyclerAdapter<Add1,myadapter.myviewholder> {

    public myadapter(@NonNull FirebaseRecyclerOptions<Add1> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull Add1 model) {

        holder.hospital.setText(model.getHospital());
        holder.city.setText(model.getCity());
        holder.contact.setText(model.getContact());
        holder.a_plus.setText(model.getA_plus());
        holder.a_minus.setText(model.getA_minus());
        holder.b_plus.setText(model.getB_plus());
        holder.b_minus.setText(model.getB_minus());
        holder.ab_plus.setText(model.getAB_plus());
        holder.ab_minus.setText(model.getAB_minus());
        holder.o_plus.setText(model.getO_plus());
        holder.o_minus.setText(model.getO_minus());

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView contact,city,hospital,a_plus,a_minus,b_plus,b_minus,ab_plus,ab_minus,o_plus,o_minus;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            city = (TextView)itemView.findViewById(R.id.city);
            contact = (TextView)itemView.findViewById(R.id.contact);
            hospital = (TextView)itemView.findViewById(R.id.hospital);
            a_plus = (TextView)itemView.findViewById(R.id.a_plus);
            a_minus = (TextView)itemView.findViewById(R.id.a_minus);
            b_plus =(TextView)itemView.findViewById(R.id.b_plus);
            b_minus =(TextView)itemView.findViewById(R.id.b_minus);
            ab_plus =(TextView)itemView.findViewById(R.id.ab_plus);
            ab_minus =(TextView)itemView.findViewById(R.id.ab_minus);
            o_plus =(TextView)itemView.findViewById(R.id.o_plus);
            o_minus =(TextView)itemView.findViewById(R.id.o_minus);


        }
    }
}
