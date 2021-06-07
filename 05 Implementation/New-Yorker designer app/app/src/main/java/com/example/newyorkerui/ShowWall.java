package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import NewYorkerApp.WallLayout;
import NewYorkerApp.CalculateOffer;

public class ShowWall extends AppCompatActivity {

    Button switchButton, tilpasDesign;
    TextView frameInput, glasInput, priceInput;
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
        tilpasDesign = (Button) findViewById(R.id.tilpasDesign);


        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ShowWall.this, UserContact.class);
                startMyActivity(myIntent);
            }
        });

        tilpasDesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String calGlassPrice = priceInput.getText().toString();
                String totalGlass = glasInput.getText().toString();

                Intent myIntent = new Intent(ShowWall.this, Glasstype.class);
                myIntent.putExtra("forGlassPrice", calGlassPrice);
                myIntent.putExtra("totalGlass", totalGlass);
                startActivity(myIntent);
            }
        });

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