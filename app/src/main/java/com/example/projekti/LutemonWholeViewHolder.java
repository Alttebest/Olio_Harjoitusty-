package com.example.projekti;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonWholeViewHolder extends RecyclerView.ViewHolder{

    ImageView lutemonImage;
    TextView nameColor, attack, defense, health, experience, wins, losses, daysTrained;

    public LutemonWholeViewHolder(@NonNull View itemView) {
        super(itemView);
        lutemonImage = itemView.findViewById(R.id.ivLutemonImage);
        nameColor = itemView.findViewById(R.id.txtNameColor);
        attack = itemView.findViewById(R.id.txtAttack);
        defense = itemView.findViewById(R.id.txtDefense);
        health = itemView.findViewById(R.id.txtHealth);
        experience = itemView.findViewById(R.id.txtExperience);
        wins = itemView.findViewById(R.id.txtWins);
        losses = itemView.findViewById(R.id.txtLosses);
        daysTrained = itemView.findViewById(R.id.txtDaysTrained);
    }
}
