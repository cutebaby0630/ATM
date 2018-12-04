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
    List<String> fruits = Arrays.asList("蘋果","芭樂","香蕉");
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
                RecyclerView recyclerView = findViewById(R.id.recycler);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new MainAdapter());

    }
    class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(android.R.layout.simple_list_item_1,parent,false);

            return new MainViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return fruits.size();
        }

        class MainViewHolder extends RecyclerView.ViewHolder{
                    TextView nametext;
                    public MainViewHolder(View itemView) {
                        super(itemView);
                        nametext = itemView.findViewById(R.id.recycler);
                    }
                }
    }

    private void listView() {
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
