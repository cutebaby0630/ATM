package com.cutebaby.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NicknameActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
    }
    public void name(View view){
        EditText edname = findViewById(R.id.ed_name);
        String username = edname.getText().toString();
        getSharedPreferences("userName",MODE_PRIVATE)
                .edit()
                .putString("NICKNAME",username)
                .apply();
        Intent age = new Intent(this,AgeActivity.class);
        startActivity(age);
    }
    public void backname (View view){
        Intent login = new Intent(this,Login.class);
        startActivity(login);
    }

}
