package com.airpush.jetpacktestdemo.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.airpush.jetpacktestdemo.R;
import com.airpush.jetpacktestdemo.model.User;
import com.airpush.jetpacktestdemo.viewmodel.UserViewModel;

import java.util.List;

public class FragmentOne extends Fragment {
    private Button btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        insert(userViewModel);
        btn = view.findViewById(R.id.btn_one);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("aaa", "111");
                Navigation.findNavController(getView()).navigate(R.id.action_two, bundle);
            }
        });
        return view;
    }

    private void insert(UserViewModel userViewModel) {
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setName("a"+i);
            user.setAge(18);
            userViewModel.insert(user);
        }
    }
}