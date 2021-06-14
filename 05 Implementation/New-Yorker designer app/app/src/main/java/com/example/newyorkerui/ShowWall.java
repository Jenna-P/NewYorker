package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import Logic.WallLayout;
import Logic.CalculateOffer;

public class ShowWall extends AppCompatActivity {

    Button switchButton, adjust;
    TextView totalFrame_sw, totalGlass_sw, totalPrice_sw;
    ImageView wallDesign;
    WallLayout wall = new WallLayout();
    CalculateOffer cal = new CalculateOffer();

    private void startMyActivity(Intent intent) {
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showwall);
        setDesignAndPrice();


        switchButton = (Button) findViewById(R.id.acceptwall);
        adjust = (Button) findViewById(R.id.adjust);


        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ShowWall.this, UserContact.class);
                startMyActivity(myIntent);
            }
        });

        adjust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String totalPrice_sw_str = totalPrice_sw.getText().toString();
                String totalGlass_sw_str = totalGlass_sw.getText().toString();
                String totalFrame_sw_str = totalFrame_sw.getText().toString();

                Intent myIntent = new Intent(ShowWall.this, Glasstype.class);
                myIntent.putExtra("totalPrice_sw", totalPrice_sw_str);
                myIntent.putExtra("totalGlass_sw", totalGlass_sw_str);
                myIntent.putExtra("totalFrame_sw", totalFrame_sw_str);
                myIntent.putExtra("class", "showWall");
                startActivity(myIntent);
            }
        });

    }

    public void setDesignAndPrice() {
        totalFrame_sw = findViewById(R.id.totalFrame);
        totalGlass_sw = findViewById(R.id.totalGlass);
        totalPrice_sw = findViewById(R.id.totalPrice);
        wallDesign = findViewById(R.id.wallDesign);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        String w = bundle.getString("width");
        String h = bundle.getString("height");   //getText fra bruger input i UserMeasurments Class

        int widthInput = Integer.parseInt(w);
        int totalFrame = wall.calculateFrame(widthInput);  // parseInt og henter metod med int parametre

        int heightInput = Integer.parseInt(h);
        int totalPane = wall.calculatePane(heightInput);
        int totalGlass = totalFrame * wall.calculatePane(heightInput);

        double price = cal.calculatePrice(totalGlass);

        String setTotalFrame = String.valueOf(totalFrame);
        String setTotalGlass = String.valueOf(totalGlass);
        String setPrice = String.valueOf(price);

        totalFrame_sw.setText(setTotalFrame);
        totalGlass_sw.setText(setTotalGlass);
        totalPrice_sw.setText(setPrice);

        if(totalFrame == 1 && totalPane == 4) {
            wallDesign.setImageResource(R.drawable.a14);
        } else if (totalFrame == 2 && totalPane == 3) {
            wallDesign.setImageResource(R.drawable.a23);
        } else if (totalFrame == 2 && totalPane == 4) {
            wallDesign.setImageResource(R.drawable.a24);
        } else if (totalFrame == 3 && totalPane == 3){
            wallDesign.setImageResource(R.drawable.a33);
        } else if (totalFrame == 3 && totalPane == 4) {
            wallDesign.setImageResource(R.drawable.a34);
        } else if (totalFrame == 4 && totalPane == 3) {
            wallDesign.setImageResource(R.drawable.a43);
        } else if (totalFrame == 4 && totalPane == 4) {
            wallDesign.setImageResource(R.drawable.a44);
        } else if (totalFrame == 4 && totalPane == 5) {
            wallDesign.setImageResource(R.drawable.a45);
        } else if (totalFrame == 5 && totalPane == 3) {
            wallDesign.setImageResource(R.drawable.a53);
        } else if (totalFrame == 5 && totalPane == 4) {
            wallDesign.setImageResource(R.drawable.a54);
        } else if (totalFrame ==6 && totalPane == 4) {
            wallDesign.setImageResource(R.drawable.a64);
        }
    }


}