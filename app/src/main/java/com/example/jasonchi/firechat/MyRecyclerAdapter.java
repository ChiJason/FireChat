package com.example.jasonchi.firechat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JasonChi on 2016/12/14.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    ArrayList<Contact> list;

    public MyRecyclerAdapter(ArrayList<Contact> list){
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = list.get(position);
        holder.setValues(contact);
    }

    @Override
    public int getItemCount() {
        return list==null ? 0: list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        final TextView textViewName;
        final TextView textViewPhone;
        final TextView textViewAddr;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.tv_name);
            textViewPhone = (TextView) itemView.findViewById(R.id.tv_phone);
            textViewAddr = (TextView) itemView.findViewById(R.id.tv_addr);
        }

        public void setValues(Contact contact){
            textViewName.setText(contact.getName());
            textViewPhone.setText(contact.getPhone());
            textViewAddr.setText(contact.getAddr());
        }
    }
}
