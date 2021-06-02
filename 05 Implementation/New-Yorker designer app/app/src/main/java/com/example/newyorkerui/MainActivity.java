package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button switchButton;
    Button catalogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catalogButton = (Button) findViewById(R.id.catalougeButton);;
        catalogButton.setOnClickListener(view -> showCatalog());

        switchButton = (Button) findViewById(R.id.nextActivityButton);;
        switchButton.setOnClickListener(view -> launchActivity());
    }

    private void showCatalog() {
        Intent intent = new Intent(this, Catalogue.class);
        startActivity(intent);
    }

    private void launchActivity() {

        Intent intent = new Intent(this, UserMeasurements.class);
        startActivity(intent);
    }
}