package com.squats.assignment.Activity.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.squats.assignment.Activity.API.Model.PostDetails;

import java.util.List;

@Dao
public interface UserDao {


    @Query("SELECT * FROM User_Data")
    List<PostDetails> getAllPostDetails();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<PostDetails> postDetailsList);

}
