package com.example.scheduler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Saver {
    //Will save the current state of the schedule to a file
    FileWriter writer;

    //generic save method
    public void save(ArrayList<?> toSave, File fileToSave) throws IOException {
        //create file if it doesn't exist
        if (!fileToSave.exists()) {
            fileToSave.createNewFile();
        }
        writer = new FileWriter(fileToSave);
        for (int i = 0; i < toSave.size(); i++) {
            String line = toSave.get(i).toString();
            writer.write(line + "\n");
        }
        writer.close();
    }
}
