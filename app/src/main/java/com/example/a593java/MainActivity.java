package com.example.a593java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.main_recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,2));
        getAdapter(data());
    }

    ArrayList<Main> data() {
        ArrayList<Main> list = new ArrayList<>();
        ArrayList<Posts> posts = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            posts.add(new Posts(R.drawable.ali));
        }
        for (int i = 0; i < 14; i++) {
            list.add(new Main(posts));
        }

        return list;
    }

    void getAdapter(ArrayList<Main> mains) {
        PostsAdapter postsAdapter = new PostsAdapter(this, mains);
        recyclerView.setAdapter(postsAdapter);
    }
}