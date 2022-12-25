package com.santosh.buyon;

public class model_product_item {

    public model_product_item() {

    }

    private String img,Price,Title,Productdescription;


    public model_product_item(String img, String price, String title, String productdescription) {
        this.img = img;
        Price = price;
        Title = title;
        Productdescription = productdescription;


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
