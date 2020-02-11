package com.squats.assignment.Activity.MVVM;

import androidx.lifecycle.MutableLiveData;

import com.squats.assignment.Activity.API.ApiClient;
import com.squats.assignment.Activity.API.Model.PostDetails;
import com.squats.assignment.Activity.API.Model.ServerResponse;
import com.squats.assignment.Activity.API.RetroInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* @class : Interact with the data source remote api or local data source
*
 */
public class UserRepository {

    private RetroInterface apiInterface;

    public UserRepository(){

    }

    public MutableLiveData<ServerResponse> getApiResponse(){

        final MutableLiveData<ServerResponse> liveDataList = new MutableLiveData<>();

        apiInterface = ApiClient.getClient().create(RetroInterface.class);
        Call<ServerResponse> serverResponseCall=apiInterface.getUserList();
        serverResponseCall.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                   liveDataList.setValue(response.body());
                   storeDataToRoom(response.body());
            }
            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {

            }
        });

        return liveDataList;
    }

    private void storeDataToRoom(ServerResponse body) {





    }

}
