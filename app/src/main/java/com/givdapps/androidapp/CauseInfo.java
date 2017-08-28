package com.givdapps.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;


public class CauseInfo extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cause_info);


        ImageButton donate = (ImageButton) findViewById(R.id.donate_button);
        donate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                startActivity(new Intent(CauseInfo.this, DonateScreen.class));
            }
        });
    }
    public void exit_button (View view){
        Intent intent = new Intent(this, CausesNavigationDrawer.class);
        startActivity(intent);
    }
}