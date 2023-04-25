package com.example.projekti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonWholeListAdapter extends RecyclerView.Adapter<LutemonWholeViewHolder>{

    final private Context context;
    final private ArrayList<Lutemon> lutemons;

    public LutemonWholeListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonWholeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonWholeViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_wholeinfoview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonWholeViewHolder holder, int position) {
        holder.lutemonImage.setImageResource(lutemons.get(position).getImage());
        holder.nameColor.setText(lutemons.get(position).getName());
        holder.attack.append(String.valueOf(lutemons.get(position).getAttack()));
        holder.defense.append(String.valueOf(lutemons.get(position).getDefense()));
        holder.health.append(lutemons.get(position).getHealth() + "/" + lutemons.get(position).getMaxHealth());
        holder.experience.append(String.valueOf(lutemons.get(position).getExperience()));
        holder.wins.append(String.valueOf(lutemons.get(position).getWins()));
        holder.losses.append(String.valueOf(lutemons.get(position).getLosses()));
        holder.daysTrained.append(String.valueOf(lutemons.get(position).getDaysTrained()));
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
