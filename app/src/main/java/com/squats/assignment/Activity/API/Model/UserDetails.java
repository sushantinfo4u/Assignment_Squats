package com.squats.assignment.Activity.API.Model;

import com.google.gson.annotations.SerializedName;

public class UserDetails {

    @SerializedName("username")
    private String username;
    @SerializedName("user_id")
    private String user_id;
    @SerializedName("profile_picture")
    private String profile_picture;
    @SerializedName("name")
    private String name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
