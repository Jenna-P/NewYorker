package com.example.newyorkerui;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.ViewHolder>
{
   CatalogData[] catalogData;
   Context context;

   public CatalogAdapter(CatalogData[] catalogData, Catalog activity) {
       this.catalogData = catalogData;
       this.context = activity;

   }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.catalog_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       final CatalogData catalogList = catalogData[position];

       holder.tv_wall.setText(catalogList.getWall());
       holder.tv_width_catalog.setText(catalogList.getWidth());
       holder.tv_height_catalog.setText(catalogList.getHeight());
       holder.tv_price_catalog.setText(catalogList.getCatalogPrice());
       holder.wallImage.setImageResource(catalogList.getWallImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UserMeasurements.class);
                intent.putExtra("possHeight", catalogList.getHeight());
                intent.putExtra("possWidth", catalogList.getWidth());
                intent.putExtra("Class","CA");

                context.startActivity(intent);

                System.out.println("clicked");
            }
        });

    }

    @Override
    public int getItemCount() {
        return catalogData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{   //create our own viewholer

        ImageView wallImage;
        TextView tv_wall;
        TextView tv_width_catalog;
        TextView tv_height_catalog;
        TextView tv_price_catalog;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            wallImage = itemView.findViewById(R.id.imageview);
            tv_wall = itemView.findViewById(R.id.wallName);
            tv_width_catalog = itemView.findViewById(R.id.possibleWidth);
            tv_height_catalog = itemView.findViewById(R.id.possibleHeight);
            tv_price_catalog = itemView.findViewById(R.id.catalogPrice);

        }
    }
}
