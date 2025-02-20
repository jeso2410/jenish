package com.radhey.firebasedemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterAcivity extends AppCompatActivity {

    SessionManager sessionManager;
    EditText name,number,email,password;
    Button register,loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register_acivity);

        sessionManager = new SessionManager(this);
        name = findViewById(R.id.edtName);
        number = findViewById(R.id.edtNumber);
        email = findViewById(R.id.edtEmail);
        password = findViewById(R.id.edtPassword);
        register = findViewById(R.id.registerBtn);
        loginBtn = findViewById(R.id.loginButton);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = name.getText().toString();
                String number1 = number.getText().toString();
                String email1 = email.getText().toString();
                String password1 = password.getText().toString();

                sessionManager.createSession(name1,email1,number1);

                Intent intent = new Intent(RegisterAcivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterAcivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}