package com.cutebaby.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final int RC_LOGIN = 100;
    boolean login = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!login){
            Intent intent = new Intent(this,Login.class);
            startActivityForResult(intent,RC_LOGIN);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_LOGIN){
            if (resultCode != RESULT_OK) {
                finish();
            }else{
                login=true;
                String nickname = getSharedPreferences("userName",MODE_PRIVATE)
                        .getString("NICKNAME",null);
                int age  = getSharedPreferences("userAge",MODE_PRIVATE)
                        .getInt("AGE",0);
                String gender = getSharedPreferences("userGender",MODE_PRIVATE)
                        .getString("GENDER",null);
                if(nickname == null || age ==0 || gender==null){
                    Intent nick = new Intent(this,NicknameActivity.class);
                    startActivity(nick);
                }

////                TODO:check name,age,gender
//                Intent nick = new Intent(this,NicknameActivity.class);
//                startActivity(nick);
            }


        }
    }
}
