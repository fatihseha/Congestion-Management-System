//FATİH SEHA ÖÇAL 
//BULUTHAN İNAN
//ALPEREN ERTAN
//RAMAZAN BAYBÖREK
//CONGESTION MANAGEMENT SYSTEM

package CongestionSystem;

import java.util.ArrayList;


interface Observer {
    public void Update(TrafficSensor trafficSensor);
}

//'ConcreteObserver' ==> Investor

class Controller implements Observer {
    private ArrayList<TrafficSensor> sensors = new ArrayList<TrafficSensor>();      //where we keep sensors

    public void Update(TrafficSensor trafficSensor) {                               //updating the controller array according 
        for(int i =0 ; i<sensors.size() ; i++){                                     //to a change in specific traffic sensor        
            if(sensors.get(i).getStreet().equals(trafficSensor.getStreet())){
                sensors.get(i).setCongestion1(trafficSensor.getCongestion());
            }
        }
    }
    public ArrayList<TrafficSensor> getSensors() { return sensors; }                //this method return sensor Array in Controller
    public void setSensors(ArrayList<TrafficSensor> sensors) { this.sensors = sensors; } //this method sets a new sensor Array in Controller

    public void Accept(Visitor visitor) {                                                
        // set argument to something that helps
        // tell the Observers what happened
        for (int i = 0; i < sensors.size(); i++) {
            sensors.get(i).Accept(visitor);		}
    }

}

