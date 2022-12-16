package com.santosh.buyon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;

public class product_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);



        ImageCarousel carousel = findViewById(R.id.carousel_product_image);

        ArrayList<CarouselItem> banner =new ArrayList<>();
        banner.add(new CarouselItem("https://assets3.cbsnewsstatic.com/hub/i/2022/09/07/30988df2-6682-44db-a1e5-a5b6a9ccd006/iphone-14-pro.png",""));
        banner.add(new CarouselItem("https://phonecharacteristics.com/link_img/423700631cf9bea7816.jpg",""));
        banner.add(new CarouselItem("https://images.ctfassets.net/vx12w8gtks6f/342Ffp88l7pPVkZadHT57A/53223abada02e38555723f8bfafce198/PEP_Carousel_4_top_frontback_iphone14ProMax_purple_PreOrder_EN.png",""));
        banner.add(new CarouselItem("https://cdn.shopify.com/s/files/1/0593/0480/4531/products/IPHONE14PROMAX7_COLOR-GOLD_CAPACITY-ALL_1000x.png?v=1664874449",""));


        carousel.setData(banner);

    }
}