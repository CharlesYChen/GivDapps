package com.givdapps.androidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.Toast;

import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.model.Token;
import com.stripe.android.model.Card;
import com.stripe.android.view.CardInputWidget;

public class DonateScreen extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.donate_screen);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.8));

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.dimAmount = 0.5f; // Dim level. 0.0 - no dim, 1.0 - completely opaque
        lp.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        getWindow().setAttributes(lp);

//        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.donate_options);
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
//        {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                // checkedId is the RadioButton selected
//            }
//        });

//        Button donate = (Button) findViewById(R.id.change_card);
//        donate.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick (View v){
//                startActivity(new Intent(DonateScreen.this, PaymentMethod.class));
//            }
//        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.donate_five:
                if (checked)
                    break;
            case R.id.donate_ten:
                if (checked)
                    break;
            case R.id.donate_twenty:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.donate_fifty:
                if (checked)
                    // Ninjas rule
                    break;
            case R.id.enter_donation:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    public void paymentMethod (View view){
        Intent intent = new Intent(this, PaymentMethod.class);
        startActivity(intent);
    }

    public void exit (View view){
        Intent intent = new Intent(this, CauseInfo.class);
        startActivity(intent);
    }

    public void donateButton(View view){
        CardInputWidget mCardInputWidget = (CardInputWidget) findViewById(R.id.card_input_widget);

        Card cardToSave = mCardInputWidget.getCard();
        if (cardToSave == null) {
//            mErrorDialogHandler.showError("Invalid Card Data");
            Toast.makeText(this, "Invalid Card Data",Toast.LENGTH_LONG).show();
        }

        // Remember that the card object will be null if the user inputs invalid data.
        Card card = mCardInputWidget.getCard();
        if (card == null) {
            // Do not continue token creation.
            Toast.makeText(DonateScreen.this, "Create token error", Toast.LENGTH_LONG).show();
        }

        //replaced mContext and getContext() with "this"
        Stripe stripe = new Stripe(this, "pk_test_dFxW1XuPTIKrEE3gCtgq9Fd0");
        stripe.createToken(
                card,
                new TokenCallback() {
                    public void onSuccess(Token token) {
                        // Send token to your server
                    }
                    public void onError(Exception error) {
                        // Show localized error message
                        Toast.makeText(DonateScreen.this, "Send token error", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}
