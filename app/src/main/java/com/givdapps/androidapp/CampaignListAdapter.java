package com.givdapps.androidapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class CampaignListAdapter extends BaseAdapter{

    private Context mContext;
    public List<CampaignListElements> mCampaignList;

    public CampaignListAdapter(Context mContext, List<CampaignListElements> mCampaignList) {
        this.mContext = mContext;
        this.mCampaignList = mCampaignList;
    }

    @Override
    public int getCount() {
        return mCampaignList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCampaignList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.campaign_row, null);

        TextView name = (TextView) v.findViewById(R.id.header_name);
        TextView tag_name = (TextView) v.findViewById(R.id.header_tag_name);
        TextView header_text = (TextView) v.findViewById(R.id.header_text);
        ImageView profile_image = (ImageView) v.findViewById(R.id.profile_image);
        ImageView content_image = (ImageView) v.findViewById(R.id.content_image);

        name.setText(mCampaignList.get(position).getHeader_Name());
        tag_name.setText(mCampaignList.get(position).getHeader_tag_name());
        header_text.setText(mCampaignList.get(position).getHeader_text());
        profile_image.setImageResource(mCampaignList.get(position).getProfile_image());
        content_image.setImageResource(mCampaignList.get(position).getContent_image());

        v.setTag(mCampaignList.get(position).getHeader_tag_name());
        return v;
    }
}