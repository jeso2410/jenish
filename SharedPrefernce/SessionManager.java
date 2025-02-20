package com.radhey.firebasedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class SessionManager
{
    Context context;
    SharedPreferences sharedPreferences;
    private final String PREF_FILE_NAME = "shop";
    private final int PRIVATE_MODE = 0;
    SharedPreferences.Editor editor;

    public SessionManager(Context context)
    {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME,PRIVATE_MODE);
         editor = sharedPreferences.edit();
    }
    public Boolean checkSession(){
        if (sharedPreferences.contains("login")){
             return true;
        }
        else {
            return false;
        }
    }
    public void createSession(String name,String email, String number){

        editor.putString("name",name);
        editor.putString("email",email);
        editor.putString("number",number);
        editor.putBoolean("login",false);
        editor.commit();

    }

    public String getSessionDetails(String key){
        String value = sharedPreferences.getString(key,null);
        return value;
    }

    public void logOut(){
        editor.clear();
        editor.commit();
        //editor.remove("name");

        Intent intent = new Intent(context,LoginActivity.class);
        context.startActivity(intent);
    }
}
