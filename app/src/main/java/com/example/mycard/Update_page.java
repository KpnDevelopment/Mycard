package com.example.mycard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Update_page extends AppCompatActivity {
    Button searchbtn;
    Button updatebtn;
    Button deletebtn;
    EditText eserialno;
    EditText edistrict;
    EditText estate;
    EditText elocation;
    Machine_ViewModel machine_viewModel;
    ArrayList<Machine_db> machine_dbs = new ArrayList<>();

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
        machine_viewModel = new ViewModelProvider(this).get(Machine_ViewModel.class);
        machine_viewModel.getmachine().observe(this, new Observer<List<Machine_db>>() {
            @Override
            public void onChanged(List<Machine_db> machine_dbs) {
//

            }
        });
        searchbtn.setOnClickListener(new View.OnClickListener() {            //operate Search Btn
            @Override
            public void onClick(View v) {
                //
            }
        });
        updatebtn.setOnClickListener(new View.OnClickListener() {            //operate update Btn
            @Override
            public void onClick(View v) {
                ShowDialogup(v);
                clear();
                //
            }
        });
        deletebtn.setOnClickListener(new View.OnClickListener() {           //operate delete Btn
            @Override
            public void onClick(View v) {
                ShowDialog(v);
                clear();

            }
        });
    }

    public void ShowDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Dr Mech");
        builder.setMessage("Are you sure you want Delete");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT);

            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_SHORT);
                    }
                });
        //create return alert
        builder.create().show();
    }

    public void ShowDialogup(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Dr Mech");
        builder.setMessage("Are you sure you want Update");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT);

            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_SHORT);
                    }
                });
        //create return alert
        builder.create().show();
    }
    public void  clear(){
        eserialno.setText(" ");
        edistrict.setText(" ");
        estate.setText(" ");
        elocation.setText(" ");
    }
}

