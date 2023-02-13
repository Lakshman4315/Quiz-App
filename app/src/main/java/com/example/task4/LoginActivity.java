package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.task4.database.model.Dao;
import com.example.task4.database.model.UserDatabase;

public class LoginActivity extends AppCompatActivity {

    private EditText emailView,passwordView;
    private Button loginButton;
    private TextView registerTv;
    private Dao dao;


    public Boolean succesfulLogin=true;
    public static String sharedPrefFile = "com.example.android.firstProject";
    private SharedPreferences myPreferences;
    static final String LOGGED_IN = "loggedIn";
    public static String userSharedPrefFile = "USER_DATA_FILE";
    private SharedPreferences userPreferences;
    String userEmail="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        if(myPreferences.getBoolean(LOGGED_IN, false)){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            updateLoginSharedCache();
            finish();
        }

        userPreferences = getSharedPreferences(userSharedPrefFile, MODE_PRIVATE);

        init();

//        UserDatabase user
        dao = UserDatabase.getDatabase(LoginActivity.this).dao();

        loginButton.setOnClickListener(view -> {
            String Email = emailView.getText().toString();
            String pass = passwordView.getText().toString();

            if(Email.equals("") || pass.equals("")){
                Toast.makeText(LoginActivity.this,"Please Fill All Information",Toast.LENGTH_SHORT).show();
            }else{
                if(Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
//                    if(dao.emailValidate(Email)){
                    if(dao.login(Email,pass)){
                        Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT).show();

                        succesfulLogin = true;
                        updateLoginSharedCache();
                        userEmail = Email;
                        userLoginSharedCache();
                        startActivity(new Intent(this, MainActivity.class));
                        finish();
                    }else{
                        Toast.makeText(this,"Email or Password is incorrect",Toast.LENGTH_SHORT).show();

                        succesfulLogin = false;
                        updateLoginSharedCache();
                    }
//                    }else{
//                        Toast.makeText(this,"Email does not exists",Toast.LENGTH_SHORT).show();
//                    }
                }else{
                    Toast.makeText(this,"Please Enter Valid Email",Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerTv.setOnClickListener(view -> {
            Intent registerIntent = new Intent(this, RegisterActivity.class);
            startActivity(registerIntent);
        });
    }

    void init(){
        emailView = findViewById(R.id.emailEditText);
        passwordView = findViewById(R.id.passwordEditText);
        registerTv = findViewById(R.id.registerText);
        loginButton = findViewById(R.id.loginButton);
    }

    private void updateLoginSharedCache(){
        SharedPreferences.Editor preferencesEditor = myPreferences.edit();
        preferencesEditor.putBoolean(LOGGED_IN, succesfulLogin);
        preferencesEditor.apply();
    }

    private void userLoginSharedCache(){
        SharedPreferences.Editor userPreferencesEditor = userPreferences.edit();
        userPreferencesEditor.putString("USER_EMAIL",userEmail);
        userPreferencesEditor.apply();
    }

}