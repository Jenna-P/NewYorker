package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class UserMeasurements extends AppCompatActivity {

    Button switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermeasurements);

        //tilslutter UI til kode
        switchButton = (Button) findViewById(R.id.makeoffer);

        //Brugerens input
        EditText hEdit = (EditText) findViewById(R.id.userheight);
        EditText wEdit = (EditText) findViewById(R.id.userwidth);

        switchButton.setOnClickListener(view -> launchActivity());
    }
    private void launchActivity() {
        Intent intent = new Intent(this, ShowWall.class);
        startActivity(intent);
    }
}