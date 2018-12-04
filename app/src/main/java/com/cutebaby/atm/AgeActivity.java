package com.cutebaby.atm;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class AgeActivity extends BaseActivity {

    int[] nums = {19,20,21,22,23,24};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);
//RecyclerView
        RecyclerView recyclerView = findViewById(R.id.age_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AgeAdapter());
    }
//必須寫完VuewHolder再做繼承
    class AgeAdapter extends RecyclerView.Adapter<AgeAdapter.AgeViewHolder>{

    @NonNull
    @Override
    public AgeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = getLayoutInflater().inflate(R.layout.age_row,parent,false);
        return new AgeViewHolder(view);
    }
//    要不要顯示
    @Override
    public void onBindViewHolder(@NonNull AgeViewHolder holder, int position) {
        holder.agetext.setText(nums[position]+"");
        if(nums[position]==19){
            holder.agetext.setTextColor(Color.RED);
        }
    }
//
    @Override
    public int getItemCount() {
        return nums.length;
    }

    //        建立layout拉元件定id→在ViewHolder類別中建立屬性(配合layout元件)→建構子中使用itemView.findViewById
        class AgeViewHolder extends RecyclerView.ViewHolder{
            TextView agetext;
            public AgeViewHolder(View itemView) {
                super(itemView);
//                不能直接findViewById，要找別人丟進來的TextView
                agetext = itemView.findViewById(R.id.row_age);
            }
        }

    }

    public void age(View view){
        EditText edage = findViewById(R.id.ed_age);
        int age = Integer.parseInt(edage.getText().toString());
//        getSharedPreferences("userAge",MODE_PRIVATE)
//                .edit()
//                .putInt("AGE",age)
//                .apply();
        user.setAge(age);
        Intent gender = new Intent(this,GenderActivity.class);
        startActivity(gender);
    }
    public void backage(View view){
        Intent nickname = new Intent(this,NicknameActivity.class);
        startActivity(nickname);
    }
}
