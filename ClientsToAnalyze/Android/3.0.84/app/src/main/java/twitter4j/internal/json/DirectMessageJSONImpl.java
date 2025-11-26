package twitter4j.internal.json;

import com.sec.spp.push.Config;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.DirectMessage;
import twitter4j.ResponseList;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
final class DirectMessageJSONImpl extends TwitterResponseImpl implements Serializable, DirectMessage {
    private static final long serialVersionUID = -7104233663827757577L;
    private Date createdAt;

    /* renamed from: id */
    private long f13734id;
    private User recipient;
    private long recipientId;
    private String recipientScreenName;
    private User sender;
    private long senderId;
    private String senderScreenName;
    private String text;

    DirectMessageJSONImpl(HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, TwitterException, IOException, IllegalArgumentException, InvocationTargetException {
        super(httpResponse);
        JSONObject jSONObjectAsJSONObject = httpResponse.asJSONObject();
        init(jSONObjectAsJSONObject);
        if (configuration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
            DataObjectFactoryUtil.registerJSONObject(this, jSONObjectAsJSONObject);
        }
    }

    DirectMessageJSONImpl(JSONObject jSONObject) throws TwitterException {
        init(jSONObject);
    }

    private void init(JSONObject jSONObject) throws TwitterException {
        this.f13734id = z_T4JInternalParseUtil.getLong("id", jSONObject);
        this.text = z_T4JInternalParseUtil.getUnescapedString("text", jSONObject);
        this.senderId = z_T4JInternalParseUtil.getLong("sender_id", jSONObject);
        this.recipientId = z_T4JInternalParseUtil.getLong("recipient_id", jSONObject);
        this.createdAt = z_T4JInternalParseUtil.getDate("created_at", jSONObject);
        this.senderScreenName = z_T4JInternalParseUtil.getUnescapedString("sender_screen_name", jSONObject);
        this.recipientScreenName = z_T4JInternalParseUtil.getUnescapedString("recipient_screen_name", jSONObject);
        try {
            this.sender = new UserJSONImpl(jSONObject.getJSONObject(Config.NOTIFICATION_INTENT_SENDER));
            this.recipient = new UserJSONImpl(jSONObject.getJSONObject("recipient"));
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    @Override // twitter4j.DirectMessage
    public long getId() {
        return this.f13734id;
    }

    @Override // twitter4j.DirectMessage
    public String getText() {
        return this.text;
    }

    @Override // twitter4j.DirectMessage
    public long getSenderId() {
        return this.senderId;
    }

    @Override // twitter4j.DirectMessage
    public long getRecipientId() {
        return this.recipientId;
    }

    @Override // twitter4j.DirectMessage
    public Date getCreatedAt() {
        return this.createdAt;
    }

    @Override // twitter4j.DirectMessage
    public String getSenderScreenName() {
        return this.senderScreenName;
    }

    @Override // twitter4j.DirectMessage
    public String getRecipientScreenName() {
        return this.recipientScreenName;
    }

    @Override // twitter4j.DirectMessage
    public User getSender() {
        return this.sender;
    }

    @Override // twitter4j.DirectMessage
    public User getRecipient() {
        return this.recipient;
    }

    static ResponseList<DirectMessage> createDirectMessageList(HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, JSONException, TwitterException, IOException, IllegalArgumentException, InvocationTargetException {
        try {
            if (configuration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.clearThreadLocalMap();
            }
            JSONArray jSONArrayAsJSONArray = httpResponse.asJSONArray();
            int length = jSONArrayAsJSONArray.length();
            ResponseListImpl responseListImpl = new ResponseListImpl(length, httpResponse);
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArrayAsJSONArray.getJSONObject(i);
                DirectMessageJSONImpl directMessageJSONImpl = new DirectMessageJSONImpl(jSONObject);
                responseListImpl.add(directMessageJSONImpl);
                if (configuration.isJSONStoreEnabled()) {
                    DataObjectFactoryUtil.registerJSONObject(directMessageJSONImpl, jSONObject);
                }
            }
            if (configuration.isJSONStoreEnabled()) {
                DataObjectFactoryUtil.registerJSONObject(responseListImpl, jSONArrayAsJSONArray);
            }
            return responseListImpl;
        } catch (JSONException e) {
            throw new TwitterException(e);
        } catch (TwitterException e2) {
            throw e2;
        }
    }

    public int hashCode() {
        return (int) this.f13734id;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this != obj) {
            return (obj instanceof DirectMessage) && ((DirectMessage) obj).getId() == this.f13734id;
        }
        return true;
    }

    public String toString() {
        return new StringBuffer().append("DirectMessageJSONImpl{id=").append(this.f13734id).append(", text='").append(this.text).append('\'').append(", sender_id=").append(this.senderId).append(", recipient_id=").append(this.recipientId).append(", created_at=").append(this.createdAt).append(", sender_screen_name='").append(this.senderScreenName).append('\'').append(", recipient_screen_name='").append(this.recipientScreenName).append('\'').append(", sender=").append(this.sender).append(", recipient=").append(this.recipient).append('}').toString();
    }
}
