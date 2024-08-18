package com.example.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    TextView tv_login;
    EditText et_user_name,et_full_name,et_user_email,et_user_password,et_user_ConformPassword,et_user_phone;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tv_login  = findViewById(R.id.et_login_from_register);
        et_user_name = findViewById(R.id.et_user_name_register);
        et_full_name = findViewById(R.id.et_full_name_register);
        et_user_email = findViewById(R.id.et_user_email_register);
        et_user_password = findViewById(R.id.et_user_password_register);
        et_user_ConformPassword = findViewById(R.id.et_user_ConformPassword_register);
        et_user_phone = findViewById(R.id.et_user_phone_register);
        btn_register = findViewById(R.id.btn_register_from_register);

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        ShoppingDatabase db = new ShoppingDatabase(this);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int c = 0;
                String patternEmail = "^[A-Za-z0-9+_.-]+@(.+)$";
                String patternPass = "^[A-Za-z0-9]{8,16}$";
                String patternPhone = "^0[3-5-7-8-9]\\d{8}$";

                if (et_user_name.getText().toString().isEmpty() || et_full_name.getText().toString().isEmpty() ||
                    et_user_email.getText().toString().isEmpty() || et_user_password.getText().toString().isEmpty() ||
                    et_user_ConformPassword.getText().toString().isEmpty() || et_user_phone.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "All field are required", Toast.LENGTH_SHORT).show();
                } else {
                    if (!et_user_email.getText().toString().matches(patternEmail)) {
                        et_user_email.setError("Invalid email. Example: example@gmail.com");
                    } else if (!et_user_password.getText().toString().matches(patternPass)) {
                        et_user_password.setError("Password must be from 8 to 16 characters!");
                    } else if (!et_user_ConformPassword.getText().toString().equals(et_user_password.getText().toString())) {
                        et_user_ConformPassword.setError("Confirm Password is not equal to Password");
                    } else if (!et_user_phone.getText().toString().matches(patternPhone)) {
                        et_user_phone.setError("Invalid phone. Example: 09|03|05|07|08 xxxxxxxx");
                    } else {
                        db.insertUser(new Users(et_user_name.getText().toString(),
                                et_full_name.getText().toString(),
                                "",
                                et_user_password.getText().toString(),
                                et_user_email.getText().toString(),
                                et_user_phone.getText().toString()));
                        Toast.makeText(RegisterActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
    }
}