package com.airpush.jetpacktestdemo.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.airpush.jetpacktestdemo.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Query("select * from user")
    LiveData<List<User>> selectAll();

    @Query("delete  from user")
    void deleteAll();

    @Update
    void update(User... user);
}
