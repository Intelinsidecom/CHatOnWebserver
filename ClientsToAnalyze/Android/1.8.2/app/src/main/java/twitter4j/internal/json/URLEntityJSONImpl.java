package twitter4j.internal.json;

import java.net.MalformedURLException;
import java.net.URL;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.TwitterException;
import twitter4j.URLEntity;

/* loaded from: classes.dex */
final class URLEntityJSONImpl implements URLEntity {
    private static final long serialVersionUID = 1165188478018146676L;
    private String displayURL;
    private URL expandedURL;
    private URL url;
    private int start = -1;
    private int end = -1;

    URLEntityJSONImpl(JSONObject jSONObject) throws JSONException, TwitterException {
        init(jSONObject);
    }

    private void init(JSONObject jSONObject) throws JSONException, TwitterException {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("indices");
            this.start = jSONArray.getInt(0);
            this.end = jSONArray.getInt(1);
            try {
                this.url = new URL(jSONObject.getString(RtspHeaders.Values.URL));
            } catch (MalformedURLException e) {
            }
            if (!jSONObject.isNull("expanded_url")) {
                try {
                    this.expandedURL = new URL(jSONObject.getString("expanded_url"));
                } catch (MalformedURLException e2) {
                }
            }
            if (!jSONObject.isNull("display_url")) {
                this.displayURL = jSONObject.getString("display_url");
            }
        } catch (JSONException e3) {
            throw new TwitterException(e3);
        }
    }

    @Override // twitter4j.URLEntity
    public URL getURL() {
        return this.url;
    }

    @Override // twitter4j.URLEntity
    public URL getExpandedURL() {
        return this.expandedURL;
    }

    @Override // twitter4j.URLEntity
    public String getDisplayURL() {
        return this.displayURL;
    }

    @Override // twitter4j.URLEntity
    public int getStart() {
        return this.start;
    }

    @Override // twitter4j.URLEntity
    public int getEnd() {
        return this.end;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        URLEntityJSONImpl uRLEntityJSONImpl = (URLEntityJSONImpl) obj;
        if (this.end == uRLEntityJSONImpl.end && this.start == uRLEntityJSONImpl.start) {
            if (this.displayURL == null ? uRLEntityJSONImpl.displayURL != null : !this.displayURL.equals(uRLEntityJSONImpl.displayURL)) {
                return false;
            }
            if (this.expandedURL == null ? uRLEntityJSONImpl.expandedURL != null : !this.expandedURL.equals(uRLEntityJSONImpl.expandedURL)) {
                return false;
            }
            if (this.url != null) {
                if (this.url.equals(uRLEntityJSONImpl.url)) {
                    return true;
                }
            } else if (uRLEntityJSONImpl.url == null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (((this.expandedURL != null ? this.expandedURL.hashCode() : 0) + (((this.url != null ? this.url.hashCode() : 0) + (((this.start * 31) + this.end) * 31)) * 31)) * 31) + (this.displayURL != null ? this.displayURL.hashCode() : 0);
    }

    public String toString() {
        return new StringBuffer().append("URLEntityJSONImpl{start=").append(this.start).append(", end=").append(this.end).append(", url=").append(this.url).append(", expandedURL=").append(this.expandedURL).append(", displayURL=").append(this.displayURL).append('}').toString();
    }
}
