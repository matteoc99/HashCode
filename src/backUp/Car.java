package backUp;

import java.awt.*;
import java.util.ArrayList;

public class Car {

    public Point location= new Point();
    public int timer;
    public ArrayList<Ride> rides;


    public Car() {
        location.x = 0;
        location.y = 0;
        timer = 0;
        rides = new ArrayList<>();
    }


    public int distanceToPoint(Point point) {
        return Math.abs(location.x - point.x) + Math.abs(location.y + point.y);
    }


    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public ArrayList<Ride> getRides() {
        return rides;
    }

    public void setRides(ArrayList<Ride> rides) {
        this.rides = rides;
    }

    public void incrementTimer(int besteZeit) {
        timer += besteZeit;
    }

    public String ridesToString() {
        StringBuilder ret = new StringBuilder();

        for (Ride ride : rides) {
            ret.append(" ").append(ride.index);
        }
        return ret.toString();
    }
}
