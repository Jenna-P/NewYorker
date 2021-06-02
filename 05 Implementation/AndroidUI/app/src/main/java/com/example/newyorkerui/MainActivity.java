package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchButton = (Button) findViewById(R.id.nextActivityButton);;
        switchButton.setOnClickListener(view -> launchActivity());
    }

    private void launchActivity() {

        Intent intent = new Intent(this, UserMeasurements.class);
        startActivity(intent);
    }
}