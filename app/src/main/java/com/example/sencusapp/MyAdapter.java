package com.example.sencusapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
Context context;
ArrayList<Registered_Agent> list;

    public MyAdapter(Context context, ArrayList<Registered_Agent> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.agententry,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
Registered_Agent registered_agent = list.get(position);

holder.lastname.setText(registered_agent.getLastname());
holder.email.setText(registered_agent.getEmail());
holder.phone_number.setText(registered_agent.getPhone_number());
//holder.password.setText(registered_agent.getPassword());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView lastname,email,phone_number,password;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            lastname = itemView.findViewById(R.id.cardname);
            email = itemView.findViewById(R.id.carEmail);
            phone_number= itemView.findViewById(R.id.cardphne);
          //  password= itemView.findViewById(R.id.cardPassword);
        }
    }
}
