package twitter4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import twitter4j.internal.http.HttpParameter;

/* loaded from: classes.dex */
public final class Query implements Serializable {
    public static final String KILOMETERS = "km";
    public static final String MILES = "mi";
    public static final String MIXED = "mixed";
    public static final String POPULAR = "popular";
    public static final String RECENT = "recent";
    private static HttpParameter WITH_TWITTER_USER_ID = new HttpParameter("with_twitter_user_id", "true");
    private static final long serialVersionUID = -8108425822233599808L;
    private String geocode;
    private String lang;
    private String locale;
    private long maxId;
    private int page;
    private String query;
    private String resultType;
    private int rpp;
    private String since;
    private long sinceId;
    private String until;

    public Query() {
        this.query = null;
        this.lang = null;
        this.locale = null;
        this.maxId = -1L;
        this.rpp = -1;
        this.page = -1;
        this.since = null;
        this.sinceId = -1L;
        this.geocode = null;
        this.until = null;
        this.resultType = null;
    }

    public Query(String str) {
        this.query = null;
        this.lang = null;
        this.locale = null;
        this.maxId = -1L;
        this.rpp = -1;
        this.page = -1;
        this.since = null;
        this.sinceId = -1L;
        this.geocode = null;
        this.until = null;
        this.resultType = null;
        this.query = str;
    }

    public String getQuery() {
        return this.query;
    }

    public void setQuery(String str) {
        this.query = str;
    }

    public Query query(String str) {
        setQuery(str);
        return this;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public Query lang(String str) {
        setLang(str);
        return this;
    }

    public String getLocale() {
        return this.locale;
    }

    public void setLocale(String str) {
        this.locale = str;
    }

    public Query locale(String str) {
        setLocale(str);
        return this;
    }

    public long getMaxId() {
        return this.maxId;
    }

    public void setMaxId(long j) {
        this.maxId = j;
    }

    public Query maxId(long j) {
        setMaxId(j);
        return this;
    }

    public int getRpp() {
        return this.rpp;
    }

    public void setRpp(int i) {
        this.rpp = i;
    }

    public Query rpp(int i) {
        setRpp(i);
        return this;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int i) {
        this.page = i;
    }

    public Query page(int i) {
        setPage(i);
        return this;
    }

    public String getSince() {
        return this.since;
    }

    public void setSince(String str) {
        this.since = str;
    }

    public Query since(String str) {
        setSince(str);
        return this;
    }

    public long getSinceId() {
        return this.sinceId;
    }

    public void setSinceId(long j) {
        this.sinceId = j;
    }

    public Query sinceId(long j) {
        setSinceId(j);
        return this;
    }

    public String getGeocode() {
        return this.geocode;
    }

    public void setGeoCode(GeoLocation geoLocation, double d, String str) {
        this.geocode = new StringBuffer().append(geoLocation.getLatitude()).append(",").append(geoLocation.getLongitude()).append(",").append(d).append(str).toString();
    }

    public Query geoCode(GeoLocation geoLocation, double d, String str) {
        setGeoCode(geoLocation, d, str);
        return this;
    }

    public String getUntil() {
        return this.until;
    }

    public void setUntil(String str) {
        this.until = str;
    }

    public Query until(String str) {
        setUntil(str);
        return this;
    }

    public String getResultType() {
        return this.resultType;
    }

    public void setResultType(String str) {
        this.resultType = str;
    }

    public Query resultType(String str) {
        setResultType(str);
        return this;
    }

    HttpParameter[] asHttpParameterArray(HttpParameter httpParameter) {
        ArrayList arrayList = new ArrayList();
        appendParameter("q", this.query, arrayList);
        appendParameter("lang", this.lang, arrayList);
        appendParameter("locale", this.locale, arrayList);
        appendParameter("max_id", this.maxId, arrayList);
        appendParameter("rpp", this.rpp, arrayList);
        appendParameter("page", this.page, arrayList);
        appendParameter("since", this.since, arrayList);
        appendParameter("since_id", this.sinceId, arrayList);
        appendParameter("geocode", this.geocode, arrayList);
        appendParameter("until", this.until, arrayList);
        appendParameter("result_type", this.resultType, arrayList);
        arrayList.add(WITH_TWITTER_USER_ID);
        arrayList.add(httpParameter);
        return (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]);
    }

    private void appendParameter(String str, String str2, List<HttpParameter> list) {
        if (str2 != null) {
            list.add(new HttpParameter(str, str2));
        }
    }

    private void appendParameter(String str, long j, List<HttpParameter> list) {
        if (0 <= j) {
            list.add(new HttpParameter(str, String.valueOf(j)));
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
        if (this.maxId == query.maxId && this.page == query.page && this.rpp == query.rpp && this.sinceId == query.sinceId) {
            if (this.geocode == null ? query.geocode != null : !this.geocode.equals(query.geocode)) {
                return false;
            }
            if (this.lang == null ? query.lang != null : !this.lang.equals(query.lang)) {
                return false;
            }
            if (this.locale == null ? query.locale != null : !this.locale.equals(query.locale)) {
                return false;
            }
            if (this.query == null ? query.query != null : !this.query.equals(query.query)) {
                return false;
            }
            if (this.since == null ? query.since != null : !this.since.equals(query.since)) {
                return false;
            }
            if (this.until == null ? query.until != null : !this.until.equals(query.until)) {
                return false;
            }
            if (this.resultType != null) {
                if (this.resultType.equals(query.resultType)) {
                    return true;
                }
            } else if (query.resultType == null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (((this.until != null ? this.until.hashCode() : 0) + (((this.geocode != null ? this.geocode.hashCode() : 0) + (((((this.since != null ? this.since.hashCode() : 0) + (((((((((this.locale != null ? this.locale.hashCode() : 0) + (((this.lang != null ? this.lang.hashCode() : 0) + ((this.query != null ? this.query.hashCode() : 0) * 31)) * 31)) * 31) + ((int) (this.maxId ^ (this.maxId >>> 32)))) * 31) + this.rpp) * 31) + this.page) * 31)) * 31) + ((int) (this.sinceId ^ (this.sinceId >>> 32)))) * 31)) * 31)) * 31) + (this.resultType != null ? this.resultType.hashCode() : 0);
    }

    public String toString() {
        return new StringBuffer().append("Query{query='").append(this.query).append('\'').append(", lang='").append(this.lang).append('\'').append(", locale='").append(this.locale).append('\'').append(", maxId=").append(this.maxId).append(", rpp=").append(this.rpp).append(", page=").append(this.page).append(", since='").append(this.since).append('\'').append(", sinceId=").append(this.sinceId).append(", geocode='").append(this.geocode).append('\'').append(", until='").append(this.until).append('\'').append(", resultType='").append(this.resultType).append('\'').append('}').toString();
    }
}
