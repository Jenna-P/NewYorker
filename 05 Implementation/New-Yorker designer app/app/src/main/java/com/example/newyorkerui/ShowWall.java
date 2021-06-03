package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import KD_iteration1.WallLayout;
import NewYorkerApp.CalculateOffer;

public class ShowWall extends AppCompatActivity {

    Button switchButton;
    TextView frameInput;
    TextView glasInput;
    TextView priceInput;
    ImageView wallDesign;
    WallLayout wall = new WallLayout();
    CalculateOffer cal = new CalculateOffer();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showwall);

        setDesignAndPrice();


        switchButton = (Button) findViewById(R.id.acceptwall);;
        switchButton.setOnClickListener(view -> launchActivity());
    }

    private void launchActivity() {

        Intent intent = new Intent(this, ShowMeasurements.class);

        startActivity(intent);
    }

    public void setDesignAndPrice() {
        frameInput = (TextView) findViewById(R.id.fagInput);
        glasInput = (TextView) findViewById(R.id.glasInput);
        priceInput = (TextView) findViewById(R.id.prisInput);
        wallDesign = (ImageView) findViewById(R.id.wallDesign);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        String w = bundle.getString("width");
        String h = bundle.getString("height");   //getText fra bruger input i UserMeasurments Class

        int widthInput = Integer.parseInt(w);
        int totalFrame = wall.calculateFrame(widthInput);  // parseInt og henter metod med int parametre

        int heightInput = Integer.parseInt(h);
        int totalPane = wall.calculatePane(heightInput);
        int totalGlas = totalFrame * wall.calculatePane(heightInput);

        double price = cal.calculatePrice(totalGlas);

        String setTotalFrame = String.valueOf(totalFrame);
        String setTotalGlas = String.valueOf(totalGlas);
        String setPrice = String.valueOf(price);

        frameInput.setText(setTotalFrame);
        glasInput.setText(setTotalGlas);
        priceInput.setText(setPrice);

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