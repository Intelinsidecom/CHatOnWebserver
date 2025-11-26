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
public class Status extends WeiboResponse implements Serializable {
    private static final long serialVersionUID = 1608000492860584608L;
    private String bmiddle_pic;
    private Date createdAt;

    /* renamed from: id */
    private long f7916id;
    private String inReplyToScreenName;
    private long inReplyToStatusId;
    private int inReplyToUserId;
    private boolean isFavorited;
    private boolean isTruncated;
    private double latitude;
    private double longitude;
    private String mid;
    private String original_pic;
    private RetweetDetails retweetDetails;
    private Status retweeted_status;
    private String source;
    private String text;
    private String thumbnail_pic;
    private User user;

    Status(Response response, Weibo weibo) {
        super(response);
        this.latitude = -1.0d;
        this.longitude = -1.0d;
        this.user = null;
        init(response, response.asDocument().getDocumentElement(), weibo);
    }

    Status(Response response, Element element, Weibo weibo) {
        super(response);
        this.latitude = -1.0d;
        this.longitude = -1.0d;
        this.user = null;
        init(response, element, weibo);
    }

    Status(Response response) throws WeiboException {
        super(response);
        this.latitude = -1.0d;
        this.longitude = -1.0d;
        this.user = null;
        constructJson(response.asJSONObject());
    }

    private void constructJson(JSONObject jSONObject) throws WeiboException {
        try {
            this.f7916id = jSONObject.getLong("id");
            this.text = jSONObject.getString("text");
            this.source = jSONObject.getString("source");
            this.createdAt = parseDate(jSONObject.getString("created_at"), "EEE MMM dd HH:mm:ss z yyyy");
            this.inReplyToStatusId = getLong("in_reply_to_status_id", jSONObject);
            this.inReplyToUserId = getInt("in_reply_to_user_id", jSONObject);
            this.isFavorited = getBoolean("favorited", jSONObject);
            this.thumbnail_pic = jSONObject.getString("thumbnail_pic");
            this.bmiddle_pic = jSONObject.getString("bmiddle_pic");
            this.original_pic = jSONObject.getString("original_pic");
            if (!jSONObject.isNull(PropertyConfiguration.USER)) {
                this.user = new User(jSONObject.getJSONObject(PropertyConfiguration.USER));
            }
            this.inReplyToScreenName = jSONObject.getString("inReplyToScreenName");
            if (!jSONObject.isNull("retweeted_status")) {
                this.retweetDetails = new RetweetDetails(jSONObject.getJSONObject("retweeted_status"));
                this.retweeted_status = new Status(jSONObject.getJSONObject("retweeted_status"));
            }
            this.mid = jSONObject.getString("mid");
            String string = jSONObject.getString("geo");
            if (string != null && !"".equals(string) && !"null".equals(string)) {
                getGeoInfo(string);
            }
        } catch (JSONException e) {
            throw new WeiboException(String.valueOf(e.getMessage()) + ":" + jSONObject.toString(), e);
        }
    }

    private void getGeoInfo(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (char c : str.toCharArray()) {
            if (c > '-' && c < ':') {
                stringBuffer.append(c);
            }
            if (c == ',' && stringBuffer.length() > 0) {
                this.latitude = Double.parseDouble(stringBuffer.toString());
                stringBuffer.delete(0, stringBuffer.length());
            }
        }
        this.longitude = Double.parseDouble(stringBuffer.toString());
    }

    public Status(JSONObject jSONObject) throws WeiboException {
        this.latitude = -1.0d;
        this.longitude = -1.0d;
        this.user = null;
        constructJson(jSONObject);
    }

    public Status(String str) throws WeiboException {
        this.latitude = -1.0d;
        this.longitude = -1.0d;
        this.user = null;
        constructJson(new JSONObject(str));
    }

    private void init(Response response, Element element, Weibo weibo) {
        ensureRootNodeNameIs("status", element);
        this.user = new User(response, (Element) element.getElementsByTagName(PropertyConfiguration.USER).item(0), weibo);
        this.f7916id = getChildLong("id", element);
        this.text = getChildText("text", element);
        this.source = getChildText("source", element);
        this.createdAt = getChildDate("created_at", element);
        this.isTruncated = getChildBoolean("truncated", element);
        this.inReplyToStatusId = getChildLong("in_reply_to_status_id", element);
        this.inReplyToUserId = getChildInt("in_reply_to_user_id", element);
        this.isFavorited = getChildBoolean("favorited", element);
        this.inReplyToScreenName = getChildText("in_reply_to_screen_name", element);
        NodeList elementsByTagName = element.getElementsByTagName("georss:point");
        if (1 == elementsByTagName.getLength()) {
            String[] strArrSplit = elementsByTagName.item(0).getFirstChild().getNodeValue().split(" ");
            if (!"null".equals(strArrSplit[0])) {
                this.latitude = Double.parseDouble(strArrSplit[0]);
            }
            if (!"null".equals(strArrSplit[1])) {
                this.longitude = Double.parseDouble(strArrSplit[1]);
            }
        }
        NodeList elementsByTagName2 = element.getElementsByTagName("retweet_details");
        if (1 == elementsByTagName2.getLength()) {
            this.retweetDetails = new RetweetDetails(response, (Element) elementsByTagName2.item(0), weibo);
            this.retweeted_status = new Status(response, (Element) elementsByTagName2.item(0), weibo);
        }
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public long getId() {
        return this.f7916id;
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

    public String getThumbnail_pic() {
        return this.thumbnail_pic;
    }

    public String getBmiddle_pic() {
        return this.bmiddle_pic;
    }

    public String getOriginal_pic() {
        return this.original_pic;
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

    public Status getRetweeted_status() {
        return this.retweeted_status;
    }

    public String getMid() {
        return this.mid;
    }

    static List constructStatuses(Response response, Weibo weibo) throws WeiboException {
        Document documentAsDocument = response.asDocument();
        if (isRootNodeNilClasses(documentAsDocument)) {
            return new ArrayList(0);
        }
        try {
            ensureRootNodeNameIs("statuses", documentAsDocument);
            NodeList elementsByTagName = documentAsDocument.getDocumentElement().getElementsByTagName("status");
            int length = elementsByTagName.getLength();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new Status(response, (Element) elementsByTagName.item(i), weibo));
            }
            return arrayList;
        } catch (WeiboException e) {
            ensureRootNodeNameIs("nil-classes", documentAsDocument);
            return new ArrayList(0);
        }
    }

    static List constructStatuses(Response response) throws WeiboException {
        try {
            JSONArray jSONArrayAsJSONArray = response.asJSONArray();
            int length = jSONArrayAsJSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new Status(jSONArrayAsJSONArray.getJSONObject(i)));
            }
            return arrayList;
        } catch (WeiboException e) {
            throw e;
        } catch (JSONException e2) {
            throw new WeiboException(e2);
        }
    }

    public int hashCode() {
        return (int) this.f7916id;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof Status) && ((Status) obj).f7916id == this.f7916id;
    }

    public String toString() {
        return "Status [createdAt=" + this.createdAt + ", id=" + this.f7916id + ", text=" + this.text + ", source=" + this.source + ", isTruncated=" + this.isTruncated + ", inReplyToStatusId=" + this.inReplyToStatusId + ", inReplyToUserId=" + this.inReplyToUserId + ", isFavorited=" + this.isFavorited + ", inReplyToScreenName=" + this.inReplyToScreenName + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", thumbnail_pic=" + this.thumbnail_pic + ", bmiddle_pic=" + this.bmiddle_pic + ", original_pic=" + this.original_pic + ", retweetDetails=" + this.retweetDetails + ",  mid=" + this.mid + ", user=" + this.user + "retweeted_status=" + (this.retweeted_status == null ? "null" : this.retweeted_status.toString()) + "]";
    }
}
