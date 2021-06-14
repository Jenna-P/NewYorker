package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Door_showWall extends AppCompatActivity {

    public Intent intent;
    TextView totalFrame_d, totalGlass_d, totalPrice_d, chosenDoor_d, chosenHandle_d;
    Button ok, adjust_d;
    ImageView wallDesign_d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door_show_wall);

        totalFrame_d = (TextView) findViewById(R.id.totalFrame_d);
        totalGlass_d = (TextView) findViewById(R.id.totalGlass_d);
        totalPrice_d = (TextView) findViewById(R.id.totalPrice_d);
        chosenDoor_d =  (TextView) findViewById(R.id.chosenDoor_d);
        chosenHandle_d =  (TextView) findViewById(R.id.chosenHandle_d);
        wallDesign_d = (ImageView) findViewById(R.id.wallDesign_d);
        ok = (Button) findViewById(R.id.acceptwall_d);
        adjust_d = (Button) findViewById(R.id.adjust_d);

        intent = getIntent();
        Bundle bundle = intent.getExtras();
        String totalFrame_d_str = bundle.getString("totalFrame_dh");
        String totalGlass_d_str = bundle.getString("totalGlass_dh");
        String totalPrice_d_str = bundle.getString("totalPrice_dh");
        String chosenDoor_d_str = bundle.getString("chosenDoor_dh");
        String chosenHandle_d_str = bundle.getString("chosenHandle_dh");

        totalFrame_d.setText(totalFrame_d_str);
        totalGlass_d.setText(totalGlass_d_str);
        totalPrice_d.setText(totalPrice_d_str);
        chosenDoor_d.setText(chosenDoor_d_str);
        chosenHandle_d.setText(chosenHandle_d_str);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(Door_showWall.this, UserContact.class);
                startActivity(intent);
            }
        });

        adjust_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(Door_showWall.this, Glasstype.class);
                intent.putExtra("totalPrice_d", totalPrice_d_str);
                intent.putExtra("class", "d_showWall");
                startActivity(intent);

            }
        });
    }



}