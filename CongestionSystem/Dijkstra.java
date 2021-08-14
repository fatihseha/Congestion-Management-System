//FATİH SEHA ÖÇAL 
//BULUTHAN İNAN
//ALPEREN ERTAN
//RAMAZAN BAYBÖREK
//CONGESTION MANAGEMENT SYSTEM


package CongestionSystem;
import java.util.*;
//This class is our points
class Vertex implements Comparable<Vertex>                  
{
    public final String name;
    public Edge[] adjacencies = new Edge[3];         //this array contains routes between points
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

    public void addStreet(Edge edge){               //adding a new route to a point 
        for(int i =0;i<adjacencies.length;i++){
            if(adjacencies[i]==null){
                adjacencies[i]=edge;
                break;
            }
        }
    }
}

//this class is our routes 
class Edge
{
    public final Vertex target;
    AppleSensorInterface appleSensorInterface;
    SamsungSensorInterface samsungSensorInterface;
    SonySensorInterface sonySensorInterface;
    double congestion;
    Random randomCong = new Random();

    public Edge(AppleSensorInterface appleSensorInterface,Vertex argTarget)
    { target = argTarget;
        this.congestion = randomCong.nextDouble();
        this.appleSensorInterface=appleSensorInterface;
        appleSensorInterface.setStreet(this);
        appleSensorInterface.setCongestion1(congestion);
    }
    public Edge(SamsungSensorInterface samsungSensorInterface,Vertex argTarget)
    { target = argTarget;
        this.congestion = randomCong.nextDouble();
        this.samsungSensorInterface = samsungSensorInterface;
        samsungSensorInterface.setStreet(this);
        samsungSensorInterface.setCongestion1(congestion);
    }
    public Edge(SonySensorInterface sonySensorInterface,Vertex argTarget)
    { target = argTarget;
        this.congestion = randomCong.nextDouble();
        this.sonySensorInterface = sonySensorInterface;
        sonySensorInterface.setStreet(this);
        sonySensorInterface.setCongestion1(congestion);
    }
}

//Dijkstra Algorithm to find the shortest path 
public class Dijkstra
{
    public static void computePaths(Vertex source)
    {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();


            // Visit each edge exiting u
            if(u.adjacencies.length<2){
                for (int i=0;i>2;i++)
                {
                    Vertex v = u.adjacencies[i].target;
                    double weight = u.adjacencies[i].congestion;
                    double distanceThroughU = u.minDistance + weight;
                    if (distanceThroughU < v.minDistance) {
                        vertexQueue.remove(v);
                        v.minDistance = distanceThroughU ;
                        v.previous = u;
                        vertexQueue.add(v);
                    }
                }
            }
            if(u.adjacencies.length>2){
                for (int i=0;i<=1;i++)
                {
                    Vertex v = u.adjacencies[i].target;
                    double weight = u.adjacencies[i].congestion;
                    double distanceThroughU = u.minDistance + weight;
                    if (distanceThroughU < v.minDistance) {
                        vertexQueue.remove(v);
                        v.minDistance = distanceThroughU ;
                        v.previous = u;
                        vertexQueue.add(v);
                    }
                }
            }
        }
    }
    public static List<Vertex> getShortestPathTo(Vertex target)
    {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }
    
}
