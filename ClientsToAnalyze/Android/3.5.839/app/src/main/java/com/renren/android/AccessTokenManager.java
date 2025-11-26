package com.renren.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.p137vk.sdk.VKAccessToken;
import com.sec.chaton.p051c.C1428b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class AccessTokenManager implements Parcelable {
    public static final Parcelable.Creator<AccessTokenManager> CREATOR = new C0710b();
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
        m2237h();
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
        m2237h();
    }

    /* renamed from: a */
    String m2241a() {
        this.accessToken = m2240k();
        return this.accessToken;
    }

    /* renamed from: b */
    String m2243b() {
        if (this.sessionKey == null || this.sessionSecret == null) {
            m2238i();
        }
        if (System.currentTimeMillis() > this.expireTime) {
            m2239j();
        }
        return this.sessionKey;
    }

    /* renamed from: c */
    String m2244c() {
        if (this.sessionKey == null || this.sessionSecret == null) {
            m2238i();
        }
        if (System.currentTimeMillis() > this.expireTime) {
            m2239j();
        }
        return this.sessionSecret;
    }

    /* renamed from: d */
    long m2245d() {
        return this.uid;
    }

    /* renamed from: e */
    public boolean m2246e() {
        if (this.sessionKey == null || this.sessionSecret == null || System.currentTimeMillis() >= this.expireTime) {
            return (this.sessionKey == null || this.sessionSecret == null || System.currentTimeMillis() >= this.expireTime) ? false : true;
        }
        return true;
    }

    /* renamed from: a */
    void m2242a(String str) {
        m2231a(str, true);
    }

    /* renamed from: f */
    void m2247f() {
        this.accessToken = m2240k();
        if (this.accessToken != null) {
            m2238i();
        }
        try {
            m2238i();
            if (this.sessionKey == null || this.sessionSecret == null || this.expireTime < System.currentTimeMillis()) {
                m2233b(this.accessToken);
            }
        } catch (Exception e) {
            e.printStackTrace();
            m2248g();
        }
    }

    /* renamed from: h */
    private void m2237h() {
        if (this.context != null) {
            SharedPreferences sharedPreferences = this.context.getSharedPreferences(RENREN_SDK_CONFIG, 0);
            sharedPreferences.registerOnSharedPreferenceChangeListener(new SharedPreferencesOnSharedPreferenceChangeListenerC0707a(this, sharedPreferences));
        }
    }

    /* renamed from: g */
    void m2248g() {
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
    public synchronized void m2238i() {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(RENREN_SDK_CONFIG, 0);
        this.sessionKey = sharedPreferences.getString(RENREN_SDK_CONFIG_PROP_SESSION_KEY, null);
        this.sessionSecret = sharedPreferences.getString(RENREN_SDK_CONFIG_PROP_SESSION_SECRET, null);
        this.uid = sharedPreferences.getLong(RENREN_SDK_CONFIG_PROP_USER_ID, 0L);
        long j = sharedPreferences.getLong(RENREN_SDK_CONFIG_PROP_EXPIRE_SECONDS, 0L);
        long j2 = sharedPreferences.getLong(RENREN_SDK_CONFIG_PROP_SESSION_CREATE_TIME, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.expireTime = j2 + j;
        if (this.expireTime < jCurrentTimeMillis) {
            m2239j();
            this.sessionKey = null;
            this.sessionSecret = null;
            this.expireTime = 0L;
            this.uid = 0L;
        }
    }

    /* renamed from: a */
    private void m2231a(String str, boolean z) {
        if (str != null && str.length() >= 1) {
            this.accessToken = str;
            try {
                m2238i();
                if (this.sessionKey == null || this.sessionSecret == null || this.expireTime < System.currentTimeMillis()) {
                    m2233b(str);
                }
            } catch (Exception e) {
                e.printStackTrace();
                m2248g();
            }
            if (z) {
                m2235c(str);
            } else {
                m2248g();
            }
        }
    }

    /* renamed from: b */
    private void m2233b(String str) {
        if (str != null && str.length() >= 1) {
            Bundle bundle = new Bundle();
            bundle.putString("oauth_token", str);
            try {
                JSONObject jSONObject = new JSONObject(C0726g.m2307b(C1428b.f5115u, "POST", bundle));
                if (jSONObject.optString("error", null) != null) {
                    throw new C0723e(jSONObject.toString());
                }
                this.sessionKey = jSONObject.getJSONObject("renren_token").getString("session_key");
                this.sessionSecret = jSONObject.getJSONObject("renren_token").getString("session_secret");
                this.uid = jSONObject.getJSONObject("user").getLong("id");
                long j = jSONObject.getJSONObject("renren_token").getLong(VKAccessToken.EXPIRES_IN) * 1000;
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.expireTime = jCurrentTimeMillis + j;
                m2230a(this.sessionKey, this.sessionSecret, jCurrentTimeMillis, j, this.uid);
                Log.i("Renren-SDK", "---login success sessionKey:" + this.sessionKey + " expires:" + j + " sessionSecret:" + this.sessionSecret + " uid:" + this.uid);
            } catch (JSONException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }
    }

    /* renamed from: c */
    private void m2235c(String str) {
        SharedPreferences.Editor editorEdit = this.context.getSharedPreferences(RENREN_SDK_CONFIG, 0).edit();
        if (str != null) {
            editorEdit.putString(RENREN_SDK_CONFIG_PROP_ACCESS_TOKEN, str);
            editorEdit.putLong(RENREN_SDK_CONFIG_PROP_CREATE_TIME, System.currentTimeMillis());
        } else {
            m2248g();
        }
        editorEdit.commit();
    }

    /* renamed from: a */
    private void m2230a(String str, String str2, long j, long j2, long j3) {
        if (str == null || str2 == null) {
            m2248g();
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
    private void m2239j() {
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
    private String m2240k() {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(RENREN_SDK_CONFIG, 0);
        String string = sharedPreferences.getString(RENREN_SDK_CONFIG_PROP_ACCESS_TOKEN, null);
        if (string == null) {
            return null;
        }
        if (sharedPreferences.getLong(RENREN_SDK_CONFIG_PROP_CREATE_TIME, 0L) + (Long.parseLong(string.split("\\.")[2]) * 1000) >= System.currentTimeMillis() - ONE_HOUR) {
            return string;
        }
        m2248g();
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
