package com.givdapps.androidapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InterestScreen extends AppCompatActivity {
    ArrayList<String> selectedItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interest_screen);

        ListView checkableList = (ListView) findViewById(R.id.checkable_list);
        checkableList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String [] items = {"Cancer","Children","Community","Environmental Protection","Poverty","Rehabilitation","Religion","Victims"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, R.layout.interest_checklist,R.id.check_list,items);
        checkableList.setAdapter(adapter);
        checkableList.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            //dont know why background color doesnt change after clicking on a highlighted checkbox
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                if(view.isSelected()){
                    view.setBackgroundColor(Color.WHITE);
                }

                else
                    view.setBackgroundColor(Color.rgb(228,239,249));

                String selectedItem = ((TextView)view).getText().toString();
                if(selectedItems.contains(selectedItem)){
                    selectedItems.remove(selectedItem);
                    view.setBackgroundColor(Color.WHITE);
                }
                else
                    selectedItems.add(selectedItem);

            }
        });
    }
    public void showSelectedItems (View view){
        String items="";
        for(String item:selectedItems){
            items+="-"+item+"\n";
        }
        Toast.makeText(this, "You have selected \n"+items,Toast.LENGTH_LONG).show();
    }
    public void causesButton(View view){
        Intent intent = new Intent(this, CausesNavigationDrawer.class);
        startActivity(intent);
    }
}
