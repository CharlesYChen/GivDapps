package com.givdapps.androidapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IntroScreen extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_screen);

        //image slider
        viewPager = (ViewPager) findViewById(R.id.intro_screen_viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        //image slider dot indicator
        viewPager = (ViewPager) findViewById(R.id.intro_screen_viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(viewPager, true);
    }
    public void signUpScreen(View view){
        Intent intent = new Intent(this, SignUpScreen.class);
        startActivity(intent);
    }
    public void signInButton(View view){
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
    }
}
