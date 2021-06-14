package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import Logic.CalculateOffer;

public class Glasstype extends AppCompatActivity {

    Button switchButton;
    RadioGroup radioGroup_gt;
    RadioButton radioButton_gt;
    CheckBox cb;
    EditText totalPrice_gt;  // show price at Glasstype activity

    public Intent intent;
    public String totalPrice_gt_str = "";
    public String totalGlass_gt_str ="";
    public String totalFrame_gt_str = "";
    CalculateOffer cal = new CalculateOffer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glasstype);

        cb = (CheckBox) findViewById(R.id.checkBox);
        radioGroup_gt = (RadioGroup) findViewById(R.id.radioGroup_door);
        switchButton = (Button) findViewById(R.id.AcceptGlasstype);
        totalPrice_gt = (EditText) findViewById(R.id.totalPrice_gt);


        intent = getIntent();
        Bundle bundle = intent.getExtras();
        String totalPrice_gt_str = bundle.getString("totalPrice_sw");
        String totalGlass_gt_str = bundle.getString("totalGlass_sw");
        String totalFrame_gt_str = bundle.getString("totalFrame_sw");

        double totalPrice_gt_doub = Double.parseDouble(totalPrice_gt_str);

        totalPrice_gt.setText(totalPrice_gt_str);



        //radio group selected
        radioGroup_gt.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // get value from ShowWall class (total glass, price)

                int totalGlass_int = Integer.parseInt(totalGlass_gt_str);

                int radioId = radioGroup_gt.getCheckedRadioButtonId();

                radioButton_gt = findViewById(radioId);

                switch(radioId){
                    case R.id.radioButton1:
                        totalPrice_gt.setText(totalPrice_gt_str);
                        break;
                    case R.id.radioButton2:

                        double satinPrice =  cal.calculateSatinGlass(totalGlass_int) + totalPrice_gt_doub;
                        String tp = String.valueOf(satinPrice);
                        totalPrice_gt.setText(tp);

                        break;
                    case R.id.radioButton3:
                        // do operations specific to this selection
                        double lydPrice =  cal.calculateLydGlass(totalGlass_int) + totalPrice_gt_doub;
                        String tpLyd = String.valueOf(lydPrice);
                        totalPrice_gt.setText(tpLyd);
                        break;
                }
            }
        });


        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup_gt.getCheckedRadioButtonId();

                radioButton_gt = findViewById(radioId);
                String str = radioButton_gt.getText().toString();

                String totalPrice_gt_str = totalPrice_gt.getText().toString(); // get price value to pass to DoorType activity

              if(cb.isChecked()) {
                  intent = new Intent(Glasstype.this, Doortype.class);
                  intent.putExtra("totalPrice_gt", totalPrice_gt_str);
                  intent.putExtra("totalFrame_gt", totalFrame_gt_str);
                  intent.putExtra("totalGlass_gt", totalGlass_gt_str); //passing value
                 startActivity(intent);
              }
             else {
                  intent = new Intent(Glasstype.this, Glass_showWall.class);
                  intent.putExtra("totalFrame_gt", totalFrame_gt_str);
                  intent.putExtra("totalGlass_gt", totalGlass_gt_str);
                  intent.putExtra("totalPrice_gt", totalPrice_gt_str);
                  intent.putExtra("chosenGlass_gt", str);

                  startActivity(intent);
              }


            }
        });



    }



}