package com.squats.assignment.Activity.API.Model;

import com.google.gson.annotations.SerializedName;

public class ServerResponse {

    @SerializedName("result")
    private ResultData resultData;

    @SerializedName("status")
    private String status;

    public ResultData getResultData() {
        return resultData;
    }

    public void setResultData(ResultData resultData) {
        this.resultData = resultData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
