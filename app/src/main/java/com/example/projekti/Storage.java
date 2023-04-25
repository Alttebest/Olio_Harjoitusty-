package com.example.projekti;

import java.util.ArrayList;

public abstract class Storage {
    protected String name;
    protected ArrayList<Lutemon> lutemons = new ArrayList<>();
    public void addLutemon(Lutemon lutemon){
        this.lutemons.add(lutemon);
    }

    public void removeLutemon(Lutemon lutemon){
        lutemons.remove(lutemon);
    }

    public Lutemon getLutemon(int id){
        return lutemons.get(id);
    }

    public ArrayList<Lutemon> getAllLutemons(){
        return lutemons;
    }
}
