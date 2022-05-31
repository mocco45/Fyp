package com.example.sencusapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class agent_panel extends AppCompatActivity {
    private CardView cardHome, formCencs,agentSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_panel);

        cardHome = (CardView) findViewById(R.id.home_);
        formCencs = (CardView) findViewById(R.id.cardCensusForm);
        agentSettings = (CardView) findViewById(R.id.AgentSettin);

        formCencs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openForm();
            }
            public void openForm(){
                Intent intent = new Intent(getApplicationContext(),agent_form_option.class);
                startActivity(intent);

            }
        });

        agentSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setting();
            }
            private void setting(){
                Toast.makeText(agent_panel.this, "soon will be updated", Toast.LENGTH_SHORT).show();
            }
        });
    }
}