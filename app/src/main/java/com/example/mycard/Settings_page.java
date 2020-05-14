package com.example.mycard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;

public class Settings_page extends AppCompatActivity {
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);
        layout=findViewById(R.id.aboutus);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings_page.this,Settings_About_Btn.class));
            }
        });

    }
//    public void darkmode(View view) {
//        Switch darkSwitch = (Switch) findViewById(R.id.darkswitch);
//    }
}
