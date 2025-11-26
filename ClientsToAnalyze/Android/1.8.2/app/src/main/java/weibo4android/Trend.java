package weibo4android;

import java.io.Serializable;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class Trend implements Serializable {
    private static final long serialVersionUID = 1925956704460743946L;
    private String name;
    private String query;

    public Trend(JSONObject jSONObject) {
        this.query = null;
        this.name = jSONObject.getString("name");
        if (!jSONObject.isNull("query")) {
            this.query = jSONObject.getString("query");
        }
    }

    public String getName() {
        return this.name;
    }

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
        if (!this.name.equals(trend.name)) {
            return false;
        }
        if (this.query != null) {
            if (this.query.equals(trend.query)) {
                return true;
            }
        } else if (trend.query == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.query != null ? this.query.hashCode() : 0) + (this.name.hashCode() * 31);
    }

    public String toString() {
        return "Trend{name='" + this.name + "', query='" + this.query + "'}";
    }
}
