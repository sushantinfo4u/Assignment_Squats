package com.squats.assignment.Activity.API.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.squats.assignment.Activity.DataTypeConvertrer;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "UserPostInfo")
public class Posts {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int unquique_cosnttaint;

    @ColumnInfo(name="key")
    @SerializedName("key")
    private String key;

    @ColumnInfo(name="value")
    @SerializedName("value")
    private String value;

    @ColumnInfo(name = "ListData")
    @TypeConverters(DataTypeConvertrer.class)
    @SerializedName("list")
    private List<PostDetails> postDetailsArrayList;

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


    public List<PostDetails> getPostDetailsArrayList() {
        return postDetailsArrayList;
    }

    public void setPostDetailsArrayList(List<PostDetails> postDetailsArrayList) {
        this.postDetailsArrayList = postDetailsArrayList;
    }

    public int getUnquique_cosnttaint() {
        return unquique_cosnttaint;
    }

    public void setUnquique_cosnttaint(int unquique_cosnttaint) {
        this.unquique_cosnttaint = unquique_cosnttaint;
    }

}


