package com.radhey.firebasedemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SessionManager sessionManager = new SessionManager(MainActivity.this);
                boolean check = sessionManager.checkSession();

                if (check == true){
                    Intent i = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(i);
                }
            }
        },3000);
    }
}