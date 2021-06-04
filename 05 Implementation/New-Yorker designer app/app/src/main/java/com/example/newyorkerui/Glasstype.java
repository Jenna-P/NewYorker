package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Glasstype extends AppCompatActivity {

    Button switchButton;
    RadioGroup radioGroup;
    RadioButton rb;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glasstype);

        cb = (CheckBox) findViewById(R.id.checkBox);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        switchButton = (Button) findViewById(R.id.AcceptGlasstype);
        switchButton.setOnClickListener(view -> launchActivity());

        if(cb.isChecked()) {
            Toast.makeText(this, "Dør valgt ",
                    Toast.LENGTH_SHORT).show();
        }

    }


    private void launchActivity() {


            Intent intente = new Intent(this, ShowWall.class);
            startActivity(intente);

    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        rb = findViewById(radioId);

    }
}