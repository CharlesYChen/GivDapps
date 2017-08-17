package com.givdapps.androidapp;

public class CampaignListElements {

    private String header_name;
    private String header_tag_name;
    private String header_text;
    private int profile_image;
    private int content_image;

    public CampaignListElements(String header_name, String header_tag_name, String header_text, int profile_image, int content_image) {
        this.header_name = header_name;
        this.header_tag_name = header_tag_name;
        this.header_text = header_text;
        this.profile_image = profile_image;
        this.content_image = content_image;
    }

    public String getHeader_Name() {
        return header_name;
    }

    public void setHeader_Name(String header_name) {
        this.header_name = header_name;
    }

    public String getHeader_tag_name() {
        return header_tag_name;
    }

    public void setHeader_tag_name(String header_tag_name) {
        this.header_tag_name = header_tag_name;
    }

    public String getHeader_text() {
        return header_text;
    }

    public void setHeader_text(String cause_text) {
        this.header_text = cause_text;
    }

    public int getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(int profile_picture) {
        this.profile_image = profile_picture;
    }

    public int getContent_image() {
        return content_image;
    }

    public void setContent_image(int cause_image) {
        this.content_image = cause_image;
    }
}
