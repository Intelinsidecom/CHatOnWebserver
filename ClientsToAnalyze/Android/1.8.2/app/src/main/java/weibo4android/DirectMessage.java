package weibo4android;

import com.sec.spp.push.Config;
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
public class DirectMessage extends WeiboResponse implements Serializable {
    private static final long serialVersionUID = -3253021825891789737L;
    private Date created_at;

    /* renamed from: id */
    private Long f7912id;
    private User recipient;
    private int recipient_id;
    private String recipient_screen_name;
    private User sender;
    private int sender_id;
    private String sender_screen_name;
    private String text;

    DirectMessage(Response response, Weibo weibo) {
        super(response);
        init(response, response.asDocument().getDocumentElement(), weibo);
    }

    DirectMessage(Response response, Element element, Weibo weibo) {
        super(response);
        init(response, element, weibo);
    }

    DirectMessage(JSONObject jSONObject) throws WeiboException {
        try {
            this.f7912id = Long.valueOf(jSONObject.getLong("id"));
            this.text = jSONObject.getString("text");
            this.sender_id = jSONObject.getInt("sender_id");
            this.recipient_id = jSONObject.getInt("recipient_id");
            this.created_at = parseDate(jSONObject.getString("created_at"), "EEE MMM dd HH:mm:ss z yyyy");
            this.sender_screen_name = jSONObject.getString("sender_screen_name");
            this.recipient_screen_name = jSONObject.getString("recipient_screen_name");
            if (!jSONObject.isNull(Config.NOTIFICATION_INTENT_SENDER)) {
                this.sender = new User(jSONObject.getJSONObject(Config.NOTIFICATION_INTENT_SENDER));
            }
        } catch (JSONException e) {
            throw new WeiboException(String.valueOf(e.getMessage()) + ":" + jSONObject.toString(), e);
        }
    }

    private void init(Response response, Element element, Weibo weibo) {
        ensureRootNodeNameIs("direct_message", element);
        this.sender = new User(response, (Element) element.getElementsByTagName(Config.NOTIFICATION_INTENT_SENDER).item(0), weibo);
        this.recipient = new User(response, (Element) element.getElementsByTagName("recipient").item(0), weibo);
        this.f7912id = Long.valueOf(getChildLong("id", element));
        this.text = getChildText("text", element);
        this.sender_id = getChildInt("sender_id", element);
        this.recipient_id = getChildInt("recipient_id", element);
        this.created_at = getChildDate("created_at", element);
        this.sender_screen_name = getChildText("sender_screen_name", element);
        this.recipient_screen_name = getChildText("recipient_screen_name", element);
    }

    public long getId() {
        return this.f7912id.longValue();
    }

    public String getText() {
        return this.text;
    }

    public int getSenderId() {
        return this.sender_id;
    }

    public int getRecipientId() {
        return this.recipient_id;
    }

    public Date getCreatedAt() {
        return this.created_at;
    }

    public String getSenderScreenName() {
        return this.sender_screen_name;
    }

    public String getRecipientScreenName() {
        return this.recipient_screen_name;
    }

    public User getSender() {
        return this.sender;
    }

    public User getRecipient() {
        return this.recipient;
    }

    static List constructDirectMessages(Response response, Weibo weibo) throws WeiboException {
        Document documentAsDocument = response.asDocument();
        if (isRootNodeNilClasses(documentAsDocument)) {
            return new ArrayList(0);
        }
        try {
            ensureRootNodeNameIs("direct-messages", documentAsDocument);
            NodeList elementsByTagName = documentAsDocument.getDocumentElement().getElementsByTagName("direct_message");
            int length = elementsByTagName.getLength();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new DirectMessage(response, (Element) elementsByTagName.item(i), weibo));
            }
            return arrayList;
        } catch (WeiboException e) {
            if (isRootNodeNilClasses(documentAsDocument)) {
                return new ArrayList(0);
            }
            throw e;
        }
    }

    static List constructDirectMessages(Response response) throws WeiboException {
        JSONArray jSONArrayAsJSONArray = response.asJSONArray();
        try {
            int length = jSONArrayAsJSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(new DirectMessage(jSONArrayAsJSONArray.getJSONObject(i)));
            }
            return arrayList;
        } catch (JSONException e) {
            throw new WeiboException(e);
        }
    }

    public int hashCode() {
        return this.f7912id.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof DirectMessage) && ((DirectMessage) obj).f7912id == this.f7912id;
    }

    public String toString() {
        return "DirectMessage{id=" + this.f7912id + ", text='" + this.text + "', sender_id=" + this.sender_id + ", recipient_id=" + this.recipient_id + ", created_at=" + this.created_at + ", sender_screen_name='" + this.sender_screen_name + "', recipient_screen_name='" + this.recipient_screen_name + "', sender=" + this.sender + ", recipient=" + this.recipient + '}';
    }
}
