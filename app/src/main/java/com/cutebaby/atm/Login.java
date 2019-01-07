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
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private String username;
    private String password;
    private EditText edname;
    private EditText edpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        讀取資料
        String name =getSharedPreferences("atm",MODE_PRIVATE)
                .getString("USERID","");
//        EditText edname = findViewById(R.id.ed_name);
      findView();
        edname.setText(name);
    }
    public void login(View view){
        findView();
        username = edname.getText().toString();
        password = edpassword.getText().toString();
        if("cutebaby".equals(username)&& "love0420".equals(password) ){
            setResult(RESULT_OK);
//            登入成功後，儲存資料
//            SharedPreferences setting = getSharedPreferences("atm",MODE_PRIVATE);
//            setting.edit().putString("USERID",username).apply();
            getSharedPreferences("atm",MODE_PRIVATE)
                    .edit()
                    .putString("USERID", username)
                    .apply();
            finish();
        }else{
            new AlertDialog.Builder(this).setMessage("登入失 敗")
                    .setTitle("error")
                    .setPositiveButton("OK",null)
//                    .setNegativeButton("Clear", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            edname.setText("");
//                            edpassword.setText("");
//                        }
//                    })
        .show();

        }



    }

    private void findView() {
        edname = findViewById(R.id.ed_name);
        edpassword = findViewById(R.id.ed_password);
    }

}
