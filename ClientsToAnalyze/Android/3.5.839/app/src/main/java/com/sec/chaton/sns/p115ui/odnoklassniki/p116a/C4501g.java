package com.sec.chaton.sns.p115ui.odnoklassniki.p116a;

import com.p137vk.sdk.VKOpenAuthActivity;
import java.io.IOException;
import java.util.HashMap;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Util.java */
/* renamed from: com.sec.chaton.sns.ui.odnoklassniki.a.g */
/* loaded from: classes.dex */
public class C4501g {
    /* renamed from: a */
    public static final String[] m17046a(String str, boolean z) {
        String[] strArr = null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            strArr = new String[2];
            strArr[0] = jSONObject.getString("access_token");
            if (!z) {
                strArr[1] = jSONObject.getString("refresh_token");
            }
        } catch (JSONException e) {
        }
        return strArr;
    }

    /* renamed from: a */
    public static final String m17045a(String str) {
        HashMap map = new HashMap(5);
        map.put("code", str);
        map.put("redirect_uri", "okauth://ok223397120");
        map.put("grant_type", "authorization_code");
        map.put(VKOpenAuthActivity.VK_EXTRA_CLIENT_ID, "223397120");
        map.put("client_secret", "29341535E6AFF6362750637B");
        try {
            return C4499e.m17038a(new DefaultHttpClient(), "http://api.odnoklassniki.ru/oauth/token.do", map);
        } catch (IOException e) {
            return null;
        }
    }
}
