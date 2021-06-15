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
    TextView totalFrame_sw, totalGlass_sw, totalPrice_sw, chosenGlass, chosenDH, chosenDoor;
    ImageView wallDesign;
    WallLayout wall = new WallLayout();
    CalculateOffer cal = new CalculateOffer();
    Intent intent;



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
                intent = new Intent(ShowWall.this, UserContact.class);
               startActivity(intent);
            }
        });

        adjust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String totalPrice_sw_str = totalPrice_sw.getText().toString();
                String totalGlass_sw_str = totalGlass_sw.getText().toString();
                String totalFrame_sw_str = totalFrame_sw.getText().toString();

                intent = new Intent(ShowWall.this, Glasstype.class);
                intent.putExtra("totalPrice_sw", totalPrice_sw_str);
                intent.putExtra("totalGlass_sw", totalGlass_sw_str);
                intent.putExtra("totalFrame_sw", totalFrame_sw_str);
                intent.putExtra("class", "showWall");
                startActivity(intent);
            }
        });

    }

    public void setDesignAndPrice() {
        totalFrame_sw = findViewById(R.id.totalFrame);
        totalGlass_sw = findViewById(R.id.totalGlass);
        totalPrice_sw = findViewById(R.id.totalPrice);
        wallDesign = findViewById(R.id.wallDesign);
        chosenGlass = findViewById(R.id.chosenGlass);
        chosenDH = findViewById(R.id.chosenDH);
        chosenDoor = findViewById(R.id.chosenDoor);


        String className = getIntent().getStringExtra("class");
        if(className.equals("UM")) {  //get data from userMeasurements
            String height_str = getIntent().getStringExtra("height");
            String width_str = getIntent().getStringExtra("width");

            int widthInput = Integer.parseInt(width_str);
            int totalFrame = wall.calculateFrame(widthInput);  // parseInt og henter metod med int parametre

            int heightInput = Integer.parseInt(height_str);
            int totalPane = wall.calculatePane(heightInput);
            int totalGlass = totalFrame * wall.calculatePane(heightInput);

            double price = cal.calculatePrice(totalGlass);

            String setTotalFrame = String.valueOf(totalFrame);
            String setTotalGlass = String.valueOf(totalGlass);
            String setPrice = String.valueOf(price);

            totalFrame_sw.setText(setTotalFrame);
            totalGlass_sw.setText(setTotalGlass);
            totalPrice_sw.setText(setPrice);
            setImage();

        }else if(className.equals("GT")){  //from GlassType class -  tilpas (showall) to Glasstype class and show adjustede wall designe

            totalFrame_sw.setText(getIntent().getStringExtra("totalFrame_gt"));
            totalGlass_sw.setText(getIntent().getStringExtra("totalGlass_gt"));
            totalPrice_sw.setText(getIntent().getStringExtra("totalPrice_gt"));
            chosenGlass.setText(getIntent().getStringExtra("chosenGlass_gt"));
            setImage();

        }else if(className.equals("DH")){


            totalFrame_sw.setText(getIntent().getStringExtra("totalFrame_dh"));
            totalGlass_sw.setText(getIntent().getStringExtra("totalGlass_dh"));
            totalPrice_sw.setText(getIntent().getStringExtra("totalPrice_dh"));
            chosenDH.setText(getIntent().getStringExtra("chosenHandle_dh"));
            chosenDoor.setText(getIntent().getStringExtra("chosenDoor_dh"));
            wallDesign.setImageResource(R.drawable.doer6glas1024x1024);
        }

    }

    public void setImage() {
        int totalFrame = Integer.parseInt(totalFrame_sw.getText().toString());
        int totalGlass = Integer.parseInt(totalGlass_sw.getText().toString());

        if (totalFrame == 1 && totalGlass == 4) {
                wallDesign.setImageResource(R.drawable.a14);
            } else if (totalFrame == 2 && totalGlass == 6) {
                wallDesign.setImageResource(R.drawable.a23);
            } else if (totalFrame == 2 && totalGlass == 8) {
                wallDesign.setImageResource(R.drawable.a24);
            } else if (totalFrame == 3 && totalGlass == 9) {
                wallDesign.setImageResource(R.drawable.a33);
            } else if (totalFrame == 3 && totalGlass == 12) {
                wallDesign.setImageResource(R.drawable.a34);
            } else if (totalFrame == 4 && totalGlass == 12) {
                wallDesign.setImageResource(R.drawable.a43);
            } else if (totalFrame == 4 && totalGlass == 16) {
                wallDesign.setImageResource(R.drawable.a44);
            } else if (totalFrame == 4 && totalGlass == 20) {
                wallDesign.setImageResource(R.drawable.a45);
            } else if (totalFrame == 5 && totalGlass == 15) {
                wallDesign.setImageResource(R.drawable.a53);
            } else if (totalFrame == 5 && totalGlass == 20) {
                wallDesign.setImageResource(R.drawable.a54);
            } else if (totalFrame == 6 && totalGlass == 24) {
                wallDesign.setImageResource(R.drawable.a64);
            }
    }


}