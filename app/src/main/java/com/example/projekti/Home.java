package com.example.projekti;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Home extends Storage{
    private static Home home = null;
    final public String FILENAME = "lutemons.data";
    private Home(String name){
        this.name = name;
    }

    public static Home getInstance() {
        if (home == null){
            home = new Home("Koti");
        }
        return home;
    }

    public void createLutemon(Lutemon lutemon){
        addLutemon(lutemon);
    }

    public void loadLutemons(Context context){
        File file = new File(context.getFilesDir().getPath(), FILENAME);
        if (file.exists()) {
            try {
                ObjectInputStream lutemonReader = new ObjectInputStream(context.openFileInput(FILENAME));
                lutemons = (ArrayList<Lutemon>) lutemonReader.readObject();
                lutemonReader.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
