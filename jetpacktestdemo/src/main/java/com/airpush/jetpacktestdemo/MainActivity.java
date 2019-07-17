package com.airpush.jetpacktestdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.widget.Toast;

import com.airpush.jetpacktestdemo.lifecycle.MyObserver;
import com.airpush.jetpacktestdemo.viewmodel.TestViewModel;

public class MainActivity extends AppCompatActivity {
    private TestViewModel testViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLifecycle().addObserver(new MyObserver());
        testViewModel = ViewModelProviders.of(this).get(TestViewModel.class);
        testViewModel.getData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.fragment).navigateUp();
    }
}
