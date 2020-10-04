package com.example.save_life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    private Button button;
    private Button button3;
    private Button msg;
    TextView pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        pro = findViewById(R.id.view);
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MyInfo.class);
                startActivity(i);
            }
        });


        msg = findViewById(R.id.btnmsg);
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Message.class);
                startActivity(i);
            }
        });


        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity3();
            }
        });

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity2();
            }

        });
    }

    public void openMainActivity3() {
        Intent intent = new Intent(this, AddPage.class);
        startActivity(intent);
    }

    public void openMainActivity2() {
        Intent intent = new Intent(this, details.class);
        startActivity(intent);

    }
}