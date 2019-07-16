package com.airpush.jetpacktestdemo.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TestViewModel extends ViewModel {
    private MutableLiveData<String> data = new MutableLiveData<>();

    public MutableLiveData<String> getData() {

        return data;
    }
}
