package weibo4android;

import java.io.Serializable;
import java.util.ArrayList;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import twitter4j.conf.PropertyConfiguration;
import weibo4android.http.Response;
import weibo4android.org.json.JSONArray;
import weibo4android.org.json.JSONException;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class ListObject extends WeiboResponse implements Serializable {
    private static final long serialVersionUID = 4208232205515192208L;
    private String description;
    private String fullName;

    /* renamed from: id */
    private long f13751id;
    private int memberCount;
    private String mode;
    private String name;
    private String slug;
    private int subscriberCount;
    private String uri;
    private User user;

    ListObject(Response response, Weibo weibo) {
        super(response);
        init(response, response.asDocument().getDocumentElement(), weibo);
    }

    ListObject(Response response, Element element, Weibo weibo) {
        super(response);
        init(response, element, weibo);
    }

    ListObject(JSONObject jSONObject) throws WeiboException {
        try {
            this.f13751id = jSONObject.getLong("id");
            this.name = jSONObject.getString("name");
            this.fullName = jSONObject.getString("full_name");
            this.slug = jSONObject.getString("slug");
            this.description = jSONObject.getString("description");
            this.subscriberCount = jSONObject.getInt("subscriber_count");
            this.memberCount = jSONObject.getInt("member_count");
            this.uri = jSONObject.getString("uri");
            this.mode = jSONObject.getString(RtspHeaders.Values.MODE);
            if (!jSONObject.isNull(PropertyConfiguration.USER)) {
                this.user = new User(jSONObject.getJSONObject(PropertyConfiguration.USER));
            }
        } catch (JSONException e) {
            throw new WeiboException(e.getMessage() + ":" + jSONObject.toString(), e);
        }
    }

    private void init(Response response, Element element, Weibo weibo) {
        ensureRootNodeNameIs("list", element);
        this.f13751id = getChildLong("id", element);
        this.name = getChildText("name", element);
        this.fullName = getChildText("full_name", element);
        this.slug = getChildText("slug", element);
        this.description = getChildText("description", element);
        this.subscriberCount = getChildInt("subscriber_count", element);
        this.memberCount = getChildInt("member_count", element);
        this.uri = getChildText("uri", element);
        this.mode = getChildText(RtspHeaders.Values.MODE, element);
        NodeList elementsByTagName = element.getElementsByTagName(PropertyConfiguration.USER);
        if (elementsByTagName.getLength() != 0) {
            this.user = new User(response, (Element) elementsByTagName.item(0), weibo);
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String str) {
        this.fullName = str;
    }

    public String getSlug() {
        return this.slug;
    }

    public void setSlug(String str) {
        this.slug = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public int getSubscriberCount() {
        return this.subscriberCount;
    }

    public void setSubscriberCount(int i) {
        this.subscriberCount = i;
    }

    public int getMemberCount() {
        return this.memberCount;
    }

    public void setMemberCount(int i) {
        this.memberCount = i;
    }

    public void setId(long j) {
        this.f13751id = j;
    }

    public long getId() {
        return this.f13751id;
    }

    public String getMode() {
        return this.mode;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    static ListObjectWapper constructListObjects(Response response, Weibo weibo) throws WeiboException {
        Document documentAsDocument = response.asDocument();
        if (isRootNodeNilClasses(documentAsDocument)) {
            return new ListObjectWapper(new ArrayList(0), 0L, 0L);
        }
        try {
            ensureRootNodeNameIs("lists_list", documentAsDocument);
            Element documentElement = documentAsDocument.getDocumentElement();
            NodeList elementsByTagName = documentElement.getElementsByTagName("lists");
            if (elementsByTagName.getLength() == 0) {
                return new ListObjectWapper(new ArrayList(0), 0L, 0L);
            }
            NodeList elementsByTagName2 = ((Element) elementsByTagName.item(0)).getElementsByTagName("list");
            int length = elementsByTagName2.getLength();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new ListObject(response, (Element) elementsByTagName2.item(i), weibo));
            }
            long childLong = getChildLong("previous_curosr", documentElement);
            long childLong2 = getChildLong("next_curosr", documentElement);
            if (childLong2 == -1) {
                childLong2 = getChildLong("nextCurosr", documentElement);
            }
            return new ListObjectWapper(arrayList, childLong, childLong2);
        } catch (WeiboException e) {
            if (isRootNodeNilClasses(documentAsDocument)) {
                return new ListObjectWapper(new ArrayList(0), 0L, 0L);
            }
            throw e;
        }
    }

    static ListObjectWapper constructListObjects(Response response) throws WeiboException {
        JSONObject jSONObjectAsJSONObject = response.asJSONObject();
        try {
            JSONArray jSONArray = jSONObjectAsJSONObject.getJSONArray("lists");
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new ListObject(jSONArray.getJSONObject(i)));
            }
            long j = jSONObjectAsJSONObject.getLong("previous_curosr");
            long j2 = jSONObjectAsJSONObject.getLong("next_cursor");
            if (j2 == -1) {
                j2 = jSONObjectAsJSONObject.getLong("nextCursor");
            }
            return new ListObjectWapper(arrayList, j, j2);
        } catch (JSONException e) {
            throw new WeiboException(e);
        }
    }

    public int hashCode() {
        return (int) this.f13751id;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this != obj) {
            return (obj instanceof ListObject) && ((ListObject) obj).f13751id == this.f13751id;
        }
        return true;
    }

    public String toString() {
        return "ListObject{id=" + this.f13751id + ", name='" + this.name + "', fullName='" + this.fullName + "', slug='" + this.slug + "', description='" + this.description + "', subscriberCount=" + this.subscriberCount + ", memberCount=" + this.memberCount + ", mode='" + this.mode + "', uri='" + this.uri + "', user='" + this.user.toString() + "'}";
    }
}
