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

public class Doorhandletype extends AppCompatActivity {

    Button switchButton;
    EditText totalPrice_dh;
    RadioGroup radioGroup_dh;
    RadioButton radioButton_dh;
    Intent intent;

    CalculateOffer cal = new CalculateOffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doorhandletype);

        totalPrice_dh = (EditText) findViewById(R.id.totalPrice_dh);
        switchButton = (Button) findViewById(R.id.confirmHandle);
        radioGroup_dh = (RadioGroup) findViewById(R.id.radioGroup_handle);

        //get data from dt(DoorType) class
        intent = getIntent();
        intent = getIntent();
        Bundle bundle = intent.getExtras();
        String totalPrice_dh_str = bundle.getString("totalPrice_dt");
        String totalFrame_dh_str = bundle.getString("totalFrame_dt");
        String totalGlass_dh_str = bundle.getString("totalGlass_dt");
        String chosenDoor_dh_str = bundle.getString("chosenDoor_dt");

        totalPrice_dh.setText(totalPrice_dh_str); // set price first, because standard glass type is always chose

        radioGroup_dh.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {  //check radio button
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int radioId = radioGroup_dh.getCheckedRadioButtonId();
                radioButton_dh = findViewById(radioId);

                String str = radioButton_dh.getText().toString();
                String totalPrice_dh_str = totalPrice_dh.getText().toString();
                double price_double = Double.parseDouble(totalPrice_dh_str);

                switch (radioId) {   //messing 1
                    case R.id.Choice1:

                        double price_messing1 = price_double + cal.chooseMessingOne();
                        String pr_messing1_str = String.valueOf(price_messing1);
                        totalPrice_dh.setText(pr_messing1_str);

                        break;
                    case R.id.Choice2:  //messing 2

                        double price_messing2 = price_double + cal.chooseMessingTwo();
                        String pr_messing2_str = String.valueOf(price_messing2);
                        totalPrice_dh.setText(pr_messing2_str);

                        break;
                    case R.id.Choice3: // sort 1

                        double price_black1 = price_double + cal.chooseBlackOne();
                        String pr_black1_str = String.valueOf(price_black1);
                        totalPrice_dh.setText(pr_black1_str);

                        break;
                    case R.id.Choice4: //sort 2

                        double price_black2 = price_double + cal.chooseBlackTwo();
                        String pr_black2_str = String.valueOf(price_black2);
                        totalPrice_dh.setText(pr_black2_str);

                        break;

                    case R.id.Choice5:  //ingen handle

                       String noHandle = getIntent().getStringExtra("totalPrice_dt");
                        totalPrice_dh.setText(noHandle);
                }

                }
        });

        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId = radioGroup_dh.getCheckedRadioButtonId();
                radioButton_dh = findViewById(radioId);

                String str = radioButton_dh.getText().toString();

               //passing data from dh(DoorHandletype) class to showWall class
                String passPrice = totalPrice_dh.getText().toString();
                Intent intent = new Intent(Doorhandletype.this, ShowWall.class);
                intent.putExtra("totalPrice_dh", passPrice);
                intent.putExtra("totalFrame_dh", totalFrame_dh_str);
                intent.putExtra("totalGlass_dh", totalGlass_dh_str);
                intent.putExtra("chosenDoor_dh", chosenDoor_dh_str);
                intent.putExtra("chosenHandle_dh", str);
                intent.putExtra("class", "DH");
                startActivity(intent);

            }
        });
    }










}