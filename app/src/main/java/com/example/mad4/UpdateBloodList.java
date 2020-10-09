package com.example.mad4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class UpdateBloodList extends AppCompatActivity {

    Button button1 , button2;
    EditText hospital,city,contact,at,bt,ct,dt,et,ft,gt,ht;
    Add1 add;
    DatabaseReference Ref;
    AwesomeValidation awesomeValidation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_blood_list);


        button1 = findViewById(R.id.upd);
        button2 = findViewById(R.id.can);

        at = findViewById(R.id.att);
        bt = findViewById(R.id.btt);
        ct = findViewById(R.id.ctt);
        dt = findViewById(R.id.dtt);
        et = findViewById(R.id.ett);
        ft = findViewById(R.id.ftt);
        gt = findViewById(R.id.gtt);
        ht = findViewById(R.id.htt);
        hospital = findViewById(R.id.hospital);
        city = findViewById(R.id.city);
        contact = findViewById(R.id.contact);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.hospital,
                RegexTemplate.NOT_EMPTY,R.string.invalid_hospital_name);
        awesomeValidation.addValidation(this,R.id.contact,
                "[0-9]{10}$",R.string.invalid_phone_number);
        awesomeValidation.addValidation(this,R.id.city,
                RegexTemplate.NOT_EMPTY,R.string.invalid_city);
        awesomeValidation.addValidation(this,R.id.att,
                RegexTemplate.NOT_EMPTY,R.string.invalid);
        awesomeValidation.addValidation(this,R.id.btt,
                RegexTemplate.NOT_EMPTY,R.string.invalid);
        awesomeValidation.addValidation(this,R.id.ctt,
                RegexTemplate.NOT_EMPTY,R.string.invalid);
        awesomeValidation.addValidation(this,R.id.dtt,
                RegexTemplate.NOT_EMPTY,R.string.invalid);
        awesomeValidation.addValidation(this,R.id.ett,
                RegexTemplate.NOT_EMPTY,R.string.invalid);
        awesomeValidation.addValidation(this,R.id.ftt,
                RegexTemplate.NOT_EMPTY,R.string.invalid);
        awesomeValidation.addValidation(this,R.id.gtt,
                RegexTemplate.NOT_EMPTY,R.string.invalid);
        awesomeValidation.addValidation(this,R.id.htt,
                RegexTemplate.NOT_EMPTY,R.string.invalid);



        String as = getIntent().getStringExtra("aa");
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
        contact.setText(con);

      /*  DatabaseReference Ref = FirebaseDatabase.getInstance().getReference().child("add");
        Ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild("4")){
                    try{
                        add.Set
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });  */


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(awesomeValidation.validate()){

                String a = at.getText().toString();
                String b = bt.getText().toString();
                String c = ct.getText().toString();
                String d = dt.getText().toString();
                String e = et.getText().toString();
                String f = ft.getText().toString();
                String g = gt.getText().toString();
                String h = ht.getText().toString();
                String contactt = contact.getText().toString();
                String cit = city.getText().toString();
                String hos = hospital.getText().toString();

                Ref = FirebaseDatabase.getInstance().getReference().child("add");

                HashMap hashMap = new HashMap();

                hashMap.put("a_plus",a);
                hashMap.put("a_minus",b);
                hashMap.put("b_plus",c);
                hashMap.put("b_minus",d);
                hashMap.put("ab_plus",e);
                hashMap.put("ab_minus",f);
                hashMap.put("o_plus",g);
                hashMap.put("o_minus",h);
                hashMap.put("contact",contactt);
                hashMap.put("hospital",cit);
                hashMap.put("city",hos);

                Ref.child("4").updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {
                        Toast.makeText(getApplicationContext(), "Successfully Updated", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), List.class);
                        startActivity(i);

                    }
                });
                }else

                    {
                        Toast.makeText(getApplicationContext(), "Validation Failed..", Toast.LENGTH_SHORT).show();
                    }
                }
                });




        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),List.class);
                startActivity(i);
            }
        });


        /*public void showToast(View view) {
            Toast toast = Toast.makeText(getApplicationContext(),"Details Updated",Toast.LENGTH_LONG);
            toast.show();
        }*/

            }
        };



