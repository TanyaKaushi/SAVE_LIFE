package com.example.madmini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class AddPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText name, city, age, contact, email;
    Button upload;
    Spinner blood, gender;

    //DatabaseReference ref;

    Donor donor;

    public void clearControls(){
        name.setText("");
        city.setText("");
        age.setText("");
        contact.setText("");
        email.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_page);

        Spinner aSpinner = findViewById(R.id.spin);
        aSpinner.setOnItemSelectedListener(this);

        name = findViewById(R.id.txtname);
        city = findViewById(R.id.txtcity);
        age = findViewById(R.id.txtage);
        contact = findViewById(R.id.txtcontact);
        email = findViewById(R.id.txtemail);
        blood = findViewById(R.id.spin);
        gender = findViewById(R.id.sping);

        upload = findViewById(R.id.btn);

        donor = new Donor();

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  ref = FirebaseDatabase.getInstance().getReference().child("Donor");

                try{

                    if(TextUtils.isEmpty(name.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Enter a Name",Toast.LENGTH_LONG).show();

                    else if(TextUtils.isEmpty(city.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Enter a City",Toast.LENGTH_LONG).show();

                    else if(TextUtils.isEmpty(age.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Enter a Age",Toast.LENGTH_LONG).show();

                    else{
                        donor.setName(name.getText().toString().trim());
                        donor.setBlood(blood.getSelectedItem().toString());
                        donor.setCity(city.getText().toString().trim());
                        donor.setAge(age.getText().toString().trim());
                        donor.setGender(gender.getSelectedItem().toString());
                        donor.setContact(Integer.parseInt(contact.getText().toString().trim()));
                        donor.setEmail(email.getText().toString().trim());

                        //ref.push().setValue(donor);
                        //ref.child("Donor").setValue(donor);
                        Toast.makeText(getApplicationContext(),"Data Saved Successfully",Toast.LENGTH_LONG).show();

                        String data1 = name.getText().toString();
                        String data2 = blood.getSelectedItem().toString();
                        String data3 = city.getText().toString();
                        String data4 = age.getText().toString();
                        String data5 = gender.getSelectedItem().toString();
                        String data6 = contact.getText().toString();
                        String data7= email.getText().toString();

                        Intent i = new Intent(getApplicationContext(), ViewPage.class);
                        clearControls();

                        i.putExtra("nm",data1);
                        i.putExtra("bl",data2);
                        i.putExtra("ci",data3);
                        i.putExtra("ag",data4);
                        i.putExtra("ge",data5);
                        i.putExtra("con",data6);
                        i.putExtra("em",data7);

                        startActivity(i);
                    }
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Invalid Contact Number",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


}
