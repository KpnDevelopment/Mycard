package com.example.mycard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mycard.Adapter.Filter_adapter;
import com.example.mycard.Model.Filter_model;

import java.util.ArrayList;

public class Filter_page extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    String[] Sort={"District","State","Location"};
    private RecyclerView filmech;
    private LinearLayout fillayout;
    Filter_adapter adapter_fil;
    ArrayList<Machine_db> machine_dbs=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_page);
//        fm.add(new Filter_model("1010","palakkad","mannarkkad","kerala"));
//        fm.add(new Filter_model("1011","malappuram","angadippuram","kerala"));
//        fm.add(new Filter_model("1012","kozhikkode","faruk","kerala"));
//        fm.add(new Filter_model("1013","eranakulam","kochi","kerala"));
//        fm.add(new Filter_model("1014","palakkad","ottappalam","kerala"));
        filmech=findViewById(R.id.filterrecycler);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        LinearLayoutManager Lmgr = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager recylmgr=Lmgr;
        filmech.setLayoutManager(recylmgr);
        adapter_fil = new Filter_adapter(Filter_page.this,machine_dbs);
        filmech.setAdapter(adapter_fil);




    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),Sort[position] , Toast.LENGTH_LONG).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }

}



