package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class playlists extends AppCompatActivity {
    MyRecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlists);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.My_playlist_title);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_name);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(playlists.this,menu_activity.class);
                startActivity(intent);
            }
        });

        // Demo song list
        ArrayList<String> playlist_names = new ArrayList<>();
        playlist_names.add("Playlist 1");
        playlist_names.add("Playlist 2");
        playlist_names.add("Playlist 3");
        playlist_names.add("Playlist 4");
        playlist_names.add("Playlist 5");
        playlist_names.add("Playlist 6");

        // set up the RecyclerView
        final RecyclerView recyclerView = findViewById(R.id.playlists);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, playlist_names, "playlists");
        recyclerView.setAdapter(adapter);
        adapter.setItemClickListener(new MyRecyclerViewAdapter.OnRecyclerViewClickListener() {
            // Action when single clicked
            @Override
            public void onItemClickListener(View view) {
                int position = recyclerView.getChildAdapterPosition(view);
                System.out.println(position + "clicked");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.toolbar_add :
                // Action for "add" button at playlist toolbar
                System.out.println("Create Content");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
//      Action for 1. "Rename", 2. "Remove"
//            case 1:
//                return true;
//            case 2:
//                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
