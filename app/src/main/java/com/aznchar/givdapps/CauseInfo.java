package com.aznchar.givdapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;


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
}