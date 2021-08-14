//FATİH SEHA ÖÇAL 
//BULUTHAN İNAN
//ALPEREN ERTAN
//RAMAZAN BAYBÖREK
//CONGESTION MANAGEMENT SYSTEM

package CongestionSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;

public class IteratorClass {   
        //We use it to iterate between edges and we set congestions
	static void congestionChange(Iterator<Edge> itr) {		
		while (itr.hasNext()) {
                     Random rand = new Random();
                     double randCongestion = rand.nextDouble();
                    
			Edge element = itr.next();
			if(element.congestion>0.9){
                            
                            element.congestion=element.congestion-0.1;}
                        else if(element.congestion<0.1)
                            element.congestion=element.congestion+0.1;
                        else if(randCongestion >=0.5)
                            element.congestion=element.congestion+0.1;
                        else
                            element.congestion=element.congestion-0.1;
                          
                        if(element.appleSensorInterface==null && element.samsungSensorInterface==null)
                            element.sonySensorInterface.setCongestion(element.congestion);
                        else if(element.appleSensorInterface==null && element.sonySensorInterface==null)
                            element.samsungSensorInterface.setCongestion(element.congestion);
                        else if(element.samsungSensorInterface==null && element.sonySensorInterface==null)
                            element.appleSensorInterface.setCongestion(element.congestion);
                        
		}           
		
	}
	}
	

