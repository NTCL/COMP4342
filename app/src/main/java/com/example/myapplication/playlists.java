package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.List;

public class playlists extends AppCompatActivity {
    MyRecyclerViewAdapter adapter;
    String txt;

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
                // position is the row number of the clicked playlist (starting from 0,1,2,3...)
                int position = recyclerView.getChildAdapterPosition(view);
                // song_list variable is for displaying the list of songs
                // Below is a demo
                ArrayList<String> song_list = new ArrayList<String>();
                song_list.add("Song1");
                song_list.add("Song2");
                song_list.add("Song3");
                Intent intent = new Intent(playlists.this, display_song.class);
                intent.putExtra("Song_list", song_list);
                startActivity(intent);
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
                // Action for "add" playlist at playlist toolbar (to be implement)
                System.out.println("Create Content");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull final MenuItem item) {
        switch(item.getItemId()){
//      Action for 1. "Rename", 2. "Remove"
            case 1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Rename");
                final EditText input = new EditText(this);
                input.setSingleLine();
                builder.setView(input);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txt = input.getText().toString();
                        adapter.editItem(item.getOrder(), txt);
                    }
                });
                builder.create().show();
                return true;
            case 2:
                adapter.removeItem(item.getOrder());
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
