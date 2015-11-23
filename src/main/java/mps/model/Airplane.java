package mps.model;

/**
 * Created by D.Zh. on 12.11.15.
 * dmitry.zhuravlyov@yahoo.com
 */
public class Airplane extends Aircraft{

    private AirplaneType airplaneType;

    public Airplane(AirplaneType airplaneType) {
        this.airplaneType = airplaneType;
    }

    public Airplane(AirplaneType airplaneType, Integer number, Double breadth, Double altitude,
                    Double longitude, Double heading) {
        this.airplaneType = airplaneType;
        setNumber(number);
        setBreadth(breadth);
        setAltitude(altitude);
        setLongitude(longitude);
        setHeading(heading);
    }




    public AirplaneType getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(AirplaneType airplaneType) {
        this.airplaneType = airplaneType;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "airplaneType=" + airplaneType;
    }
}
