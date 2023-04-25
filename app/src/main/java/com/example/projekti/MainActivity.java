package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Context context;
    static final private String FILENAME = "lutemons.data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        Home.getInstance().loadLutemons(context);
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

    public static void saveLutemons(Context context) {
        ArrayList<Lutemon> lutemonsToSave = new ArrayList<>();
        lutemonsToSave.addAll(Home.getInstance().getAllLutemons());
        lutemonsToSave.addAll(TrainingArea.getInstance().getAllLutemons());
        lutemonsToSave.addAll(Battlefield.getInstance().getAllLutemons());
        try {
            ObjectOutputStream lutemonWriter = new ObjectOutputStream(context.openFileOutput(FILENAME, Context.MODE_PRIVATE));
            lutemonWriter.writeObject(lutemonsToSave);
            lutemonWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}