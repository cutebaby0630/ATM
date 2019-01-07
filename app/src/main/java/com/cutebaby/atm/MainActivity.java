package com.cutebaby.atm;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
         RecyclerView recycler = findViewById(R.id.recycler_main);
                recycler.setHasFixedSize(true);
                recycler.setLayoutManager(new LinearLayoutManager(this));
                recycler.setAdapter(new MainAdapter());



    }
    class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

        @Override
        public void onBindViewHolder(@NonNull final MainActivity.MainAdapter.MainViewHolder holder, final int position) {
            holder.maintext.setText(data.get(position)+"");
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.age_row,parent,false);
            return new MainViewHolder(view);
        }

        class MainViewHolder extends RecyclerView.ViewHolder{
                    TextView maintext;
                    public MainViewHolder(View itemView){
                        super(itemView);
                        maintext = itemView.findViewById(R.id.row_age);

                    }
                }
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
