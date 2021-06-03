package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserContact extends AppCompatActivity {

    Button switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usercontact);

        //tilslutter UI til kode
        switchButton = findViewById(R.id.sendorder);

        //brugerens input
        EditText uName = findViewById(R.id.name);
        EditText uEmail = findViewById(R.id.email);
        EditText uPhone = findViewById(R.id.phone);
        EditText uComments = findViewById(R.id.comments);
        View uMaker = findViewById(R.id.dropdownlist);

        switchButton.setOnClickListener(view -> launchActivity());
    }

    private void launchActivity() {

        Intent intentu = new Intent(this, ShowAccept.class);
        startActivity(intentu);
    }
}