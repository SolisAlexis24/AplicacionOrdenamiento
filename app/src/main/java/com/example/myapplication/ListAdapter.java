package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.RecyclerHolder> {
    private List<ListElement> mData;
    private Context context;

    public ListAdapter(List<ListElement> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_element, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        ListElement item = mData.get(position);
        holder.img.setImageResource(item.getImg());
        holder.imgClr.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
        holder.name.setText(item.getName());
        holder.desc.setText(item.getDesc());

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class RecyclerHolder extends RecyclerView.ViewHolder{
        public ImageView imgClr, img;
        public TextView name, desc;
        public RecyclerHolder(@NonNull View itemView){
            super(itemView);
            img = itemView.findViewById(R.id.iconImageView);
            imgClr = itemView.findViewById(R.id.iconImageView);
            name = itemView.findViewById(R.id.Nombre);
            desc = itemView.findViewById(R.id.Description);
        }
    }
}

