package com.squats.assignment.Activity.MVVM;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.squats.assignment.Activity.API.Model.ServerResponse;

public class UserListModel extends ViewModel {

    private MutableLiveData<ServerResponse> data;
    private UserRepository movieModel;

    public UserListModel() {
        movieModel = new UserRepository();
    }

    public void init() {
        if (this.data != null) {
            // ViewModel is created per Fragment so
            // we know the userId won't change
            return;
        }
        data = movieModel.getApiResponse();
    }

    public MutableLiveData<ServerResponse> getUserList() {
        return this.data;
    }

}
