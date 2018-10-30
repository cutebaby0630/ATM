package com.cutebaby.atm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login(View view){
        EditText edname = findViewById(R.id.ed_name);
        EditText edpassword = findViewById(R.id.ed_password);
        String username = edname.getText().toString();
        String password = edpassword.getText().toString();
        if("cutebaby".equals(username)&& "love0420".equals(password) ){
            setResult(RESULT_OK);
            finish();
        }



    }

}
