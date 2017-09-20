package com.example.zulqarnain.reteroappcontact;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Zul Qarnain on 9/4/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ContactHolder> {

    List<Contact> contacts ;
    RecyclerAdapter(List<Contact> contacts){
        this.contacts = contacts;
    }

    @Override
    public RecyclerAdapter.ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ContactHolder contactHolder = new ContactHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false));
        return contactHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ContactHolder holder, int position) {
                holder.TEmail.setText(contacts.get(position).getEmail());
                holder.TName.setText(contacts.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ContactHolder extends RecyclerView.ViewHolder{

        TextView TName,TEmail;
        public ContactHolder(View itemView) {
            super(itemView);
            TName = (TextView) itemView.findViewById(R.id.name);
            TEmail = (TextView) itemView.findViewById(R.id.email);
        }
    }
}
