package com.p137vk.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.p137vk.sdk.api.VKParameters;
import com.p137vk.sdk.util.VKStringJoiner;
import com.p137vk.sdk.util.VKUtil;
import com.sec.chaton.privateplugin.data.Spam;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public class VKAccessToken {
    public static final String ACCESS_TOKEN = "access_token";
    public static final String CREATED = "created";
    public static final String EXPIRES_IN = "expires_in";
    public static final String HTTPS_REQUIRED = "https_required";
    public static final String SECRET = "secret";
    public static final String SHARED_PREF_NAME = "CHATON_VKONTAKTE_ACCESS_PREF";
    public static final String TOKEN_KEY = "CHATON_VKONTAKTE_SESSION";
    public static final String USER_ID = "user_id";
    public String accessToken = null;
    public int expiresIn = 0;
    public String userId = null;
    public String secret = null;
    public boolean httpsRequired = false;
    public long created = 0;

    public void saveTokenToFile(String str) throws IOException {
        VKUtil.stringToFile(str, serialize());
    }

    public void saveTokenToSharedPreferences(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(SHARED_PREF_NAME, 0).edit();
        editorEdit.putString(TOKEN_KEY, serialize());
        editorEdit.commit();
    }

    private VKAccessToken() {
    }

    protected String serialize() {
        VKParameters vKParameters = new VKParameters();
        vKParameters.put("access_token", this.accessToken);
        vKParameters.put(EXPIRES_IN, Integer.valueOf(this.expiresIn));
        vKParameters.put("user_id", this.userId);
        vKParameters.put(CREATED, Long.valueOf(this.created));
        if (this.secret != null) {
            vKParameters.put(SECRET, this.secret);
        }
        if (this.httpsRequired) {
            vKParameters.put(HTTPS_REQUIRED, Spam.ACTIVITY_REPORT);
        }
        return VKStringJoiner.joinParams(vKParameters);
    }

    public static VKAccessToken tokenFromUrlString(String str) {
        if (str == null) {
            return null;
        }
        return tokenFromParameters(VKUtil.explodeQueryString(str));
    }

    public static VKAccessToken tokenFromParameters(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        VKAccessToken vKAccessToken = new VKAccessToken();
        try {
            vKAccessToken.accessToken = map.get("access_token");
            vKAccessToken.expiresIn = Integer.parseInt(map.get(EXPIRES_IN));
            if (vKAccessToken.expiresIn == 0) {
                vKAccessToken.expiresIn = 86400;
            }
            vKAccessToken.userId = map.get("user_id");
            vKAccessToken.secret = map.get(SECRET);
            vKAccessToken.httpsRequired = false;
            if (map.containsKey(HTTPS_REQUIRED)) {
                vKAccessToken.httpsRequired = map.get(HTTPS_REQUIRED).equals(Spam.ACTIVITY_REPORT);
            }
            if (map.containsKey(CREATED)) {
                vKAccessToken.created = Long.parseLong(map.get(CREATED));
            } else {
                vKAccessToken.created = System.currentTimeMillis();
            }
            return vKAccessToken;
        } catch (Exception e) {
            return null;
        }
    }

    public static VKAccessToken tokenFromSharedPreferences(Context context) {
        return tokenFromUrlString(context.getSharedPreferences(SHARED_PREF_NAME, 0).getString(TOKEN_KEY, null));
    }

    public static VKAccessToken tokenFromFile(String str) {
        try {
            return tokenFromUrlString(VKUtil.fileToString(str));
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isExpired() {
        return this.expiresIn > 0 && ((long) (this.expiresIn * 1000)) + this.created < System.currentTimeMillis();
    }
}
