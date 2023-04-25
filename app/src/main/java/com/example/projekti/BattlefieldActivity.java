package com.example.projekti;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BattlefieldActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView txtFightInfo;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battlefield);
        context = this;

        recyclerView = findViewById(R.id.rvFightLutemons);
        txtFightInfo = findViewById(R.id.txtFightInfo);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonCBListAdapter(getApplicationContext(), Battlefield.getInstance().getAllLutemons()));
    }

    public void fight(View view){
        ArrayList<Integer> checkedPositions = new ArrayList<>();
        for (int i=0 ; i < recyclerView.getChildCount() ; i++){
            View child = recyclerView.getChildAt(i);
            CheckBox checkBox = child.findViewById(R.id.cbForLutemon);
            if (checkBox.isChecked()){
                checkedPositions.add(recyclerView.getChildAdapterPosition(child));
            }
        }
        if (checkedPositions.size() == 2) {
            Lutemon a = Battlefield.getInstance().getLutemon(checkedPositions.get(0));
            Lutemon b = Battlefield.getInstance().getLutemon(checkedPositions.get(1));

            String message = Battlefield.getInstance().fight(a, b);
            recyclerView.getAdapter().notifyDataSetChanged();
            MainActivity.saveLutemons(context);
            for (Lutemon lutemon : TrainingArea.getInstance().getAllLutemons()){
                lutemon.gainExperience();
                lutemon.daysTrained++;
            }
            txtFightInfo.setText(message);

        } else {
            txtFightInfo.setText("Valitse tasan kaksi");
        }
    }
}
