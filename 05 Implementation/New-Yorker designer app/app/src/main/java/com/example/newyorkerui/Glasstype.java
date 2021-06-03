package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Glasstype extends AppCompatActivity {

    Button switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glasstype);

        switchButton = (Button) findViewById(R.id.AcceptGlasstype);
        switchButton.setOnClickListener(view -> launchActivity());
    }

    private void launchActivity() {

        Intent intente = new Intent(this, Doortype.class);
        startActivity(intente);
    }
}