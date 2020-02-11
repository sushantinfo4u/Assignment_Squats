package com.squats.assignment.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

import com.squats.assignment.Activity.API.ApiClient;
import com.squats.assignment.Activity.API.Model.PostDetails;
import com.squats.assignment.Activity.API.Model.Posts;
import com.squats.assignment.Activity.API.Model.ServerResponse;
import com.squats.assignment.Activity.API.RetroInterface;
import com.squats.assignment.Activity.MVVM.UserListModel;
import com.squats.assignment.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private UserListModel mViewModel;
    private ExpandableListView listView;
    private List<String> listDataHeader;
    private HashMap<String, List<PostDetails>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle(getString(R.string.home));

        listDataHeader=new ArrayList<>();
        listDataChild=new HashMap<>();

//        Articles,Posts,Recipes

        listDataHeader.add("Posts");
        listDataHeader.add("Recipes");
        listDataHeader.add("Articles");

        listView=findViewById(R.id.listView);


        progressDialog=new ProgressDialog(this);
        progressDialog.show();
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Please wait....");


        apicalll();

//         view model observer owner

/*        mViewModel = ViewModelProviders.of(this).get(UserListModel.class);
        mViewModel.init();
        mViewModel.getUserList().observe(this, new Observer<ServerResponse>() {
            @Override
            public void onChanged(@Nullable ServerResponse apiResponse) {

                Log.i("test","observer called");
                setDataToView(apiResponse);
             }
        });*/

    }

    private void setDataToView(ServerResponse apiResponse) {

        List<Posts> postList=apiResponse.getResultData().getInnerData().getPostsArrayList();

        if (postList!=null&&postList.size()>0){

            for(int i=0;i<postList.size();i++){
                for(int j=0;j<postList.get(i).getPostDetailsArrayList().size();j++){

                    listDataChild.put(postList.get(i).getValue(),postList.get(i).getPostDetailsArrayList());
                }
            }
        }

        ExpandableAdapter listAdapter=new ExpandableAdapter(getApplicationContext(),listDataHeader,listDataChild);
        listView.setAdapter(listAdapter);

    }

    private void apicalll() {

        RetroInterface apiService = ApiClient.getClient().create(RetroInterface.class);

        Call<ServerResponse>  responseCall=apiService.getUserList();
        responseCall.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {

                progressDialog.dismiss();

                setDataToView(response.body());

                Log.i("test","Success : "+response.body().getResultData().getInnerData().getPostsArrayList().size());
                    Log.i("test","Success : "+response.body().getResultData().getInnerData().getUser().getUserDetailsArrayList().size());

            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {

                progressDialog.dismiss();

                Log.i("test","error "+t.getMessage());
            }
        });




    }
}
