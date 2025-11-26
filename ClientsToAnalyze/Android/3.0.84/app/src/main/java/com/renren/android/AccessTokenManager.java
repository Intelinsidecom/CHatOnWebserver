package com.renren.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.sec.chaton.p020c.C0817b;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.conf.PropertyConfiguration;

/* loaded from: classes.dex */
class AccessTokenManager implements Parcelable {
    public static final Parcelable.Creator<AccessTokenManager> CREATOR = new C0198b();
    private static final String KEY_ACCESS_TOKEN = "renren_token_manager_access_token";
    private static final String KEY_SESSION_KEY = "renren_token_manager_session_key";
    private static final String KEY_SESSION_KEY_EXPIRE_TIME = "renren_token_manager_session_key_expire_time";
    private static final String KEY_SESSION_SECRET = "renren_token_manager_session_secret";
    private static final String KEY_UID = "renren_token_manager_user_id";
    private static final long ONE_HOUR = 3600000;
    private static final String RENREN_SDK_CONFIG = "renren_sdk_config";
    private static final String RENREN_SDK_CONFIG_PROP_ACCESS_TOKEN = "renren_sdk_config_prop_access_token";
    private static final String RENREN_SDK_CONFIG_PROP_CREATE_TIME = "renren_sdk_config_prop_create_time";
    private static final String RENREN_SDK_CONFIG_PROP_EXPIRE_SECONDS = "renren_sdk_config_prop_expire_secends";
    private static final String RENREN_SDK_CONFIG_PROP_SESSION_CREATE_TIME = "renren_sdk_config_prop_session_create_time";
    private static final String RENREN_SDK_CONFIG_PROP_SESSION_KEY = "renren_sdk_config_prop_session_key";
    private static final String RENREN_SDK_CONFIG_PROP_SESSION_SECRET = "renren_sdk_config_prop_session_secret";
    private static final String RENREN_SDK_CONFIG_PROP_USER_ID = "renren_sdk_config_prop_user_id";
    private String accessToken;
    private Context context;
    private long expireTime;
    private String sessionKey;
    private String sessionSecret;
    private long uid;

    AccessTokenManager(Context context) {
        this.accessToken = null;
        this.sessionSecret = null;
        this.expireTime = 0L;
        this.context = context;
        m505h();
    }

    public AccessTokenManager(Parcel parcel) {
        this.accessToken = null;
        this.sessionSecret = null;
        this.expireTime = 0L;
        Bundle bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
        if (bundle != null) {
            this.accessToken = bundle.getString(KEY_ACCESS_TOKEN);
            this.sessionKey = bundle.getString(KEY_SESSION_KEY);
            this.sessionSecret = bundle.getString(KEY_SESSION_SECRET);
            this.expireTime = bundle.getLong(KEY_SESSION_KEY_EXPIRE_TIME);
            this.uid = bundle.getLong(KEY_UID);
        }
        m505h();
    }

    /* renamed from: a */
    String m509a() {
        this.accessToken = m508k();
        return this.accessToken;
    }

    /* renamed from: b */
    String m511b() {
        if (this.sessionKey == null || this.sessionSecret == null) {
            m506i();
        }
        if (System.currentTimeMillis() > this.expireTime) {
            m507j();
        }
        return this.sessionKey;
    }

    /* renamed from: c */
    String m512c() {
        if (this.sessionKey == null || this.sessionSecret == null) {
            m506i();
        }
        if (System.currentTimeMillis() > this.expireTime) {
            m507j();
        }
        return this.sessionSecret;
    }

    /* renamed from: d */
    long m513d() {
        return this.uid;
    }

    /* renamed from: e */
    public boolean m514e() {
        if (this.sessionKey != null && this.sessionSecret != null && System.currentTimeMillis() < this.expireTime) {
            return true;
        }
        m506i();
        return (this.sessionKey == null || this.sessionSecret == null || System.currentTimeMillis() >= this.expireTime) ? false : true;
    }

    /* renamed from: a */
    void m510a(String str) {
        m499a(str, true);
    }

    /* renamed from: f */
    void m515f() {
        this.accessToken = m508k();
        if (this.accessToken != null) {
            m506i();
        }
        try {
            m506i();
            if (this.sessionKey == null || this.sessionSecret == null || this.expireTime < System.currentTimeMillis()) {
                m501b(this.accessToken);
            }
        } catch (Exception e) {
            e.printStackTrace();
            m516g();
        }
    }

    /* renamed from: h */
    private void m505h() {
        if (this.context != null) {
            SharedPreferences sharedPreferences = this.context.getSharedPreferences(RENREN_SDK_CONFIG, 0);
            sharedPreferences.registerOnSharedPreferenceChangeListener(new SharedPreferencesOnSharedPreferenceChangeListenerC0195a(this, sharedPreferences));
        }
    }

    /* renamed from: g */
    void m516g() {
        SharedPreferences.Editor editorEdit = this.context.getSharedPreferences(RENREN_SDK_CONFIG, 0).edit();
        editorEdit.remove(RENREN_SDK_CONFIG_PROP_ACCESS_TOKEN);
        editorEdit.remove(RENREN_SDK_CONFIG_PROP_CREATE_TIME);
        editorEdit.remove(RENREN_SDK_CONFIG_PROP_SESSION_KEY);
        editorEdit.remove(RENREN_SDK_CONFIG_PROP_SESSION_SECRET);
        editorEdit.remove(RENREN_SDK_CONFIG_PROP_EXPIRE_SECONDS);
        editorEdit.remove(RENREN_SDK_CONFIG_PROP_USER_ID);
        editorEdit.commit();
        this.accessToken = null;
        this.sessionKey = null;
        this.sessionSecret = null;
        this.expireTime = 0L;
        this.uid = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public synchronized void m506i() {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(RENREN_SDK_CONFIG, 0);
        this.sessionKey = sharedPreferences.getString(RENREN_SDK_CONFIG_PROP_SESSION_KEY, null);
        this.sessionSecret = sharedPreferences.getString(RENREN_SDK_CONFIG_PROP_SESSION_SECRET, null);
        this.uid = sharedPreferences.getLong(RENREN_SDK_CONFIG_PROP_USER_ID, 0L);
        long j = sharedPreferences.getLong(RENREN_SDK_CONFIG_PROP_EXPIRE_SECONDS, 0L);
        long j2 = sharedPreferences.getLong(RENREN_SDK_CONFIG_PROP_SESSION_CREATE_TIME, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.expireTime = j2 + j;
        if (this.expireTime < jCurrentTimeMillis) {
            m507j();
            this.sessionKey = null;
            this.sessionSecret = null;
            this.expireTime = 0L;
            this.uid = 0L;
        }
    }

    /* renamed from: a */
    private void m499a(String str, boolean z) {
        if (str != null && str.length() >= 1) {
            this.accessToken = str;
            try {
                m506i();
                if (this.sessionKey == null || this.sessionSecret == null || this.expireTime < System.currentTimeMillis()) {
                    m501b(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
                m516g();
            }
            if (z) {
                m503c(str);
            } else {
                m516g();
            }
        }
    }

    /* renamed from: b */
    private void m501b(String str) {
        if (str != null && str.length() >= 1) {
            Bundle bundle = new Bundle();
            bundle.putString("oauth_token", str);
            try {
                JSONObject jSONObject = new JSONObject(C0214g.m575b(C0817b.f3143o, "POST", bundle));
                if (jSONObject.optString("error", null) != null) {
                    throw new C0211e(jSONObject.toString());
                }
                this.sessionKey = jSONObject.getJSONObject("renren_token").getString("session_key");
                this.sessionSecret = jSONObject.getJSONObject("renren_token").getString("session_secret");
                this.uid = jSONObject.getJSONObject(PropertyConfiguration.USER).getLong("id");
                long j = jSONObject.getJSONObject("renren_token").getLong("expires_in") * 1000;
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.expireTime = jCurrentTimeMillis + j;
                m498a(this.sessionKey, this.sessionSecret, jCurrentTimeMillis, j, this.uid);
                Log.i("Renren-SDK", "---login success sessionKey:" + this.sessionKey + " expires:" + j + " sessionSecret:" + this.sessionSecret + " uid:" + this.uid);
            } catch (JSONException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    /* renamed from: c */
    private void m503c(String str) {
        SharedPreferences.Editor editorEdit = this.context.getSharedPreferences(RENREN_SDK_CONFIG, 0).edit();
        if (str != null) {
            editorEdit.putString(RENREN_SDK_CONFIG_PROP_ACCESS_TOKEN, str);
            editorEdit.putLong(RENREN_SDK_CONFIG_PROP_CREATE_TIME, System.currentTimeMillis());
        } else {
            m516g();
        }
        editorEdit.commit();
    }

    /* renamed from: a */
    private void m498a(String str, String str2, long j, long j2, long j3) {
        if (str == null || str2 == null) {
            m516g();
            return;
        }
        SharedPreferences.Editor editorEdit = this.context.getSharedPreferences(RENREN_SDK_CONFIG, 0).edit();
        editorEdit.putString(RENREN_SDK_CONFIG_PROP_SESSION_KEY, str);
        editorEdit.putString(RENREN_SDK_CONFIG_PROP_SESSION_SECRET, str2);
        editorEdit.putLong(RENREN_SDK_CONFIG_PROP_EXPIRE_SECONDS, j2);
        editorEdit.putLong(RENREN_SDK_CONFIG_PROP_SESSION_CREATE_TIME, j);
        editorEdit.putLong(RENREN_SDK_CONFIG_PROP_USER_ID, j3);
        editorEdit.commit();
    }

    /* renamed from: j */
    private void m507j() {
        SharedPreferences.Editor editorEdit = this.context.getSharedPreferences(RENREN_SDK_CONFIG, 0).edit();
        editorEdit.remove(RENREN_SDK_CONFIG_PROP_SESSION_KEY);
        editorEdit.remove(RENREN_SDK_CONFIG_PROP_SESSION_SECRET);
        editorEdit.remove(RENREN_SDK_CONFIG_PROP_EXPIRE_SECONDS);
        editorEdit.remove(RENREN_SDK_CONFIG_PROP_SESSION_CREATE_TIME);
        editorEdit.remove(RENREN_SDK_CONFIG_PROP_USER_ID);
        this.sessionKey = null;
        this.sessionSecret = null;
        this.expireTime = 0L;
        this.uid = 0L;
        editorEdit.commit();
    }

    /* renamed from: k */
    private String m508k() {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(RENREN_SDK_CONFIG, 0);
        String string = sharedPreferences.getString(RENREN_SDK_CONFIG_PROP_ACCESS_TOKEN, null);
        if (string == null) {
            return null;
        }
        if (sharedPreferences.getLong(RENREN_SDK_CONFIG_PROP_CREATE_TIME, 0L) + (Long.parseLong(string.split("\\.")[2]) * 1000) >= System.currentTimeMillis() - ONE_HOUR) {
            return string;
        }
        m516g();
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        if (this.accessToken != null) {
            bundle.putString(KEY_ACCESS_TOKEN, this.accessToken);
        }
        if (this.sessionKey != null) {
            bundle.putString(KEY_SESSION_KEY, this.sessionKey);
        }
        if (this.sessionSecret != null) {
            bundle.putString(KEY_SESSION_SECRET, this.sessionSecret);
        }
        if (this.expireTime != 0) {
            bundle.putLong(KEY_SESSION_KEY_EXPIRE_TIME, this.expireTime);
        }
        if (this.uid != 0) {
            bundle.putLong(KEY_UID, this.uid);
        }
        bundle.writeToParcel(parcel, i);
    }
}
