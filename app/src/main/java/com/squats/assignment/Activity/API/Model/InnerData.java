package com.squats.assignment.Activity.API.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class InnerData {

    @SerializedName("users")
    private User user;

    @SerializedName("posts")
    private ArrayList<Posts> postsArrayList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Posts> getPostsArrayList() {
        return postsArrayList;
    }

    public void setPostsArrayList(ArrayList<Posts> postsArrayList) {
        this.postsArrayList = postsArrayList;
    }
}
