package weibo4android;

import java.io.Serializable;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class Trend implements Serializable {
    private static final long serialVersionUID = 1925956704460743946L;
    private String name;
    private String query;
    private String url;

    public Trend(JSONObject jSONObject) {
        this.url = null;
        this.query = null;
        this.name = jSONObject.getString("name");
        if (!jSONObject.isNull("url")) {
            this.url = jSONObject.getString("url");
        }
        if (!jSONObject.isNull("query")) {
            this.query = jSONObject.getString("query");
        }
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
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
        if (this.query == null ? trend.query != null : !this.query.equals(trend.query)) {
            return false;
        }
        if (this.url != null) {
            if (this.url.equals(trend.url)) {
                return true;
            }
        } else if (trend.url == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.url != null ? this.url.hashCode() : 0) + (this.name.hashCode() * 31)) * 31) + (this.query != null ? this.query.hashCode() : 0);
    }

    public String toString() {
        return "Trend{name='" + this.name + "', url='" + this.url + "', query='" + this.query + "'}";
    }
}
