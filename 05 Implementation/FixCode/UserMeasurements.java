package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class UserMeasurements extends AppCompatActivity {

    Button switchButton;
    EditText height_input;
    EditText width_input;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermeasurements);

        height_input = (EditText) findViewById(R.id.height_input);
        width_input = (EditText) findViewById(R.id.width_input);




        switchButton = (Button) findViewById(R.id.makeoffer);;
        switchButton.setOnClickListener(view -> launchActivity());
    }

    private void launchActivity() {

        String w = width_input.getText().toString();
        String h = height_input.getText().toString();

        Intent intent = new Intent(this, ShowWall.class);
        intent.putExtra("height", h);
        intent.putExtra("width", w);
        startActivity(intent);


    }



}