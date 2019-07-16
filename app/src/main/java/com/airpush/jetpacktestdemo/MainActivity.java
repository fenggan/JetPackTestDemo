package com.airpush.jetpacktestdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.airpush.jetpacktestdemo.lifecycle.MyObserver;
import com.airpush.jetpacktestdemo.viewmodel.TestViewModel;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
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
        editText = findViewById(R.id.et);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                testViewModel.getData().postValue(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
