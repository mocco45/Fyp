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

public class agent_login extends AppCompatActivity {
    TextInputEditText etAName, etAPassword;
    Button button;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_login);

        button = (Button) findViewById(R.id.bntagentLOgin);
        etAName=findViewById(R.id.agentName);
        etAPassword=findViewById(R.id.AgetPass);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String firstname = etAName.getText().toString().trim();
                String password = etAPassword.getText().toString().trim();

                if (TextUtils.isEmpty(firstname)){
                   etAName.setError("please enter first name");
                   etAName.requestFocus();
                   return;
                }

                if (TextUtils.isEmpty(password)){
                    etAPassword.setError("please enter password");
                    etAPassword.requestFocus();
                    return;
                }
                if (password.length() == 6){
                    etAPassword.setError("please enter 6 digits");
                    etAPassword.requestFocus();
                    return;
                }
                userLogin();
            }
        });


    }

    private void userLogin() {
Intent o = new Intent(getApplicationContext(),agent_panel.class);
startActivity(o);

    }
}