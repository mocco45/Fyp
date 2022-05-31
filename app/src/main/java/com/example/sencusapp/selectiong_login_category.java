package com.example.sencusapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class selectiong_login_category extends AppCompatActivity {
    private Button btnsigninAgen, adminbtn, supervisor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectiong_login_category);

        btnsigninAgen = (Button) findViewById(R.id.btnAgetnClicked);
        supervisor =(Button) findViewById(R.id.btnSupervrclicked);
        adminbtn = (Button) findViewById(R.id.btnAdmin
        );

        btnsigninAgen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agentOpen();
            }

            public   void  agentOpen(){

                Intent s = new Intent(getApplicationContext(),agent_login.class);
                startActivity(s);

            }
        });

        supervisor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supervisoropen();
            }
            private void supervisoropen(){

               Intent intet = new Intent(getApplicationContext(),supervisor_login.class);
               startActivity(intet);
            }
        });

        adminbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminOpen();
            }
            private void adminOpen(){
                Intent intent = new Intent(getApplicationContext(),admin_login.class);
                startActivity(intent);
            }
        });
    }
}