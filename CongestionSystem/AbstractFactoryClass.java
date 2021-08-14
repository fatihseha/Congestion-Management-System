//FATİH SEHA ÖÇAL 
//BULUTHAN İNAN
//ALPEREN ERTAN
//RAMAZAN BAYBÖREK
//CONGESTION MANAGEMENT SYSTEM


package CongestionSystem;


import static CongestionSystem.CongestionSystemGUI.D;
import static CongestionSystem.CongestionSystemGUI.J;
import static CongestionSystem.Dijkstra.computePaths;
import static CongestionSystem.Dijkstra.getShortestPathTo;
import java.util.List;
import java.util.Random;



abstract class LocationCalculator{
        abstract String LocationCalcuator();
    }


    class GPS extends LocationCalculator{
        Random random = new Random();
        double randomPoint = random.nextDouble();

        @Override
        String LocationCalcuator() {             //gives a random location
            
            if(randomPoint<=0.1)
                return "A";
            else if (randomPoint<=0.2)
                return "B";
            else if (randomPoint<=0.3)
                return "C";
            else if (randomPoint<=0.4)              
                return "D";
            else if (randomPoint<=0.5)
                return "E";
            else if (randomPoint<=0.6)
                return "F";
            else if (randomPoint<=0.7)
                return "G";
            else if (randomPoint<=0.8)
                return "H";
            else if (randomPoint<=0.9)
                return "I";
            else
                return "J";
        }
    }

    class Triangulation extends LocationCalculator{
        Random random = new Random();
        double randomPoint = random.nextDouble();

        @Override
        String LocationCalcuator() {             //gives a random location
            
            if(randomPoint<=0.1)
                return "A";
            else if (randomPoint<=0.2)
                return "B";
            else if (randomPoint<=0.3)
                return "C";
            else if (randomPoint<=0.4)
                return "D";
            else if (randomPoint<=0.5)
                return "E";
            else if (randomPoint<=0.6)
                return "F";
            else if (randomPoint<=0.7)
                return "G";
            else if (randomPoint<=0.8)
                return "H";
            else if (randomPoint<=0.9)
                return "I";
            else
                return "J";
        }
    }

    abstract class RouteCalculator{
        abstract List<Vertex> RouteCalculator(Vertex location , Vertex destination);
    }

    class DSPM extends RouteCalculator{

        @Override                                //Uses Dijkstra Algorithm to calculate shortest path
        List<Vertex> RouteCalculator(Vertex location , Vertex destination) {
            computePaths(location); // run Dijkstra
            System.out.println("Distance to " + ": " + destination.minDistance);
            List<Vertex> path = getShortestPathTo(destination);
            System.out.println("Path: " + path);
            
            return path;
        }
    }

    class BFM extends RouteCalculator{
        @Override                                //Uses Dijkstra Algorithm to calculate shortest path          
        List<Vertex> RouteCalculator(Vertex location , Vertex destination) {
            computePaths(location); // run Dijkstra
            System.out.println("Distance to " + ": " + destination.minDistance);
            List<Vertex> path = getShortestPathTo(destination);
            System.out.println("Path: " + path);
            return path;
        }
    }

    abstract class VersionFactory{}
    
    

    class Version1 extends VersionFactory{       //there is 2 different "location" and "route" calculators 
        LocationCalculator l = new GPS();        //our first version uses GPS method and DSPM 
        RouteCalculator r = new DSPM();          //our second version uses Triangulation and BFM 
    }                                            //when they called 

    class Version2 extends VersionFactory{
        LocationCalculator l = new Triangulation();
        RouteCalculator r = new BFM();
    }





