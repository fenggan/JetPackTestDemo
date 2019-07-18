package com.airpush.jetpacktestdemo.db;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.airpush.jetpacktestdemo.model.User;

import java.util.List;

public class UserRepository {
    private UserDao userDao;

    public UserRepository(Application application) {
        userDao = UserRoomDataBase.getInstance(application.getApplicationContext()).userDao();
    }

    public void insert(User user) {
        new InsertAsyncTask(userDao).execute(user);
    }

    public void delete() {
        new DeleteAsyncTask(userDao).execute();
    }

    public LiveData<List<User>> selectAll() {
        return userDao.selectAll();
    }

    private class InsertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao insertDao;

        public InsertAsyncTask(UserDao userDao) {
            this.insertDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            insertDao.insert(users[0]);
            return null;
        }
    }

    private class DeleteAsyncTask extends AsyncTask<Void, Void, Void> {

        private UserDao deleteDao;

        public DeleteAsyncTask(UserDao userDao) {
            this.deleteDao = userDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            deleteDao.deleteAll();
            return null;
        }
    }
}
