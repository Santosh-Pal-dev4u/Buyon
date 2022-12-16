package com.santosh.buyon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class profile_recyler_adapter extends RecyclerView.Adapter<profile_recyler_adapter.Myviewholder> {

    Context context;
    String Title[];
    int img[];

    public profile_recyler_adapter(Context context, String title[], int img[]) {
        this.context = context;
        Title = title;
        this.img = img;
    }

    @NonNull
    @Override
    public profile_recyler_adapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_custom_items,null,false);
       Myviewholder myviewholder=new Myviewholder(view);
       return myviewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull profile_recyler_adapter.Myviewholder holder, int position) {
        holder.textView.setText(Title[position]);
        holder.img.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {
        return Title.length;
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView textView;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.txt_title);
            img=itemView.findViewById(R.id.img_for_icon);


        }
    }
}
