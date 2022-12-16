package com.santosh.buyon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class category_items_adapter extends RecyclerView.Adapter<category_items_adapter.Myviewholder> {

    Context context;
    String title[];
    int img[];

    public category_items_adapter(Context context, String title[], int img[]) {
        this.context = context;
       this.title = title;
        this.img = img;
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
        holder.textView.setText(title[position]);
        holder.img.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {
        return img.length;
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
