package mps.model;


import java.io.Serializable;

/**
 * Created by D.Zh. on 12.11.15.
 * dmitry.zhuravlyov@yahoo.com
 */
public class Aircraft implements Serializable {

    private Integer number;
    private Double breadth;
    private Double altitude;
    private Double heading;
    private Double longitude;

    protected Aircraft() {
    }


    public void increaseValues(Delta delta) {
        if (delta != null) {
            double dlt = delta.getDelta();
            breadth += dlt;
            altitude += dlt;
            longitude += dlt;
            longitude += dlt;
            heading += dlt;
        }
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getBreadth() {
        return breadth;
    }

    public void setBreadth(Double breadth) {
        this.breadth = breadth;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getHeading() {
        return heading;
    }

    public void setHeading(Double heading) {
        this.heading = heading;
    }

    @Override
    public String toString() {
        return "Aircraft{ " +
                "number='" + number + '\'' +
                ", breadth='" + breadth + '\'' +
                ", altitude='" + altitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", heading='" + heading + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aircraft aircraft = (Aircraft) o;

        return number.equals(aircraft.number);

    }

    @Override
    public int hashCode() {
        return 0;
    }
}
