package com.example.projekti;

public class Battlefield extends Storage{

    private static Battlefield battlefield = null;
    private Battlefield(String name){
        this.name = name;
    }

    public static Battlefield getInstance() {
        if (battlefield == null){
            battlefield = new Battlefield("Taisteluareena");
        }
        return battlefield;
    }


    public String fight(Lutemon a, Lutemon b){
        int counter = 0;
        String message = "";
        while (a.health > 0 && b.health > 0){
            if(counter % 2 == 0){
                message += a.printSpecs() + "\n";
                message += b.printSpecs() + "\n";

                b.defense(a);
                message += a.getName() + " hyökkää ja " + b.getName() + " puolustautuu." + "\n";
                if (b.health <= 0){
                    message += b.getName() + " kuolee." + "\n";
                    message += "Taistelu on ohi." + "\n";
                } else {
                    message += b.getName() + " välttää kuoleman!" + "\n";
                }
            } else {
                message += b.printSpecs() + "\n";
                message += a.printSpecs() + "\n";

                a.defense(b);
                message += b.getName() + " hyökkää ja " + a.getName() + " puolustautuu." + "\n";
                if (a.health <= 0){
                    message += a.getName() + " kuolee." + "\n";
                    message += "Taistelu on ohi." + "\n";
                } else {
                    message += a.getName() + " välttää kuoleman!" + "\n";
                }
            }
            counter++;
        }
        return message;
    }
}
