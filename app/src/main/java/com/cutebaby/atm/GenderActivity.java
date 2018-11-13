package com.cutebaby.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

    }
    public void gender(View view){
        EditText edgender = findViewById(R.id.ed_gender);
        String gender = edgender.getText().toString();
        getSharedPreferences("userGender",MODE_PRIVATE)
                .edit()
                .putString("AGE",gender)
                .apply();
        Intent main = new Intent(this,MainActivity.class);
        startActivity(main);
    }
}
