package com.santosh.buyon;

public class model_product_item {

    public model_product_item(String img, String price, String name) {
        this.img = img;
        this.price = price;
        this.name = name;
    }

    private String img,price,name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public String getPrice() {
        return price;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
