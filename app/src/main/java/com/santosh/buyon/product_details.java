package com.santosh.buyon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.google.firebase.firestore.FirebaseFirestore;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class product_details extends AppCompatActivity implements PaymentResultListener {
    TextView product_name,product_price,product_datails_txt;
    LottieAnimationView shopnow;
    Checkout checkout;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);

        shopnow=findViewById(R.id.shopnow_anim_btn);

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
        checkout=new Checkout();


        for (int i=0;i<ww.size();i++){
            banner.add(new CarouselItem(ww.get(i)));
        }


        carousel.setData(banner);


        // payment

        shopnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initialize Razorpay
                checkout.preload(product_details.this);
                checkout.setKeyID("rzp_test_4tBTeSXE0j4rxG");


        /*
          You need to pass current activity in order to let Razorpay create CheckoutActivity
         */


                    final Checkout co = new Checkout();

                    try {
                        JSONObject options = new JSONObject();
                        options.put("name", "oms-infotech");
                        options.put("description", "Reference No. #123456");
                        options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
                        options.put("currency", "INR");
                        options.put("amount", "100");

                        JSONObject preFill = new JSONObject();
                        preFill.put("email", "santoshbhagel321@gmail.com");
                        preFill.put("contact", "8178600597");

                        options.put("prefill", preFill);

                        co.open(product_details.this, options);
                    } catch (Exception e) {
                        Toast.makeText(product_details.this, "Error in payment: " + e.getMessage(), Toast.LENGTH_SHORT)
                                .show();
                        e.printStackTrace();
                    }
                }


        });

    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "Sucess", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "Faild", Toast.LENGTH_SHORT).show();
    }
}

