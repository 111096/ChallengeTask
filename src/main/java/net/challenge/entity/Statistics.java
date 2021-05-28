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
public class Statistics {

    double max;
    double min;
    double avg;
    long count;

    public Statistics() {
        max = 0;
        min = 999999999;
        avg = 0;
        count = 0;
    }

    public Statistics(double max, double min, double avg, long count) {
        this.max = max;
        this.min = min;
        this.avg = avg;
        this.count = count;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

}
