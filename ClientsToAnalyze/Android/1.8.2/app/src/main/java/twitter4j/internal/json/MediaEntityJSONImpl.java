package twitter4j.internal.json;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.MediaEntity;
import twitter4j.TwitterException;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
public class MediaEntityJSONImpl implements MediaEntity {
    private static final long serialVersionUID = -5196438049688518593L;
    private String displayURL;
    private int end;
    private URL expandedURL;

    /* renamed from: id */
    private long f7900id;
    private URL mediaURL;
    private URL mediaURLHttps;
    private Map sizes;
    private int start;
    private URL url;

    public MediaEntityJSONImpl(JSONObject jSONObject) throws JSONException, TwitterException {
        this.start = -1;
        this.end = -1;
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("indices");
            this.start = jSONArray.getInt(0);
            this.end = jSONArray.getInt(1);
            this.f7900id = z_T4JInternalParseUtil.getLong("id", jSONObject);
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
            if (!jSONObject.isNull("media_url")) {
                try {
                    this.mediaURL = new URL(jSONObject.getString("media_url"));
                } catch (MalformedURLException e3) {
                }
            }
            if (!jSONObject.isNull("media_url_https")) {
                try {
                    this.mediaURLHttps = new URL(jSONObject.getString("media_url_https"));
                } catch (MalformedURLException e4) {
                }
            }
            if (!jSONObject.isNull("display_url")) {
                this.displayURL = jSONObject.getString("display_url");
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("sizes");
            this.sizes = new HashMap(4);
            this.sizes.put(MediaEntity.Size.LARGE, new Size(jSONObject2.getJSONObject("large")));
            this.sizes.put(MediaEntity.Size.MEDIUM, new Size(jSONObject2.getJSONObject("medium")));
            this.sizes.put(MediaEntity.Size.SMALL, new Size(jSONObject2.getJSONObject("small")));
            this.sizes.put(MediaEntity.Size.THUMB, new Size(jSONObject2.getJSONObject("thumb")));
        } catch (JSONException e5) {
            throw new TwitterException(e5);
        }
    }

    @Override // twitter4j.MediaEntity
    public long getId() {
        return this.f7900id;
    }

    @Override // twitter4j.MediaEntity
    public URL getMediaURL() {
        return this.mediaURL;
    }

    @Override // twitter4j.MediaEntity
    public URL getMediaURLHttps() {
        return this.mediaURLHttps;
    }

    @Override // twitter4j.URLEntity
    public URL getURL() {
        return this.url;
    }

    @Override // twitter4j.URLEntity
    public String getDisplayURL() {
        return this.displayURL;
    }

    @Override // twitter4j.URLEntity
    public URL getExpandedURL() {
        return this.expandedURL;
    }

    @Override // twitter4j.MediaEntity
    public Map getSizes() {
        return this.sizes;
    }

    @Override // twitter4j.URLEntity
    public int getStart() {
        return this.start;
    }

    @Override // twitter4j.URLEntity
    public int getEnd() {
        return this.end;
    }

    class Size implements MediaEntity.Size {
        private static final long serialVersionUID = 8681853416159361581L;
        int height;
        int resize;
        int width;

        Size(JSONObject jSONObject) {
            this.width = jSONObject.getInt("w");
            this.height = jSONObject.getInt("h");
            this.resize = "fit".equals(jSONObject.getString("resize")) ? 100 : MediaEntity.Size.CROP;
        }

        @Override // twitter4j.MediaEntity.Size
        public int getWidth() {
            return this.width;
        }

        @Override // twitter4j.MediaEntity.Size
        public int getHeight() {
            return this.height;
        }

        @Override // twitter4j.MediaEntity.Size
        public int getResize() {
            return this.resize;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Size)) {
                return false;
            }
            Size size = (Size) obj;
            return this.height == size.height && this.resize == size.resize && this.width == size.width;
        }

        public int hashCode() {
            return (((this.width * 31) + this.height) * 31) + this.resize;
        }

        public String toString() {
            return new StringBuffer().append("Size{width=").append(this.width).append(", height=").append(this.height).append(", resize=").append(this.resize).append('}').toString();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MediaEntityJSONImpl) && this.f7900id == ((MediaEntityJSONImpl) obj).f7900id;
    }

    public int hashCode() {
        return (int) (this.f7900id ^ (this.f7900id >>> 32));
    }

    public String toString() {
        return new StringBuffer().append("MediaEntityJSONImpl{id=").append(this.f7900id).append(", start=").append(this.start).append(", end=").append(this.end).append(", url=").append(this.url).append(", mediaURL=").append(this.mediaURL).append(", mediaURLHttps=").append(this.mediaURLHttps).append(", expandedURL=").append(this.expandedURL).append(", displayURL='").append(this.displayURL).append('\'').append(", sizes=").append(this.sizes).append('}').toString();
    }
}
