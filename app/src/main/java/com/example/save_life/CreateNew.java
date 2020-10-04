package com.example.save_life;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateNew extends AppCompatActivity {

    Spinner a,b,c,d,e,f,g,h;
    DatabaseReference ref;
    Button button;
    Add1 add;
    EditText hospital,city,contact;

    AwesomeValidation awesomeValidation;

    private void clearControls(){
        a.setSelected(Boolean.parseBoolean(" "));
        b.setSelected(Boolean.parseBoolean(""));
        c.setSelected(Boolean.parseBoolean(""));
        d.setSelected(Boolean.parseBoolean(""));
        e.setSelected(Boolean.parseBoolean(""));
        f.setSelected(Boolean.parseBoolean(""));
        g.setSelected(Boolean.parseBoolean(""));
        h.setSelected(Boolean.parseBoolean(""));
        hospital.setText("");
        city.setText("");
        contact.setText("");
        //spin.setText("");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);

        button = findViewById(R.id.upload);
        hospital = findViewById(R.id.hospital);
        city = findViewById(R.id.city);
        contact = findViewById(R.id.contact);
        a = findViewById(R.id.aSpinner);
        b = findViewById(R.id.bSpinner);
        c = findViewById(R.id.cSpinner);
        d = findViewById(R.id.dSpinner);
        e = findViewById(R.id.eSpinner);
        f = findViewById(R.id.fSpinner);
        g = findViewById(R.id.gSpinner);
        h = findViewById(R.id.hSpinner);


        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this,R.id.hospital,
                RegexTemplate.NOT_EMPTY,R.string.invalid_hospital_name);
        awesomeValidation.addValidation(this,R.id.contact,
                "[0-9]{10}$",R.string.invalid_phone_number);
        awesomeValidation.addValidation(this,R.id.city,
                RegexTemplate.NOT_EMPTY,R.string.invalid_city);

        add = new Add1();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate()){

                    ref = FirebaseDatabase.getInstance().getReference().child("hospital_add");
                    add.setA_plus(a.getSelectedItem().toString().trim());
                    add.setA_minus(b.getSelectedItem().toString().trim());
                    add.setB_plus(c.getSelectedItem().toString().trim());
                    add.setB_minus(d.getSelectedItem().toString().trim());
                    add.setAB_plus(e.getSelectedItem().toString().trim());
                    add.setAB_minus(f.getSelectedItem().toString().trim());
                    add.setO_plus(g.getSelectedItem().toString().trim());
                    add.setO_minus(h.getSelectedItem().toString().trim());
                    add.setHospital(hospital.getText().toString().trim());
                    add.setCity(city.getText().toString().trim());
                    add.setContact(contact.getText().toString().trim());


                    //Ref.push().setValue(add);
                    ref.child("1").setValue(add);

                    Toast.makeText(getApplicationContext(), "Added Successfully..", Toast.LENGTH_SHORT).show();

                    String A = a.getSelectedItem().toString();
                    String B = b.getSelectedItem().toString();
                    String C = c.getSelectedItem().toString();
                    String D = d.getSelectedItem().toString();
                    String E = e.getSelectedItem().toString();
                    String F = f.getSelectedItem().toString();
                    String G = g.getSelectedItem().toString();
                    String H = h.getSelectedItem().toString();
                    String Hospital = hospital.getText().toString();
                    String City = city.getText().toString();
                    String Contact = contact.getText().toString();

                    Intent i = new Intent(getApplicationContext(),List1.class);
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



                }else {
                    Toast.makeText(getApplicationContext(),"Validation Failed..",Toast.LENGTH_SHORT).show();
                }



            }

                /*public void showToast (View view){
                    Toast toast = Toast.makeText(getApplicationContext(), "New List Created", Toast.LENGTH_LONG);
                    toast.show();
                }*/

        });


    }
}