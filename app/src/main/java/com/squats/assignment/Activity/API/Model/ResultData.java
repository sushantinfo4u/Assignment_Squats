package com.squats.assignment.Activity.API.Model;

import com.google.gson.annotations.SerializedName;

public class ResultData {

    @SerializedName("data")
    private InnerData innerData;

    public InnerData getInnerData() {
        return innerData;
    }

    public void setInnerData(InnerData innerData) {
        this.innerData = innerData;
    }
}
