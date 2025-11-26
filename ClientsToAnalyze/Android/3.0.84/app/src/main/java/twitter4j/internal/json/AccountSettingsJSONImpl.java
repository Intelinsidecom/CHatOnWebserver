package twitter4j.internal.json;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.AccountSettings;
import twitter4j.Location;
import twitter4j.TimeZone;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
class AccountSettingsJSONImpl extends TwitterResponseImpl implements Serializable, AccountSettings {
    private static final long serialVersionUID = 7983363611306383416L;
    private final boolean ALWAYS_USE_HTTPS;
    private final boolean DISCOVERABLE_BY_EMAIL;
    private final boolean GEO_ENABLED;
    private final String LANGUAGE;
    private final String SLEEP_END_TIME;
    private final String SLEEP_START_TIME;
    private final boolean SLEEP_TIME_ENABLED;
    private final TimeZone TIMEZONE;
    private final Location[] TREND_LOCATION;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private AccountSettingsJSONImpl(HttpResponse httpResponse, JSONObject jSONObject) throws JSONException, TwitterException {
        super(httpResponse);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("sleep_time");
            this.SLEEP_TIME_ENABLED = z_T4JInternalParseUtil.getBoolean("enabled", jSONObject2);
            this.SLEEP_START_TIME = jSONObject2.getString("start_time");
            this.SLEEP_END_TIME = jSONObject2.getString("end_time");
            if (jSONObject.isNull("trend_location")) {
                this.TREND_LOCATION = new Location[0];
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray("trend_location");
                this.TREND_LOCATION = new Location[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.TREND_LOCATION[i] = new LocationJSONImpl(jSONArray.getJSONObject(i));
                }
            }
            this.GEO_ENABLED = z_T4JInternalParseUtil.getBoolean("geo_enabled", jSONObject);
            this.LANGUAGE = jSONObject.getString("language");
            this.ALWAYS_USE_HTTPS = z_T4JInternalParseUtil.getBoolean("always_use_https", jSONObject);
            this.DISCOVERABLE_BY_EMAIL = z_T4JInternalParseUtil.getBoolean("discoverable_by_email", jSONObject);
            this.TIMEZONE = new TimeZoneJSONImpl(jSONObject.getJSONObject("time_zone"));
        } catch (JSONException e) {
            throw new TwitterException(e);
        }
    }

    AccountSettingsJSONImpl(HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this(httpResponse, httpResponse.asJSONObject());
        if (configuration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
            DataObjectFactoryUtil.registerJSONObject(this, httpResponse.asJSONObject());
        }
    }

    AccountSettingsJSONImpl(JSONObject jSONObject) {
        this((HttpResponse) null, jSONObject);
    }

    @Override // twitter4j.AccountSettings
    public boolean isSleepTimeEnabled() {
        return this.SLEEP_TIME_ENABLED;
    }

    @Override // twitter4j.AccountSettings
    public String getSleepStartTime() {
        return this.SLEEP_START_TIME;
    }

    @Override // twitter4j.AccountSettings
    public String getSleepEndTime() {
        return this.SLEEP_END_TIME;
    }

    @Override // twitter4j.AccountSettings
    public Location[] getTrendLocations() {
        return this.TREND_LOCATION;
    }

    @Override // twitter4j.AccountSettings
    public boolean isGeoEnabled() {
        return this.GEO_ENABLED;
    }

    @Override // twitter4j.AccountSettings
    public boolean isDiscoverableByEmail() {
        return this.DISCOVERABLE_BY_EMAIL;
    }

    @Override // twitter4j.AccountSettings
    public boolean isAlwaysUseHttps() {
        return this.ALWAYS_USE_HTTPS;
    }

    @Override // twitter4j.AccountSettings
    public String getLanguage() {
        return this.LANGUAGE;
    }

    @Override // twitter4j.AccountSettings
    public TimeZone getTimeZone() {
        return this.TIMEZONE;
    }
}
