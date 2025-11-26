package twitter4j.internal.json;

import java.io.Serializable;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import org.json.JSONObject;
import twitter4j.Trend;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
final class TrendJSONImpl implements Serializable, Trend {
    private static final long serialVersionUID = 1925956704460743946L;
    private String name;
    private String query;
    private String url;

    TrendJSONImpl(JSONObject jSONObject, boolean z) {
        this.url = null;
        this.query = null;
        this.name = z_T4JInternalParseUtil.getRawString("name", jSONObject);
        this.url = z_T4JInternalParseUtil.getRawString(RtspHeaders.Values.URL, jSONObject);
        this.query = z_T4JInternalParseUtil.getRawString("query", jSONObject);
        if (z) {
            DataObjectFactoryUtil.registerJSONObject(this, jSONObject);
        }
    }

    TrendJSONImpl(JSONObject jSONObject) {
        this(jSONObject, false);
    }

    @Override // twitter4j.Trend
    public String getName() {
        return this.name;
    }

    @Override // twitter4j.Trend
    public String getUrl() {
        return this.url;
    }

    @Override // twitter4j.Trend
    public String getQuery() {
        return this.query;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Trend)) {
            return false;
        }
        Trend trend = (Trend) obj;
        if (!this.name.equals(trend.getName())) {
            return false;
        }
        if (this.query == null ? trend.getQuery() != null : !this.query.equals(trend.getQuery())) {
            return false;
        }
        if (this.url != null) {
            if (this.url.equals(trend.getUrl())) {
                return true;
            }
        } else if (trend.getUrl() == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.url != null ? this.url.hashCode() : 0) + (this.name.hashCode() * 31)) * 31) + (this.query != null ? this.query.hashCode() : 0);
    }

    public String toString() {
        return new StringBuffer().append("TrendJSONImpl{name='").append(this.name).append('\'').append(", url='").append(this.url).append('\'').append(", query='").append(this.query).append('\'').append('}').toString();
    }
}
