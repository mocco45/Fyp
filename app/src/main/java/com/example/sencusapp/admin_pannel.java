package com.example.sencusapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class admin_pannel extends AppCompatActivity {
    CardView cardAdd,cardWorking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_pannel);

        cardAdd = (CardView) findViewById(R.id.cardAdd);
        cardWorking= (CardView) findViewById(R.id.Working);

        cardAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCardAdd();
            }

            public void openCardAdd(){

                Intent add= new Intent(getApplicationContext(),Registration.class);
                startActivity(add);
            }
        });

        cardWorking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWorking();
            }
            public void openWorking(){

                Intent intent= new Intent(getApplicationContext(),view_working_agent.class);
                startActivity(intent);
            }
        });
    }
}