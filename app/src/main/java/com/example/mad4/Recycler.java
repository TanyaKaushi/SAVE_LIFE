package com.example.mad4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Recycler extends AppCompatActivity {

    RecyclerView recview;
    myadapter adapter;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recview = (RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));
        btn = findViewById(R.id.request);

        FirebaseRecyclerOptions<Add1> options = new FirebaseRecyclerOptions.Builder<Add1>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("add"),Add1.class).build();

        adapter = new myadapter(options);
        recview.setAdapter(adapter);


       /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),addBloodReq.class);
            }
        });*/
    }

    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }

}