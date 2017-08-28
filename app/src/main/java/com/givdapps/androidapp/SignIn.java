package com.givdapps.androidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        EditText email_address = (EditText)findViewById(R.id.email_address);
        EditText enter_password = (EditText)findViewById(R.id.enter_password);

    }

    public void signinButton(View view){

        EditText email_address = (EditText)findViewById(R.id.email_address);
        EditText enter_password = (EditText)findViewById(R.id.enter_password);

        String email = email_address.getText().toString();
        String password = enter_password.getText().toString();
        if (email.trim().length() == 0 && password.trim().length()==0) {
            Toast.makeText(this, "Please enter your email and password.", Toast.LENGTH_SHORT).show();
        }
        else if (email.trim().length() == 0) {
            Toast.makeText(this, "Please enter your email.", Toast.LENGTH_SHORT).show();
        }
        else if(password.trim().length()==0){
            Toast.makeText(this, "Please enter your password.", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, CausesNavigationDrawer.class);
            startActivity(intent);
        }
    }
    public void getNewPasswordButton (View view){
        Intent intent = new Intent(this, NewPassword.class);
        startActivity(intent);
    }
    public void getNewAccountButton (View view){
        Intent intent = new Intent(this, IntroScreen.class);
        startActivity(intent);
    }
}
