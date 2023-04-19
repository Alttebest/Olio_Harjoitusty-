package com.example.projekti;

public class TrainingArea extends Storage{

    private static TrainingArea trainingArea = null;
    private TrainingArea(String name){
        this.name = name;
    }

    public static TrainingArea getInstance() {
        if (trainingArea == null){
            trainingArea = new TrainingArea("Harjoitusalue");
        }
        return trainingArea;
    }

    public void train(){
        for (Lutemon lutemon : this.lutemons){
            lutemon.gainExperience();
        }
    }
}
