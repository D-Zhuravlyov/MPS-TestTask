package mps.nodes;

import com.google.gson.Gson;
import mps.exception.NodeException;
import mps.model.Aircraft;
import mps.model.Delta;
import org.apache.log4j.Logger;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.util.Util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by D.Zh. on 20.11.15.
 * dmitry.zhuravlyov@yahoo.com
 */
public class AircraftNode extends ReceiverAdapter implements Runnable {


    private Gson gson = new Gson();
    final static Logger logger = Logger.getLogger(Aircraft.class);

    private int deltaTimerMillis = 3000;

    private Aircraft aircraft;
    private JChannel channel;

    public AircraftNode() {
    }

    public AircraftNode(Aircraft aircraft, String clusterName) throws Exception {
        this.aircraft = aircraft;
        connectToCluster(clusterName);
    }

    private void connectToCluster(String clusterName) throws Exception {
        channel = new JChannel();
        channel.setReceiver(this);
        channel.connect(clusterName);

    }

    @Override
    public void viewAccepted(View view) {
        System.out.println("** Aircraft view: " + view);
    }


    @Override
    public void receive(Message msg) {
    }

    public void run() {
        while (true) {
            try {
                if (aircraft == null) {
                    throw new NodeException("No aircraft assigned to Node found!");
                }
                aircraft.increaseValues(new Delta(20.00));
                Message msg = new Message(null, null, gson.toJson(aircraft));
                channel.send(msg);
                Thread.sleep(deltaTimerMillis);
            } catch (Exception e) {
                logger.trace("No aircraft assigned to Node found!");
            }
        }
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        if (aircraft != null) {
            this.aircraft = aircraft;
        }
    }

    public int getDeltaTimerMillis() {
        return deltaTimerMillis;
    }

    public void setDeltaTimerMillis(int deltaTimerMillis) {
        this.deltaTimerMillis = deltaTimerMillis;
    }
}
