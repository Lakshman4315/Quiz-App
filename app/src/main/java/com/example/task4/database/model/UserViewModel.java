package com.example.task4.database.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private final UserRepository userRepository;

    private LiveData<List<Model>> mAllData;

    private List<Model> userData;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        mAllData = userRepository.getAllData();
    }

    LiveData<List<Model>> getAllData(){
        return mAllData;
    }

    public void insert(Model data){
        userRepository.insert(data);
    }

}
