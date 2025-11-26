package com.facebook;

import com.facebook.p008b.C0105s;
import com.sec.chaton.settings2.PrefFragmentChats;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: FacebookRequestError.java */
/* renamed from: com.facebook.ab */
/* loaded from: classes.dex */
public final class C0061ab {

    /* renamed from: a */
    private static final C0064ae f66a = new C0064ae(HttpResponseCode.f13733OK, 299);

    /* renamed from: b */
    private static final C0064ae f67b = new C0064ae(HttpResponseCode.f13733OK, 299);

    /* renamed from: c */
    private static final C0064ae f68c = new C0064ae(400, 499);

    /* renamed from: d */
    private static final C0064ae f69d = new C0064ae(HttpResponseCode.INTERNAL_SERVER_ERROR, 599);

    /* renamed from: e */
    private final int f70e;

    /* renamed from: f */
    private final boolean f71f;

    /* renamed from: g */
    private final EnumC0063ad f72g;

    /* renamed from: h */
    private final int f73h;

    /* renamed from: i */
    private final int f74i;

    /* renamed from: j */
    private final int f75j;

    /* renamed from: k */
    private final String f76k;

    /* renamed from: l */
    private final String f77l;

    /* renamed from: m */
    private final JSONObject f78m;

    /* renamed from: n */
    private final JSONObject f79n;

    /* renamed from: o */
    private final Object f80o;

    /* renamed from: p */
    private final HttpURLConnection f81p;

    /* renamed from: q */
    private final C0180y f82q;

    private C0061ab(int i, int i2, int i3, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, C0180y c0180y) {
        boolean z;
        boolean z2 = true;
        this.f73h = i;
        this.f74i = i2;
        this.f75j = i3;
        this.f76k = str;
        this.f77l = str2;
        this.f79n = jSONObject;
        this.f78m = jSONObject2;
        this.f80o = obj;
        this.f81p = httpURLConnection;
        if (c0180y != null) {
            this.f82q = c0180y;
            z = true;
        } else {
            this.f82q = new C0065af(this, str2);
            z = false;
        }
        EnumC0063ad enumC0063ad = null;
        if (z) {
            enumC0063ad = EnumC0063ad.CLIENT;
            z2 = false;
        } else {
            if (i2 == 1 || i2 == 2) {
                enumC0063ad = EnumC0063ad.SERVER;
                z2 = false;
            } else if (i2 == 4 || i2 == 17) {
                enumC0063ad = EnumC0063ad.THROTTLING;
                z2 = false;
            } else if (i2 == 10 || f66a.m116a(i2)) {
                enumC0063ad = EnumC0063ad.PERMISSION;
                z2 = false;
            } else if (i2 != 102 && i2 != 190) {
                z2 = false;
            } else if (i3 == 459 || i3 == 464) {
                enumC0063ad = EnumC0063ad.AUTHENTICATION_RETRY;
            } else {
                enumC0063ad = EnumC0063ad.AUTHENTICATION_REOPEN_SESSION;
                if (i3 != 458 && i3 == 460) {
                }
                z2 = false;
            }
            if (enumC0063ad == null) {
                if (f68c.m116a(i)) {
                    enumC0063ad = EnumC0063ad.BAD_REQUEST;
                } else if (f69d.m116a(i)) {
                    enumC0063ad = EnumC0063ad.SERVER;
                } else {
                    enumC0063ad = EnumC0063ad.OTHER;
                }
            }
        }
        this.f72g = enumC0063ad;
        this.f70e = 0;
        this.f71f = z2;
    }

    private C0061ab(int i, int i2, int i3, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection) {
        this(i, i2, i3, str, str2, jSONObject, jSONObject2, obj, httpURLConnection, null);
    }

    C0061ab(HttpURLConnection httpURLConnection, Exception exc) {
        this(-1, -1, -1, null, null, null, null, null, httpURLConnection, exc instanceof C0180y ? (C0180y) exc : new C0180y(exc));
    }

    public C0061ab(int i, String str, String str2) {
        this(-1, i, -1, str, str2, null, null, null, null, null);
    }

    /* renamed from: a */
    public int m112a() {
        return this.f73h;
    }

    /* renamed from: b */
    public int m113b() {
        return this.f74i;
    }

    /* renamed from: c */
    public String m114c() {
        return this.f76k;
    }

    /* renamed from: d */
    public String m115d() {
        return this.f77l != null ? this.f77l : this.f82q.getLocalizedMessage();
    }

    public String toString() {
        return "{HttpStatus: " + this.f73h + ", errorCode: " + this.f74i + ", errorType: " + this.f76k + ", errorMessage: " + this.f77l + "}";
    }

    /* renamed from: a */
    static C0061ab m111a(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
        String strOptString;
        String strOptString2;
        int i;
        int iOptInt = -1;
        try {
            if (jSONObject.has("code")) {
                int i2 = jSONObject.getInt("code");
                Object objM265a = C0105s.m265a(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
                if (objM265a != null && (objM265a instanceof JSONObject)) {
                    JSONObject jSONObject2 = (JSONObject) objM265a;
                    boolean z = false;
                    if (jSONObject2.has("error")) {
                        JSONObject jSONObject3 = (JSONObject) C0105s.m265a(jSONObject2, "error", (String) null);
                        String strOptString3 = jSONObject3.optString(PrefFragmentChats.TYPE, null);
                        strOptString2 = jSONObject3.optString("message", null);
                        int iOptInt2 = jSONObject3.optInt("code", -1);
                        iOptInt = jSONObject3.optInt("error_subcode", -1);
                        z = true;
                        i = iOptInt2;
                        strOptString = strOptString3;
                    } else if (jSONObject2.has("error_code") || jSONObject2.has("error_msg") || jSONObject2.has("error_reason")) {
                        strOptString = jSONObject2.optString("error_reason", null);
                        strOptString2 = jSONObject2.optString("error_msg", null);
                        int iOptInt3 = jSONObject2.optInt("error_code", -1);
                        iOptInt = jSONObject2.optInt("error_subcode", -1);
                        i = iOptInt3;
                        z = true;
                    } else {
                        i = -1;
                        strOptString2 = null;
                        strOptString = null;
                    }
                    if (z) {
                        return new C0061ab(i2, i, iOptInt, strOptString, strOptString2, jSONObject2, jSONObject, obj, httpURLConnection);
                    }
                }
                if (!f67b.m116a(i2)) {
                    return new C0061ab(i2, -1, -1, null, null, jSONObject.has("body") ? (JSONObject) C0105s.m265a(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT") : null, jSONObject, obj, httpURLConnection);
                }
            }
        } catch (JSONException e) {
        }
        return null;
    }
}
