package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class display_song extends AppCompatActivity{
    MyRecyclerViewAdapter adapter;
    ArrayList<String> Song_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_song);
        Intent intent = getIntent();
        Song_list = intent.getStringArrayListExtra("Song_list");

        // set up the RecyclerView
        final RecyclerView recyclerView = findViewById(R.id.song_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, Song_list, "display_song");
        recyclerView.setAdapter(adapter);
        adapter.setItemClickListener(new MyRecyclerViewAdapter.OnRecyclerViewClickListener() {

            @Override
            public void onItemClickListener(View view) {
                // Action when single clicked
                int position = recyclerView.getChildAdapterPosition(view);
                System.out.println(position + "clicked");
            }
        });
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
//      Action for 1. "Add to favourite", 2. "Add to playlist", 3. "Remove"
//            case 1:
//                return true;
//            case 2:
//                return true;
//            case 3:
//                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
