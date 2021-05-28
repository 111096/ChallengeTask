/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.challenge.entity;

/**
 *
 * @author moust
 */
public class Tick {

    String instrument;
    double price;
    long timestamp;

    public Tick() {
    }

    public Tick(String instrument, double price, long timestamp) {
        this.instrument = instrument;
        this.price = price;
        this.timestamp = timestamp;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return
                instrument + ',' +price +'#'+ timestamp ;
    }
}
