package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class UserMeasurements extends AppCompatActivity {

    Button switchButton;
    EditText hEdit;
    EditText wEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermeasurements);

        //tilslutter UI til kode
        switchButton = (Button) findViewById(R.id.makeoffer);;
        hEdit = (EditText)findViewById(R.id.userheight);
        wEdit = (EditText)findViewById(R.id.userwidth);

        passHeightData();
        passWidghtData();

        switchButton.setOnClickListener(view -> launchActivity());
    }

    // gør mål synlige for andre classes
    private String passHeightData() {
        //laver brugerens input til strings
        return (hEdit.getText().toString() );
    }
    private String passWidghtData() {
        //laver brugerens input til strings
        return (wEdit.getText().toString() );
    }

    private void launchActivity() {
        Intent intent = new Intent(this, ShowWall.class);
        startActivity(intent);
    }
}