package com.aznchar.givdapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        EditText editText1 = (EditText)findViewById(R.id.email_address);
        editText1.setSelection(editText1.length()/2);

        EditText editText2 = (EditText)findViewById(R.id.enter_password);
        editText2.setSelection(editText2.length()/2);
    }
    public void introButton(View view){
        Intent intent = new Intent(this, IntroScreen.class);
        startActivity(intent);
    }
}
