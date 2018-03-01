package main;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Matteo Cosi & Markus Pobitzer
 * @since 01.03.2018
 */
public class Main {

    public static int R = -1;  //– number of rows of the grid (1 ≤ R ≤ 10000)
    public static int C = -1;  // – number of columns of the grid (1 ≤ C ≤ 10000)
    public static int F = -1;  //– number of vehicles in the fleet (1 ≤ F ≤ 1000)
    public static int N = -1;  // – number of rides (1 ≤ N ≤ 10000)
    public static int B = -1;  // – per-ride bonus for starting the ride on time (1 ≤ B ≤ 10000)
    public static int T = -1;  //number of steps in the simulation (1 ≤ T ≤ 10#9 )

    public static ArrayList<Ride> rides;

    public static void main(String[] args) {

        String[] names = {"a_example", "b_should_be_easy", "c_no_hurry", "d_metropolis", "e_high_bonus"};

        for (String string : names) {
            Ride.hauptIndex = 0;

            rides = readInFile(string);

            System.out.println(R+" "+C+" "+F+" "+N+" "+B+" "+T);

            check(rides);

            ArrayList<Car> cars = new ArrayList<>();
            for (int i = 0; i < F; i++) {
                cars.add(new Car());
            }
            for (Car car : cars) {
                boolean hasRide = true;
                while (hasRide) {
                    Ride best = getNextBestRide(car);
                    if (best == null) {
                        hasRide = false;
                    } else {
                        rides.get(rides.indexOf(best)).setVergeben(true);
                    }
                }
            }
            writeArray(cars,string);
        }
    }

    private static void check(ArrayList<Ride> rides) {
        for (int i = 0; i < rides.size(); i++) {
            if(rides.get(i).getIndex()>N)
                System.out.println("ALARM");
        }
    }

    public static void writeArray(ArrayList<Car> cars,String filename){
        String name = System.getProperty("user.dir") + "/src/files/"+filename+".out";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(name))){
            for (Car car : cars) {
                bw.write(car.rides.size() + car.ridesToString()+"\n");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public static Ride getNextBestRide(Car car) {
        Ride best = null;
        int besteZeit = Integer.MAX_VALUE;
        ArrayList<Ride> free = getFreeRides();
        for (int i = 0; i < free.size(); i++) {
            Ride ride = free.get(i);
            int leereFahrt = car.distanceToPoint(ride.getFrom());
            int waitTime = ride.start - (car.getTimer()+leereFahrt) < 0 ? 0 : (car.getTimer()+leereFahrt);
            int fahrtLength = ride.getFahrtTime();
            int total = waitTime + fahrtLength + leereFahrt;
            if (total + car.getTimer() < besteZeit && total + car.getTimer() < T && total + car.getTimer() < ride.finish) {
                best = ride;
                besteZeit = total + car.getTimer();
            }
        }
        if (best != null) {
            car.setTimer(besteZeit);
            car.rides.add(best);
            car.setLocation(best.getTo());
        }
        return best;
    }


    public static ArrayList<Ride> readInFile(String file) {
        ArrayList<Ride> ret = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/files/" + file+".in"))) {
            String line = br.readLine();

            R = Integer.parseInt(line.substring(0, line.indexOf(' ')));
            line = line.substring(line.indexOf(' ') + 1, line.length());

            C = Integer.parseInt(line.substring(0, line.indexOf(' ')));
            line = line.substring(line.indexOf(' ') + 1, line.length());


            F = Integer.parseInt(line.substring(0, line.indexOf(' ')));
            line = line.substring(line.indexOf(' ') + 1, line.length());


            N = Integer.parseInt(line.substring(0, line.indexOf(' ')));
            line = line.substring(line.indexOf(' ') + 1, line.length());


            B = Integer.parseInt(line.substring(0, line.indexOf(' ')));
            line = line.substring(line.indexOf(' ') + 1, line.length());


            T = Integer.parseInt(line);

            line = br.readLine();
            int counter = 0;
            while (line != null && counter<N) {
                counter++;
                int xFrom = xFrom = Integer.parseInt(line.substring(0, line.indexOf(' ')));
                    line = line.substring(line.indexOf(' ') + 1, line.length());


                int xTo = Integer.parseInt(line.substring(0, line.indexOf(' ')));
                line = line.substring(line.indexOf(' ') + 1, line.length());

                int yFrom = Integer.parseInt(line.substring(0, line.indexOf(' ')));
                line = line.substring(line.indexOf(' ') + 1, line.length());

                int yTo = Integer.parseInt(line.substring(0, line.indexOf(' ')));
                line = line.substring(line.indexOf(' ') + 1, line.length());


                int start = Integer.parseInt(line.substring(0, line.indexOf(' ')));
                line = line.substring(line.indexOf(' ') + 1, line.length());

                int end = Integer.parseInt(line);

                Ride ride = new Ride(new Point(xFrom, yFrom), new Point(xTo, yTo), start, end);
                ret.add(ride);
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }


    public static ArrayList<Ride> getFreeRides(){
        ArrayList<Ride> free = new ArrayList<>();
        for (Ride ride :
                rides) {
            if(!ride.isVergeben()){
                free.add(ride);
            }
        }
        return free;
    }

}
