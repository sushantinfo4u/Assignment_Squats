package com.squats.assignment.Activity.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.squats.assignment.Activity.API.Model.PostDetails;
import com.squats.assignment.Activity.API.Model.Posts;

import java.util.List;

@Dao
public interface UserDao {

/*

    @Query("SELECT * FROM     @ColumnInfo(name=\"value\")\n")
    List<PostDetails> getAllPostDetails();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<PostDetails> postDetailsList);

*/

    @Query("SELECT * FROM UserPostInfo")
    List<Posts> getAllPostDetails();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(List<Posts> postDetailsList);

}
