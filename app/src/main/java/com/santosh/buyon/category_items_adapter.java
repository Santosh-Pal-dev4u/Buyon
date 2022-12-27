package com.santosh.buyon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class category_items_adapter extends RecyclerView.Adapter<category_items_adapter.Myviewholder> {

    Context context;
    ArrayList<model_category> arraycategory;


    public category_items_adapter(Context context, ArrayList<model_category> arraycategory) {
        this.context = context;
        this.arraycategory = arraycategory;
    }

    @NonNull
    @Override
    public category_items_adapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_items_custom,null,false);
       Myviewholder myviewholder=new Myviewholder(view);
       return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull category_items_adapter.Myviewholder holder, int position) {


        Glide.with(context).load(arraycategory.get(position).getImg()).into(holder.img);
        holder.textView.setText(arraycategory.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return arraycategory.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView textView;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.txt_for_category_items);
            img=itemView.findViewById(R.id.img_for_category_items);


        }
    }
}
