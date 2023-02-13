package com.example.task4.database.model;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Query("SELECT * from user ORDER BY USERNAME ASC")
    LiveData<List<Model>> getAlphabetizedWords();

    @Query("SELECT Exists (Select * from user where EMAIL=:email)")
    boolean emailValidate(String email);

    @Query("SELECT Exists (Select * from user where EMAIL=:email and PASSWORD =:password )")
    boolean login(String email, String password);

    @Query("Select * from user where EMAIL =:email")
    Model getUserData(String email);

    @Query("UPDATE user SET USERNAME =:username where EMAIL =:email")
    void updateUser(String email,String username);

    @Query("UPDATE user SET Email =:newEmail where EMAIL =:oldEmail")
    void updateUserEmail(String oldEmail,String newEmail);

    @Query("UPDATE user SET PASSWORD =:pass where EMAIL =:oldEmail")
    void updateUserPass(String oldEmail,String pass);

    @Insert
    void insert(Model data);

    @Update
    void update(Model data);

    @Delete
    void delete(Model data);

    @Query("DELETE From user")
    void deleteAll();
}
