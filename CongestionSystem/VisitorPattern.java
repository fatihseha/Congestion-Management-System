//FATİH SEHA ÖÇAL 
//BULUTHAN İNAN
//ALPEREN ERTAN
//RAMAZAN BAYBÖREK
//CONGESTION MANAGEMENT SYSTEM

package CongestionSystem;

import java.util.ArrayList;
import java.util.Random;

//We used this class to reset our sensors.

interface Element {
    public void Accept(Visitor visitor);
}


interface Visitor {
    public void Visit(AppleToTraffic element);
    public void Visit(SamsungToTraffic element);
    public void Visit(SonyToTraffic element);
}


class CongestionVisitor implements  Visitor {

    @Override
    public void Visit(AppleToTraffic element) {

        element.setCongestion(0.0);
        element.setCongestion(element.getStreet().congestion);
        System.out.println(element.toString()+" reseted.");

    }

    @Override
    public void Visit(SamsungToTraffic element) {

        element.setCongestion(0.0);
        element.setCongestion(element.getStreet().congestion);
        System.out.println(element.toString()+" reseted.");
    }

    @Override
    public void Visit(SonyToTraffic element) {

        element.setCongestion(0.0);
        element.setCongestion(element.getStreet().congestion);
        System.out.println(element.toString()+" reseted.");
    }
}

