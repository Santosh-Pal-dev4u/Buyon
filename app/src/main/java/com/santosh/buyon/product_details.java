package com.santosh.buyon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;

public class product_details extends AppCompatActivity {
    TextView product_name,product_price,product_datails_txt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);

        String price=getIntent().getExtras().getString("price");
        String Title=getIntent().getExtras().getString("name");
        String imgd=getIntent().getExtras().getString("img");
        String productdescription=getIntent().getExtras().getString("Productdescription");
        String productimage=getIntent().getExtras().getString("Productimage");
      //  String imgd= String.valueOf(Glide.with(this).load("img"));

        product_datails_txt=findViewById(R.id.product_datails_txt);
        product_datails_txt.setText(productdescription);
        product_name=findViewById(R.id.product_name);
        product_name.setText(Title);
        product_price=findViewById(R.id.product_price);
        product_price.setText(price);
        ImageCarousel carousel = findViewById(R.id.carousel_product_image);

        ArrayList<CarouselItem> banner =new ArrayList<>();


          banner.add(new CarouselItem(imgd));



        carousel.setData(banner);

    }
}