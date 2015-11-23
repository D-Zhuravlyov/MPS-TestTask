package mps.start;

import mps.model.Aircraft;
import mps.model.Airplane;
import mps.model.AirplaneType;
import mps.dispatcher.DispatcherCenter;
import mps.nodes.AircraftNode;
import mps.nodes.DispatcherCenterNode;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by D.Zh. on 12.11.15.
 * dmitry.zhuravlyov@yahoo.com
 */
public class Start {
    public static void main(String[] args) {

        final String clusterName = "TEST";
        try {
            DispatcherCenter dispatcherCenter = new DispatcherCenter();

            DispatcherCenterNode dispatcherNode = new DispatcherCenterNode(dispatcherCenter);


            Airplane airplane1 = new Airplane(AirplaneType.A300, 1, 200., 100., 100., 100.);

            Airplane airplane2 = new Airplane(AirplaneType.B777, 2, 200., 100., 100., 100.);

            Airplane airplane3 = new Airplane(AirplaneType.L39, 3, 200., 100., 100., 100.);

            dispatcherCenter.addAircraft(airplane1);
            dispatcherCenter.addAircraft(airplane2);
            dispatcherCenter.addAircraft(airplane3);


            dispatcherNode.init(clusterName);

            Thread tr = new Thread(new AircraftNode(airplane1, clusterName));
            Thread tr2 = new Thread(new AircraftNode(airplane2, clusterName));
            Thread tr3 = new Thread(new AircraftNode(airplane3, clusterName));
            Thread tr4 = new Thread(dispatcherNode);
            tr4.start();
            tr.start();
            tr3.start();
            tr2.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception in Start class");
        }
    }

}
