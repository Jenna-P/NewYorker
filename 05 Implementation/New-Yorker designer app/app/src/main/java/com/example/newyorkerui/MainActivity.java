package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button switchButton;
    Button catalogButton;

    private void startMyActivity(Intent intent) {
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catalogButton = (Button) findViewById(R.id.catalougeButton);
        switchButton = (Button) findViewById(R.id.nextActivityButton);

        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, UserMeasurements.class);
                myIntent.putExtra("Class","main");
                startMyActivity(myIntent);
            }
        });

        catalogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Catalog.class);
                startActivity(myIntent);
            }
        });


    }


}