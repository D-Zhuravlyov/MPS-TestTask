package mps.nodes;

import com.google.gson.Gson;
import mps.dispatcher.DispatcherCenter;
import mps.model.Aircraft;
import org.apache.log4j.Logger;
import org.jgroups.*;

import java.util.*;

/**
 * Created by D.Zh. on 20.11.15.
 * dmitry.zhuravlyov@yahoo.com
 */
public class DispatcherCenterNode extends ReceiverAdapter implements Runnable{

    final static Logger logger = Logger.getLogger(DispatcherCenterNode.class);
    private Gson gson = new Gson();


    final Set<Aircraft> state = new HashSet<Aircraft>();

    private JChannel channel;

    private DispatcherCenter dispatcherCenter;

    public DispatcherCenterNode(DispatcherCenter dispatcherCenter) {
        this.dispatcherCenter = dispatcherCenter;
    }

    public void init(String clusterName) throws Exception {
        channel = new JChannel();
        channel.setReceiver(this);
        channel.connect(clusterName);
    }

    @Override
    public void receive(Message msg) {
        synchronized (state) {
            state.add(gson.fromJson(msg.getObject().toString(), Aircraft.class));
        }
    }


    @Override
    public void viewAccepted(View view) {
        System.out.println("** Dispatcher view: " + view);
    }


    public void run() {
        while (true) {
            try {
                Calendar date = new GregorianCalendar();
                for (Aircraft a : state) {
                    logger.debug(date.getTime()+": "+a );
                }
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
