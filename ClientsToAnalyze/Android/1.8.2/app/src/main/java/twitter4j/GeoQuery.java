package twitter4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import twitter4j.internal.http.HttpParameter;

/* loaded from: classes.dex */
public final class GeoQuery implements Serializable {
    public static final String CITY = "city";
    public static final String NEIGHBORHOOD = "neighborhood";
    private static final long serialVersionUID = 927081526936169802L;
    private String accuracy;
    private String granularity;

    /* renamed from: ip */
    private String f7891ip;
    private GeoLocation location;
    private int maxResults;

    public GeoQuery(GeoLocation geoLocation) {
        this.location = geoLocation;
        this.f7891ip = null;
    }

    public GeoQuery(String str) {
        this.f7891ip = str;
        this.location = null;
    }

    public GeoLocation getLocation() {
        return this.location;
    }

    public String getIp() {
        return this.f7891ip;
    }

    public String getAccuracy() {
        return this.accuracy;
    }

    public void setAccuracy(String str) {
        this.accuracy = str;
    }

    public GeoQuery accuracy(String str) {
        setAccuracy(str);
        return this;
    }

    public String getGranularity() {
        return this.granularity;
    }

    public void setGranularity(String str) {
        this.granularity = str;
    }

    public GeoQuery granularity(String str) {
        setGranularity(str);
        return this;
    }

    public int getMaxResults() {
        return this.maxResults;
    }

    public void setMaxResults(int i) {
        this.maxResults = i;
    }

    public GeoQuery maxResults(int i) {
        setMaxResults(i);
        return this;
    }

    HttpParameter[] asHttpParameterArray() {
        ArrayList arrayList = new ArrayList();
        if (this.location != null) {
            appendParameter("lat", this.location.getLatitude(), arrayList);
            appendParameter("long", this.location.getLongitude(), arrayList);
        }
        if (this.f7891ip != null) {
            appendParameter("ip", this.f7891ip, arrayList);
        }
        appendParameter("accuracy", this.accuracy, arrayList);
        appendParameter("granularity", this.granularity, arrayList);
        appendParameter("max_results", this.maxResults, (List) arrayList);
        return (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]);
    }

    private void appendParameter(String str, String str2, List list) {
        if (str2 != null) {
            list.add(new HttpParameter(str, str2));
        }
    }

    private void appendParameter(String str, int i, List list) {
        if (i > 0) {
            list.add(new HttpParameter(str, String.valueOf(i)));
        }
    }

    private void appendParameter(String str, double d, List list) {
        list.add(new HttpParameter(str, String.valueOf(d)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GeoQuery geoQuery = (GeoQuery) obj;
        if (this.maxResults != geoQuery.maxResults) {
            return false;
        }
        if (this.accuracy == null ? geoQuery.accuracy != null : !this.accuracy.equals(geoQuery.accuracy)) {
            return false;
        }
        if (this.granularity == null ? geoQuery.granularity != null : !this.granularity.equals(geoQuery.granularity)) {
            return false;
        }
        if (this.f7891ip == null ? geoQuery.f7891ip != null : !this.f7891ip.equals(geoQuery.f7891ip)) {
            return false;
        }
        if (this.location != null) {
            if (this.location.equals(geoQuery.location)) {
                return true;
            }
        } else if (geoQuery.location == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.accuracy != null ? this.accuracy.hashCode() : 0) + (((this.f7891ip != null ? this.f7891ip.hashCode() : 0) + ((this.location != null ? this.location.hashCode() : 0) * 31)) * 31)) * 31) + (this.granularity != null ? this.granularity.hashCode() : 0)) * 31) + this.maxResults;
    }

    public String toString() {
        return new StringBuffer().append("GeoQuery{location=").append(this.location).append(", ip='").append(this.f7891ip).append('\'').append(", accuracy='").append(this.accuracy).append('\'').append(", granularity='").append(this.granularity).append('\'').append(", maxResults=").append(this.maxResults).append('}').toString();
    }
}
