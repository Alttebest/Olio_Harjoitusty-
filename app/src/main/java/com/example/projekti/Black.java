package com.example.projekti;

public class Black extends Lutemon{

    public Black(String name){
        super();
        this.name = name;
        this.image = R.drawable.musta;
        this.color = "Musta";
        this.attack = 9;
        this.defense = 0;
        this.maxHealth = 16;
        this.health = 16;
        this.id = getNumberOfCreatedLutemons();
    }
}
