package com.example.mad4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class List extends AppCompatActivity {

    TextView at,bt,ct,dt,et,ft,gt,ht,hospital,contact,city;
    Button btn1,btn2;
    DatabaseReference Ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        at = findViewById(R.id.a);
        bt = findViewById(R.id.b);
        ct = findViewById(R.id.c);
        dt = findViewById(R.id.d);
        et = findViewById(R.id.e);
        ft = findViewById(R.id.f);
        gt = findViewById(R.id.g);
        ht = findViewById(R.id.h);
        hospital = findViewById(R.id.hospital);
        city = findViewById(R.id.city);
        contact = findViewById(R.id.contact);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);

       /* String as = getIntent().getStringExtra("aa");
        String bs = getIntent().getStringExtra("bb");
        String cs = getIntent().getStringExtra("cc");
        String ds = getIntent().getStringExtra("dd");
        String es = getIntent().getStringExtra("ee");
        String fs = getIntent().getStringExtra("ff");
        String gs = getIntent().getStringExtra("gg");
        String hs = getIntent().getStringExtra("hh");
        String hos = getIntent().getStringExtra("hospital");
        String cit = getIntent().getStringExtra("city");
        String con = getIntent().getStringExtra("contact");

        at.setText(as);
        bt.setText(bs);
        ct.setText(cs);
        dt.setText(ds);
        et.setText(es);
        ft.setText(fs);
        gt.setText(gs);
        ht.setText(hs);
        hospital.setText(hos);
        city.setText(cit);
        contact.setText(con);*/

        DatabaseReference UpRef = FirebaseDatabase.getInstance().getReference().child("add").child("4");
        UpRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()){
                    at.setText(dataSnapshot.child("a_plus").getValue().toString());
                    bt.setText(dataSnapshot.child("a_minus").getValue().toString());
                    ct.setText(dataSnapshot.child("b_plus").getValue().toString());
                    dt.setText(dataSnapshot.child("b_minus").getValue().toString());
                    et.setText(dataSnapshot.child("ab_plus").getValue().toString());
                    ft.setText(dataSnapshot.child("ab_minus").getValue().toString());
                    gt.setText(dataSnapshot.child("o_plus").getValue().toString());
                    ht.setText(dataSnapshot.child("o_minus").getValue().toString());
                    hospital.setText(dataSnapshot.child("hospital").getValue().toString());
                    city.setText(dataSnapshot.child("city").getValue().toString());
                    contact.setText(dataSnapshot.child("contact").getValue().toString());

                }else
                    Toast.makeText(getApplicationContext(),"No  Source to Display",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String A = at.getText().toString();
                String B = bt.getText().toString();
                String C = ct.getText().toString();
                String D = dt.getText().toString();
                String E = et.getText().toString();
                String F = ft.getText().toString();
                String G = gt.getText().toString();
                String H = ht.getText().toString();
                String Hospital = hospital.getText().toString();
                String City = city.getText().toString();
                String Contact = contact.getText().toString();

                Intent i = new Intent(getApplicationContext(),UpdateBloodList.class);
                //clearControls();

                i.putExtra("aa", A);
                i.putExtra("bb", B);
                i.putExtra("cc", C);
                i.putExtra("dd", D);
                i.putExtra("ee", E);
                i.putExtra("ff", F);
                i.putExtra("gg", G);
                i.putExtra("hh", H);
                i.putExtra("hospital",Hospital);
                i.putExtra("city",City);
                i.putExtra("contact",Contact);
                startActivity(i);
            }
        });



        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseReference dRef = FirebaseDatabase.getInstance().getReference().child("add");
                dRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("4")){
                            Ref = FirebaseDatabase.getInstance().getReference().child("add").child("4");
                            Ref.removeValue();

                            Toast.makeText(getApplicationContext(),"Details Deleted Successfully..",Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);
                        }
                        else
                            Toast.makeText(getApplicationContext(),"No Source to Delete",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


    }
}