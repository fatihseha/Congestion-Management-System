//FATİH SEHA ÖÇAL 
//BULUTHAN İNAN
//ALPEREN ERTAN
//RAMAZAN BAYBÖREK
//CONGESTION MANAGEMENT SYSTEM

package CongestionSystem;

import static CongestionSystem.Dijkstra.computePaths;
import static CongestionSystem.Dijkstra.getShortestPathTo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;



public class CongestionSystemGUI extends javax.swing.JFrame{  
        static Controller c1 = new Controller();
        static IteratorClass it = new IteratorClass();
        static Vertex destination;
        static List<Vertex> list;
        
        static Visitor visitor = new CongestionVisitor(); // We create our visitor
    
        static SamsungSensorInterface socket = new SamsungToTraffic(c1);
        static    AppleSensorInterface socket1 = new AppleToTraffic(c1);
        static   SamsungSensorInterface socket2 = new SamsungToTraffic(c1);
        static   AppleSensorInterface socket3 = new AppleToTraffic(c1);
        static   SamsungSensorInterface socket4 = new SamsungToTraffic(c1);
        static  AppleSensorInterface socket5 = new AppleToTraffic(c1);
        static   SamsungSensorInterface socket6 = new SamsungToTraffic(c1);     //We create our sensors here
        static   AppleSensorInterface socket7 = new AppleToTraffic(c1);
        static   AppleSensorInterface socket8 = new AppleToTraffic(c1);
        static  SamsungSensorInterface socket9 = new SamsungToTraffic(c1);
        static  AppleSensorInterface socket10 = new AppleToTraffic(c1);
        static  AppleSensorInterface socket11 = new AppleToTraffic(c1);
        
        static boolean clicked1=false;  //to change our button functions according to these booleans                         
        static boolean clicked2=false;
    
     // mark all the vertices
     static Vertex A = new Vertex("A");
     static  Vertex B = new Vertex("B");
     static Vertex C = new Vertex("C");
     static Vertex D = new Vertex("D");
     static Vertex E = new Vertex("E");             //We create our points here
     static Vertex F = new Vertex("F");
     static  Vertex G = new Vertex("G");
     static Vertex H = new Vertex("H");
     static  Vertex I = new Vertex("I");
     static  Vertex J = new Vertex("J");
     
     Vertex currentPoint;
     static Vertex [] vertexArray = new Vertex[10];
     boolean mapStop = false;       //this booleans prevents map to refresh
     
     static ArrayList<Edge> edgeArray= new ArrayList<Edge>();
     
        boolean AandB=false;
        boolean CandD=false;
        boolean EandF=false;
        boolean JandI=false;                //booleans for helping draw the route 
        boolean IandH=false;
        boolean HandG=false;
        boolean AandJ=false;
        boolean BandC=false;
        boolean DandE=false;
        boolean FandG=false;
        boolean CandI=false;
        boolean EandH=false;
     
     static Edge AB = new Edge(socket,B);
     static Edge AJ = new Edge(socket1,J);
     static Edge BA = new Edge(socket,A);
     static Edge BC = new Edge(socket2,C);
     static Edge CB = new Edge(socket2,B);
     static Edge CD = new Edge(socket3,D);
     static Edge CI = new Edge(socket4,I);
     static Edge DC = new Edge(socket3,C);
     static Edge DE = new Edge(socket5,E);
     static Edge EF = new Edge(socket6,F);      //we define our connections between points
     static Edge ED = new Edge(socket5,D);
     static Edge EH = new Edge(socket7,H);
     static Edge FE = new Edge(socket6,E);
     static Edge FG = new Edge(socket8,G);
     static Edge GH = new Edge(socket9,H);
     static Edge GF = new Edge(socket8,F);
     static Edge HE = new Edge(socket7,E);
     static Edge HI = new Edge(socket10,I);
     static Edge IH = new Edge(socket10,H);
     static Edge HG = new Edge(socket9,G);
     static Edge IC = new Edge(socket4,C);
     static Edge IJ = new Edge(socket11,J);
     static Edge JI = new Edge(socket11,I);
     static Edge JA = new Edge(socket1,A);
     
     
     
     
     
     
     
    
     
        
    Graphics g;    
    boolean isClickedMapButton = false;
    
    
   
    
    public CongestionSystemGUI() {
        initComponents();
    }
    
    void map(){                     //we draw our map here 
        
        
        APoint.setVisible(true);                
        BPoint.setVisible(true);
        CPoint.setVisible(true);                
        DPoint.setVisible(true);
        EPoint.setVisible(true);                
        FPoint.setVisible(true);
        GPoint.setVisible(true);                
        HPoint.setVisible(true);
        IPoint.setVisible(true);                
        JPoint.setVisible(true);
        
        //we draw our lines and give them colors according to congestion here 
          //                        until line 282 
   
        
        Graphics AB = getGraphics();
        System.out.println("socket değeri="+socket.getCongestion());
        
        if(socket.getCongestion()>0.7)
            AB.setColor(Color.RED);
        else if(socket.getCongestion()>0.33 && socket.getCongestion()<=0.7)
            AB.setColor(Color.BLUE);
        else
            AB.setColor(Color.YELLOW);
        if(AandB){
            AB.setColor(Color.GREEN);
        }
        AB.drawLine(240,100,320,100);   
        
        Graphics CD = getGraphics();
        if(socket3.getCongestion()>0.7)
            CD.setColor(Color.RED);
        else if(socket3.getCongestion()>0.33 && socket3.getCongestion()<=0.7)
            CD.setColor(Color.BLUE);
        else
            CD.setColor(Color.YELLOW);
        if(CandD){
            CD.setColor(Color.GREEN);
        }
        CD.drawLine(320,200,400,200);
   
        Graphics EF = getGraphics();
        if(socket6.getCongestion()>0.7)
            EF.setColor(Color.RED);
        else if(socket6.getCongestion()>0.33 && socket6.getCongestion()<=0.7)
            EF.setColor(Color.BLUE);
        else
            EF.setColor(Color.YELLOW);
        if(EandF){
            EF.setColor(Color.GREEN);
        }
        EF.drawLine(400,300,480,300);
    
        Graphics JI = getGraphics();
        if(socket11.getCongestion()>0.7)
            JI.setColor(Color.RED);
        else if(socket11.getCongestion()>0.33 && socket11.getCongestion()<=0.7)
            JI.setColor(Color.BLUE);
        else
            JI.setColor(Color.YELLOW);
        if(JandI){
            JI.setColor(Color.GREEN);
        }
        JI.drawLine(240,400,320,400);
    
        Graphics IH = getGraphics();
        if(socket10.getCongestion()>0.7)
            IH.setColor(Color.RED);
        else if(socket10.getCongestion()>0.33 && socket10.getCongestion()<=0.7)
            IH.setColor(Color.BLUE);
        else
            IH.setColor(Color.YELLOW);
        if(IandH){
            IH.setColor(Color.GREEN);
        }
        IH.drawLine(320,400,400,400);
    
        Graphics HG = getGraphics();
        if(socket9.getCongestion()>0.7)
            HG.setColor(Color.RED);
        else if(socket9.getCongestion()>0.33 && socket9.getCongestion()<=0.7)
            HG.setColor(Color.BLUE);
        else
            HG.setColor(Color.YELLOW);
        if(HandG){
            HG.setColor(Color.GREEN);
        }
        HG.drawLine(400,400,480,400);
   
        Graphics AJ = getGraphics();
        if(socket1.getCongestion()>0.7)
            AJ.setColor(Color.RED);
        else if(socket1.getCongestion()>0.33 && socket1.getCongestion()<=0.7)
            AJ.setColor(Color.BLUE);
        else
            AJ.setColor(Color.YELLOW);  
        if(AandJ){
            AJ.setColor(Color.GREEN);
        }
        AJ.drawLine(240,100,240,400);
    
        Graphics BC = getGraphics();
        if(socket2.getCongestion()>0.7)
            BC.setColor(Color.RED);
        else if(socket2.getCongestion()>0.33 && socket2.getCongestion()<=0.7)
            BC.setColor(Color.BLUE);
        else
            BC.setColor(Color.YELLOW);
        if(BandC){
            BC.setColor(Color.GREEN);
        }
        BC.drawLine(320,100,320,200);
    
        Graphics DE = getGraphics();
        if(socket5.getCongestion()>0.7)
            DE.setColor(Color.RED);
        else if(socket5.getCongestion()>0.33 && socket5.getCongestion()<=0.7)
            DE.setColor(Color.BLUE);
        else
            DE.setColor(Color.YELLOW);
        if(DandE){
            DE.setColor(Color.GREEN);
        }
        DE.drawLine(400,200,400,300);
    
    
        Graphics FG = getGraphics();
        if(socket8.getCongestion()>0.7)
            FG.setColor(Color.RED);
        else if(socket8.getCongestion()>0.33 && socket8.getCongestion()<=0.7)
            FG.setColor(Color.BLUE);
        else
            FG.setColor(Color.YELLOW);
        if(FandG){
            FG.setColor(Color.GREEN);
        }
        FG.drawLine(480,300,480,400);
    
    
        Graphics CI = getGraphics();
        if(socket4.getCongestion()>0.7)
            CI.setColor(Color.RED);
        else if(socket4.getCongestion()>0.33 && socket4.getCongestion()<=0.7)
            CI.setColor(Color.BLUE);
        else
            CI.setColor(Color.YELLOW);
        if(CandI){
            CI.setColor(Color.GREEN);
        }
        CI.drawLine(320,200,320,400);
    
    
        Graphics EH = getGraphics();
        if(socket7.getCongestion()>0.7)
            EH.setColor(Color.RED);
        else if(socket7.getCongestion()>0.33 && socket7.getCongestion()<=0.7)
            EH.setColor(Color.BLUE);
        else
            EH.setColor(Color.YELLOW);
        if(EandH){
            EH.setColor(Color.GREEN);
        }
        EH.drawLine(400,300,400,400);
        
        System.out.println(socket.getCongestion());
        System.out.println(socket1.getCongestion());
        System.out.println(socket2.getCongestion());
        System.out.println(socket3.getCongestion());
        System.out.println(socket4.getCongestion());
        System.out.println(socket5.getCongestion());
        System.out.println(socket6.getCongestion());
        System.out.println(socket7.getCongestion());
        System.out.println(socket8.getCongestion());
        System.out.println(socket9.getCongestion());        
        System.out.println(socket10.getCongestion());
        System.out.println(IJ.congestion);
        
        
        
    }
    void refreshMap(){
        map();
    }
    
    
    
    void every10seconds(){      //every 2 seconds this method creates new map with new congestions 
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
    @Override
    public void run() {
        if(mapStop)
            return;
        else{
            try {
                every1second();
                refreshMap();
                edgeArray.clear();
                Thread.sleep(4000);
                revalidate();
                map();
                pack();
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(CongestionSystemGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
        
        }
            }, 0, 2000);//wait 0 ms before doing the action and do it evry 1000ms (1second)
        

            
    }
    
    void disableMapButton(){
        displayMapButton.setEnabled(false);
    }
   
    void every1second(){            //this method uses iterator to give new congestion to connections 
        edgeArray.add(AB);
        edgeArray.add(AJ);
        edgeArray.add(BA);
        edgeArray.add(BC);
        edgeArray.add(CB);
        edgeArray.add(CD);
        edgeArray.add(CI);
        edgeArray.add(DC);
        edgeArray.add(DE);
        edgeArray.add(EF);
        edgeArray.add(ED);
        edgeArray.add(EH);
        edgeArray.add(FE);
        edgeArray.add(FG);
        edgeArray.add(GH);
        edgeArray.add(GF);
        edgeArray.add(HE);
        edgeArray.add(HI);
        edgeArray.add(IH);
        edgeArray.add(HG);
        edgeArray.add(IC);
        edgeArray.add(IJ);
        edgeArray.add(JI);
        edgeArray.add(JA);
        
        Iterator<Edge> iterator = edgeArray.iterator();
	ListIterator<Edge> itr = edgeArray.listIterator(edgeArray.size());
        
        
        IteratorClass.congestionChange(iterator); 
        
       
    
    }
    
    //initiation of our components
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        v2CalculateButton = new javax.swing.JButton();
        v1CalculateButton = new javax.swing.JButton();
        destinationComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        displayMapButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        userLocationFixed = new javax.swing.JTextField();
        APoint = new javax.swing.JLabel();
        BPoint = new javax.swing.JLabel();
        CPoint = new javax.swing.JLabel();
        DPoint = new javax.swing.JLabel();
        EPoint = new javax.swing.JLabel();
        FPoint = new javax.swing.JLabel();
        GPoint = new javax.swing.JLabel();
        HPoint = new javax.swing.JLabel();
        IPoint = new javax.swing.JLabel();
        JPoint = new javax.swing.JLabel();
        PathTextField = new javax.swing.JLabel();
        currentLocationTextField = new javax.swing.JLabel();
        RefreshButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        v2CalculateButton.setText("Version2");
        v2CalculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v2CalculateButtonActionPerformed(evt);
            }
        });

        v1CalculateButton.setText("Version1");
        v1CalculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v1CalculateButtonActionPerformed(evt);
            }
        });

        destinationComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Destination: ");

        jLabel2.setText("Calculate:");

        jLabel3.setText("Calculate:");

        displayMapButton.setText("DISPLAY MAP");
        displayMapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayMapButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Your Location :");

        userLocationFixed.setEditable(false);

        APoint.setText("A");

        BPoint.setText("B");

        CPoint.setText("C");

        DPoint.setText("D");

        EPoint.setText("E");

        FPoint.setText("F");

        GPoint.setText("G");

        HPoint.setText("H");

        IPoint.setText("I");

        JPoint.setText("J");

        RefreshButton.setText("Refresh");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displayMapButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(v1CalculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(v2CalculateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(RefreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(destinationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(APoint)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userLocationFixed, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(222, 222, 222)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(MainPanelLayout.createSequentialGroup()
                                        .addComponent(JPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(80, 80, 80)
                                        .addComponent(IPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(80, 80, 80)
                                        .addComponent(HPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)
                                        .addComponent(GPoint))
                                    .addGroup(MainPanelLayout.createSequentialGroup()
                                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addComponent(CPoint)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(DPoint))
                                            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(BPoint)
                                                .addGroup(MainPanelLayout.createSequentialGroup()
                                                    .addGap(84, 84, 84)
                                                    .addComponent(EPoint))))
                                        .addGap(70, 70, 70)
                                        .addComponent(FPoint))))
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(currentLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(221, 221, 221)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 256, Short.MAX_VALUE)))
                .addContainerGap())
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(displayMapButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(userLocationFixed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(APoint)
                    .addComponent(BPoint))
                .addGap(79, 79, 79)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CPoint)
                    .addComponent(DPoint))
                .addGap(84, 84, 84)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EPoint)
                    .addComponent(FPoint))
                .addGap(105, 105, 105)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GPoint)
                    .addComponent(HPoint)
                    .addComponent(IPoint)
                    .addComponent(JPoint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 548, Short.MAX_VALUE)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(PathTextField)
                    .addComponent(currentLocationTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(v1CalculateButton)
                    .addComponent(v2CalculateButton)
                    .addComponent(destinationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(RefreshButton))
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 965, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 986, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void v2CalculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v2CalculateButtonActionPerformed
        //this method calls when button2 clicked
       //this button calculates the route according to selected version 
        
        
        if(clicked2==false){
            v1CalculateButton.setText("Get location with Triangulation");
            v2CalculateButton.setText("Get route using BFM");
            v2CalculateButton.setEnabled(false);
            clicked1=true;
            
        }
        else{
            if(v1CalculateButton.getText().equals("Get location with GPS")){
                 Version1 v1 = new Version1();
                 
                 list=v1.r.RouteCalculator(currentPoint, destination);
                 PathTextField.setText(list.toString());
                 
                 System.out.println("v1 rota calculate");
                 for(int i=0;i<list.size()-1;i++){
                     if(list.get(i).name.equals("A") && list.get(i+1).name.equals("B")){
                         AandB=true;
                     }
                     if(list.get(i).name.equals("B") && list.get(i+1).name.equals("A")){
                         AandB=true;
                     }
                     if(list.get(i).name.equals("A") && list.get(i+1).name.equals("J")){
                         AandJ=true;
                     }
                     if(list.get(i).name.equals("J") && list.get(i+1).name.equals("A")){
                         AandJ=true;
                     }
                     if(list.get(i).name.equals("B") && list.get(i+1).name.equals("C")){
                         BandC=true;
                     }
                     if(list.get(i).name.equals("C") && list.get(i+1).name.equals("B")){
                         BandC=true;
                     }
                     if(list.get(i).name.equals("C") && list.get(i+1).name.equals("D")){
                         CandD=true;
                     }
                     if(list.get(i).name.equals("D") && list.get(i+1).name.equals("C")){
                         CandD=true;
                     }
                     if(list.get(i).name.equals("C") && list.get(i+1).name.equals("I")){
                        CandI=true;
                     }
                     if(list.get(i).name.equals("I") && list.get(i+1).name.equals("C")){
                        CandI=true;
                     }
                     if(list.get(i).name.equals("D") && list.get(i+1).name.equals("E")){
                         DandE=true;
                     }
                     if(list.get(i).name.equals("E") && list.get(i+1).name.equals("D")){
                         DandE=true;
                     }
                     if(list.get(i).name.equals("E") && list.get(i+1).name.equals("F")){
                         EandF=true;
                     }
                     if(list.get(i).name.equals("F") && list.get(i+1).name.equals("E")){
                         EandF=true;
                     }
                     if(list.get(i).name.equals("H") && list.get(i+1).name.equals("E")){
                         EandH=true;
                     }
                     if(list.get(i).name.equals("E") && list.get(i+1).name.equals("H")){
                         EandH=true;
                     }
                     if(list.get(i).name.equals("F") && list.get(i+1).name.equals("G")){
                         FandG=true;
                     }
                     if(list.get(i).name.equals("G") && list.get(i+1).name.equals("F")){
                         FandG=true;
                     }
                     if(list.get(i).name.equals("G") && list.get(i+1).name.equals("H")){
                         HandG=true;
                     }
                     if(list.get(i).name.equals("H") && list.get(i+1).name.equals("G")){
                         HandG=true;
                     }
                     if(list.get(i).name.equals("H") && list.get(i+1).name.equals("I")){
                         IandH=true;
                     }
                     if(list.get(i).name.equals("I") && list.get(i+1).name.equals("H")){
                         IandH=true;
                     }
                     if(list.get(i).name.equals("I") && list.get(i+1).name.equals("J")){
                         JandI=true;
                     }
                     if(list.get(i).name.equals("J") && list.get(i+1).name.equals("I")){
                         JandI=true;
                     }
                     
                 }
                 map(); //after we decide where should be green we redraw the map according to that.
                 return;
        
            }
            else if(v1CalculateButton.getText().equals("Get location with Triangulation")){
            Version2 v2 = new Version2();
                 
                 list=v2.r.RouteCalculator(currentPoint, destination);}
                 PathTextField.setText(list.toString());
            
            
            System.out.println("v2 rota calculate");
            for(int i=0;i<list.size()-1;i++){   //here where we decide which connection should be green
                     if(list.get(i).name.equals("A") && list.get(i+1).name.equals("B")){
                         AandB=true;
                     }
                     if(list.get(i).name.equals("B") && list.get(i+1).name.equals("A")){
                         AandB=true;
                     }
                     if(list.get(i).name.equals("A") && list.get(i+1).name.equals("J")){
                         AandJ=true;
                     }
                     if(list.get(i).name.equals("J") && list.get(i+1).name.equals("A")){
                         AandJ=true;
                     }
                     if(list.get(i).name.equals("B") && list.get(i+1).name.equals("C")){
                         BandC=true;
                     }
                     if(list.get(i).name.equals("C") && list.get(i+1).name.equals("B")){
                         BandC=true;
                     }
                     if(list.get(i).name.equals("C") && list.get(i+1).name.equals("D")){
                         CandD=true;
                     }
                     if(list.get(i).name.equals("D") && list.get(i+1).name.equals("C")){
                         CandD=true;
                     }
                     if(list.get(i).name.equals("C") && list.get(i+1).name.equals("I")){
                        CandI=true;
                     }
                     if(list.get(i).name.equals("I") && list.get(i+1).name.equals("C")){
                        CandI=true;
                     }
                     if(list.get(i).name.equals("D") && list.get(i+1).name.equals("E")){
                         DandE=true;
                     }
                     if(list.get(i).name.equals("E") && list.get(i+1).name.equals("D")){
                         DandE=true;
                     }
                     if(list.get(i).name.equals("E") && list.get(i+1).name.equals("F")){
                         EandF=true;
                     }
                     if(list.get(i).name.equals("F") && list.get(i+1).name.equals("E")){
                         EandF=true;
                     }
                     if(list.get(i).name.equals("H") && list.get(i+1).name.equals("E")){
                         EandH=true;
                     }
                     if(list.get(i).name.equals("E") && list.get(i+1).name.equals("H")){
                         EandH=true;
                     }
                     if(list.get(i).name.equals("F") && list.get(i+1).name.equals("G")){
                         FandG=true;
                     }
                     if(list.get(i).name.equals("G") && list.get(i+1).name.equals("F")){
                         FandG=true;
                     }
                     if(list.get(i).name.equals("G") && list.get(i+1).name.equals("H")){
                         HandG=true;
                     }
                     if(list.get(i).name.equals("H") && list.get(i+1).name.equals("G")){
                         HandG=true;
                     }
                     if(list.get(i).name.equals("H") && list.get(i+1).name.equals("I")){
                         IandH=true;
                     }
                     if(list.get(i).name.equals("I") && list.get(i+1).name.equals("H")){
                         IandH=true;
                     }
                     if(list.get(i).name.equals("I") && list.get(i+1).name.equals("J")){
                         JandI=true;
                     }
                     if(list.get(i).name.equals("J") && list.get(i+1).name.equals("I")){
                         JandI=true;
                     }
                     
                 }
                 map(); //after we decide where should be green we redraw the map according to that.
            return;
        }
       
    }//GEN-LAST:event_v2CalculateButtonActionPerformed

    private void v1CalculateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v1CalculateButtonActionPerformed
        //this method calls when button1 clicked
        //this button calculates the location according to selected version 
        
        
        if(clicked1==false){
            v1CalculateButton.setText("Get location with GPS");
            v2CalculateButton.setText("Get route using DSPM");
            v2CalculateButton.setEnabled(false);
            clicked1=true;
        }
        else{
            if(clicked1==true){
        mapStop=true;
        v2CalculateButton.setEnabled(true);
        Version1 version1 = new Version1();
                    vertexArray[0] = A;
                    vertexArray[1] = B;
                    vertexArray[2] = C;
                    vertexArray[3] = D;
                    vertexArray[4] = E;
                    vertexArray[5] = F;
                    vertexArray[6] = G;
                    vertexArray[7] = H;
                    vertexArray[8] = I;
                    vertexArray[9] = J;
                    
                    
                for(int i = 0 ; i<vertexArray.length;i++){
                            if(vertexArray[i].toString().equals(version1.l.LocationCalcuator())){
                                    currentPoint=vertexArray[i];
                            }
                    }
                userLocationFixed.setText(currentPoint.toString());
                currentLocationTextField.setText(currentPoint.toString());
                
                
                if(userLocationFixed.getText().equals("A"))
                    destinationComboBox.removeItemAt(0);                
                else if(userLocationFixed.getText().equals("B"))
                    destinationComboBox.removeItemAt(1);
                else if(userLocationFixed.getText().equals("C"))
                    destinationComboBox.removeItemAt(2);
                else if(userLocationFixed.getText().equals("D"))
                    destinationComboBox.removeItemAt(3);
                else if(userLocationFixed.getText().equals("E"))
                    destinationComboBox.removeItemAt(4);                //current location removes from the destination points(combobox)
                else if(userLocationFixed.getText().equals("F"))
                    destinationComboBox.removeItemAt(5);
                else if(userLocationFixed.getText().equals("G"))
                    destinationComboBox.removeItemAt(6);
                else if(userLocationFixed.getText().equals("H"))
                    destinationComboBox.removeItemAt(7);
                else if(userLocationFixed.getText().equals("I"))
                    destinationComboBox.removeItemAt(8);
                else if(userLocationFixed.getText().equals("J"))
                    destinationComboBox.removeItemAt(9);
                clicked2=true;               

        }
            else{
                if(clicked2==true){
                    mapStop=true;
                    v2CalculateButton.setEnabled(true);
        Version2 version2 = new Version2();
                    vertexArray[0] = A;
                    vertexArray[1] = B;
                    vertexArray[2] = C;
                    vertexArray[3] = D;
                    vertexArray[4] = E;
                    vertexArray[5] = F;
                    vertexArray[6] = G;
                    vertexArray[7] = H;
                    vertexArray[8] = I;
                    vertexArray[9] = J;
                    
                    
                for(int i = 0 ; i<vertexArray.length;i++){
                            if(vertexArray[i].toString().equals(version2.l.LocationCalcuator())){
                                    currentPoint=vertexArray[i];
                            }
                    }
                userLocationFixed.setText(currentPoint.toString());
                currentLocationTextField.setText(currentPoint.toString());
                
                
                if(userLocationFixed.getText().equals("A"))
                    destinationComboBox.removeItemAt(0);                
                else if(userLocationFixed.getText().equals("B"))
                    destinationComboBox.removeItemAt(1);
                else if(userLocationFixed.getText().equals("C"))
                    destinationComboBox.removeItemAt(2);
                else if(userLocationFixed.getText().equals("D"))             //current location removes from the destination points(combobox)
                    destinationComboBox.removeItemAt(3);
                else if(userLocationFixed.getText().equals("E"))
                    destinationComboBox.removeItemAt(4);
                else if(userLocationFixed.getText().equals("F"))
                    destinationComboBox.removeItemAt(5);
                else if(userLocationFixed.getText().equals("G"))
                    destinationComboBox.removeItemAt(6);
                else if(userLocationFixed.getText().equals("H"))
                    destinationComboBox.removeItemAt(7);
                else if(userLocationFixed.getText().equals("I"))
                    destinationComboBox.removeItemAt(8);
                else if(userLocationFixed.getText().equals("J"))
                    destinationComboBox.removeItemAt(9);
                    
                }
            }
        }
        
    }//GEN-LAST:event_v1CalculateButtonActionPerformed
    //when display map button clicked this method runs
    private void displayMapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayMapButtonActionPerformed
        // TODO add your handling code here: 
        //every1second();
        map();
        every10seconds();
        isClickedMapButton=true;
        disableMapButton();
    }//GEN-LAST:event_displayMapButtonActionPerformed

    private void destinationComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationComboBoxActionPerformed
        // TODO add your handling code here:
        if(destinationComboBox.getSelectedItem().equals("A"))
                    destination=A;           
        else if(destinationComboBox.getSelectedItem().equals("B"))
                    destination=B; 
        else if(destinationComboBox.getSelectedItem().equals("C"))
                    destination=C;
        else if(destinationComboBox.getSelectedItem().equals("D"))
                    destination=D; 
        else if(destinationComboBox.getSelectedItem().equals("E"))      //if a new item selected from the combobox
                    destination=E;                                       //we make that item our destination 
        else if(destinationComboBox.getSelectedItem().equals("F"))          
                    destination=F; 
        else if(destinationComboBox.getSelectedItem().equals("G"))
                    destination=G; 
        else if(destinationComboBox.getSelectedItem().equals("H"))
                    destination=H; 
        else if(destinationComboBox.getSelectedItem().equals("I"))
                    destination=I; 
        else if(destinationComboBox.getSelectedItem().equals("J"))
                    destination=J; 
    }//GEN-LAST:event_destinationComboBoxActionPerformed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed

        c1.Accept(visitor);
    }//GEN-LAST:event_RefreshButtonActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CongestionSystemGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CongestionSystemGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CongestionSystemGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CongestionSystemGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CongestionSystemGUI cong = new CongestionSystemGUI();
                cong.setVisible(true);                
                
                MainPanel.setVisible(true);
                
                APoint.setVisible(false);                
                BPoint.setVisible(false);
                CPoint.setVisible(false);                
                DPoint.setVisible(false);
                EPoint.setVisible(false);                
                FPoint.setVisible(false);
                GPoint.setVisible(false);                
                HPoint.setVisible(false);
                IPoint.setVisible(false);                
                JPoint.setVisible(false);
                
                
        String destination;    


        // set the edges and weight
        A.addStreet(AB);
        A.addStreet(AJ);
        B.addStreet(BA);
        B.addStreet(BC);
        C.addStreet(CB);
        C.addStreet(CD);
        C.addStreet(CI);
        D.addStreet(DC);
        D.addStreet(DE);
        E.addStreet(EF);
        E.addStreet(ED);
        E.addStreet(EH);
        F.addStreet(FE);
        F.addStreet(FG);
        G.addStreet(GH);
        G.addStreet(GF);
        H.addStreet(HE);
        H.addStreet(HI);
        H.addStreet(HG);
        I.addStreet(IC);
        I.addStreet(IH);
        I.addStreet(IJ);
        J.addStreet(JI);
        J.addStreet(JA); 
        
                    destinationComboBox.addItem("A");
                    destinationComboBox.addItem("B");
                    destinationComboBox.addItem("C");
                    destinationComboBox.addItem("D");
                    destinationComboBox.addItem("E");
                    destinationComboBox.addItem("F");
                    destinationComboBox.addItem("G");
                    destinationComboBox.addItem("H");
                    destinationComboBox.addItem("I");
                    destinationComboBox.addItem("J");
        
        
                    
        
        
        

                
            }
        });
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel APoint;
    public static javax.swing.JLabel BPoint;
    public static javax.swing.JLabel CPoint;
    public static javax.swing.JLabel DPoint;
    public static javax.swing.JLabel EPoint;
    public static javax.swing.JLabel FPoint;
    public static javax.swing.JLabel GPoint;
    public static javax.swing.JLabel HPoint;
    public static javax.swing.JLabel IPoint;
    public static javax.swing.JLabel JPoint;
    private static javax.swing.JPanel MainPanel;
    private javax.swing.JLabel PathTextField;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JLabel currentLocationTextField;
    private static javax.swing.JComboBox<String> destinationComboBox;
    private javax.swing.JButton displayMapButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField userLocationFixed;
    private javax.swing.JButton v1CalculateButton;
    private javax.swing.JButton v2CalculateButton;
    // End of variables declaration//GEN-END:variables
}
