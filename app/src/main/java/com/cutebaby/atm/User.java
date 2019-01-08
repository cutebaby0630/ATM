package com.cutebaby.atm;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

public class User {
    private Context context;
    String id;
    String nickname;
    String gender;
    int age;
    boolean vaild = false;
    SharedPreferences settings;
    ArrayList<String> data = new ArrayList<>();

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }



    public User (Context context){
        this.context= context;
        settings = context.getSharedPreferences("user",Context.MODE_PRIVATE);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        if(nickname ==null){
            nickname = settings.getString("NICKNAME",null);
        }
        return nickname;
    }

    public void setNickname(String nickname) {
        data.add(nickname);
        settings.edit()
                .putString("NICKNAME",nickname)
                .apply();

        this.nickname = nickname;
    }

    public String getGender() {
        if(gender == null ){
            gender = settings.getString("GENDER",null);
        }
        return gender;
    }

    public void setGender(String gender) {
        data.add(gender);
        settings.edit()
                .putString("GENDER",gender)
                .apply();
        this.gender = gender;
    }

    public int getAge() {
        if(age ==0){
            age = settings.getInt("AGE",0);
        }
        return age;
    }

    public void setAge(int age) {
        data.add(age+"");
        settings.edit()
                .putInt("AGE",age)
                .apply();
        this.age = age;
    }

    public boolean isVaild() {
        vaild =  getNickname() != null && getGender()!= null && getAge()!=0;
        return vaild;
    }


}
