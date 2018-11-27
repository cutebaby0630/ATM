package com.cutebaby.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {
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
//        listView
//                listView();
//                RecyclerView
    }

    private void listView() {
        List<String> fruits = Arrays.asList("蘋果","芭樂","香蕉");
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fruits);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_LOGIN){
            if (resultCode != RESULT_OK) {
                finish();
            }else{
//                login=true;
//                String nickname = getSharedPreferences("userName",MODE_PRIVATE)
//                        .getString("NICKNAME",null);
//                int age  = getSharedPreferences("userAge",MODE_PRIVATE)
//                        .getInt("AGE",0);
//                String gender = getSharedPreferences("userGender",MODE_PRIVATE)
//                        .getString("GENDER",null);
                if(!user.isVaild()){
                    Intent nickname= new Intent(this,NicknameActivity.class);
                    startActivity(nickname);
                }

////                TODO:check name,age,gender
//                Intent nick = new Intent(this,NicknameActivity.class);
//                startActivity(nick);
            }


        }
    }
}
