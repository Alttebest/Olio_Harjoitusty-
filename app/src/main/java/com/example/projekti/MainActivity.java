package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        Home home = Home.getInstance();
        Battlefield battlefield = Battlefield.getInstance();
        TrainingArea trainingArea = TrainingArea.getInstance();

        //Home.getInstance().loadLutemons(context);
    }

    public void switchToAddLutemon(View view){
        Intent intent = new Intent(this, AddLutemonActivity.class);
        startActivity(intent);
    }

    public void switchToMoveLutemons(View view){
        Intent intent = new Intent(this, MoveLutemonsActivity.class);
        startActivity(intent);
    }

    public void switchToBattlefield(View view){
        Intent intent = new Intent(this, BattlefieldActivity.class);
        startActivity(intent);
    }

    public void switchToListLutemons(View view){
        Intent intent = new Intent(this, ListLutemonsActivity.class);
        startActivity(intent);
    }
}