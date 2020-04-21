package com.example.myapplication;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    public interface OnRecyclerViewClickListener {
        void onItemClickListener(View view);
    }

    private OnRecyclerViewClickListener listener;
    public void setItemClickListener(OnRecyclerViewClickListener itemClickListener) {
        listener = itemClickListener;
    }

    private List<String> mData;
    private LayoutInflater mInflater;
    private String Type;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context, List<String> data, String type) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.Type = type;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        if(listener != null){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(v);
                }
            });
        }
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String song = mData.get(position);
        holder.myTextView.setText(song);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.each_row);
            myTextView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            if (Type.equals("display_song")) {
                menu.add(this.getAdapterPosition(), 1, 0, R.string.add_to_favourite_button);
                menu.add(this.getAdapterPosition(), 2, 1, R.string.add_to_playlist_button);
                menu.add(this.getAdapterPosition(), 3, 2, R.string.remove_button);
            }
            if (Type.equals("playlists")) {
                menu.add(this.getAdapterPosition(), 1, 0, R.string.rename_button);
                menu.add(this.getAdapterPosition(), 2, 1, R.string.remove_button);
            }
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }


}
