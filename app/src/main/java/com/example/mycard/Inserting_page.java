package com.example.mycard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Inserting_page extends AppCompatActivity {
    EditText serialno_txt;
    EditText district_txt;
    EditText state_txt;
    EditText location_txt;
    Button submit_btn;
    Machine_ViewModel machine_viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserting_page);
        serialno_txt=findViewById(R.id.serialno_txt);
        district_txt=findViewById(R.id.district_txt);
        state_txt=findViewById(R.id.state_txt);
        location_txt=findViewById(R.id.location_txt);
        submit_btn=findViewById(R.id.submit_btn);
        machine_viewModel= new ViewModelProvider(this).get(Machine_ViewModel.class);
        machine_viewModel.getmachine().observe(this, new Observer<List<Machine_db>>() {
            @Override
            public void onChanged(List<Machine_db> machine_dbs) {

            }
        });
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savetask();
                btnClick(v);

            }

        });

    }
    private void savetask(){
        final String serialno=serialno_txt.getText().toString().trim();
        final String district=district_txt.getText().toString().trim();
        final String state=state_txt.getText().toString().trim();
        final String location=location_txt.getText().toString().trim();
        Machine_db machine_db=new Machine_db(serialno,district,state,location);
        machine_viewModel.insert(machine_db);

    }

//    public void btnClick() {
//
//    }

    public void btnClick(View view) {
        Toast.makeText(this,"Add Sucessful",Toast.LENGTH_SHORT).show();
    }
}
