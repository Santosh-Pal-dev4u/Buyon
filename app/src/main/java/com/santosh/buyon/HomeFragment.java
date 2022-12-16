package com.santosh.buyon;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    AlertDialog.Builder builder;

    product_adapter product_adapter;
    FirebaseFirestore firebaseFirestore;

    model_product_item model_product_item;
    ArrayList<model_product_item> arrayList;

    RecyclerView recycler_view_for_category_items,recycler_view_for_products;
    String item_name[]={"Fashion","Grocery","Mobiles","Sports","Care","Furniture"};
    int item_img[]={R.drawable.img_11,R.drawable.img_9,R.drawable.img_3,R.drawable.img_7,R.drawable.img_1,R.drawable.img_sofa};

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_home, container, false);

       firebaseFirestore=FirebaseFirestore.getInstance();


       // image slider bannner

        ImageCarousel carousel = view.findViewById(R.id.carousel);

        ArrayList<CarouselItem> banner =new ArrayList<>();
        banner.add(new CarouselItem("https://images-eu.ssl-images-amazon.com/images/G/31/img19/laptops/750x450-1_1545999822._CB457223703_.jpg",""));
        banner.add(new CarouselItem("https://economictimes.indiatimes.com/thumb/msid-94677060,width-1200,height-900,resizemode-4,imgsize-37878/best-laptops-and-tablets-at-huge-discounts-in-amazon-sale-today.jpg?from=mdr",""));
        banner.add(new CarouselItem("https://cdn.mos.cms.futurecdn.net/DnrckHRgetDkkD6hJMoA2K.jpg",""));
        banner.add(new CarouselItem("https://www.grabon.in/indulge/wp-content/uploads/2022/06/Upcoming-Amazon-Sales-in-India.jpg",""));


        carousel.setData(banner);

        //


        // category

        recycler_view_for_category_items=view.findViewById(R.id.recycler_view_for_category_items);
        recycler_view_for_category_items.setAdapter(new category_items_adapter(getActivity(),item_name,item_img));
        recycler_view_for_category_items.setLayoutManager(new StaggeredGridLayoutManager(1,0));


        // products


        arrayList=new ArrayList<>();
        arrayList.add(new model_product_item("https://media.istockphoto.com/id/1304528713/photo/red-jogging-sneakers-for-jogging-isolated-on-white-background-sport-shoes-modern-fashion.jpg?b=1&s=170667a&w=0&k=20&c=cyGIls0oqQk_lOWJqmb3_1O2arsZdvkF5maeqyP9G2o=","1799","Nike Air"));

        arrayList.add(new model_product_item("https://cdn1.smartprix.com/rx-i90lUSCYm-w1200-h1200/90lUSCYm.jpg","3599","Samsung Watch5"));


        arrayList.add(new model_product_item("https://cdn.shopify.com/s/files/1/0608/4988/1306/products/3263.jpg?v=1648711134","48999","Sony Bravia"));


        arrayList.add(new model_product_item("https://m.media-amazon.com/images/I/71PfGyStYmL._SL1000_.jpg","1199","Skate Board"));

        arrayList.add(new model_product_item("https://rukminim1.flixcart.com/image/832/832/l5fnhjk0/dslr-camera/f/t/m/eos-r10-24-2-r10-canon-original-imagg42fsbgv79da.jpeg?q=70","1199","Skate Board"));

         product_adapter=new product_adapter(getActivity(),arrayList);

        recycler_view_for_products=view.findViewById(R.id.recycler_view_for_products);
        recycler_view_for_products.setAdapter(product_adapter);
        recycler_view_for_products.setLayoutManager(new StaggeredGridLayoutManager(2,1));
/*        Eventchangelistner();*/
        product_adapter.setonitemclicklistner(new clickonadpater() {
            @Override
            public void clickme(int pos) {

                Intent inn = new Intent(getActivity(), product_details.class);
                startActivity(inn);


            }
        });






        return view;
    }

 /*   private void Eventchangelistner() {

        firebaseFirestore.collection("Trending Products")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                        if(error != null){
                            Log.e("Firebase error",error.getMessage());
                           return;
                        }
                         for (DocumentChange documentChange : value.getDocumentChanges()){

                             if(documentChange.getType()== DocumentChange.Type.ADDED){

                                 arrayList.add(documentChange.getDocument().toObject(model_product_item.getClass()));

                             }
                             product_adapter.notifyDataSetChanged();


                         }





                    }
                });



    }*/


}