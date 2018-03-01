package main2;

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

    static int hauptIndex=0;
    int index =-1;


    boolean vergeben =false;


    public Ride() {

        index = hauptIndex;
        hauptIndex++;
    }

    public Ride(Point from, Point to, int start, int finish) {
        this();
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

    public boolean isVergeben() {
        return vergeben;
    }

    public void setVergeben(boolean vergeben) {
        this.vergeben = vergeben;
    }


    public int distanceBetweenTwoPoint(Point location,Point point){
        return  Math.abs(location.x-point.x)+ Math.abs(location.y+point.y);
    }
    public int getFahrtTime() {
        return distanceBetweenTwoPoint(getFrom(),getTo());
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
