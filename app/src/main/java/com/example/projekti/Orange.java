package com.example.projekti;

public class Orange extends  Lutemon{

    public Orange(String name){
        super();
        this.name = name;
        this.image = R.drawable.oranssi;
        this.color = "Oranssi";
        this.attack = 7;
        this.defense = 2;
        this.maxHealth = 18;
        this.health = 18;
        this.id = getNumberOfCreatedLutemons();
    }
}
