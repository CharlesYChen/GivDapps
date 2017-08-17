package com.givdapps.androidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_new_password);
    }
}