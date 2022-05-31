package com.example.sencusapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class admin_login extends AppCompatActivity {
    TextInputEditText etName, etPassword;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        button = (Button) findViewById(R.id.bntAdminLOgin);
        etName = (TextInputEditText) findViewById(R.id.adminName);
        etPassword = (TextInputEditText) findViewById(R.id.adminPassword);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstname = etName.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (TextUtils.isEmpty(firstname)) {
                    etName.setError("please enter firstname");
                    etName.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    etPassword.setError("please enter password");
                    etPassword.requestFocus();
                    return;
                }


                AdminPannel();

            }

            private void AdminPannel() {
                Intent adminPannel = new Intent(getApplicationContext(), admin_pannel.class);
                startActivity(adminPannel);
            }

        });


    }


}