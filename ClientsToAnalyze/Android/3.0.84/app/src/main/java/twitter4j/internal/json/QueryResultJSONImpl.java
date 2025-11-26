package twitter4j.internal.json;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Tweet;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
final class QueryResultJSONImpl implements Serializable, QueryResult {
    private static final long serialVersionUID = -9059136565234613286L;
    private double completedIn;
    private long maxId;
    private int page;
    private String query;
    private String refreshUrl;
    private int resultsPerPage;
    private long sinceId;
    private List<Tweet> tweets;
    private String warning;

    QueryResultJSONImpl(HttpResponse httpResponse, Configuration configuration) throws JSONException, IllegalAccessException, TwitterException, IOException, IllegalArgumentException, InvocationTargetException {
        JSONObject jSONObjectAsJSONObject = httpResponse.asJSONObject();
        try {
            this.sinceId = z_T4JInternalParseUtil.getLong("since_id", jSONObjectAsJSONObject);
            this.maxId = z_T4JInternalParseUtil.getLong("max_id", jSONObjectAsJSONObject);
            this.refreshUrl = z_T4JInternalParseUtil.getUnescapedString("refresh_url", jSONObjectAsJSONObject);
            this.resultsPerPage = z_T4JInternalParseUtil.getInt("results_per_page", jSONObjectAsJSONObject);
            this.warning = z_T4JInternalParseUtil.getRawString("warning", jSONObjectAsJSONObject);
            this.completedIn = z_T4JInternalParseUtil.getDouble("completed_in", jSONObjectAsJSONObject);
            this.page = z_T4JInternalParseUtil.getInt("page", jSONObjectAsJSONObject);
            this.query = z_T4JInternalParseUtil.getURLDecodedString("query", jSONObjectAsJSONObject);
            JSONArray jSONArray = jSONObjectAsJSONObject.getJSONArray("results");
            this.tweets = new ArrayList(jSONArray.length());
            if (configuration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.clearThreadLocalMap();
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                this.tweets.add(new TweetJSONImpl(jSONArray.getJSONObject(i), configuration));
            }
        } catch (JSONException e) {
            throw new TwitterException(new StringBuffer().append(e.getMessage()).append(":").append(jSONObjectAsJSONObject.toString()).toString(), e);
        }
    }

    QueryResultJSONImpl(Query query) {
        this.sinceId = query.getSinceId();
        this.resultsPerPage = query.getRpp();
        this.page = query.getPage();
        this.tweets = new ArrayList(0);
    }

    @Override // twitter4j.QueryResult
    public long getSinceId() {
        return this.sinceId;
    }

    @Override // twitter4j.QueryResult
    public long getMaxId() {
        return this.maxId;
    }

    @Override // twitter4j.QueryResult
    public String getRefreshUrl() {
        return this.refreshUrl;
    }

    @Override // twitter4j.QueryResult
    public int getResultsPerPage() {
        return this.resultsPerPage;
    }

    @Override // twitter4j.QueryResult
    public String getWarning() {
        return this.warning;
    }

    @Override // twitter4j.QueryResult
    public double getCompletedIn() {
        return this.completedIn;
    }

    @Override // twitter4j.QueryResult
    public int getPage() {
        return this.page;
    }

    @Override // twitter4j.QueryResult
    public String getQuery() {
        return this.query;
    }

    @Override // twitter4j.QueryResult
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
        if (Double.compare(queryResult.getCompletedIn(), this.completedIn) == 0 && this.maxId == queryResult.getMaxId() && this.page == queryResult.getPage() && this.resultsPerPage == queryResult.getResultsPerPage() && this.sinceId == queryResult.getSinceId() && this.query.equals(queryResult.getQuery())) {
            if (this.refreshUrl == null ? queryResult.getRefreshUrl() != null : !this.refreshUrl.equals(queryResult.getRefreshUrl())) {
                return false;
            }
            if (this.tweets == null ? queryResult.getTweets() != null : !this.tweets.equals(queryResult.getTweets())) {
                return false;
            }
            if (this.warning != null) {
                if (this.warning.equals(queryResult.getWarning())) {
                    return true;
                }
            } else if (queryResult.getWarning() == null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.warning != null ? this.warning.hashCode() : 0) + (((((this.refreshUrl != null ? this.refreshUrl.hashCode() : 0) + (((((int) (this.sinceId ^ (this.sinceId >>> 32))) * 31) + ((int) (this.maxId ^ (this.maxId >>> 32)))) * 31)) * 31) + this.resultsPerPage) * 31);
        long jDoubleToLongBits = this.completedIn != 0.0d ? Double.doubleToLongBits(this.completedIn) : 0L;
        return (((((((iHashCode * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31) + this.page) * 31) + this.query.hashCode()) * 31) + (this.tweets != null ? this.tweets.hashCode() : 0);
    }

    public String toString() {
        return new StringBuffer().append("QueryResultJSONImpl{sinceId=").append(this.sinceId).append(", maxId=").append(this.maxId).append(", refreshUrl='").append(this.refreshUrl).append('\'').append(", resultsPerPage=").append(this.resultsPerPage).append(", warning='").append(this.warning).append('\'').append(", completedIn=").append(this.completedIn).append(", page=").append(this.page).append(", query='").append(this.query).append('\'').append(", tweets=").append(this.tweets).append('}').toString();
    }
}
