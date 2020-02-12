package com.squats.assignment.Activity.API.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.squats.assignment.Activity.DataTypeConvertrer;

import java.io.Serializable;

public class PostDetails implements Serializable {

//    @ColumnInfo(name = "title")
    @SerializedName("title")
    private String title;

//    @ColumnInfo(name = "cuisine")
    @SerializedName("cuisine")
    private String cuisine;

//    @ColumnInfo(name = "image_url")
    @SerializedName("image_url")
    private String image_url;

//    @ColumnInfo(name = "recipe_type")
    @SerializedName("recipe_type")
    private String recipe_type;

//    @ColumnInfo(name = "post_id")
    @SerializedName("post_id")
    private String post_id;

//    @ColumnInfo(name = "id")
    @SerializedName("id")
    private String id;

//    @ColumnInfo(name = "user_id")
    @SerializedName("user_id")
    private String user_id;

//    @ColumnInfo(name = "description")
    @SerializedName("description")
    private String description;

//    @ColumnInfo(name = "created_at")
    @SerializedName("created_at")
    private String created_at;

//    @ColumnInfo(name = "group_id")
    @SerializedName("group_id")
    private String group_id;

//    @ColumnInfo(name = "profile_picture")
    @SerializedName("profile_picture")
    private String profile_picture;

//    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String name;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getRecipe_type() {
        return recipe_type;
    }

    public void setRecipe_type(String recipe_type) {
        this.recipe_type = recipe_type;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
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
