package com.bignerdranch.android.personaltrainer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;



public class NewCustomerActivity extends AppCompatActivity {

    private Button mBackButton;
    private Button mConfirmButton;
    private EditText mCustomerName;
    private EditText mAdditionalInfo;
    private MyCustomerDatabase theDatabase;
    private ImageButton mPhotoButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_customer);

        mBackButton = (Button) findViewById(R.id.back_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewCustomerActivity.this , CustomersActivity.class);
                startActivity(intent);
            }
        });

        mConfirmButton = (Button) findViewById(R.id.confirm_button);
        mConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddCustomer();

            }
        });
        mCustomerName = (EditText) findViewById(R.id.editTextName);
        mAdditionalInfo = (EditText) findViewById(R.id.editTextAdditionalInfo);
        theDatabase = new  MyCustomerDatabase(this);
        mPhotoButton = (ImageButton) findViewById(R.id.imageButton);
        mPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TakePhoto();

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
        Intent intent = new Intent(NewCustomerActivity.this , LoginActivity.class);
        startActivity(intent);
        return true;
    }

    private void AddCustomer() {
        theDatabase.addNewCustomer(mCustomerName.getText().toString(), mAdditionalInfo.getText().toString(), true);
    }
    int REQUEST_IMAGE_CAPTURE = 1;
    private void TakePhoto(){


        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mPhotoButton.setImageBitmap(imageBitmap);
        }
    }
}
