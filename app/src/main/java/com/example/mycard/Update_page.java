package com.example.mycard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Update_page extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] Sort={"Idle","BreakDown","Run"};
    Button searchbtn;
    Button updatebtn;
    Button deletebtn;
    EditText eserialno;
    EditText edistrict;
    EditText estate;
    EditText elocation;
    EditText ewarranty;
    EditText eworking;
    Spinner spinner;
    Machine_ViewModel machine_viewModel;
    List<Machine_db> machine_dbs;
    Machine_Dao machine_dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_page);
        searchbtn = findViewById(R.id.usearching_btn);
        updatebtn = findViewById(R.id.uupdate_btn);
        deletebtn = findViewById(R.id.udelete_btn);
        eserialno = findViewById(R.id.serialno_e_txt);
        edistrict = findViewById(R.id.district_e_txt);
        estate = findViewById(R.id.state_e_txt);
        elocation = findViewById(R.id.location_e_txt);
        ewarranty=findViewById(R.id.warranty_e_txt);
        spinner=findViewById(R.id.spinner_work_up);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,
                R.array.planets_array,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spinner.setAdapter(adapter);
        machine_viewModel = new ViewModelProvider(this).get(Machine_ViewModel.class);
        machine_viewModel.reMechine().observe(this, new Observer<List<Machine_db>>() {
            @Override
            public void onChanged(List<Machine_db> machine_dbs) {
                fil(machine_dbs);
            }
        });
        searchbtn.setOnClickListener(new View.OnClickListener() {            //operate Search Btn
            @Override
            public void onClick(View v) {
                String val =eserialno.getText().toString();
                machine_viewModel.pass(val);

            }
        });
        updatebtn.setOnClickListener(new View.OnClickListener() {            //operate update Btn
            @Override
            public void onClick(View v) {
                machine_viewModel.update(elocation.getText().toString(),edistrict.getText().toString(),estate.getText().toString(),eserialno.getText().toString(),ewarranty.getText().toString(),eworking.getText().toString());
                ShowDialogup();
                clear();
                //
            }
        });
        deletebtn.setOnClickListener(new View.OnClickListener() {           //operate delete Btne
            @Override
            public void onClick(View v) {
                machine_viewModel.delete(elocation.getText().toString(),edistrict.getText().toString(),estate.getText().toString(),eserialno.getText().toString(),ewarranty.getText().toString(),eworking.getText().toString());
                ShowDialog();

            }
        });
    }

    public void ShowDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Dr Mech");
        builder.setMessage("Are you sure you want Delete");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG);

            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_LONG);
                    }
                });
        //create return alert
        builder.create().show();
    }

    public void ShowDialogup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Dr Mech");
        builder.setMessage("Are you sure you want Update");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG);
                finish();

            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_LONG);
                    }
                });
        //create return alert
        builder.create().show();
    }

    public void clear() {
        eserialno.setText(null);
        edistrict.setText(null);
        estate.setText(null);
        elocation.setText(null);
        ewarranty.setText(null);
        eworking.setText(null);
    }


    public void fil(List<Machine_db> machine_dbs) {
        if (machine_dbs.size() > 0) {
            edistrict.setText(machine_dbs.get(0).getDistrict());
            estate.setText(machine_dbs.get(0).getState());
            elocation.setText(machine_dbs.get(0).getLocation());
            ewarranty.setText(machine_dbs.get(0).getWarranty());
            eworking.setText(machine_dbs.get(0).getWorking());
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),Sort[position],Toast.LENGTH_LONG).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
