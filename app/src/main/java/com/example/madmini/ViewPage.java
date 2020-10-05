package com.example.madmini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class ViewPage extends AppCompatActivity {

    TextView name, blood, city, age, gender, contact, email;
    Button button;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);


        name = findViewById(R.id.txname);
        blood = findViewById(R.id.txblood);
        city = findViewById(R.id.txcity);
        age = findViewById(R.id.txage);
        gender = findViewById(R.id.txgender);
        contact = findViewById(R.id.txcontact);
        email = findViewById(R.id.txemail);

        button = findViewById(R.id.btnupdate);


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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nam = name.getText().toString();
                String blo = blood.getText().toString();
                String cit = city.getText().toString();
                String ag = age.getText().toString();
                String gen = gender.getText().toString();
                String cont = contact.getText().toString();
                String ema = email.getText().toString();

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

