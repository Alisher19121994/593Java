package com.example.a593java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Main> list;

    public PostsAdapter(Context context, ArrayList<Main> list) {
        this.context = context;
        this.list = list;
    }

    public void photoAdapter(ArrayList<Posts> posts, RecyclerView recyclerView) {
        PhotoAdapter photoAdapter = new PhotoAdapter(context, posts);
        recyclerView.setAdapter(photoAdapter);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.posts, parent, false);
        return new PhotoViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Main main = list.get(position);

        if (holder instanceof PhotoViewHolders) {
            RecyclerView recyclerView = ((PhotoViewHolders) holder).recyclerView;
            photoAdapter(main.posts,recyclerView);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class PhotoViewHolders extends RecyclerView.ViewHolder {
        RecyclerView recyclerView ;

        public PhotoViewHolders(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.post_recyclerview);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            SnapHelper snapHelper = new LinearSnapHelper();
            snapHelper.attachToRecyclerView(recyclerView);
        }
    }
}

