package com.example.save_life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Retrieve_Hos extends AppCompatActivity {

    Button btn,btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve__hos);

        btn =(Button) findViewById(R.id.button3);

        btn4 = (Button) findViewById(R.id.btn4);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Add_ReqBlood.class);
                startActivity(intent);
            }
        });
    }
}