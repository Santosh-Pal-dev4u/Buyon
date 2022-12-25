package com.santosh.buyon;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class product_adapter extends RecyclerView.Adapter<product_adapter.Myviewholder> {

    Context context;
    ArrayList<model_product_item> arrayList;

    clickonadpater clickonadpater;

    public product_adapter(Context context, ArrayList<model_product_item> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public product_adapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Myviewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.product_items, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull product_adapter.Myviewholder holder, int position) {

        Glide.with(context).load(arrayList.get(position).getImg()).into(holder.imageView);
        holder.textView.setText(arrayList.get(position).getPrice());
        holder.textView2.setText(arrayList.get(position).getTitle());



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView, textView2,textView3;


        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView2);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  clickonadpater.clickme(getAdapterPosition());
                }
            });
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);


        }
    }

    public void setonitemclicklistner(clickonadpater clickonadpater) {
        this.clickonadpater = clickonadpater;
    }
}
