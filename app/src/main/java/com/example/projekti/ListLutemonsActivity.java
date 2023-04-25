package com.example.projekti;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListLutemonsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private final ArrayList<Lutemon> allLutemons = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lutemons);
        allLutemons.addAll(Home.getInstance().getAllLutemons());
        allLutemons.addAll(TrainingArea.getInstance().getAllLutemons());
        allLutemons.addAll(Battlefield.getInstance().getAllLutemons());


        recyclerView = findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonWholeListAdapter(getApplicationContext(), allLutemons));
    }
}
