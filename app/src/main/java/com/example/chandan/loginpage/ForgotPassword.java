package com.example.chandan.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    EditText newPass;
    EditText reenterNewPass;
    Button submit;
    String newPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        //intent to get data from mainactivity
        Intent intent1 = getIntent();
        Bundle bundle = intent1.getExtras();
        //"currentPassword" is parsed from MainActivity
        final String password = bundle.getString("currentPassword");


        newPass = (EditText) findViewById(R.id.newpassword);
        reenterNewPass =(EditText) findViewById(R.id.reenterpassword);
        submit = (Button) findViewById(R.id.submit);
        //set on click listener for submit button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newPass.getText().toString().equals(reenterNewPass.getText().toString())){
                    newPassword = newPass.getText().toString();
                    String newPassdd = newPassword;
                    Toast.makeText(ForgotPassword.this, "successfully changed ", Toast.LENGTH_SHORT).show();

                    //send new password to main activity "newPassword"
                    Intent intent1 = new Intent();
                    intent1.putExtra("newPassword",newPassdd);
                    setResult(1,intent1);
                    finish();
                }else {
                    Toast.makeText(ForgotPassword.this, "passwords doesn't match", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
