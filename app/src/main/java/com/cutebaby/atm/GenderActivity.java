package com.cutebaby.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GenderActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

    }
    public void gender(View view){
        EditText edgender = findViewById(R.id.ed_gender);
        String gender = edgender.getText().toString();
//        getSharedPreferences("userGender",MODE_PRIVATE)
//                .edit()
//                .putString("GENDER",gender)
//                .apply();
        user.setGender(gender);
        data.add(gender);
        Intent main = new Intent(this,MainActivity.class);
        setResult(RESULT_OK);
        main.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(main);
    }
    public void backgender(View view){
        Intent age = new Intent(this,AgeActivity.class);
        startActivity(age);
    }

}
