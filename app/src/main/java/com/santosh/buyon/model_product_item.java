package com.santosh.buyon;

import java.util.List;

public class model_product_item {

    public model_product_item() {

    }

    private String img,Price,Title,Productdescription;
    private List<String> Productimage;



    public model_product_item(String img, String price, String title, String productdescription) {
        this.img = img;
        Price = price;
        Title = title;
        Productdescription = productdescription;


    }

    public model_product_item(List<String> productimage) {
        Productimage = productimage;
    }

    public List<String> getProductimage() {
        return Productimage;
    }

    public void setProductimage(List<String> productimage) {
        Productimage = productimage;
    }

    public String getProductdescription() {
        return Productdescription;
    }

    public void setProductdescription(String productdescription) {
        Productdescription = productdescription;
    }



    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
