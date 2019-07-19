package com.airpush.jetpacktestdemo.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airpush.jetpacktestdemo.R;
import com.airpush.jetpacktestdemo.adapter.UserAdapter;
import com.airpush.jetpacktestdemo.model.User;
import com.airpush.jetpacktestdemo.viewmodel.UserViewModel;

public class FragmentThree extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        final UserAdapter adapter = new UserAdapter();
        recyclerView.setAdapter(adapter);
        userViewModel.get().observe(this, new Observer<PagedList<User>>() {
            @Override
            public void onChanged(PagedList<User> users) {
                adapter.submitList(users);
            }
        });
    }
}
