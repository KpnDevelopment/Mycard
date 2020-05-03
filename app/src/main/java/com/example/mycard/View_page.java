package com.example.mycard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mycard.Adapter.Filter_adapter;

import java.util.ArrayList;
import java.util.List;

public class View_page extends AppCompatActivity {
    Machine_ViewModel machine_viewModel;
    private RecyclerView recyclerView;
    private Button viewbtn;
    Filter_adapter adapter_fil;
    ArrayList<Machine_db>machine_dbs=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        recyclerView = findViewById(R.id.view_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager lmgr=new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager rlmgr=lmgr;
        adapter_fil=new Filter_adapter(View_page.this,machine_dbs);
        recyclerView.setAdapter(adapter_fil);
        machine_viewModel=new ViewModelProvider(this).get(Machine_ViewModel.class);
        machine_viewModel.getmachine().observe(this, new Observer<List<Machine_db>>() {
            @Override
            public void onChanged(List<Machine_db> machine_dbs) {
                adapter_fil.Setdata(machine_dbs);
            }
        });
//        viewbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(View_page.this, Inserting_page.class);
//                startActivity(intent);
//            }
//        });
//        getTasks();

    }
}