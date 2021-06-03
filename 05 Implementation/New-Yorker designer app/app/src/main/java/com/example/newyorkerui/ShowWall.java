package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import NewYorkerApp.WallLayout;
import NewYorkerApp.CalculateOffer;

public class ShowWall extends AppCompatActivity {

    Button switchButton, tilpasDesign;
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

        switchButton = (Button) findViewById(R.id.acceptwall);
        switchButton.setOnClickListener(view -> launchActivity());

        tilpasDesign = (Button) findViewById(R.id.tilpasDesign);
        tilpasDesign.setOnClickListener(view -> adjustDesign());
    }

    private void launchActivity() {

        Intent intent = new Intent(this, UserContact.class);
        startActivity(intent);
    }

    private  void adjustDesign(){
        Intent intenta = new Intent(this, Glasstype.class);
        startActivity(intenta);

    }


    public void setDesignAndPrice() {
        frameInput = findViewById(R.id.fagInput);
        glasInput = findViewById(R.id.glasInput);
        priceInput = findViewById(R.id.prisInput);
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

        frameInput.setText(setTotalFrame);
        glasInput.setText(setTotalGlass);
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