package com.squats.assignment.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.Toast;
import com.squats.assignment.Activity.API.Model.PostDetails;
import com.squats.assignment.Activity.API.Model.Posts;
import com.squats.assignment.Activity.API.Model.ServerResponse;
import com.squats.assignment.Activity.MVVM.UserListModel;
import com.squats.assignment.Activity.Room.DatabaseClient;
import com.squats.assignment.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private UserListModel mViewModel;
    private ExpandableListView listView;
    private List<String> listDataHeader;
    private HashMap<String, List<PostDetails>> listDataChild;
    private List<Posts> listFromRoom;
    private List<Posts> listFromAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setTitle(getString(R.string.home));

        listDataHeader=new ArrayList<>();
        listDataChild=new HashMap<>();
        listFromRoom =new ArrayList<>();
        listFromAPI =new ArrayList<>();

        listDataHeader.add("Posts");
        listDataHeader.add("Recipes");
        listDataHeader.add("Articles");

        listView=findViewById(R.id.listView);

        new GetDataFromRoom().execute();

    }


    class GetDataFromRoom extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog=new ProgressDialog(HomeActivity.this);
            progressDialog.show();
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Please wait....");
        }

        @Override
        protected Void doInBackground(Void... voids) {

            listFromRoom =DatabaseClient.getInstance(getApplicationContext()).getUserDatabase().userDao().getAllPostDetails();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            progressDialog.dismiss();

            if(listFromRoom!=null&&listFromRoom.size()>0){
                Toast.makeText(getApplicationContext(), "ROOM DB....", Toast.LENGTH_SHORT).show();
                setDataToView(null);
            }else {

                Toast.makeText(getApplicationContext(), "API CALL....", Toast.LENGTH_SHORT).show();

                mViewModel = ViewModelProviders.of(HomeActivity.this).get(UserListModel.class);
                mViewModel.init();
                mViewModel.getUserList().observe(HomeActivity.this, new Observer<ServerResponse>() {
                    @Override
                    public void onChanged(@Nullable ServerResponse apiResponse) {

                        setDataToView(apiResponse);
                    }
                });

            }

         }
    }

    class SaveDataToRoom extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {

            try{
                Log.i("test"," data to room "+ listFromAPI.size());
                DatabaseClient.getInstance(getApplicationContext()).getUserDatabase().userDao().insert(listFromAPI);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            Log.i("test","data from  API "+listFromAPI.size());

//            Toast.makeText(HomeActivity.this, "Data is saved into database", Toast.LENGTH_SHORT).show();
        }
    }

    private void setDataToView(ServerResponse apiResponse) {

                if(apiResponse!=null){
                      listFromAPI =apiResponse.getResultData().getInnerData().getPostsArrayList();

                    if (listFromAPI !=null&& listFromAPI.size()>0){

                        Log.i("test"," data from API "+listFromAPI.size());

                        for(int i = 0; i< listFromAPI.size(); i++){
                            for(int j = 0; j< listFromAPI.get(i).getPostDetailsArrayList().size(); j++){

//                                listFromRoom.add(listFromAPI.get(i).getPostDetailsArrayList().get(j));
                                listDataChild.put(listFromAPI.get(i).getValue(), listFromAPI.get(i).getPostDetailsArrayList());
                            }
                        }
                        new SaveDataToRoom().execute();
                    }
                }else {

                    Log.i("test"," data from Room : "+listFromRoom.size());

                    if(listFromRoom!=null&&listFromRoom.size()>0){

                            for(int i = 0; i< listFromRoom.size(); i++){
                                for(int j = 0; j< listFromRoom.get(i).getPostDetailsArrayList().size(); j++){

                                    listDataChild.put(listFromRoom.get(i).getValue(), listFromRoom.get(i).getPostDetailsArrayList());
                                }
                            }

                        }
                }


        ExpandableAdapter listAdapter=new ExpandableAdapter(getApplicationContext(),listDataHeader,listDataChild);
        listView.setAdapter(listAdapter);

    }

//    private void apicalll() {
//
//        RetroInterface apiService = ApiClient.getClient().create(RetroInterface.class);
//
//        Call<ServerResponse>  responseCall=apiService.getUserList();
//        responseCall.enqueue(new Callback<ServerResponse>() {
//            @Override
//            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
//
//                progressDialog.dismiss();
//
//                setDataToView(response.body());
//
//                Log.i("test","Success : "+response.body().getResultData().getInnerData().getPostsArrayList().size());
//                    Log.i("test","Success : "+response.body().getResultData().getInnerData().getUser().getUserDetailsArrayList().size());
//
//            }
//
//            @Override
//            public void onFailure(Call<ServerResponse> call, Throwable t) {
//
//                progressDialog.dismiss();
//
//                Log.i("test","error "+t.getMessage());
//            }
//        });
//
//
//    }
}
