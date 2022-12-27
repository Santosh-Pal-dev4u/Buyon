package com.santosh.buyon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.firestore.FirebaseFirestore;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class product_details extends AppCompatActivity {
    TextView product_name,product_price,product_datails_txt;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);

        String price=getIntent().getExtras().getString("price");
        String Title=getIntent().getExtras().getString("name");
        String productdescription=getIntent().getExtras().getString("Productdescription");
        ArrayList<String> ww=getIntent().getExtras().getStringArrayList("Productimage");



        product_datails_txt=findViewById(R.id.product_datails_txt);
        product_datails_txt.setText(productdescription);
        product_name=findViewById(R.id.product_name);
        product_name.setText(Title);
        product_price=findViewById(R.id.product_price);
        product_price.setText(price);

        //imageslider

        ImageCarousel carousel = findViewById(R.id.carousel_product_image);

        ArrayList<CarouselItem> banner =new ArrayList<>();


        for (int i=0;i<ww.size();i++){
            banner.add(new CarouselItem(ww.get(i)));
        }


        carousel.setData(banner);

    }
}