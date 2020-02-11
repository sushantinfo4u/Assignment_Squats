package com.squats.assignment.Activity.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.squats.assignment.Activity.API.Model.PostDetails;

@Database(entities = PostDetails.class,version = 1)
public abstract class UserDatabase extends RoomDatabase {

    private static UserDatabase userDatabaseInsance;
    private static final String DB_NAME="user.db";





}
