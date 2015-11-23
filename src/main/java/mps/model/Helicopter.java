package mps.model;


/**
 * Created by D.Zh. on 12.11.15.
 * dmitry.zhuravlyov@yahoo.com
 */
public class Helicopter extends Aircraft {

    private HeliType heliType;

    public Helicopter(HeliType heliType) {
        this.heliType = heliType;
    }

    public Helicopter(HeliType heliType, Integer number, Double breadth, Double altitude,
                      Double longitude, Double heading) {
        this.heliType = heliType;
        setNumber(number);
        setBreadth(breadth);
        setAltitude(altitude);
        setLongitude(longitude);
        setHeading(heading);
    }

    public HeliType getHeliType() {
        return heliType;
    }

    public void setHeliType(HeliType heliType) {
        this.heliType = heliType;
    }

    @Override
    public String toString() {
        return "Helicopter{" +
                "heliType=" + heliType +
                '}' +
                " " + super.toString();
    }
}
