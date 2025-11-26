package weibo4android;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import weibo4android.http.Response;
import weibo4android.org.json.JSONArray;
import weibo4android.org.json.JSONException;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class RetweetDetails extends WeiboResponse implements Serializable {
    static final long serialVersionUID = 1957982268696560598L;
    private long retweetId;
    private Date retweetedAt;
    private User retweetingUser;

    RetweetDetails(Response response, Weibo weibo) {
        super(response);
        init(response, response.asDocument().getDocumentElement(), weibo);
    }

    RetweetDetails(JSONObject jSONObject) throws WeiboException {
        init(jSONObject);
    }

    private void init(JSONObject jSONObject) throws WeiboException {
        try {
            this.retweetId = jSONObject.getInt("retweetId");
            this.retweetedAt = parseDate(jSONObject.getString("retweetedAt"), "EEE MMM dd HH:mm:ss z yyyy");
            this.retweetingUser = new User(jSONObject.getJSONObject("retweetingUser"));
        } catch (JSONException e) {
            throw new WeiboException(String.valueOf(e.getMessage()) + ":" + jSONObject.toString(), e);
        }
    }

    RetweetDetails(Response response, Element element, Weibo weibo) {
        super(response);
        init(response, element, weibo);
    }

    private void init(Response response, Element element, Weibo weibo) {
        ensureRootNodeNameIs("retweet_details", element);
        this.retweetId = getChildLong("retweet_id", element);
        this.retweetedAt = getChildDate("retweeted_at", element);
        this.retweetingUser = new User(response, (Element) element.getElementsByTagName("retweeting_user").item(0), weibo);
    }

    public long getRetweetId() {
        return this.retweetId;
    }

    public Date getRetweetedAt() {
        return this.retweetedAt;
    }

    public User getRetweetingUser() {
        return this.retweetingUser;
    }

    static List createRetweetDetails(Response response) throws WeiboException {
        try {
            JSONArray jSONArrayAsJSONArray = response.asJSONArray();
            int length = jSONArrayAsJSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new RetweetDetails(jSONArrayAsJSONArray.getJSONObject(i)));
            }
            return arrayList;
        } catch (WeiboException e) {
            throw e;
        } catch (JSONException e2) {
            throw new WeiboException(e2);
        }
    }

    static List createRetweetDetails(Response response, Weibo weibo) throws WeiboException {
        Document documentAsDocument = response.asDocument();
        if (isRootNodeNilClasses(documentAsDocument)) {
            return new ArrayList(0);
        }
        try {
            ensureRootNodeNameIs("retweets", documentAsDocument);
            NodeList elementsByTagName = documentAsDocument.getDocumentElement().getElementsByTagName("retweet_details");
            int length = elementsByTagName.getLength();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new RetweetDetails(response, (Element) elementsByTagName.item(i), weibo));
            }
            return arrayList;
        } catch (WeiboException e) {
            ensureRootNodeNameIs("nil-classes", documentAsDocument);
            return new ArrayList(0);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RetweetDetails) && this.retweetId == ((RetweetDetails) obj).retweetId;
    }

    public int hashCode() {
        return (((((int) (this.retweetId ^ (this.retweetId >>> 32))) * 31) + this.retweetedAt.hashCode()) * 31) + this.retweetingUser.hashCode();
    }

    public String toString() {
        return "RetweetDetails{retweetId=" + this.retweetId + ", retweetedAt=" + this.retweetedAt + ", retweetingUser=" + this.retweetingUser + '}';
    }
}
