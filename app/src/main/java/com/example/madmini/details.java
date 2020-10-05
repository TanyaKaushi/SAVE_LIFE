package com.example.madmini;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class details extends AppCompatActivity {

    TextView a, b, c, d, e, f, g;
    Button btn, btn1;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        a=(TextView)findViewById(R.id.txtname);
        b=(TextView)findViewById(R.id.txtblood);
        c=(TextView)findViewById(R.id.txtcity);
        d=(TextView)findViewById(R.id.txtage);
        e=(TextView)findViewById(R.id.txtgender);
        f=(TextView)findViewById(R.id.txtcontact);
        g=(TextView)findViewById(R.id.txtemail);

        btn1=(Button)findViewById(R.id.btndelete);

        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {*/

                ref= FirebaseDatabase.getInstance().getReference().child("Donor").child("Donor");
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String name=dataSnapshot.child("name").getValue().toString();
                        String blood=dataSnapshot.child("blood").getValue().toString();
                        String city=dataSnapshot.child("city").getValue().toString();
                        String age=dataSnapshot.child("age").getValue().toString();
                        String gender=dataSnapshot.child("gender").getValue().toString();
                        String contact=dataSnapshot.child("contact").getValue().toString();
                        String email=dataSnapshot.child("email").getValue().toString();

                        a.setText(name);
                        b.setText(blood);
                        c.setText(city);
                        d.setText(age);
                        e.setText(gender);
                        f.setText(contact);
                        g.setText(email);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
           // }
        //});


        String nm = getIntent().getStringExtra("nm");
        String bl = getIntent().getStringExtra("bl");
        String ci = getIntent().getStringExtra("ci");
        String ag = getIntent().getStringExtra("ag");
        String ge = getIntent().getStringExtra("ge");
        String con = getIntent().getStringExtra("con");
        String em = getIntent().getStringExtra("em");

        a.setText(nm);
        b.setText(bl);
        c.setText(ci);
        d.setText(ag);
        e.setText(ge);
        f.setText(con);
        g.setText(em);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nam = a.getText().toString();
                String blo = b.getText().toString();
                String cit = c.getText().toString();
                String ag = d.getText().toString();
                String gen = e.getText().toString();
                String cont = f.getText().toString();
                String ema = g.getText().toString();

                Intent i = new Intent(getApplicationContext(), UpdatePage.class);

                i.putExtra("nm", nam);
                i.putExtra("bl", blo);
                i.putExtra("ci", cit);
                i.putExtra("ag", ag);
                i.putExtra("ge", gen);
                i.putExtra("con", cont);
                i.putExtra("em", ema);

                startActivity(i);
            }
        });
    }

    }
