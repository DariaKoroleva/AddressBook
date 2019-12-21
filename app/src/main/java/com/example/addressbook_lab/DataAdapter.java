package com.example.addressbook_lab;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>  {

    private LayoutInflater inflater;
    private List<Contacts> contacts_list;

    DataAdapter(Context context, List<Contacts> contacts_list) {
        this.contacts_list = contacts_list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Contacts phone = contacts_list.get(position);
        holder.f_first_name.setText(phone.getFirstName());
        holder.f_last_name.setText(phone.getLastName());
        holder.f_phone_number.setText(phone.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return contacts_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView f_first_name, f_last_name, f_phone_number;
        final MenuItem bt_add_contact;
        final Button b_edit_contact, b_rm_contact;
        ViewHolder(View view){
            super(view);
            f_first_name = view.findViewById(R.id.f_first_name);
            f_last_name = view.findViewById(R.id.f_last_name);
            f_phone_number = view.findViewById(R.id.f_phone_number);

            bt_add_contact = view.findViewById(R.id.bt_add_contact);
            b_edit_contact = view.findViewById(R.id.b_edit_contact);
            b_rm_contact = view.findViewById(R.id.b_rm_contact);
        }
    }

}
