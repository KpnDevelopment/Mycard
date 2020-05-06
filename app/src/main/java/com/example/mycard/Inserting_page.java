package com.example.mycard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
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

    private void btnClick(View v) {
        savetask();
        clear();
    }

    private void savetask(){
        if (TextUtils.isEmpty(serialno_txt.getText().toString().trim()) || TextUtils.isEmpty(district_txt.getText().toString().trim())
                || TextUtils.isEmpty(state_txt.getText().toString().trim()) || TextUtils.isEmpty(state_txt.getText().toString().trim())
                || TextUtils.isEmpty(location_txt.getText().toString().trim())
        ) {
            state_txt.setError("Field can't empty");
            district_txt.setError("Field can't empty");
            state_txt.setError("Field can't empty");
            location_txt.setError("Field can't empty");
        }
        else {
        final String serialno=serialno_txt.getText().toString().trim();
        final String district=district_txt.getText().toString().trim();
        final String state=state_txt.getText().toString().trim();
        final String location=location_txt.getText().toString().trim();
        Machine_db machine_db=new Machine_db(serialno,district,state,location);
        machine_viewModel.insert(machine_db);

    }


    }
    public void  clear(){
        serialno_txt.setText(" ");
        district_txt.setText(" ");
        state_txt.setText(" ");
        location_txt.setText(" ");
    }
    public void ShowDialog(View view){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Dr Mech");
        builder.setMessage("Are you sure you want to Exit");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getApplicationContext(),"Exit",Toast.LENGTH_SHORT);
                finish();
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_SHORT);
                        finish();
                    }
                });
        //create return alert
        builder.create().show();
    }
}
