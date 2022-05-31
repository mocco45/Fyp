package com.example.sencusapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class agent_form_option extends AppCompatActivity {
    CardView cardnormal, cardRenta, cardvend, cardSpecl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_form_option);

        cardnormal = findViewById(R.id.cardNormal);
        cardRenta = findViewById(R.id.cardRentl);
        cardvend = findViewById(R.id.cardrentalHouse1);
        cardSpecl = findViewById(R.id.cardrentalHouse);


        cardnormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                normalHouse();
            }

            private void normalHouse() {
                Intent intent = new Intent(getApplicationContext(), short_form.class);
                startActivity(intent);

            }
        });

        cardRenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rentalHouse();
            }

            private  void rentalHouse(){
                Intent inten = new Intent(getApplicationContext(), rental_form.class);
                startActivity(inten);

                Toast.makeText(agent_form_option.this, "wait", Toast.LENGTH_SHORT).show();

            }
        });

        cardvend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vendaHouse();
            }
            private void vendaHouse(){

                Toast.makeText(getApplicationContext(), "Soon Will be Updated..!", Toast.LENGTH_SHORT).show();     }
        });
        cardSpecl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                special();
            }
            private void special(){

                Toast.makeText(getApplicationContext(), "Soon Will be updated stay tuned..!", Toast.LENGTH_SHORT).show();
            }
        });
    }



}
