package weibo4android;

import java.util.ArrayList;
import java.util.List;
import weibo4android.http.PostParameter;

/* loaded from: classes.dex */
public class Query {
    public static final String KILOMETERS = "km";
    public static final String MILES = "mi";
    private String geocode;
    private String lang;
    private int page;
    private String query;
    private int rpp;
    private long sinceId;

    public Query() {
        this.query = null;
        this.lang = null;
        this.rpp = -1;
        this.page = -1;
        this.sinceId = -1L;
        this.geocode = null;
    }

    public Query(String str) {
        this.query = null;
        this.lang = null;
        this.rpp = -1;
        this.page = -1;
        this.sinceId = -1L;
        this.geocode = null;
        this.query = str;
    }

    public String getQuery() {
        return this.query;
    }

    public void setQuery(String str) {
        this.query = str;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public int getRpp() {
        return this.rpp;
    }

    public void setRpp(int i) {
        this.rpp = i;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int i) {
        this.page = i;
    }

    public long getSinceId() {
        return this.sinceId;
    }

    public void setSinceId(long j) {
        this.sinceId = j;
    }

    public String getGeocode() {
        return this.geocode;
    }

    public void setGeoCode(double d, double d2, double d3, String str) {
        this.geocode = d + "," + d2 + "," + d3 + str;
    }

    public PostParameter[] asPostParameters() {
        ArrayList arrayList = new ArrayList();
        appendParameter("q", this.query, arrayList);
        appendParameter("lang", this.lang, arrayList);
        appendParameter("rpp", this.rpp, arrayList);
        appendParameter("page", this.page, arrayList);
        appendParameter("since_id", this.sinceId, arrayList);
        appendParameter("geocode", this.geocode, arrayList);
        return (PostParameter[]) arrayList.toArray(new PostParameter[arrayList.size()]);
    }

    private void appendParameter(String str, String str2, List<PostParameter> list) {
        if (str2 != null) {
            list.add(new PostParameter(str, str2));
        }
    }

    private void appendParameter(String str, long j, List<PostParameter> list) {
        if (0 <= j) {
            list.add(new PostParameter(str, String.valueOf(j)));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Query query = (Query) obj;
        if (this.page == query.page && this.rpp == query.rpp && this.sinceId == query.sinceId) {
            if (this.geocode == null ? query.geocode != null : !this.geocode.equals(query.geocode)) {
                return false;
            }
            if (this.lang == null ? query.lang != null : !this.lang.equals(query.lang)) {
                return false;
            }
            if (this.query != null) {
                if (this.query.equals(query.query)) {
                    return true;
                }
            } else if (query.query == null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.lang != null ? this.lang.hashCode() : 0) + ((this.query != null ? this.query.hashCode() : 0) * 31)) * 31) + this.rpp) * 31) + this.page) * 31) + ((int) (this.sinceId ^ (this.sinceId >>> 32)))) * 31) + (this.geocode != null ? this.geocode.hashCode() : 0);
    }

    public String toString() {
        return "Query{query='" + this.query + "', lang='" + this.lang + "', rpp=" + this.rpp + ", page=" + this.page + ", sinceId=" + this.sinceId + ", geocode='" + this.geocode + "'}";
    }
}
