package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class menu_activity extends AppCompatActivity {
    Button playlist_button;
    Button favourite_button;
    Button all_song_button;
    Button recently_played_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_page);
        playlist_button = findViewById(R.id.My_playlist);
        playlist_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(menu_activity.this,playlists.class);
                startActivity(intent);
            }
        });
        favourite_button = findViewById(R.id.Favourites);
        favourite_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // list variable is for displaying the list of songs
                // Below is a demo
                ArrayList<String> song_list = new ArrayList<String>();
                song_list.add("Song1");
                song_list.add("Song2");
                song_list.add("Song3");
                Intent intent = new Intent(menu_activity.this, display_song.class);
                intent.putExtra("Song_list", song_list);
                startActivity(intent);
            }
        });
        all_song_button = findViewById(R.id.All_songs);
        all_song_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // list variable is for displaying the list of songs
                // Below is a demo
                ArrayList<String> song_list = new ArrayList<String>();
                song_list.add("Song1");
                song_list.add("Song2");
                song_list.add("Song3");
                Intent intent = new Intent(menu_activity.this, display_song.class);
                intent.putExtra("Song_list", song_list);
                startActivity(intent);
            }
        });
        recently_played_button = findViewById(R.id.Recently_played);
        recently_played_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // list variable is for displaying the list of songs
                // Below is a demo
                ArrayList<String> song_list = new ArrayList<String>();
                song_list.add("Song1");
                song_list.add("Song2");
                song_list.add("Song3");
                Intent intent = new Intent(menu_activity.this, display_song.class);
                intent.putExtra("Song_list", song_list);
                startActivity(intent);
            }
        });
    }
}
