package com.airpush.jetpacktestdemo.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

public class MyObserver implements DefaultLifecycleObserver {

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {

    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        owner.getLifecycle().removeObserver(this);
    }
}
