package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class UserMeasurements extends AppCompatActivity {

    Button switchButton;
    EditText height_input, width_input;
    TextView minMaxHeight, minMaxWidth;
    Intent intent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermeasurements);

        height_input = (EditText) findViewById(R.id.height_input);
        width_input = (EditText) findViewById(R.id.width_input);
        minMaxHeight = (TextView) findViewById(R.id.minMaxHeight);
        minMaxWidth = (TextView) findViewById(R.id.minMaxWidth);



        String className = getIntent().getStringExtra("Class");
        if(className.equals("CA")) {
            String h = getIntent().getStringExtra("possHeight");
            String w = getIntent().getStringExtra("possWidth");
            minMaxHeight.setText(h);
            minMaxWidth.setText(w);

        } else {
           Log.d("Opret", "Opret tilbud");

        }


        switchButton = (Button) findViewById(R.id.makeoffer);
        switchButton.setOnClickListener(view -> launchActivity());
    }

    private void launchActivity() {

        String w = width_input.getText().toString();
        String h = height_input.getText().toString();

        Intent intent = new Intent(UserMeasurements.this, ShowWall.class);
        intent.putExtra("height", h);
        intent.putExtra("width", w);
        intent.putExtra("class", "UM");
        startActivity(intent);
    }
}