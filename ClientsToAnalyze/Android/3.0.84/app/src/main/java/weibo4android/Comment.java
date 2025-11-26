package weibo4android;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import twitter4j.conf.PropertyConfiguration;
import weibo4android.http.Response;
import weibo4android.org.json.JSONArray;
import weibo4android.org.json.JSONException;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class Comment extends WeiboResponse implements Serializable {
    private static final long serialVersionUID = 1608000492860584608L;
    private Date createdAt;

    /* renamed from: id */
    private long f13744id;
    private String inReplyToScreenName;
    private long inReplyToStatusId;
    private int inReplyToUserId;
    private boolean isFavorited;
    private boolean isTruncated;
    private double latitude;
    private double longitude;
    private RetweetDetails retweetDetails;
    private String source;
    private String text;
    private User user;

    Comment(Response response, Weibo weibo) {
        super(response);
        this.latitude = -1.0d;
        this.longitude = -1.0d;
        this.user = null;
        init(response, response.asDocument().getDocumentElement(), weibo);
    }

    Comment(Response response) throws WeiboException {
        super(response);
        this.latitude = -1.0d;
        this.longitude = -1.0d;
        this.user = null;
        JSONObject jSONObjectAsJSONObject = response.asJSONObject();
        try {
            this.f13744id = jSONObjectAsJSONObject.getLong("id");
            this.text = jSONObjectAsJSONObject.getString("text");
            this.source = jSONObjectAsJSONObject.getString("source");
            this.createdAt = parseDate(jSONObjectAsJSONObject.getString("created_at"), "EEE MMM dd HH:mm:ss z yyyy");
            if (!jSONObjectAsJSONObject.isNull(PropertyConfiguration.USER)) {
                this.user = new User(jSONObjectAsJSONObject.getJSONObject(PropertyConfiguration.USER));
            }
        } catch (JSONException e) {
            throw new WeiboException(e.getMessage() + ":" + jSONObjectAsJSONObject.toString(), e);
        }
    }

    public Comment(JSONObject jSONObject) {
        this.latitude = -1.0d;
        this.longitude = -1.0d;
        this.user = null;
        this.f13744id = jSONObject.getLong("id");
        this.text = jSONObject.getString("text");
        this.source = jSONObject.getString("source");
        this.createdAt = parseDate(jSONObject.getString("created_at"), "EEE MMM dd HH:mm:ss z yyyy");
        if (!jSONObject.isNull(PropertyConfiguration.USER)) {
            this.user = new User(jSONObject.getJSONObject(PropertyConfiguration.USER));
        }
    }

    Comment(Response response, Element element, Weibo weibo) {
        super(response);
        this.latitude = -1.0d;
        this.longitude = -1.0d;
        this.user = null;
        init(response, element, weibo);
    }

    public Comment(String str) {
        this.latitude = -1.0d;
        this.longitude = -1.0d;
        this.user = null;
        JSONObject jSONObject = new JSONObject(str);
        this.f13744id = jSONObject.getLong("id");
        this.text = jSONObject.getString("text");
        this.source = jSONObject.getString("source");
        this.createdAt = parseDate(jSONObject.getString("created_at"), "EEE MMM dd HH:mm:ss z yyyy");
        this.user = new User(jSONObject.getJSONObject(PropertyConfiguration.USER));
    }

    private void init(Response response, Element element, Weibo weibo) {
        ensureRootNodeNameIs("comment", element);
        this.user = new User(response, (Element) element.getElementsByTagName(PropertyConfiguration.USER).item(0), weibo);
        this.f13744id = getChildLong("id", element);
        this.text = getChildText("text", element);
        this.source = getChildText("source", element);
        this.createdAt = getChildDate("created_at", element);
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public long getId() {
        return this.f13744id;
    }

    public String getText() {
        return this.text;
    }

    public String getSource() {
        return this.source;
    }

    public boolean isTruncated() {
        return this.isTruncated;
    }

    public long getInReplyToStatusId() {
        return this.inReplyToStatusId;
    }

    public int getInReplyToUserId() {
        return this.inReplyToUserId;
    }

    public String getInReplyToScreenName() {
        return this.inReplyToScreenName;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public boolean isFavorited() {
        return this.isFavorited;
    }

    public User getUser() {
        return this.user;
    }

    public boolean isRetweet() {
        return this.retweetDetails != null;
    }

    public RetweetDetails getRetweetDetails() {
        return this.retweetDetails;
    }

    static List<Comment> constructComments(Response response, Weibo weibo) throws WeiboException {
        Document documentAsDocument = response.asDocument();
        if (isRootNodeNilClasses(documentAsDocument)) {
            return new ArrayList(0);
        }
        try {
            ensureRootNodeNameIs("comments", documentAsDocument);
            NodeList elementsByTagName = documentAsDocument.getDocumentElement().getElementsByTagName("comment");
            int length = elementsByTagName.getLength();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new Comment(response, (Element) elementsByTagName.item(i), weibo));
            }
            return arrayList;
        } catch (WeiboException e) {
            ensureRootNodeNameIs("nil-classes", documentAsDocument);
            return new ArrayList(0);
        }
    }

    static List<Comment> constructComments(Response response) throws WeiboException {
        try {
            JSONArray jSONArrayAsJSONArray = response.asJSONArray();
            int length = jSONArrayAsJSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new Comment(jSONArrayAsJSONArray.getJSONObject(i)));
            }
            return arrayList;
        } catch (WeiboException e) {
            throw e;
        } catch (JSONException e2) {
            throw new WeiboException(e2);
        }
    }

    public int hashCode() {
        return (int) this.f13744id;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this != obj) {
            return (obj instanceof Comment) && ((Comment) obj).f13744id == this.f13744id;
        }
        return true;
    }

    public String toString() {
        return "Comment{createdAt=" + this.createdAt + ", id=" + this.f13744id + ", text='" + this.text + "', source='" + this.source + "', isTruncated=" + this.isTruncated + ", inReplyToStatusId=" + this.inReplyToStatusId + ", inReplyToUserId=" + this.inReplyToUserId + ", isFavorited=" + this.isFavorited + ", inReplyToScreenName='" + this.inReplyToScreenName + "', latitude=" + this.latitude + ", longitude=" + this.longitude + ", retweetDetails=" + this.retweetDetails + ", user=" + this.user + '}';
    }
}
