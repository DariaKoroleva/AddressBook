package com.example.addressbook_lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Contacts> contactsList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rview_list_of_contacts);
        // создаем адаптер
        DataAdapter adapter = new DataAdapter(this, contactsList);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bt_add_contact:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setInitialData(){
        contactsList.add(new Contacts ("Иванов", "Иван",  "712345678901"));
        contactsList.add(new Contacts ("Иванова", "Мария",  "712345678902"));
        contactsList.add(new Contacts ("Сидоров", "Иннокентий", "712345678903"));
        contactsList.add(new Contacts ("Сидорова", "Алёна", "712345678904"));
    }
}
