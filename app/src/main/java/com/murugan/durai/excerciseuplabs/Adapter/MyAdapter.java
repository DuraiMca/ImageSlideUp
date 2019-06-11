package com.murugan.durai.excerciseuplabs.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.murugan.durai.excerciseuplabs.Model.ModelClass;
import com.murugan.durai.excerciseuplabs.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.viewholder> {
    List<ModelClass> list = new ArrayList<>();

    public MyAdapter(List<ModelClass> list, Context context) {
        this.list = list;
        this.context = context;
    }

    Context context;

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Picasso.with(context).load(list.get(position).getAvatarUrl()).into(holder.imageView);
        Log.i("TAG", "onBindViewHolder: "+list.get(position).getAvatarUrl());
        holder.textView.setText("" + list.get(position).getLogin());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public viewholder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img);
            textView = itemView.findViewById(R.id.name);
        }
    }
}
