package twitter4j.internal.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.HashtagEntity;
import twitter4j.TwitterException;

/* loaded from: classes.dex */
class HashtagEntityJSONImpl implements HashtagEntity {
    private static final long serialVersionUID = 4068992372784813200L;
    private String text;
    private int start = -1;
    private int end = -1;

    HashtagEntityJSONImpl(JSONObject jSONObject) throws JSONException, TwitterException {
        init(jSONObject);
    }

    private void init(JSONObject jSONObject) throws JSONException, TwitterException {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("indices");
            this.start = jSONArray.getInt(0);
            this.end = jSONArray.getInt(1);
            if (!jSONObject.isNull("text")) {
                this.text = jSONObject.getString("text");
            }
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    @Override // twitter4j.HashtagEntity
    public String getText() {
        return this.text;
    }

    @Override // twitter4j.HashtagEntity
    public int getStart() {
        return this.start;
    }

    @Override // twitter4j.HashtagEntity
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
        HashtagEntityJSONImpl hashtagEntityJSONImpl = (HashtagEntityJSONImpl) obj;
        if (this.end == hashtagEntityJSONImpl.end && this.start == hashtagEntityJSONImpl.start) {
            if (this.text != null) {
                if (this.text.equals(hashtagEntityJSONImpl.text)) {
                    return true;
                }
            } else if (hashtagEntityJSONImpl.text == null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (this.text != null ? this.text.hashCode() : 0) + (((this.start * 31) + this.end) * 31);
    }

    public String toString() {
        return new StringBuffer().append("HashtagEntityJSONImpl{start=").append(this.start).append(", end=").append(this.end).append(", text='").append(this.text).append('\'').append('}').toString();
    }
}
