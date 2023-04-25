package com.example.projekti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonCBListAdapter extends RecyclerView.Adapter<LutemonCBViewHolder> {

    private final Context context;
    private ArrayList<Lutemon> lutemons;


    public LutemonCBListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonCBViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonCBViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_cbview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonCBViewHolder holder, int position) {
        holder.specs.setText(lutemons.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
