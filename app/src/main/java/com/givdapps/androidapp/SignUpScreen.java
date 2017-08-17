package com.givdapps.androidapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class SignUpScreen extends AppCompatActivity {

    public static final int IMAGE_GALLERY_REQUEST = 20;
    private ImageButton profile_image;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        profile_image = (ImageButton) findViewById(R.id.profile_image);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    imageGallery(view);

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(SignUpScreen.this, "Permission to read your external storage denied.", Toast.LENGTH_SHORT).show();
                    break;
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    public void interestButton(View view){

        //uncomment below to prevent blank signup

//        EditText first_name = (EditText)findViewById(R.id.fNText);
//        EditText last_name = (EditText)findViewById(R.id.lNText);
//        EditText email_text = (EditText)findViewById(R.id.emailText);
//        EditText password_text = (EditText)findViewById(R.id.passwordText);
//
//        String firstName = first_name.getText().toString();
//        String lastName = last_name.getText().toString();
//        String email_address = email_text.getText().toString();
//        String set_password.length() == 0) {
//            Toast.makeText(this, "Please enter your first name.", Toast.LENGTH_SHORT).show();
//        }
//        else if(lastName.trim().length()==0){
//            Toast.makeText(this, "Please enter your last name.", Toast.LENGTH_SHORT).show();
//        }
//        else if(email_address.trim().length()==0){
//            Toast.makeText(this, "Please enter your email address.", Toast.LENGTH_SHORT).show();
//        }
//        else if(set_password.trim().length()==0){
//            Toast.makeText(this, "Please enter a password.", Toast.LENGTH_SHORT).show();
//        }
//        else { = password_text.getText().toString();
//        if (firstName.trim()
//            Intent intent = new Intent(this, InterestScreen.class);
//            startActivity(intent);
//        }

        Intent intent = new Intent(this, InterestScreen.class);
        startActivity(intent);
    }


    public void imageGallery(View v){

        if (ContextCompat.checkSelfPermission(SignUpScreen.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(SignUpScreen.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    1);
        }
        else {
            Intent photoPicker = new Intent(Intent.ACTION_PICK);
            File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            String pictureDirectoryPath = pictureDirectory.getPath();
            Uri data = Uri.parse(pictureDirectoryPath);

            // * gets all image types
            photoPicker.setDataAndType(data, "image/*");

            startActivityForResult(photoPicker, IMAGE_GALLERY_REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK){
            if(requestCode == IMAGE_GALLERY_REQUEST){
                Uri imageUri = data.getData();

                InputStream inputStream;

                try {
                    inputStream = getContentResolver().openInputStream(imageUri);
                    Bitmap image = BitmapFactory.decodeStream(inputStream);
                    profile_image.setImageBitmap(image);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Unable to open image", Toast.LENGTH_LONG).show();
                }

            }
        }
    }

}
