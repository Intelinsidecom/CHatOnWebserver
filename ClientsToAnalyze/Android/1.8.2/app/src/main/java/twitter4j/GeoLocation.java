package twitter4j;

import java.io.Serializable;

/* loaded from: classes.dex */
public class GeoLocation implements Serializable {
    private static final long serialVersionUID = -4847567157651889935L;
    protected double latitude;
    protected double longitude;

    public GeoLocation(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GeoLocation)) {
            return false;
        }
        GeoLocation geoLocation = (GeoLocation) obj;
        return Double.compare(geoLocation.getLatitude(), this.latitude) == 0 && Double.compare(geoLocation.getLongitude(), this.longitude) == 0;
    }

    public int hashCode() {
        long jDoubleToLongBits = this.latitude != 0.0d ? Double.doubleToLongBits(this.latitude) : 0L;
        int i = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
        long jDoubleToLongBits2 = this.longitude != 0.0d ? Double.doubleToLongBits(this.longitude) : 0L;
        return (i * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
    }

    public String toString() {
        return new StringBuffer().append("GeoLocation{latitude=").append(this.latitude).append(", longitude=").append(this.longitude).append('}').toString();
    }
}
