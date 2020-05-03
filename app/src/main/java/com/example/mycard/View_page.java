package com.example.mycard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mycard.Adapter.Filter_adapter;

import java.util.List;

public class View_page extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button viewbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        recyclerView = findViewById(R.id.view_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewbtn = findViewById(R.id.View_btn);
        viewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(View_page.this, Inserting_page.class);
                startActivity(intent);
            }
        });
//        getTasks();
    }
}