package com.example.mycard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mycard.Adapter.Filter_adapter;

import java.util.List;

public class Inserting_page extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] Sorting={"Idle","Running","BreakDown"};
    EditText serialno_txt;
    EditText district_txt;
    EditText state_txt;
    EditText location_txt;
    EditText war_txt;
    EditText work_txt;
    Button submit_btn;
    RecyclerView recyclerView;
    Filter_adapter filter_adapter;
    Machine_ViewModel machine_viewModel;
    Spinner spinner;
    RadioButton ron;
    RadioButton rout;
    RadioGroup rg;
    String warranty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserting_page);
        serialno_txt=findViewById(R.id.serialno_txt);
        district_txt=findViewById(R.id.district_txt);
        state_txt=findViewById(R.id.state_txt);
        location_txt=findViewById(R.id.location_txt);
//        war_txt=findViewById(R.id.warranty_txt);;
        rg=findViewById(R.id.rgroup);
        ron=findViewById(R.id.onradio);
        rout=findViewById(R.id.outradio);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.onradio:
                        warranty="Under Warranty";
                        break;
                    case R.id.outradio:
                        warranty="Out of warranty";
                        break;
                }

            }
        });
        submit_btn=findViewById(R.id.submit_btn);
       spinner=findViewById(R.id.spinner_work);
        spinner.setOnItemSelectedListener(this);
        machine_viewModel = new ViewModelProvider(this).get(Machine_ViewModel.class);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        R.array.planets_array,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinner.setAdapter(adapter);
//        machine_viewModel= new ViewModelProvider(this).get(Machine_ViewModel.class);
//        machine_viewModel.getmachine().observe(this, new Observer<List<Machine_db>>() {
//            @Override
//            public void onChanged(List<Machine_db> machine_dbs) {
//                filter_adapter.Setdata(machine_dbs);
//
//            }
//        });
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savetask();
                clear();

            }

        });

    }

    private void savetask(){
        if (TextUtils.isEmpty(serialno_txt.getText().toString().trim()) || TextUtils.isEmpty(district_txt.getText().toString().trim())
                || TextUtils.isEmpty(state_txt.getText().toString().trim()) || TextUtils.isEmpty(state_txt.getText().toString().trim())
                || TextUtils.isEmpty(location_txt.getText().toString().trim())
        ) {
            serialno_txt.setError("Field can't empty");
            district_txt.setError("Field can't empty");
            state_txt.setError("Field can't empty");
            location_txt.setError("Field can't empty");
        }
        else {
        final String serialno=serialno_txt.getText().toString().trim();
        final String district=district_txt.getText().toString().trim();
        final String state=state_txt.getText().toString().trim();
        final String location=location_txt.getText().toString().trim();
        final String working=spinner.getSelectedItem().toString().trim();
        Machine_db machine_db=new Machine_db(serialno,district,state,location,warranty,working);
        machine_viewModel.insert(machine_db);

    }


    }
    public void  clear(){
        serialno_txt.setText(null);
        district_txt.setText(null);
        state_txt.setText(null);
        location_txt.setText(null);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),Sorting[position],Toast.LENGTH_LONG).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
//    public void ShowDialog(View view){
//        AlertDialog.Builder builder= new AlertDialog.Builder(this);
//        builder.setCancelable(false);
//        builder.setTitle("Dr Mech");
//        builder.setMessage("Are you sure you want to Exit");
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int id) {
//                Toast.makeText(getApplicationContext(),"Exit",Toast.LENGTH_SHORT);
//                finish();
//            }
//        })
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_SHORT);
//                        finish();
//                    }
//                });
//        //create return alert
//        builder.create().show();
//    }
}
