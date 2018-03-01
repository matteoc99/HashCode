package main;

import java.awt.*;
import java.util.ArrayList;

public class Car {

    public Point location;
    public int timer;
    public ArrayList<Ride> rides;

    public Car(){
        location.x = 0;
        location.y = 0;
        timer = 0;
        rides = new ArrayList<>();
    }




}
