package com.airpush.jetpacktestdemo.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.airpush.jetpacktestdemo.R;
import com.airpush.jetpacktestdemo.model.User;
import com.airpush.jetpacktestdemo.viewmodel.UserViewModel;

public class FragmentTwo extends Fragment {
    private Button btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        btn = view.findViewById(R.id.btn_two);
        String text = getArguments().getString("aaa");
        if (!"".equals(text)) {
            btn.setText(text);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(getView()).navigate(R.id.action_three);
            }
        });
        return view;
    }
}