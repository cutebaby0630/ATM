package com.cutebaby.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AgeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
    }
    public void age(View view){
        EditText edage = findViewById(R.id.ed_age);
        int age = Integer.parseInt(edage.getText().toString());
        getSharedPreferences("userAge",MODE_PRIVATE)
                .edit()
                .putInt("AGE",age)
                .apply();
        Intent gender = new Intent(this,GenderActivity.class);
        startActivity(gender);
    }
    public void backage(View view){
        Intent nickname = new Intent(this,NicknameActivity.class);
        startActivity(nickname);
    }
}
