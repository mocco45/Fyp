package com.example.sencusapp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class supervisor_login extends AppCompatActivity {
    EditText etName, etPassword;
    Button button1;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor_login);

        button1= (Button) findViewById(R.id.bntSuperLOgin);

button1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
openSupervisor();
    }
    private void openSupervisor(){

        Intent h = new Intent(getApplicationContext(),supervisor_pannel.class);
        startActivity(h);
    }
});

    }

}