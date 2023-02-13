package com.example.task4.database.model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {

    private Dao mDao;
    private LiveData<List<Model>> mAlldata;

    UserRepository(Application application){
        UserDatabase db = UserDatabase.getDatabase(application);
        mDao = db.dao();
        mAlldata = mDao.getAlphabetizedWords();
    }

    LiveData<List<Model>> getAllData(){
        return mAlldata;
    }

    void  insert(Model data){
        UserDatabase.databaseWriteExecutor.execute(() ->
                mDao.insert(data));
    }

}
