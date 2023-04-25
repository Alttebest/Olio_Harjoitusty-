package com.example.projekti;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MoveLutemonsActivity extends AppCompatActivity {
    private RecyclerView recyclerViewHome;
    private RecyclerView recyclerViewTraining;
    private RecyclerView recyclerViewArena;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_lutemons);
        context = this;

        recyclerViewHome = findViewById(R.id.rvMoveLutemonsFromHome);
        recyclerViewHome.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewHome.setAdapter(new LutemonCBListAdapter(getApplicationContext(), Home.getInstance().getAllLutemons()));

        recyclerViewTraining = findViewById(R.id.rvMoveLutemonsFromTraining);
        recyclerViewTraining.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTraining.setAdapter(new LutemonCBListAdapter(getApplicationContext(), TrainingArea.getInstance().getAllLutemons()));

        recyclerViewArena = findViewById(R.id.rvMoveLutemonsFromArena);
        recyclerViewArena.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewArena.setAdapter(new LutemonCBListAdapter(getApplicationContext(), Battlefield.getInstance().getAllLutemons()));
    }


    private void moveLutemonsTo(Storage chosenStorage, ArrayList<Lutemon> lutemonsToMove){
        for (Lutemon lutemon : lutemonsToMove){
            Home.getInstance().removeLutemon(lutemon);
            TrainingArea.getInstance().removeLutemon(lutemon);
            Battlefield.getInstance().removeLutemon(lutemon);
            chosenStorage.addLutemon(lutemon);

            MainActivity.saveLutemons(context);

            recyclerViewHome.getAdapter().notifyDataSetChanged();
            recyclerViewTraining.getAdapter().notifyDataSetChanged();
            recyclerViewArena.getAdapter().notifyDataSetChanged();
        }
    }

    public void moveLutemons(View view){
        ArrayList<Lutemon> checkedLutemons = new ArrayList<>();
        for (int i=0 ; i < recyclerViewHome.getChildCount() ; i++) {
            View child = recyclerViewHome.getChildAt(i);
            CheckBox checkBox = child.findViewById(R.id.cbForLutemon);
            if (checkBox.isChecked()) {
                checkedLutemons.add(Home.getInstance().getLutemon(i));
            }
        }

        for (int i=0 ; i < recyclerViewTraining.getChildCount() ; i++) {
            View child = recyclerViewTraining.getChildAt(i);
            CheckBox checkBox = child.findViewById(R.id.cbForLutemon);
            if (checkBox.isChecked()) {
                checkedLutemons.add(TrainingArea.getInstance().getLutemon(i));
            }
        }

        for (int i=0 ; i < recyclerViewArena.getChildCount() ; i++) {
            View child = recyclerViewArena.getChildAt(i);
            CheckBox checkBox = child.findViewById(R.id.cbForLutemon);
            if (checkBox.isChecked()) {
                checkedLutemons.add(Battlefield.getInstance().getLutemon(i));
            }
        }

        RadioGroup rgMoveLutemons = findViewById(R.id.rgMoveLutemons);
        if(rgMoveLutemons.getCheckedRadioButtonId() == R.id.rbToHome) {
            for (Lutemon lutemon : checkedLutemons) {
                moveLutemonsTo(Home.getInstance(), checkedLutemons);

            }
        } else if(rgMoveLutemons.getCheckedRadioButtonId() == R.id.rbToTrainingArea) {
            for (Lutemon lutemon : checkedLutemons) {
                moveLutemonsTo(TrainingArea.getInstance(), checkedLutemons);
            }
        } else if(rgMoveLutemons.getCheckedRadioButtonId() == R.id.rbToBattlefield) {
            for (Lutemon lutemon : checkedLutemons) {
                moveLutemonsTo(Battlefield.getInstance(), checkedLutemons);
            }
        } else {
            throw new IllegalStateException("Unexpected value: " + rgMoveLutemons.getCheckedRadioButtonId());
        }
    }
}
