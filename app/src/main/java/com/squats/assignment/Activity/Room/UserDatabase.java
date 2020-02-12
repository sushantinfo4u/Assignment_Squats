package com.squats.assignment.Activity.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.squats.assignment.Activity.API.Model.Posts;

@Database(entities = Posts.class,version = 1,exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    private static UserDatabase userDatabaseInsance;
    public abstract UserDao userDao();

}
