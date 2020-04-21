package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class display_song extends AppCompatActivity{
    MyRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_song);

        // Demo song list
        ArrayList<String> songNames = new ArrayList<>();
        songNames.add("Song1");
        songNames.add("Song2");
        songNames.add("Song3");
        songNames.add("Song4");
        songNames.add("Song5");
        songNames.add("Song6");
        songNames.add("Song7");
        songNames.add("Song8");
        songNames.add("Song9");
        songNames.add("Song10");
        songNames.add("Song11");
        songNames.add("Song12");
        songNames.add("Song13");
        songNames.add("Song14");
        songNames.add("Song16");

        // set up the RecyclerView
        final RecyclerView recyclerView = findViewById(R.id.song_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, songNames, "display_song");
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
