package com.example.mycard.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycard.Machine_db;
import com.example.mycard.Model.Filter_model;
import com.example.mycard.R;

import java.util.List;

public class Filter_adapter extends RecyclerView.Adapter<Filter_adapter.Holder> {
    LayoutInflater inflater;
    Context context;
    List<Machine_db> machine_dbs;
    public Filter_adapter(Context context,List<Machine_db> machine_dbs){
        this.context=context;
        this.machine_dbs=machine_dbs;
    }

    @NonNull
    @Override
    public Filter_adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.filter_adapter,parent,false);
        Holder holder=new Holder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Filter_adapter.Holder holder, int position) {
        if (machine_dbs!=null){
            Machine_db machine_db=machine_dbs.get(position);
            holder.serialno.setText(machine_db.getSerialno());
            holder.district.setText(machine_db.getDistrict());
            holder.state.setText(machine_db.getState());
            holder.location.setText(machine_db.getLocation());
        }


    }

    @Override
    public int getItemCount() {
        if (machine_dbs!=null){
        return machine_dbs.size();
    }
        else {
            return 0;
        }
        }
        public void Setdata(List<Machine_db>machine_db){
        machine_dbs=machine_db;
        notifyDataSetChanged();
        }
    public class Holder extends RecyclerView.ViewHolder {
        public TextView serialno,district,location,state;
        public Holder(@NonNull View itemView) {
            super(itemView);
            serialno=itemView.findViewById(R.id.ser_txt);
            district=itemView.findViewById(R.id.dis_txt);
            location=itemView.findViewById(R.id.loc_txt);
            state=itemView.findViewById(R.id.sta_txt);
        }
    }
}
