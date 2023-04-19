package com.example.projekti;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battlefield);

        recyclerView = findViewById(R.id.rvFightLutemons);
        txtFightInfo = findViewById(R.id.txtFightInfo);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonCBListAdapter(getApplicationContext(), Battlefield.getInstance().getAllLutemons()));
    }

    public void fight(View view){
        ArrayList<Integer> checkedPositions = new ArrayList<>();
        Battlefield battlefield = Battlefield.getInstance();
        for (int i=0 ; i < recyclerView.getChildCount() ; i++){
            View child = recyclerView.getChildAt(i);
            CheckBox checkBox = child.findViewById(R.id.cbForLutemon);
            if (checkBox.isChecked()){
                checkedPositions.add(recyclerView.getChildAdapterPosition(child));
            }
        }
        Lutemon a = battlefield.getLutemon(checkedPositions.get(0));
        Lutemon b = battlefield.getLutemon(checkedPositions.get(1));

        String message = battlefield.fight(a,b);
        txtFightInfo.setText(message);
    }
}
