package twitter4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import twitter4j.internal.http.HttpParameter;
import twitter4j.internal.util.z_T4JInternalStringUtil;

/* loaded from: classes.dex */
public final class FilterQuery implements Serializable {
    private static final long serialVersionUID = 430966623248982833L;
    private int count;
    private long[] follow;
    private boolean includeEntities;
    private double[][] locations;
    private String[] track;

    public FilterQuery() {
        this.count = 0;
        this.follow = null;
        this.track = null;
        this.locations = (double[][]) null;
    }

    public FilterQuery(long[] jArr) {
        this();
        this.count = 0;
        this.follow = jArr;
    }

    public FilterQuery(int i, long[] jArr) {
        this();
        this.count = i;
        this.follow = jArr;
    }

    public FilterQuery(int i, long[] jArr, String[] strArr) {
        this();
        this.count = i;
        this.follow = jArr;
        this.track = strArr;
    }

    public FilterQuery(int i, long[] jArr, String[] strArr, double[][] dArr) {
        this.count = i;
        this.follow = jArr;
        this.track = strArr;
        this.locations = dArr;
    }

    public FilterQuery count(int i) {
        this.count = i;
        return this;
    }

    public FilterQuery follow(long[] jArr) {
        this.follow = jArr;
        return this;
    }

    public FilterQuery track(String[] strArr) {
        this.track = strArr;
        return this;
    }

    public FilterQuery locations(double[][] dArr) {
        this.locations = dArr;
        return this;
    }

    public FilterQuery setIncludeEntities(boolean z) {
        this.includeEntities = z;
        return this;
    }

    HttpParameter[] asHttpParameterArray() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HttpParameter("count", this.count));
        if (this.follow != null && this.follow.length > 0) {
            arrayList.add(new HttpParameter("follow", z_T4JInternalStringUtil.join(this.follow)));
        }
        if (this.track != null && this.track.length > 0) {
            arrayList.add(new HttpParameter("track", z_T4JInternalStringUtil.join(this.track)));
        }
        if (this.locations != null && this.locations.length > 0) {
            arrayList.add(new HttpParameter("locations", toLocationsString(this.locations)));
        }
        if (this.includeEntities) {
            arrayList.add(new HttpParameter("include_entities", true));
        }
        return (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]);
    }

    private String toLocationsString(double[][] dArr) {
        StringBuffer stringBuffer = new StringBuffer(dArr.length * 20 * 2);
        for (double[] dArr2 : dArr) {
            if (stringBuffer.length() != 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(dArr2[0]);
            stringBuffer.append(",");
            stringBuffer.append(dArr2[1]);
        }
        return stringBuffer.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FilterQuery filterQuery = (FilterQuery) obj;
        return this.count == filterQuery.count && Arrays.equals(this.follow, filterQuery.follow) && Arrays.equals(this.track, filterQuery.track);
    }

    public int hashCode() {
        return (((this.follow != null ? Arrays.hashCode(this.follow) : 0) + (this.count * 31)) * 31) + (this.track != null ? Arrays.hashCode(this.track) : 0);
    }

    public String toString() {
        return new StringBuffer().append("FilterQuery{count=").append(this.count).append(", follow=").append(Arrays.toString(this.follow)).append(", track=").append(this.track == null ? null : Arrays.asList(this.track)).append(", locations=").append(this.locations != null ? Arrays.asList(this.locations) : null).append(", includeEntities=").append(this.includeEntities).append('}').toString();
    }
}
