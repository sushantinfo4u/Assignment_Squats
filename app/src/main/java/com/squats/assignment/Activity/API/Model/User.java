package com.squats.assignment.Activity.API.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class User {

    @SerializedName("list")
    private ArrayList<UserDetails> userDetailsArrayList;

    @SerializedName("value")
    private String value;

    @SerializedName("key")
    private String key;

    public ArrayList<UserDetails> getUserDetailsArrayList() {
        return userDetailsArrayList;
    }

    public void setUserDetailsArrayList(ArrayList<UserDetails> userDetailsArrayList) {
        this.userDetailsArrayList = userDetailsArrayList;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
