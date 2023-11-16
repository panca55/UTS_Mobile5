package com.panca_nugraha.uts_mobile5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    List<ModalClass> mList;
    Context context;
    int orientation; // Orientasi LinearLayoutManager

    public CustomAdapter(List<ModalClass> mList, Context context, int orientation) {
        this.mList = mList;
        this.context = context;
        this.orientation = orientation;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view;

        // Tentukan layout file item berdasarkan orientasi
        if (orientation == RecyclerView.HORIZONTAL) {
            view = layoutInflater.inflate(R.layout.layout_file_horizontal, parent, false);
        } else {
            view = layoutInflater.inflate(R.layout.layout_file, parent, false);
        }

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(mList.get(position).getImage());
        holder.textView.setText(mList.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.layoutImageId);
            textView = itemView.findViewById(R.id.nameTextViewId);
        }
    }
}
