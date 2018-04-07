package com.bignerdranch.android.personaltrainer;

import android.content.Intent;
import android.media.MediaCas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SessionsActivity extends AppCompatActivity {

    private Button mNewSessionButton;
    private Button mCustomersButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessions);

        mNewSessionButton = (Button) findViewById(R.id.new_session_button);
        mNewSessionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SessionsActivity.this , NewSessionActivity.class);
                startActivity(intent);
            }
        });

        mCustomersButton = (Button) findViewById(R.id.customer_button);
        mCustomersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SessionsActivity.this , CustomersActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_logout_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Intent intent = new Intent(SessionsActivity.this , LoginActivity.class);
        startActivity(intent);
        return true;
    }
}
