package net.challenge.service;

import net.challenge.base.Base;
import net.challenge.entity.Tick;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by moust on 5/24/2021.
 */
@Service
public class TickService extends Base {

    public String createNewTick(Tick tick) {

        if (tick != null && validateInstrument(tick.getTimestamp()) == true) {

            // append new tick to file ticks.TXT
            try (FileWriter writer = new FileWriter("data/ticks.txt", true)) {
                writer.append(tick.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Base.Sucess;

        } else {
            // tick is older than 60 seconds
            return Base.Fail;
        }

    }

    public Tick findInstrumentById(String instrument) {
        Hashtable<String, Tick> tickHashtable =readFile();
        return tickHashtable.get(instrument);
    }

    public boolean validateInstrument(long timeStamp) {
        return System.currentTimeMillis() - timeStamp < Base.TIME;

    }
}
