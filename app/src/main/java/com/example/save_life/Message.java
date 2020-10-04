package com.example.save_life;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Message extends AppCompatActivity {

    Button btn;
    EditText edt1, edt2;
    private static final int MY_PERMISSION_SEND_SMS = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        btn = (Button) findViewById(R.id.button);
        edt1 = (EditText) findViewById(R.id.txt1);
        edt2 = (EditText) findViewById(R.id.txt2);


    }

    public void sendsms(View view) {

        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

            Mymessage();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSION_SEND_SMS);
        }
    }

    public void Mymessage() {
        String number = edt1.getText().toString().trim();
        String msg = edt2.getText().toString().trim();

        if (number == null || number.equals("") || msg == null || msg.equals("")) {
            Toast.makeText(this, "Fields are empty", Toast.LENGTH_LONG).show();
        } else {
            if (TextUtils.isDigitsOnly(number)) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(number, null, msg, null, null);
                Toast.makeText(this, "Message send successfully", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "PLease enter the validate number", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void onRequestPermissionReult(int reqcode, String[] permissions, int[] grantResult) {
        super.onRequestPermissionsResult(reqcode, permissions, grantResult);

        switch (reqcode)
        {
            case MY_PERMISSION_SEND_SMS: {
                if ((grantResult.length>0 && grantResult[0]==PackageManager.PERMISSION_GRANTED))
                {
                    Mymessage();
                }
                else{
                    Toast.makeText(this, "no permission granted",Toast.LENGTH_LONG).show();

                }
            }

        }


    }
}