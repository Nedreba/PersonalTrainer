package com.bignerdranch.android.personaltrainer;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomersActivity extends AppCompatActivity {

    private Button mNewCutomerButton;
    private Button mSessionsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);

        mNewCutomerButton = (Button) findViewById(R.id.new_customer_button);
        mNewCutomerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomersActivity.this , NewCustomerActivity.class);
                startActivity(intent);
            }
        });

        mSessionsButton = (Button) findViewById(R.id.session_button);
        mSessionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomersActivity.this , SessionsActivity.class);
                startActivity(intent);
            }
        });

        ListView myListView = (ListView)findViewById(R.id.customer_listview);
        MyCustomerDatabase theDatabase = new MyCustomerDatabase(this);
        ArrayList<String> customerNames = theDatabase.getCustomerNames();

        int layoutID = android.R.layout.simple_list_item_1;

        ArrayAdapter<String> myAdapterInstance = new ArrayAdapter<String>(this, layoutID, customerNames);

        myListView.setAdapter(myAdapterInstance);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_logout_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent = new Intent(CustomersActivity.this , LoginActivity.class);
        startActivity(intent);
        return true;
    }
}
