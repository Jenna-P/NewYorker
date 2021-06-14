package com.example.newyorkerui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Catalog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CatalogData[] catalogData = new CatalogData[] {
                new CatalogData("1 FAG M/4 GLAS", "Bredde: 40-60cm", "Højde: 180-240cm", "PRIS: 4.925 kr", R.drawable.a14),
                new CatalogData("2 FAG M/8 GLAS", "Bredde: 75-110cm", "Højde: 180-240cm", "PRIS:9.850 kr", R.drawable.a24),
                new CatalogData("2 FAG M/6 GLAS", "Bredde: 75-100cm", "Højde: 175-220cm", "PRIS: 7.390 kr", R.drawable.a23),
                new CatalogData("DØR M/6 GLAS", "Bredde: 75-100cm", "Højde: 175-220cm", "PRIS: 9.890 kr", R.drawable.doer6glas1024x1024),
                new CatalogData("DOBBELTDØR M/12 GLAS", "Bredde: 150-200cm", "Højde: 175-220cm", "PRIS: 19.780 kr", R.drawable.dobbeltdoer12glas1024x1024),
                new CatalogData("SYDEDØR M/6 GLAS", "Bredde: 75-100cm", "Højde: 175-220cm", "PRIS: 10.490 kr", R.drawable.skydedoer6glas),
                new CatalogData("3 FAG M/12 GLAS M/ ENKELTDØR", "Bredde: 75-110cm", "Højde: 180-240cm", "PRIS: 17.275 kr", R.drawable.d3fag12glasenkeltdoer),
                new CatalogData("4 FAG M/16 GLAS M/ DOBBELTDØR", "Bredde: 150-200cm", "Højde: 180-240cm", "PRIS: 24.700  kr", R.drawable.d4fag16glasdobbeltdoer1024x1024),
                new CatalogData("5 FAG M/20 GLAS M/ ENKELTDØR", "Bredde: 200-300cm", "Højde: 180-240cm", "PRIS: 27.125 kr", R.drawable.d5fag20glasenkeltdoer1024x1024),
                new CatalogData("6 FAG M/24 GLAS M/ ENKELTDØR", "Bredde: 240-360cm", "Højde: 180-240cm", "PRIS: 32.050 kr", R.drawable.d6fag24glasenkeltdoer1024x1024)


        };

        CatalogAdapter adapter = new CatalogAdapter(catalogData, Catalog.this);
        recyclerView.setAdapter(adapter);



    }
}