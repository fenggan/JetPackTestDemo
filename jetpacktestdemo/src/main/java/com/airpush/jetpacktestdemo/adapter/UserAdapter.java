package com.airpush.jetpacktestdemo.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.airpush.jetpacktestdemo.R;
import com.airpush.jetpacktestdemo.model.User;

public class UserAdapter extends PagedListAdapter<User, UserAdapter.MyHolder> {

    public UserAdapter() {
        super(new DiffUtil.ItemCallback<User>() {
            @Override
            public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
                return oldItem.equals(newItem);
            }

            @SuppressLint("DiffUtilEquals")
            @Override
            public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
                return oldItem.equals(newItem);
            }
        });
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_user, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        User user = getItem(position);
        if (user != null) {
            holder.name.setText(user.getName());
            holder.age.setText(user.getAge()+"");
        }
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView age;

        MyHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.user_tv_name);
            age = itemView.findViewById(R.id.user_tv_age);
        }
    }
}
