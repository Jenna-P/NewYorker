package com.example.newyorkerui;

public class CatalogData {

    private String wall;
    private String width;
    private String height;
    private String catalogPrice;
    private int wallImg;

    public CatalogData(String wall, String width, String height, String catalogPrice, int wallImg) {
        this.wall = wall;
        this.width = width;
        this.height = height;
        this.catalogPrice = catalogPrice;
        this.wallImg = wallImg;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getCatalogPrice() {
        return catalogPrice;
    }

    public void setCatalogPrice(String catalogPrice) {
        this.catalogPrice = catalogPrice;
    }

    public int getWallImg() {
        return wallImg;
    }

    public void setWallImg(int wallImg) {
        this.wallImg = wallImg;
    }
}
