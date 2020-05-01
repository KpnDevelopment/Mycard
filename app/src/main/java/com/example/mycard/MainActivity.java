package com.example.mycard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView View_card,Filter_card,Update_Card,Add_card,Settings_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View_card =findViewById(R.id.view_btn);
        Filter_card=findViewById(R.id.filter_btn);
        Update_Card=findViewById(R.id.update_btn);
        Add_card=findViewById(R.id.add_btn);
        Settings_card=findViewById(R.id.settings_btn);

        //operating card view

        View_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),View_page.class));
            }
        });

        Filter_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Filter_page.class));
            }
        });

        Update_Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Update_page.class));
            }
        });


        Add_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Inserting_page.class));
            }
        });
        Settings_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Settings_page.class));
            }
        });
    }
}
