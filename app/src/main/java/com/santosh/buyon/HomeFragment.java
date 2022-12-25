package com.santosh.buyon;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    AlertDialog.Builder builder;

    product_adapter product_adapter;
    FirebaseFirestore firebaseFirestore;


    ArrayList<model_product_item> arrayList;

    RecyclerView recycler_view_for_category_items,recycler_view_for_products;
    String item_name[]={"Fashion","Grocery","Mobiles","Sports","Care","Furniture"};
    int item_img[]={R.drawable.img_11,R.drawable.img_9,R.drawable.img_3,R.drawable.img_7,R.drawable.img_1,R.drawable.img_sofa};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_home, container, false);

        arrayList=new ArrayList<>();
        recycler_view_for_products=view.findViewById(R.id.recycler_view_for_products);
        product_adapter=new product_adapter(getActivity(),arrayList);
        recycler_view_for_products.setAdapter(product_adapter);
        recycler_view_for_products.setLayoutManager(new StaggeredGridLayoutManager(2,1));

        // firebase product
       firebaseFirestore=FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Trending Products")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                model_product_item mm=document.toObject(com.santosh.buyon.model_product_item.class);
                                arrayList.add(mm);
                                List<String> productimagearray = (List<String>) document.get("Productimage");

                                product_adapter.setonitemclicklistner(new clickonadpater() {
                                    @Override
                                    public void clickme(int pos) {

                                        Intent inn = new Intent(getActivity(), product_details.class);
                                        inn.putExtra("name",""+arrayList.get(pos).getTitle());
                                        inn.putExtra("img",""+arrayList.get(pos).getImg());
                                        inn.putExtra("price",""+arrayList.get(pos).getPrice());
                                        inn.putExtra("Productdescription",""+arrayList.get(pos).getProductdescription());
                                        inn.putExtra("Productimage",""+productimagearray);
                                        startActivity(inn);
                                        //Toast.makeText(getActivity(), ""+arrayList.get(pos).getTitle(), Toast.LENGTH_SHORT).show();


                                    }
                                });

                            }
                            product_adapter.notifyDataSetChanged();
                        }
                    }
                });




        //


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













        return view;
    }


    }


