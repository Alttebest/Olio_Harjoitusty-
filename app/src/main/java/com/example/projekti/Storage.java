package com.example.projekti;

import java.util.ArrayList;

public class Storage {
    protected String name;
    protected ArrayList<Lutemon> lutemons = new ArrayList<>();
    public void addLutemon(Lutemon lutemon){
        this.lutemons.add(lutemon);
    }

    public Lutemon getLutemon(int id){
        return lutemons.get(id);
    }

    public ArrayList<Lutemon> getAllLutemons(){
        return lutemons;
    }

    public void listLutemons(){
        for (Lutemon lutemon : lutemons){
            lutemon.printSpecs();
        }
    }
}
