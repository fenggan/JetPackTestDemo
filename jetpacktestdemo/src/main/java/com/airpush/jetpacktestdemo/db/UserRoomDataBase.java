package com.airpush.jetpacktestdemo.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.airpush.jetpacktestdemo.model.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserRoomDataBase extends RoomDatabase {
    private static UserRoomDataBase userRoomDataBase;

    public abstract UserDao userDao();

    public static UserRoomDataBase getInstance(Context context) {
        if (userRoomDataBase == null) {
            synchronized (UserRoomDataBase.class) {
                if (userRoomDataBase == null) {
                    userRoomDataBase = Room.databaseBuilder(context.getApplicationContext(), UserRoomDataBase.class, "user_database").build();
                }
            }
        }
        return userRoomDataBase;
    }
}
