package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Doortype extends AppCompatActivity {

    Button switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doortype);

        switchButton = findViewById(R.id.handlebutton);
        switchButton.setOnClickListener(view -> launchActivity());
    }

    private void launchActivity() {

       Intent intent = new Intent(this, Doorhandletype.class);
       startActivity(intent);
    }
}