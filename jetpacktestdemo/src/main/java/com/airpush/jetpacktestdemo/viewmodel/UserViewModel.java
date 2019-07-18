package com.airpush.jetpacktestdemo.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.airpush.jetpacktestdemo.db.UserRepository;
import com.airpush.jetpacktestdemo.model.User;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;

    public UserViewModel(Application context) {
        super(context);
        userRepository = new UserRepository(context);
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
