package weibo4android;

import java.util.ArrayList;
import java.util.List;
import weibo4android.http.Response;
import weibo4android.org.json.JSONArray;
import weibo4android.org.json.JSONException;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class QueryResult extends WeiboResponse {
    private static final long serialVersionUID = -9059136565234613286L;
    private double completedIn;
    private long maxId;
    private int page;
    private String query;
    private String refreshUrl;
    private int resultsPerPage;
    private long sinceId;
    private int total;
    private List<Tweet> tweets;
    private String warning;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QueryResult(Response response, WeiboSupport weiboSupport) throws WeiboException {
        super(response);
        this.total = -1;
        JSONObject jSONObjectAsJSONObject = response.asJSONObject();
        try {
            this.sinceId = jSONObjectAsJSONObject.getLong("since_id");
            this.maxId = jSONObjectAsJSONObject.getLong("max_id");
            this.refreshUrl = getString("refresh_url", jSONObjectAsJSONObject, true);
            this.resultsPerPage = jSONObjectAsJSONObject.getInt("results_per_page");
            this.warning = getString("warning", jSONObjectAsJSONObject, false);
            this.completedIn = jSONObjectAsJSONObject.getDouble("completed_in");
            this.page = jSONObjectAsJSONObject.getInt("page");
            this.query = getString("query", jSONObjectAsJSONObject, true);
            JSONArray jSONArray = jSONObjectAsJSONObject.getJSONArray("results");
            this.tweets = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                this.tweets.add(new Tweet(jSONArray.getJSONObject(i), weiboSupport));
            }
        } catch (JSONException e) {
            throw new WeiboException(e.getMessage() + ":" + jSONObjectAsJSONObject.toString(), e);
        }
    }

    QueryResult(Query query) {
        this.total = -1;
        this.sinceId = query.getSinceId();
        this.resultsPerPage = query.getRpp();
        this.page = query.getPage();
        this.tweets = new ArrayList(0);
    }

    public long getSinceId() {
        return this.sinceId;
    }

    public long getMaxId() {
        return this.maxId;
    }

    public String getRefreshUrl() {
        return this.refreshUrl;
    }

    public int getResultsPerPage() {
        return this.resultsPerPage;
    }

    @Deprecated
    public int getTotal() {
        return this.total;
    }

    public String getWarning() {
        return this.warning;
    }

    public double getCompletedIn() {
        return this.completedIn;
    }

    public int getPage() {
        return this.page;
    }

    public String getQuery() {
        return this.query;
    }

    public List<Tweet> getTweets() {
        return this.tweets;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        QueryResult queryResult = (QueryResult) obj;
        if (Double.compare(queryResult.completedIn, this.completedIn) == 0 && this.maxId == queryResult.maxId && this.page == queryResult.page && this.resultsPerPage == queryResult.resultsPerPage && this.sinceId == queryResult.sinceId && this.total == queryResult.total && this.query.equals(queryResult.query)) {
            if (this.refreshUrl == null ? queryResult.refreshUrl != null : !this.refreshUrl.equals(queryResult.refreshUrl)) {
                return false;
            }
            if (this.tweets == null ? queryResult.tweets != null : !this.tweets.equals(queryResult.tweets)) {
                return false;
            }
            if (this.warning != null) {
                if (this.warning.equals(queryResult.warning)) {
                    return true;
                }
            } else if (queryResult.warning == null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.warning != null ? this.warning.hashCode() : 0) + (((((((this.refreshUrl != null ? this.refreshUrl.hashCode() : 0) + (((((int) (this.sinceId ^ (this.sinceId >>> 32))) * 31) + ((int) (this.maxId ^ (this.maxId >>> 32)))) * 31)) * 31) + this.resultsPerPage) * 31) + this.total) * 31);
        long jDoubleToLongBits = this.completedIn != 0.0d ? Double.doubleToLongBits(this.completedIn) : 0L;
        return (((((((iHashCode * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31) + this.page) * 31) + this.query.hashCode()) * 31) + (this.tweets != null ? this.tweets.hashCode() : 0);
    }

    public String toString() {
        return "QueryResult{sinceId=" + this.sinceId + ", maxId=" + this.maxId + ", refreshUrl='" + this.refreshUrl + "', resultsPerPage=" + this.resultsPerPage + ", total=" + this.total + ", warning='" + this.warning + "', completedIn=" + this.completedIn + ", page=" + this.page + ", query='" + this.query + "', tweets=" + this.tweets + '}';
    }
}
