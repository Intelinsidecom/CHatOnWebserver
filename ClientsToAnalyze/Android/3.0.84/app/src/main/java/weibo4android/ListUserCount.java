package weibo4android;

import java.io.Serializable;
import org.w3c.dom.Element;
import weibo4android.http.Response;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class ListUserCount extends WeiboResponse implements Serializable {
    private static final long serialVersionUID = 2638697034012299545L;
    private int listCount;
    private int listedCount;
    private int subscriberCount;

    public ListUserCount(JSONObject jSONObject) {
        this.listCount = jSONObject.getInt("lists");
        this.subscriberCount = jSONObject.getInt("subscriptions");
        this.listedCount = jSONObject.getInt("listed");
    }

    public ListUserCount(Response response) {
        Element documentElement = response.asDocument().getDocumentElement();
        ensureRootNodeNameIs("count", documentElement);
        this.listCount = getChildInt("lists", documentElement);
        this.subscriberCount = getChildInt("subscriptions", documentElement);
        this.listedCount = getChildInt("listed", documentElement);
    }

    public int hashCode() {
        return (this.listCount * 100) + (this.subscriberCount * 10) + this.listedCount;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this != obj) {
            return (obj instanceof ListUserCount) && ((ListUserCount) obj).hashCode() == hashCode();
        }
        return true;
    }

    public int getListCount() {
        return this.listCount;
    }

    public void setListCount(int i) {
        this.listCount = i;
    }

    public int getSubscriberCount() {
        return this.subscriberCount;
    }

    public void setSubscriberCount(int i) {
        this.subscriberCount = i;
    }

    public int getListedCount() {
        return this.listedCount;
    }

    public void setListedCount(int i) {
        this.listedCount = i;
    }

    public String toString() {
        return "ListUserCount{listCount=" + this.listCount + ", subscriberCount=" + this.subscriberCount + ", listedCount=" + this.listedCount + '}';
    }
}
