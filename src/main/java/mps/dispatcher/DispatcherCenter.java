package mps.dispatcher;


import mps.model.Aircraft;

import java.util.*;

/**
 * Created by D.Zh. on 12.11.15.
 * dmitry.zhuravlyov@yahoo.com
 */
public class DispatcherCenter{


    private List<Aircraft> aircraftList = new ArrayList<Aircraft>();

    public DispatcherCenter() {
    }

    public void addAircraft(Aircraft aircraft) {
        if (aircraft != null) {
            aircraftList.add(aircraft);
        }
    }

    public void removeAircraft(Aircraft aircraft) {
        if (aircraftList.contains(aircraft)) {
            aircraftList.remove(aircraft);
        }
    }


    public List<Aircraft> getAircraftList() {
        return aircraftList;
    }

    public void setAircraftList(List<Aircraft> aircraftList) {
        this.aircraftList = aircraftList;
    }
}
