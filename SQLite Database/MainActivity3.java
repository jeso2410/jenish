package com.radhey.myapplication.SQLiteHelp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.radhey.myapplication.R;

public class MainActivity3 extends AppCompatActivity {
    EditText reg_name, reg_email, reg_phone_number, reg_password;
    RadioGroup reg_gender_group;
    Button reg_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        reg_name = findViewById(R.id.edtName);
        reg_email = findViewById(R.id.edtEmail);
        reg_password = findViewById(R.id.edtPassword);
        reg_phone_number = findViewById(R.id.edtPhoneNo);
        reg_gender_group = findViewById(R.id.radioGroupGender);  // Updated to RadioGroup
        reg_btn = findViewById(R.id.reg_btn);

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = reg_name.getText().toString().trim();
                String email = reg_email.getText().toString().trim();
                String password = reg_password.getText().toString().trim();
                String phone_no = reg_phone_number.getText().toString().trim();
                String gender = getSelectedGender();

                // ✅ Validation: Ensure all fields are filled
                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || phone_no.isEmpty() || gender.isEmpty()) {
                    Toast.makeText(MainActivity3.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                DbHelper dbHelper = new DbHelper(MainActivity3.this);  // Fixed context
                dbHelper.registerUserHelper(name, email, password,gender, phone_no );  // Fixed parameter order

                Toast.makeText(MainActivity3.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getSelectedGender() {
        int selectedId = reg_gender_group.getCheckedRadioButtonId();
        if (selectedId == -1) {
            return "";
        } else {
            RadioButton selectedRadioButton = findViewById(selectedId);
            return selectedRadioButton.getText().toString();
        }
    }
}
