package weibo4android;

import java.util.Arrays;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import weibo4android.http.Response;
import weibo4android.org.json.JSONArray;
import weibo4android.org.json.JSONException;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class IDs extends WeiboResponse {
    private static String[] ROOT_NODE_NAMES = {"id_list", "ids"};
    private static final long serialVersionUID = -6585026560164704953L;
    private long[] ids;
    private long nextCursor;
    private long previousCursor;

    IDs(Response response) throws WeiboException {
        super(response);
        Element documentElement = response.asDocument().getDocumentElement();
        ensureRootNodeNameIs(ROOT_NODE_NAMES, documentElement);
        NodeList elementsByTagName = documentElement.getElementsByTagName("id");
        this.ids = new long[elementsByTagName.getLength()];
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            try {
                this.ids[i] = Long.parseLong(elementsByTagName.item(i).getFirstChild().getNodeValue());
            } catch (NumberFormatException e) {
                throw new WeiboException("Weibo API returned malformed response: " + documentElement, e);
            }
        }
        this.previousCursor = getChildLong("previous_cursor", documentElement);
        this.nextCursor = getChildLong("next_cursor", documentElement);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IDs(Response response, Weibo weibo) throws WeiboException {
        super(response);
        if ("[]\n".equals(response.asString())) {
            this.previousCursor = 0L;
            this.nextCursor = 0L;
            this.ids = new long[0];
            return;
        }
        JSONObject jSONObjectAsJSONObject = response.asJSONObject();
        try {
            this.previousCursor = jSONObjectAsJSONObject.getLong("previous_cursor");
            this.nextCursor = jSONObjectAsJSONObject.getLong("next_cursor");
            if (!jSONObjectAsJSONObject.isNull("ids")) {
                JSONArray jSONArray = jSONObjectAsJSONObject.getJSONArray("ids");
                int length = jSONArray.length();
                this.ids = new long[length];
                for (int i = 0; i < length; i++) {
                    this.ids[i] = jSONArray.getLong(i);
                }
            }
        } catch (JSONException e) {
            throw new WeiboException(e);
        }
    }

    public long[] getIDs() {
        return this.ids;
    }

    public boolean hasPrevious() {
        return 0 != this.previousCursor;
    }

    public long getPreviousCursor() {
        return this.previousCursor;
    }

    public boolean hasNext() {
        return 0 != this.nextCursor;
    }

    public long getNextCursor() {
        return this.nextCursor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IDs)) {
            return false;
        }
        return Arrays.equals(this.ids, ((IDs) obj).ids);
    }

    public int hashCode() {
        if (this.ids != null) {
            return Arrays.hashCode(this.ids);
        }
        return 0;
    }

    public String toString() {
        return "IDs{ids=" + this.ids + ", previousCursor=" + this.previousCursor + ", nextCursor=" + this.nextCursor + '}';
    }
}
