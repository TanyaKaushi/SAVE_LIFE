package com.example.save_life;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class UpdatePage extends AppCompatActivity {


    EditText name, blood, city, age, gender, contact, email;
    Button button1,button2;

    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_page);

        name = findViewById(R.id.editname);
        blood = findViewById(R.id.editblood);
        city = findViewById(R.id.editcity);
        age = findViewById(R.id.editage);
        gender = findViewById(R.id.editgender);
        contact = findViewById(R.id.editcontact);
        email = findViewById(R.id.editemail);

        button1 = findViewById(R.id.btnupdate);
        button2 = findViewById(R.id.btndelete);

        String nm = getIntent().getStringExtra("nm");
        String bl = getIntent().getStringExtra("bl");
        String ci = getIntent().getStringExtra("ci");
        String ag = getIntent().getStringExtra("ag");
        String ge = getIntent().getStringExtra("ge");
        String con = getIntent().getStringExtra("con");
        String em = getIntent().getStringExtra("em");

        name.setText(nm);
        blood.setText(bl);
        city.setText(ci);
        age.setText(ag);
        gender.setText(ge);
        contact.setText(con);
        email.setText(em);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View view) {
                String nm = name.getText().toString();
                String bl = blood.getText().toString();
                String ci = city.getText().toString();
                String ag = age.getText().toString();
                String ge = gender.getText().toString();
                String con = contact.getText().toString();
                String em = email.getText().toString();

                ref = FirebaseDatabase.getInstance().getReference().child("Donor");

                HashMap hashMap = new HashMap();

                hashMap.put("name",nm);
                hashMap.put("blood",bl);
                hashMap.put("city",ci);
                hashMap.put("age",ag);
                hashMap.put("gender",ge);
                hashMap.put("contact",con);
                hashMap.put("email",em);

                ref.child("Donor").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(getApplicationContext(),"Successfully Updated", Toast.LENGTH_LONG).show();
                        //Intent i = new Intent(getApplicationContext(), ViewPage.class);
                        //startActivity(i);
                    }
                });
            }
        });



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference refe = FirebaseDatabase.getInstance().getReference().child("Donor");
                refe.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Donor")){
                            ref = FirebaseDatabase.getInstance().getReference().child("Donor").child("Donor");
                            ref.removeValue();
                            Toast.makeText(getApplicationContext(),"Data Deleted Successfully",Toast.LENGTH_LONG).show();

                        }
                        else
                            Toast.makeText(getApplicationContext(),"No Source To Delete", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });





    }
}