package twitter4j.internal.json;

import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.IDs;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
final class IDsJSONImpl extends TwitterResponseImpl implements IDs {
    private static final long serialVersionUID = -6585026560164704953L;
    private long[] ids;
    private long nextCursor;
    private long previousCursor;

    IDsJSONImpl(HttpResponse httpResponse, Configuration configuration) throws Throwable {
        super(httpResponse);
        this.previousCursor = -1L;
        this.nextCursor = -1L;
        String strAsString = httpResponse.asString();
        init(strAsString);
        if (configuration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
            DataObjectFactoryUtil.registerJSONObject(this, strAsString);
        }
    }

    IDsJSONImpl(String str) throws JSONException, TwitterException {
        this.previousCursor = -1L;
        this.nextCursor = -1L;
        init(str);
    }

    private void init(String str) throws JSONException, TwitterException {
        int i = 0;
        try {
            if (str.startsWith("{")) {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArray = jSONObject.getJSONArray("ids");
                this.ids = new long[jSONArray.length()];
                while (i < jSONArray.length()) {
                    try {
                        this.ids[i] = Long.parseLong(jSONArray.getString(i));
                        i++;
                    } catch (NumberFormatException e) {
                        throw new TwitterException(new StringBuffer().append("Twitter API returned malformed response: ").append(jSONObject).toString(), e);
                    }
                }
                this.previousCursor = z_T4JInternalParseUtil.getLong("previous_cursor", jSONObject);
                this.nextCursor = z_T4JInternalParseUtil.getLong("next_cursor", jSONObject);
                return;
            }
            JSONArray jSONArray2 = new JSONArray(str);
            this.ids = new long[jSONArray2.length()];
            while (i < jSONArray2.length()) {
                try {
                    this.ids[i] = Long.parseLong(jSONArray2.getString(i));
                    i++;
                } catch (NumberFormatException e2) {
                    throw new TwitterException(new StringBuffer().append("Twitter API returned malformed response: ").append(jSONArray2).toString(), e2);
                }
            }
            return;
        } catch (JSONException e3) {
            throw new TwitterException(e3);
        }
        throw new TwitterException(e3);
    }

    @Override // twitter4j.IDs
    public long[] getIDs() {
        return this.ids;
    }

    @Override // twitter4j.IDs, twitter4j.CursorSupport
    public boolean hasPrevious() {
        return 0 != this.previousCursor;
    }

    @Override // twitter4j.IDs, twitter4j.CursorSupport
    public long getPreviousCursor() {
        return this.previousCursor;
    }

    @Override // twitter4j.IDs, twitter4j.CursorSupport
    public boolean hasNext() {
        return 0 != this.nextCursor;
    }

    @Override // twitter4j.IDs, twitter4j.CursorSupport
    public long getNextCursor() {
        return this.nextCursor;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IDs) && Arrays.equals(this.ids, ((IDs) obj).getIDs());
    }

    public int hashCode() {
        if (this.ids != null) {
            return Arrays.hashCode(this.ids);
        }
        return 0;
    }

    public String toString() {
        return new StringBuffer().append("IDsJSONImpl{ids=").append(Arrays.toString(this.ids)).append(", previousCursor=").append(this.previousCursor).append(", nextCursor=").append(this.nextCursor).append('}').toString();
    }
}
