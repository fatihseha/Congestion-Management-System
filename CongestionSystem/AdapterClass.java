//FATİH SEHA ÖÇAL 
//BULUTHAN İNAN
//ALPEREN ERTAN
//RAMAZAN BAYBÖREK
//CONGESTION MANAGEMENT SYSTEM

package CongestionSystem;

import java.util.Random;

//it is an interface for Apple Sensor
interface AppleSensorInterface {
    double usingAppleSensor();
    void Notify();
    void Attach(Controller controller);
    void Detach();
    void setStreet(Edge street);
    Edge getStreet();
    double getCongestion();
    void setCongestion(double congestion);
    void setCongestion1(double congestion);

}
//it is an interface for Samsung Sensor
interface SamsungSensorInterface{
    double usingSamsungSensor();
    void Notify();
    void Attach(Controller controller);
    void Detach();
    void setStreet(Edge street);
    Edge getStreet();
    double getCongestion();
    void setCongestion(double congestion);
    void setCongestion1(double congestion);
}
//it is an interface for Sony Sensor
interface SonySensorInterface{
    double usingSonySensor();
    void Notify();
    void Attach(Controller controller);
    void Detach();
    void setStreet(Edge street);
    Edge getStreet();
    double getCongestion();
    void setCongestion(double congestion);
    void setCongestion1(double congestion);
}

//Target(base) class for sensors
abstract class TrafficSensor {
    protected Controller controller;

    //constructor of the class
    public TrafficSensor(Controller controller) {
        this.controller = controller;
        this.street=null;
        controller.getSensors().add(this);
    }

    //constructors of traffic sensor
    private Edge street;
    //we give random values for congestion

    private double congestion;

    //constructor method of the class
    public double usingTrafficSensor() {
        System.out.println("Street :"+" Congestion : "+congestion);
        return congestion;
    }
    //the method with using an address parameter for setting address
    public void setStreet(Edge street){
        this.street=street;
    }

    //the method for getting address as a string datatype
    public Edge getStreet() {
        return street;
    }

    //the method for getting congestion as a double datatype
    public double getCongestion(){
        return congestion;
    }

    public void setCongestion(double congestion){
        this.congestion=congestion;                     //Changing congestion and notifying
        Notify();                                      
    }

    public void Attach (Controller controller) {
        this.controller=controller;                     //Attaching a new controller
    }

    //Unregister from the list of Observers.
    public void Detach () {
       this.controller=null;
    }
    //Notify the Observers.
    public void Notify() {
        // set argument to something that helps
        // tell the Observers what happened
        controller.Update(this);
        System.out.println(" changed "+this.congestion);
    }

    public void setCongestion1(double congestion1){
        this.congestion=congestion1;                        //Changing the congestion without notifying
    }

    public void Accept(Visitor visitor) {}
}

//It's an adapter class for turning apple sensors to traffic sensors with using apple sensor interface
class AppleToTraffic extends TrafficSensor implements AppleSensorInterface  {

    //constructor method of the class
    public AppleToTraffic(Controller controller) {
        super(controller);
    }

    @Override
    public double usingAppleSensor() {
        System.out.println(" Congestion : "+getCongestion());

        return getCongestion();
    }


    public void Attach (Controller controller) {
        this.controller=controller;
    }

    //Unregister from the list of Observers.
    public void Detach () {
        this.controller=null;
    }
    //Notify the Observers.
    public void Notify() {
        // set argument to something that helps
        // tell the Observers what happened
        controller.Update(this);
        System.out.println(" changed "+this.getCongestion());
    }

    public void Accept(Visitor visitor) {visitor.Visit(this);}
}


//It's an adapter class for turning samsung sensors to traffic sensors with using samsung sensor interface
class SamsungToTraffic extends TrafficSensor implements SamsungSensorInterface  {

    //constructor method of the class
    public SamsungToTraffic(Controller controller) {
        super(controller);
    }

    @Override
    public double usingSamsungSensor() {
        System.out.println( " Congestion : "+getCongestion());

        return getCongestion();
    }




    public void Attach (Controller controller) {
        this.controller=controller;
    }

    //Unregister from the list of Observers.
    public void Detach () {
        this.controller=null;
    }
    //Notify the Observers.
    public void Notify() {
        // set argument to something that helps
        // tell the Observers what happened
        controller.Update(this);
        System.out.println(" changed "+this.getCongestion());
    }

    public void Accept(Visitor visitor) {visitor.Visit(this);}
}


//It's an adapter class for turning sony sensors to traffic sensors with using sony sensor interface
class SonyToTraffic extends TrafficSensor implements SonySensorInterface {

    //constructor method of the class
    public SonyToTraffic(Controller controller) {
        super(controller);
    }

    @Override
    public double usingSonySensor() {
        System.out.println(" Congestion : "+getCongestion());

        return getCongestion();
    }



    public void Attach (Controller controller) {
        this.controller=controller;
    }

    //Unregister from the list of Observers.
    public void Detach () {
        this.controller=null;
    }
    //Notify the Observers.
    public void Notify() {
        // set argument to something that helps
        // tell the Observers what happened
        controller.Update(this);
        System.out.println(" changed "+this.getCongestion());
    }

    public void Accept(Visitor visitor) {visitor.Visit(this);}
}



