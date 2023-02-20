package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.task4.database.model.Dao;
import com.example.task4.database.model.Model;
import com.example.task4.database.model.UserDatabase;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameView , emailView , passwordView;
    private Button registerButton;
    private TextView loginTv;
    Dao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        dao = UserDatabase.getDatabase(this).dao();

        loginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void init(){
        usernameView = findViewById(R.id.usernameEditTextRegister);
        emailView = findViewById(R.id.emailEditTextRegister);
        passwordView = findViewById(R.id.passwordEditTextRegister);
        registerButton = findViewById(R.id.Register);
        loginTv = findViewById(R.id.loginTextRegister);
    }

    public void RegisterListener(View view) {

        String userName = usernameView.getText().toString();
        String Email = emailView.getText().toString();
        String pass = passwordView.getText().toString();

        if(userName.equals("") || Email.equals("") || pass.equals("")){
            Toast.makeText(RegisterActivity.this,"Please Fill All Information",Toast.LENGTH_SHORT).show();
        }else{
            if(Patterns.EMAIL_ADDRESS.matcher(Email).matches()){

                if(!dao.emailValidate(Email)) {
                    if (pass.length() >= 8) {
                        dao.insert(new Model(userName, Email, pass));
                        startActivity(new Intent(RegisterActivity.this, AvatarActivity.class));
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Password Length Must Be Greater Than 8", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegisterActivity.this,"Email Already Exists",Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(RegisterActivity.this,"Please Enter Valid Email",Toast.LENGTH_SHORT).show();
            }
        }
    }
}

