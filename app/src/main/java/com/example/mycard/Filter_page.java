package com.example.mycard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
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
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mycard.Adapter.Filter_adapter;
import com.example.mycard.Model.Filter_model;

import java.util.ArrayList;
import java.util.List;

public class Filter_page extends AppCompatActivity implements SearchView.OnQueryTextListener {
//    String[] Sort={"Serialno","District","State","Location"};
    SearchView searchView;
    Machine_ViewModel machine_viewModel;
    private RecyclerView filmech;
    private LinearLayout fillayout;
    Filter_adapter adapter_fil;
    ArrayList<Machine_db> machine_dbs=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_page);
        searchView=findViewById(R.id.Searchviewp);
        searchView.setOnQueryTextListener(this);
//        fm.add(new Filter_model("1010","palakkad","mannarkkad","kerala"));
//        fm.add(new Filter_model("1011","malappuram","angadippuram","kerala"));
//        fm.add(new Filter_model("1012","kozhikkode","faruk","kerala"));
//        fm.add(new Filter_model("1013","eranakulam","kochi","kerala"));
//        fm.add(new Filter_model("1014","palakkad","ottappalam","kerala"));
//        filmech=findViewById(R.id.filterrecycler);
//        Spinner spinner = (Spinner) findViewById(R.id.spinner);
//        spinner.setOnItemSelectedListener(this);
// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
//        spinner.setAdapter(adapter);
        LinearLayoutManager Lmgr = new LinearLayoutManager(getApplicationContext());
        RecyclerView.LayoutManager recylmgr=Lmgr;
        filmech.setLayoutManager(recylmgr);
        adapter_fil = new Filter_adapter(Filter_page.this,machine_dbs);
        filmech.setAdapter(adapter_fil);

        machine_viewModel=new ViewModelProvider(this).get(Machine_ViewModel.class);
        machine_viewModel.reMechine().observe(this, new Observer<List<Machine_db>>() {
            @Override
            public void onChanged(List<Machine_db> machine_dbs) {
                adapter_fil.Setdata(machine_dbs);    }
        });
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text =newText;
        machine_viewModel.pass(text);
        return false;
    }

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(getApplicationContext(),Sort[position] , Toast.LENGTH_LONG).show();
//
//
//    }

//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//
//    }

}



