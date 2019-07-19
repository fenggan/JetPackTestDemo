package com.airpush.jetpacktestdemo.repository;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import com.airpush.jetpacktestdemo.db.UserDao;
import com.airpush.jetpacktestdemo.db.UserRoomDataBase;
import com.airpush.jetpacktestdemo.model.User;

import java.util.List;

public class UserDataSource extends PositionalDataSource {

    private UserDao userDao;

    UserDataSource(Application application) {
        userDao = UserRoomDataBase.getInstance(application.getApplicationContext()).userDao();
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback callback) {
        callback.onResult(getAllData(), 0, getAllData().size());
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback callback) {
        callback.onResult(getAllData());
    }

    public List<User> getAllData() {
        return userDao.getAllData();
    }
}
