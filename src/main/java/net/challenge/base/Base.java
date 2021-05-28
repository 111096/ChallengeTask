package net.challenge.base;

import net.challenge.entity.Tick;

import java.io.File;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by moust on 5/25/2021.
 */
public class Base {

    public static final long TIME = 60000;
    public static final String Sucess = "204";
    public static final String Fail = "201";

    public Hashtable<String, Tick> readFile() {

        Hashtable<String, Tick> ticks = new Hashtable<>();
        try {
            File file = new File("data/ticks.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String currentLine = scanner.next();
                Tick currentTick = convertToTick(currentLine);
                ticks.put(currentTick.getInstrument(), currentTick);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticks;
    }

    private Tick convertToTick(String currentLine) {

        return new Tick(currentLine.substring(0, currentLine.indexOf(","))
                , Double.parseDouble(currentLine.substring(currentLine.indexOf(",") + 1, currentLine.indexOf("#")))
                , Long.parseLong(currentLine.substring((currentLine.indexOf("#") + 1))));


    }

}
