package twitter4j.internal.json;

import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.TimeZone;
import twitter4j.TwitterException;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
public class TimeZoneJSONImpl implements TimeZone {
    private final String NAME;
    private final String TZINFO_NAME;
    private final int UTC_OFFSET;

    TimeZoneJSONImpl(JSONObject jSONObject) throws TwitterException {
        try {
            this.UTC_OFFSET = z_T4JInternalParseUtil.getInt("utc_offset", jSONObject);
            this.NAME = jSONObject.getString("name");
            this.TZINFO_NAME = jSONObject.getString("tzinfo_name");
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    @Override // twitter4j.TimeZone
    public String getName() {
        return this.NAME;
    }

    @Override // twitter4j.TimeZone
    public String tzinfoName() {
        return this.TZINFO_NAME;
    }

    @Override // twitter4j.TimeZone
    public int utcOffset() {
        return this.UTC_OFFSET;
    }
}
