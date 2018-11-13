package com.cutebaby.atm;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
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
        final EditText edname = findViewById(R.id.ed_name);
        final EditText edpassword = findViewById(R.id.ed_password);
        String username = edname.getText().toString();
        String password = edpassword.getText().toString();
        if("cutebaby".equals(username)&& "love0420".equals(password) ){
            setResult(RESULT_OK);
//            登入成功後，儲存資料
//            SharedPreferences setting = getSharedPreferences("atm",MODE_PRIVATE);
//            setting.edit().putString("USERID",username).apply();
            getSharedPreferences("atm",MODE_PRIVATE)
                    .edit()
                    .putString("USERID",username)
                    .apply();
            finish();
        }else{
            new AlertDialog.Builder(this).setMessage("登入失敗")
                    .setTitle("error")
                    .setPositiveButton("OK",null)
                    .setNegativeButton("Clear", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            edname.setText("");
                            edpassword.setText("");
                        }
                    }).show();

        }



    }

}
