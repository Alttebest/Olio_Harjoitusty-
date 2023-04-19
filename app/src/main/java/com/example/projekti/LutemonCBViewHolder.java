package com.example.projekti;


import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonCBViewHolder extends RecyclerView.ViewHolder {
    CheckBox checkBox;
    TextView specs;

    public LutemonCBViewHolder(@NonNull View itemView) {
        super(itemView);
        checkBox = itemView.findViewById(R.id.cbForLutemon);
        specs = itemView.findViewById(R.id.txtLutemonInfo);

    }
}
