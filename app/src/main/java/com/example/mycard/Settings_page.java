package com.example.mycard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class Settings_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);
    }

    public void aboutbtn(View view) {
        startActivity(new Intent(getApplicationContext(),Settings_About_Btn.class));
    }

//    public void darkmode(View view) {
//        Switch darkSwitch = (Switch) findViewById(R.id.darkswitch);
//    }
}
