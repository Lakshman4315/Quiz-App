package com.example.task4.database.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "user")
public class Model {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "USERNAME")
    String username;

    @ColumnInfo(name = "EMAIL")
    String email;

    @ColumnInfo(name = "PASSWORD")
    String password;

    public Model(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
