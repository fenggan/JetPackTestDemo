package com.airpush.jetpacktestdemo.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.airpush.jetpacktestdemo.db.UserRepository;
import com.airpush.jetpacktestdemo.model.User;
import com.airpush.jetpacktestdemo.repository.UserDataSourceFactory;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private LiveData<PagedList<User>> mutableLiveData;

    public UserViewModel(Application context) {
        super(context);
        userRepository = new UserRepository(context);
        DataSource.Factory factory = new UserDataSourceFactory(context);
        DataSource dataSource = factory.create();
        mutableLiveData = new LivePagedListBuilder<>(factory, 20).build();

    }

    public LiveData<PagedList<User>> get() {
        return mutableLiveData;
    }

    public LiveData<List<User>> getLiveData() {
        return selectAll();
    }

    public void insert(final User users) {
        userRepository.insert(users);
    }

    public LiveData<List<User>> selectAll() {
        return userRepository.selectAll();
    }

    public void update(User... user) {

    }

    public void deleteAll() {
        userRepository.delete();
    }
}
