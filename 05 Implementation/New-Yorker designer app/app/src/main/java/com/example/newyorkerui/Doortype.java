package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import Logic.CalculateOffer;

public class Doortype extends AppCompatActivity {

    Button switchButton;
    EditText priceWithDoor;
    RadioGroup rg_door;
    RadioButton rb_door;
    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doortype);

        switchButton = (Button) findViewById(R.id.ChooseDoorHandleType);
        priceWithDoor = (EditText) findViewById(R.id.priceWithDoorHandle);
        rg_door = (RadioGroup) findViewById(R.id.radioGroup_door);

        intent = getIntent();
        String price_str = intent.getStringExtra("calPrice");
        priceWithDoor.setText(price_str);


        rg_door.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                checkRadioButton();

            }
        });


        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String doorPrice_str = priceWithDoor.getText().toString();
                Intent intent = new Intent(Doortype.this, Doorhandletype.class);
                intent.putExtra("price_door", doorPrice_str);
                startActivity(intent);
            }
        });


    }

    public void checkRadioButton() {

       int radioId = rg_door.getCheckedRadioButtonId();
       rb_door = findViewById(radioId);

        switch (radioId) {
            case R.id.Choice1:   //single door without lock

                setPrice();

                break;
            case R.id.Choice2:

                setPrice();

                break;
            case R.id.Choice3:

                setPrice();

                break;
            case R.id.Choice4:

                setPrice();

                break;

            case R.id.Choice5:

                setPrice();

                break;
            case R.id.Choice6:

                setPrice();

        }
    }

    public void setPrice() {
        CalculateOffer cal = new CalculateOffer();

        intent = getIntent();
        String tg_str =intent.getStringExtra("totalGlass");
        int tg = Integer.parseInt(tg_str);


        String str = rb_door.getText().toString();

        double price_c1 = cal.calculateDoor(tg, str);
        String price_str = String.valueOf(price_c1);
        priceWithDoor.setText(price_str);

    }
}