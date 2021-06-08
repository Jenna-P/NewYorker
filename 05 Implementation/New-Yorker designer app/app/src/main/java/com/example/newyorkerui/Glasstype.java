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

import Logic.CalculateOffer;

public class Glasstype extends AppCompatActivity {

    Button switchButton;
    RadioGroup radioGroup;
    RadioButton rb;
    CheckBox cb;
    EditText priceWithGlass;

    public Intent intent;
    CalculateOffer cal = new CalculateOffer();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glasstype);

        cb = (CheckBox) findViewById(R.id.checkBox);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_door);
        switchButton = (Button) findViewById(R.id.AcceptGlasstype);
        priceWithGlass = (EditText) findViewById(R.id.priceWithGlass);
        rb = (RadioButton) findViewById(R.id.radioButton1);

        // get value from ShowWall class (antal Glas, pris)
        Intent itt = getIntent();
        Bundle bundle = itt.getExtras();
        String priceForGlass = bundle.getString("forGlassPrice");
        String totalGlass = bundle.getString("totalGlass");
        double ForGlassP = Double.parseDouble(priceForGlass);
        int tg = Integer.parseInt(totalGlass);

        priceWithGlass.setText(priceForGlass);

        //radio gruop selected
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int radioId = radioGroup.getCheckedRadioButtonId();

                rb = findViewById(radioId);

                switch(radioId){
                    case R.id.radioButton1:
                        priceWithGlass.setText(priceForGlass);
                        break;
                    case R.id.radioButton2:

                        double satinPrice =  cal.calculateSatinGlass(tg) + ForGlassP;
                        String tp = String.valueOf(satinPrice);
                        priceWithGlass.setText(tp);

                        break;
                    case R.id.radioButton3:
                        // do operations specific to this selection
                        double lydPrice =  cal.calculateLydGlass(tg) + ForGlassP;
                        String tpLyd = String.valueOf(lydPrice);
                        priceWithGlass.setText(tpLyd);
                        break;
                }
            }
        });


        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();

                rb = findViewById(radioId);
                String str = rb.getText().toString();
                String cal_price = priceWithGlass.getText().toString(); // get price value to pass to DoorType activity

              if(cb.isChecked()) {
                  intent = new Intent(Glasstype.this, Doortype.class);
                  intent.putExtra("calPrice", cal_price);
                  intent.putExtra("totalGlass", totalGlass); //passing value
                 startActivity(intent);
              }
             else {
                  intent = new Intent(Glasstype.this, ShowWall.class);
                  intent.putExtra("calPrice", cal_price);
                  startActivity(intent);
              }


            }
        });


    }







}