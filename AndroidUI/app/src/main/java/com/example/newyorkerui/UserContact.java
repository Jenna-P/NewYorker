package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class UserContact extends AppCompatActivity {

    Button switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usercontact);

        switchButton = (Button) findViewById(R.id.sendorder);;
        switchButton.setOnClickListener(view -> launchActivity());
    }

    private void launchActivity() {

        Intent intent = new Intent(this, ShowAccept.class);
        startActivity(intent);
    }
}