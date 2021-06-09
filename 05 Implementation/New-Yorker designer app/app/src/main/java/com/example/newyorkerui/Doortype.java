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
    EditText totalPrice_dt;
    RadioGroup radioGroup_dt;
    RadioButton radioButton_dt;
    Intent intent;

    CalculateOffer cal = new CalculateOffer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doortype);

        switchButton = (Button) findViewById(R.id.ok_dt);
        totalPrice_dt = (EditText) findViewById(R.id.totalPrice_dt);
        radioGroup_dt = (RadioGroup) findViewById(R.id.radioGroup_door);

        //get data from gt(Glasstype) class
        intent = getIntent();
        Bundle bundle = intent.getExtras();
        String totalFrame_dt_str = bundle.getString("totalFrame_gt");
        String totalGlass_dt_str = bundle.getString("totalGlass_gt");
        String totalPrice_dt_str = bundle.getString("totalPrice_gt");

        int totalGlass_dt_int = Integer.parseInt(totalGlass_dt_str); //typecating _ int

        totalPrice_dt.setText(totalPrice_dt_str);



        radioGroup_dt.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int radioId = radioGroup_dt.getCheckedRadioButtonId();
                radioButton_dt = findViewById(radioId);

                switch (radioId) {
                    case R.id.Choice1:   //single door without lock

                        double setTotalPrice_doub1 = cal.chooseSingleDoor(totalGlass_dt_int);   //calculate price with chosen door
                        String setTotalPrice_str1 = String.valueOf(setTotalPrice_doub1);
                        totalPrice_dt.setText(setTotalPrice_str1);

                        break;
                    case R.id.Choice2:   //single door with lock

                        double setTotalPrice_doub2 = cal.chooseSingleDoor(totalGlass_dt_int) + cal.lockCase;
                        String setTotalPrice_str2 = String.valueOf(setTotalPrice_doub2);
                        totalPrice_dt.setText(setTotalPrice_str2);

                        break;
                    case R.id.Choice3: //double door without lock

                        double setTotalPrice_doub3 = cal.chooseDoubleDoor(totalGlass_dt_int);
                        String setTotalPrice_str3 = String.valueOf(setTotalPrice_doub3);
                        totalPrice_dt.setText(setTotalPrice_str3);

                        break;
                    case R.id.Choice4: //double door with lock

                        double setTotalPrice_doub4 = cal.chooseDoubleDoor(totalGlass_dt_int) + cal.lockCase;
                        String setTotalPrice_str4 = String.valueOf(setTotalPrice_doub4);
                        totalPrice_dt.setText(setTotalPrice_str4);

                        break;

                    case R.id.Choice5: //single slide door

                        double setTotalPrice_doub5 = cal.chooseSingleSlideDoor(totalGlass_dt_int);
                        String setTotalPrice_str5 = String.valueOf(setTotalPrice_doub5);
                        totalPrice_dt.setText(setTotalPrice_str5);

                        break;
                    case R.id.Choice6: //double slide door

                        double setTotalPrice_doub6 = cal.chooseDoubleSlideDoor(totalGlass_dt_int);
                        String setTotalPrice_str6 = String.valueOf(setTotalPrice_doub6);
                        totalPrice_dt.setText(setTotalPrice_str6);

                }

            }
        });


        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId = radioGroup_dt.getCheckedRadioButtonId();
                radioButton_dt = findViewById(radioId);
                String str = radioButton_dt.getText().toString();

                String totalPrice_dt_pass_str = totalPrice_dt.getText().toString();

                //passing data to dh(DoorHandleType) class
                Intent intent = new Intent(Doortype.this, Doorhandletype.class);
                intent.putExtra("totalPrice_dt", totalPrice_dt_pass_str);
                intent.putExtra("totalFrame_dt", totalFrame_dt_str);
                intent.putExtra("totalGlass_dt", totalGlass_dt_str);
                intent.putExtra("chosenDoor_dt", str);
                startActivity(intent);
            }
        });


    }





}