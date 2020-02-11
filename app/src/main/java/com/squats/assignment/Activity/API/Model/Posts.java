package com.squats.assignment.Activity.API.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Posts {

    @SerializedName("key")
    private String key;

    @SerializedName("value")
    private String value;

    @SerializedName("list")
    private ArrayList<PostDetails> postDetailsArrayList;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ArrayList<PostDetails> getPostDetailsArrayList() {
        return postDetailsArrayList;
    }

    public void setPostDetailsArrayList(ArrayList<PostDetails> postDetailsArrayList) {
        this.postDetailsArrayList = postDetailsArrayList;
    }
}


