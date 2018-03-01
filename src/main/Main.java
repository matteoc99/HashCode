package main;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author Matteo Cosi & Markus Pobitzer
 * @since 01.03.2018
 */
public class Main {

    public static int R=-1;  //– number of rows of the grid (1 ≤ R ≤ 10000)
    public static int C=-1;  // – number of columns of the grid (1 ≤ C ≤ 10000)
    public static int F=-1;  //– number of vehicles in the fleet (1 ≤ F ≤ 1000)
    public static int N=-1;  // – number of rides (1 ≤ N ≤ 10000)
    public static int B=-1;  // – per-ride bonus for starting the ride on time (1 ≤ B ≤ 10000)
    public static int T=-1;  //number of steps in the simulation (1 ≤ T ≤ 10#9 )

    public static void main(String[] args) {
        CodeUtils.hello();

        ArrayList<Ride> rides = readInFile("a_example.in");
        System.out.println(R+""+C+""+F+""+N+""+B+""+T);


    }

    public static ArrayList<Ride> readInFile(String file){
        ArrayList<Ride> ret=new ArrayList();
        try(BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/files/"+file))) {
            String line = br.readLine();

            R = Integer.parseInt(line.substring(0,line.indexOf(' ')));
            line= line.substring(line.indexOf(' '+1,line.length()));

            C = Integer.parseInt(line.substring(0,line.indexOf(' ')));
            line= line.substring(line.indexOf(' '+1,line.length()));


            F = Integer.parseInt(line.substring(0,line.indexOf(' ')));
            line= line.substring(line.indexOf(' '+1,line.length()));


            N = Integer.parseInt(line.substring(0,line.indexOf(' ')));
            line= line.substring(line.indexOf(' '+1,line.length()));


            B = Integer.parseInt(line.substring(0,line.indexOf(' ')));
            line= line.substring(line.indexOf(' '+1,line.length()));


            T = Integer.parseInt(line);

            line = br.readLine();
            while (line != null) {
                int xFrom = Integer.parseInt(line.substring(0,line.indexOf(' ')));
                line= line.substring(line.indexOf(' '+1,line.length()));

                int yFrom = Integer.parseInt(line.substring(0,line.indexOf(' ')));
                line= line.substring(line.indexOf(' '+1,line.length()));


                int xTo= Integer.parseInt(line.substring(0,line.indexOf(' ')));
                line= line.substring(line.indexOf(' '+1,line.length()));


                int yTo= Integer.parseInt(line.substring(0,line.indexOf(' ')));
                line= line.substring(line.indexOf(' '+1,line.length()));


                int start = Integer.parseInt(line.substring(0,line.indexOf(' ')));
                line= line.substring(line.indexOf(' '+1,line.length()));

                int end = Integer.parseInt(line);

                Ride ride = new Ride(new Point(xFrom,yFrom),new Point(xTo,yTo),start,end);
                ret.add(ride);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }

}
