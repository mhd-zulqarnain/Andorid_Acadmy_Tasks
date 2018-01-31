package com.example.zulup.onswipdelete;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.zulup.onswipdelete.adapter.MovieAdapter;
import com.example.zulup.onswipdelete.model.Movies;
import com.example.zulup.onswipdelete.model.DataHolder;
import com.example.zulup.onswipdelete.swip.SwipHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MovieAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<Movies> movies;
    SwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        mSwipeRefreshLayout=findViewById(R.id.swiperefresh);
        movies = DataHolder.get().getMovieData();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MovieAdapter(movies, this);

        recyclerView.setAdapter(adapter);
        ItemTouchHelper.Callback callback = new SwipHelper(adapter,this);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);
        updateUi();
        getData();
    }

    private void updateUi() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                movies= DataHolder.get().getMovieData();
                adapter.notifyDataSetChanged();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }


    public Object getData() {
        return null;
    }
}
