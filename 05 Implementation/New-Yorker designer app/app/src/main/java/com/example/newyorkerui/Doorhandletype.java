package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Doorhandletype extends AppCompatActivity {

    Button switchButton;
    EditText price_dh;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doorhandletype);

        price_dh = (EditText) findViewById(R.id.priceWithDoorHandle);
        switchButton = (Button) findViewById(R.id.confirmHandle);

        intent = getIntent();
        String doorPrice_str = intent.getStringExtra("price_door");

        price_dh.setText(doorPrice_str);

        switchButton.setOnClickListener(view -> launchActivity());
    }

    private void launchActivity() {

       //TODO make another showWall(with door) to move that activity
        Intent intent = new Intent(Doorhandletype.this, UserContact.class);  //not userContact, should be new showWall activity
        startActivity(intent);
    }
}