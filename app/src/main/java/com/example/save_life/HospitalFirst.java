package com.example.save_life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HospitalFirst extends AppCompatActivity {

    DatabaseReference Ref;
    FirebaseDatabase database;
    Button button,button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_first);

        button = findViewById(R.id.btn4);
        button1 = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),CreateNew.class);
                startActivity(i);
            }
        });




        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),List.class);
                startActivity(i);
            }
        });


    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),"Go to Requests",Toast.LENGTH_LONG);
        toast.show();


    }
}