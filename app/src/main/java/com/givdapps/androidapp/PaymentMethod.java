package com.givdapps.androidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class PaymentMethod extends Activity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_method);
    }

    public void cancelButton (View view){
        Intent intent = new Intent(this, CauseInfo.class);
        startActivity(intent);
    }
    public void doneButton (View view){
        //need to get info from filled-in fields
        Intent intent = new Intent(this, CauseInfo.class);
        startActivity(intent);
    }
}
