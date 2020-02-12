package com.squats.assignment.Activity.Room;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {

    private Context context;
    private UserDatabase userDatabase;
    private static DatabaseClient databaseClientInstance;
    private static final String DB_NAME="user.db";


    private DatabaseClient(Context context){
        this.context=context;
        userDatabase= Room.databaseBuilder(context,UserDatabase.class,DB_NAME).build();
    }

    public static synchronized DatabaseClient getInstance(Context context){

            if (databaseClientInstance==null)
                databaseClientInstance=new DatabaseClient(context);
        return databaseClientInstance;
    }


    public UserDatabase getUserDatabase(){
        return userDatabase;
    }

}
