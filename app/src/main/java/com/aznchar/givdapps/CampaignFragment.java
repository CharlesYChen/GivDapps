package com.aznchar.givdapps;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CampaignFragment extends Fragment{
    private ListView campaignListView;
    private CampaignListAdapter adapter;
    private List<CampaignListElements> mCampaignList;

    View myView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Campaign");
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.campaign_fragment, container, false);

        campaignListView = (ListView)myView.findViewById(R.id.campaignListView);

        mCampaignList = new ArrayList<>();

        //add sample data, will want to replace with code getting data from database here

        mCampaignList.add(new CampaignListElements("John Doe1", "@John_Doe1", "SAMPLE TEXT", R.drawable.ic_menu_camera, R.drawable.ic_menu_gallery));
        mCampaignList.add(new CampaignListElements("John Doe2", "@John_Doe2", "SAMPLE TEXT", R.drawable.ic_menu_camera, R.drawable.ic_menu_gallery));
        mCampaignList.add(new CampaignListElements("John Doe3", "@John_Doe3", "SAMPLE TEXT", R.drawable.ic_menu_camera, R.drawable.ic_menu_gallery));
        mCampaignList.add(new CampaignListElements("John Doe4", "@John_Doe4", "SAMPLE TEXT", R.drawable.ic_menu_camera, R.drawable.ic_menu_gallery));
        mCampaignList.add(new CampaignListElements("John Doe5", "@John_Doe5", "SAMPLE TEXT", R.drawable.ic_menu_camera, R.drawable.ic_menu_gallery));

        adapter = new CampaignListAdapter(getContext(), mCampaignList);
        campaignListView.setAdapter(adapter);

        campaignListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                //insert code leading to info/donation page
                Toast.makeText(getContext(), "Clicked product id =" + view.getTag(), Toast.LENGTH_SHORT).show();
            }
        });
        return myView;
    }
}

