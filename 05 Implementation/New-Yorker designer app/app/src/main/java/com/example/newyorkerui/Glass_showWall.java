package com.example.newyorkerui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Glass_showWall extends AppCompatActivity {

    public Intent intent;
    TextView totalFrame_g, totalGlass_g, totalPrice_g, chosenGlass_g;
    Button ok, adjust_g;
    ImageView wallDesign_g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glass_show_wall);

        totalFrame_g = (TextView) findViewById(R.id.totalFrame_g);
        totalGlass_g = (TextView) findViewById(R.id.totalGlass_g);
        totalPrice_g = (TextView) findViewById(R.id.totalPrice_g);
        chosenGlass_g =  (TextView) findViewById(R.id.chosenGlass_g);
        wallDesign_g = (ImageView) findViewById(R.id.wallDesign_g);
        ok = (Button) findViewById(R.id.acceptwall_g);
        adjust_g = (Button) findViewById(R.id.adjust_g);

        intent = getIntent();
        Bundle bundle = intent.getExtras();
        String totalFrame_g = bundle.getString("totalFrame_gt");
        String totalGlass_g = bundle.getString("totalGlass_gt");
        String totalPrice_g = bundle.getString("totalPrice_gt");
        String chosenGlass_g = bundle.getString("chosenGlass_gt");

        this.totalFrame_g.setText(totalFrame_g);
        this.totalGlass_g.setText(totalGlass_g);
        this.totalPrice_g.setText(totalPrice_g);
        this.chosenGlass_g.setText(chosenGlass_g);

        //should find better way to get image(already set) from showWall class
        if(totalFrame_g.equals("2") && totalGlass_g.equals("6")) {
            wallDesign_g.setImageResource(R.drawable.a23);
        } else if (totalFrame_g.equals("2") && totalGlass_g.equals("8")) {
            wallDesign_g.setImageResource(R.drawable.a24);
        }

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(Glass_showWall.this, UserContact.class);
                startActivity(intent);
            }
        });

        adjust_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(Glass_showWall.this, Glasstype.class);
                startActivity(intent);

            }
        });

    }
}