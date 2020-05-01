package com.example.mycard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Inserting_page extends AppCompatActivity {
    EditText serialno_txt;
    EditText district_txt;
    EditText state_txt;
    EditText location_txt;
    Button submit_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserting_page);
        serialno_txt=findViewById(R.id.serialno_txt);
        district_txt=findViewById(R.id.district_txt);
        state_txt=findViewById(R.id.state_txt);
        location_txt=findViewById(R.id.location_txt);
        submit_btn=findViewById(R.id.submit_btn);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savetask();
            }
        });

    }
    private void savetask(){
        final String serialno=serialno_txt.getText().toString().trim();
        final String district=district_txt.getText().toString().trim();
        final String state=state_txt.getText().toString().trim();
        final String location=location_txt.getText().toString().trim();


    class Savetask extends AsyncTask<Void,Void,Void>{


        @Override
        protected Void doInBackground(Void... voids) {
            //creating tasks
            Machine_db machine_db=new Machine_db();

            machine_db.setSerialno(serialno);
            machine_db.setDistrict(district);
            machine_db.setState(state);
            machine_db.setLocation(location);
            //adding to database
            DatabaseClient.getInstance(getApplicationContext()).getAppdatbase().mechine_dao().insert(machine_db);

            return null;


        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
//            finish();
            startActivity(new Intent(getApplicationContext(),Inserting_page.class));
            Toast.makeText(getApplicationContext(),"saved",Toast.LENGTH_LONG).show();
        }
    }
    Savetask savetask=new Savetask();
    savetask.execute();
    }

}
