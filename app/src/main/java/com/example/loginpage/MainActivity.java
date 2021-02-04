package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //tests assertions
    private String testEmail="admin@outlook.com";
    private String testPassword="admin";


    //private variables for interface components
    private EditText etEmail;
    private EditText etPassword;
    private Button login;

    //other variables
    int attempts=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize private variables
        etEmail=(EditText) findViewById(R.id.email);
        etPassword=(EditText) findViewById(R.id.password);
        login=(Button) findViewById(R.id.login);

        View.OnClickListener loginPressed = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=etEmail.getText().toString();
                String password=etPassword.getText().toString();
                if(validate(email,password) && attempts>0){
                    setContentView(R.layout.welcome);
                    return;
                }
                if(attempts<=0){
                    etEmail.setClickable(false);
                    etPassword.setClickable(false);
                    login.setClickable(false);
                    return;
                }
                Toast.makeText(MainActivity.this,"Incorrect email or password, attempt remaining "+--attempts,Toast.LENGTH_SHORT).show();
            }
        };

        login.setOnClickListener(loginPressed);

    }

    public boolean validate(String email, String password){
        return email.equals(testEmail) && password.equals(testPassword);
    }
}