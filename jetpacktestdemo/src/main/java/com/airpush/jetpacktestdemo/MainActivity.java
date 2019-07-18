package com.airpush.jetpacktestdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.widget.Toast;

import com.airpush.jetpacktestdemo.lifecycle.MyObserver;
import com.airpush.jetpacktestdemo.model.User;
import com.airpush.jetpacktestdemo.viewmodel.TestViewModel;
import com.airpush.jetpacktestdemo.viewmodel.UserViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLifecycle().addObserver(new MyObserver());
    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.fragment).navigateUp();
    }
}
