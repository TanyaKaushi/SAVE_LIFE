package com.example.save_life;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class show_Details extends AppCompatActivity {

    TextView tx_name,tx_dob,tx_city,spinblood,tx_phone,tx_duration;
    ImageView back_img_2;
    Button up_btn,del_btn,home_btn;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__details);

        back_img_2 = (ImageView) findViewById(R.id.backimgview2);

        home_btn = findViewById(R.id.homebtn);

        back_img_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Open_add_details();
            }
        });

        final Intent intent = getIntent();
        String ntxt = intent.getStringExtra(Add_ReqBlood.Name);
        String ctxt = intent.getStringExtra(Add_ReqBlood.City);
        String dotxt = intent.getStringExtra(Add_ReqBlood.Date_O_Birth);
        String bspin = intent.getStringExtra(Add_ReqBlood.BloodGro2);
        String ptxt = intent.getStringExtra(Add_ReqBlood.Phone);
        String dtxt = intent.getStringExtra(Add_ReqBlood.Duration);

        tx_name = (TextView) findViewById(R.id.nametx);
        tx_city = (TextView) findViewById(R.id.citytx);
        tx_dob = (TextView) findViewById(R.id.dob_tx);
        spinblood = (TextView) findViewById(R.id.bloodspin);
        tx_phone = (TextView) findViewById(R.id.phonetx);
        tx_duration = (TextView)findViewById(R.id.durationtx);

        tx_name.setText(ntxt);
        tx_city.setText(ctxt);
        tx_dob.setText(dotxt);
        spinblood.setText(bspin);
        tx_phone.setText(ptxt);
        tx_duration.setText(dtxt);

        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Open_home();
            }
        });

        del_btn = (Button)findViewById(R.id.dltbtn);
        del_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatabaseReference del_Ref = FirebaseDatabase.getInstance().getReference().child("RequestBlood");
                del_Ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("D1")){
                            dbRef = FirebaseDatabase.getInstance().getReference().child("RequestBlood").child("D1");
                            dbRef.removeValue();

                            Toast.makeText(getApplicationContext(), "Data Deleted Successfully",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), Add_ReqBlood.class);
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "No Source To Delete",Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        up_btn = (Button)findViewById(R.id.upd_btn);
        up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Open_update_Details();
            }
        });

        home_btn = (Button)findViewById(R.id.homebtn);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Open_ReqBlood();
            }
        });
    }

    private void Open_home() {
        Intent i3 = new Intent(this,NeedHelp.class);
        startActivity(i3);
    }

    private void Open_ReqBlood() {
        Intent i3 = new Intent(this,NeedHelp.class);
    }


    private void Open_add_details() {
        Intent i2 = new Intent(this, Add_ReqBlood.class);
        startActivity(i2);
    }

    private void Open_update_Details() {
        Intent i = new Intent(this,up_Details.class);
        startActivity(i);
    }
}