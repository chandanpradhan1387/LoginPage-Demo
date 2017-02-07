package com.example.chandan.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button login;
    TextView forgot;
    //static password:pass
    String passwords = "pass";



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        forgot = (TextView) findViewById(R.id.forgot);

        //Set on click for login button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //login is a method which accepts inputs in String format.
                // here "passwords" contains static data as "pass"
                // login only accepted if and only if enter password is "pass" with user name "admin"

                login(passwords);
            }

        });

        //set onclick listener for forgot password option
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // intent to second activity "forgot password"
                Intent forget = new Intent(MainActivity.this,ForgotPassword.class);
                //parse the current variable containing password
                forget.putExtra("currentPassword",passwords);
                //start variable and wait for result in return
                startActivityForResult(forget,1);

            }

        });

    }
    //LOGIN method declaration
    //it requires a String value to be stored in"passwordd"
    public void login (String passwordd){
        //USERID static "admin" && password variable "passwordd"
        if (email.getText().toString().equals("admin")&&password.getText().toString().equals(passwordd)){
            //if success intent to SucessLogin activity
            Intent success = new Intent(MainActivity.this, sucessLogin.class);
            startActivity(success);
        }else {
            //if USERID !="admin" && password =! Static password "pass" or "password retrived from forgot password"
            Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    //Required as demanded by the forgotlistener "StartActivityForResult()"
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //checks if there is any data in the activity or not if not safely back
        //"if blocked is used" coz "app crashes" when *no data is entered* and *back button is pressed*
        if (data != null){
            //"newPassword" is the string which is parsed from forgotPassword activity
            final String result = data.getStringExtra("newPassword");
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //login method where Static value of password is updated
                    //with "newPassword" received from forgotPassword Activity
                    login(result);
                }

            });
        }

    }
}
