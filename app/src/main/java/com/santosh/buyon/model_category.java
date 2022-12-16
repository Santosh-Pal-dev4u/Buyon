package com.santosh.buyon;

public class model_category {

    public model_category(String img, String name) {
        this.img = img;

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

    public void setImg(String img) {
        this.img = img;
    }


}
