package com.example.projekti;

import java.io.Serializable;

public class Lutemon implements Serializable {
    protected String name, color;
    protected int experience = 0;
    protected int wins = 0;
    protected int losses = 0;
    protected int daysTrained = 0;
    private int idCounter = 0;
    protected int attack, defense, health, maxHealth, id, image;

    public Lutemon(){
        idCounter++;
    }

    public void defense(Lutemon lutemon){
        this.health -= (lutemon.attack() - this.defense);
    }

    public int attack(){
        return attack;
    }

    public int getNumberOfCreatedLutemons(){
        return idCounter;
    }

    public String getName(){
        return color + "(" + name + ")";
    }

    public void win(){
        wins++;
        health = maxHealth;
        gainExperience();
    }

    public void lose(){
        losses++;
        health = maxHealth;
    }

    public void gainExperience(){
        experience++;
        maxHealth++;
        health++;
        attack++;
    }

    public String printSpecs(){
        String message = (id + ": " + color + "(" + name + ")" + " att " + attack + "; def: " + defense + "; exp: " + experience + "; health: " + health + "/" + maxHealth);
        return message;
    }

    public int getImage() {
        return image;
    }

    public int getExperience() {
        return experience;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDaysTrained() {
        return daysTrained;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}
