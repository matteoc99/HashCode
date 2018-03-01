package main;

import java.awt.*;

/**
 * @author Matteo Cosi
 * @since 01.03.2018
 */
public class Ride {


    Point from;
    Point to;
    int start;
    int finish;


    public Ride() {
    }

    public Ride(Point from, Point to, int start, int finish) {
        this.from = from;
        this.to = to;
        this.start = start;
        this.finish = finish;
    }

    public Point getFrom() {
        return from;
    }

    public void setFrom(Point from) {
        this.from = from;
    }

    public Point getTo() {
        return to;
    }

    public void setTo(Point to) {
        this.to = to;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }
}
