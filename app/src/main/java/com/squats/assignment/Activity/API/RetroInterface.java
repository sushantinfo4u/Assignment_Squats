package com.squats.assignment.Activity.API;

import com.squats.assignment.Activity.API.Model.ServerResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroInterface {

    @GET("dqjqk")
    Call<ServerResponse> getUserList();
}
