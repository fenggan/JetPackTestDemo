package com.airpush.jetpacktestdemo.repository;

import android.app.Application;

import androidx.paging.DataSource;

public class UserDataSourceFactory extends UserDataSource.Factory {

    private Application application;

    public UserDataSourceFactory(Application application) {
        this.application = application;
    }

    @Override
    public DataSource create() {
        UserDataSource userDataSource = new UserDataSource(application);
        return userDataSource;
    }
}
