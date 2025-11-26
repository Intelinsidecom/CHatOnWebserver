package com.facebook;

import com.facebook.p032b.C0476s;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.amsoma.AMSLibs;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FacebookRequestError.java */
/* renamed from: com.facebook.ab */
/* loaded from: classes.dex */
public final class C0432ab {

    /* renamed from: a */
    private static final C0435ae f1035a = new C0435ae(200, 299);

    /* renamed from: b */
    private static final C0435ae f1036b = new C0435ae(200, 299);

    /* renamed from: c */
    private static final C0435ae f1037c = new C0435ae(AMSLibs.ENUM_VIP_AMS_SAVE_THUMBNAIL_IMAGE_SIZE, 499);

    /* renamed from: d */
    private static final C0435ae f1038d = new C0435ae(500, 599);

    /* renamed from: e */
    private final int f1039e;

    /* renamed from: f */
    private final boolean f1040f;

    /* renamed from: g */
    private final EnumC0434ad f1041g;

    /* renamed from: h */
    private final int f1042h;

    /* renamed from: i */
    private final int f1043i;

    /* renamed from: j */
    private final int f1044j;

    /* renamed from: k */
    private final String f1045k;

    /* renamed from: l */
    private final String f1046l;

    /* renamed from: m */
    private final JSONObject f1047m;

    /* renamed from: n */
    private final JSONObject f1048n;

    /* renamed from: o */
    private final Object f1049o;

    /* renamed from: p */
    private final HttpURLConnection f1050p;

    /* renamed from: q */
    private final C0551y f1051q;

    private C0432ab(int i, int i2, int i3, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, C0551y c0551y) {
        boolean z;
        boolean z2 = true;
        this.f1042h = i;
        this.f1043i = i2;
        this.f1044j = i3;
        this.f1045k = str;
        this.f1046l = str2;
        this.f1048n = jSONObject;
        this.f1047m = jSONObject2;
        this.f1049o = obj;
        this.f1050p = httpURLConnection;
        if (c0551y != null) {
            this.f1051q = c0551y;
            z = true;
        } else {
            this.f1051q = new C0436af(this, str2);
            z = false;
        }
        EnumC0434ad enumC0434ad = null;
        if (z) {
            enumC0434ad = EnumC0434ad.CLIENT;
            z2 = false;
        } else {
            if (i2 == 1 || i2 == 2) {
                enumC0434ad = EnumC0434ad.SERVER;
                z2 = false;
            } else if (i2 == 4 || i2 == 17) {
                enumC0434ad = EnumC0434ad.THROTTLING;
                z2 = false;
            } else if (i2 == 10 || f1035a.m1560a(i2)) {
                enumC0434ad = EnumC0434ad.PERMISSION;
                z2 = false;
            } else if (i2 != 102 && i2 != 190) {
                z2 = false;
            } else if (i3 == 459 || i3 == 464) {
                enumC0434ad = EnumC0434ad.AUTHENTICATION_RETRY;
            } else {
                enumC0434ad = EnumC0434ad.AUTHENTICATION_REOPEN_SESSION;
                if (i3 != 458 && i3 == 460) {
                }
                z2 = false;
            }
            if (enumC0434ad == null) {
                if (f1037c.m1560a(i)) {
                    enumC0434ad = EnumC0434ad.BAD_REQUEST;
                } else if (f1038d.m1560a(i)) {
                    enumC0434ad = EnumC0434ad.SERVER;
                } else {
                    enumC0434ad = EnumC0434ad.OTHER;
                }
            }
        }
        this.f1041g = enumC0434ad;
        this.f1039e = 0;
        this.f1040f = z2;
    }

    private C0432ab(int i, int i2, int i3, String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection) {
        this(i, i2, i3, str, str2, jSONObject, jSONObject2, obj, httpURLConnection, null);
    }

    C0432ab(HttpURLConnection httpURLConnection, Exception exc) {
        this(-1, -1, -1, null, null, null, null, null, httpURLConnection, exc instanceof C0551y ? (C0551y) exc : new C0551y(exc));
    }

    public C0432ab(int i, String str, String str2) {
        this(-1, i, -1, str, str2, null, null, null, null, null);
    }

    /* renamed from: a */
    public EnumC0434ad m1555a() {
        return this.f1041g;
    }

    /* renamed from: b */
    public int m1556b() {
        return this.f1042h;
    }

    /* renamed from: c */
    public int m1557c() {
        return this.f1043i;
    }

    /* renamed from: d */
    public String m1558d() {
        return this.f1045k;
    }

    /* renamed from: e */
    public String m1559e() {
        return this.f1046l != null ? this.f1046l : this.f1051q.getLocalizedMessage();
    }

    public String toString() {
        return "{HttpStatus: " + this.f1042h + ", errorCode: " + this.f1043i + ", errorType: " + this.f1045k + ", errorMessage: " + this.f1046l + "}";
    }

    /* renamed from: a */
    static C0432ab m1554a(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
        String strOptString;
        String strOptString2;
        int i;
        int iOptInt = -1;
        try {
            if (jSONObject.has("code")) {
                int i2 = jSONObject.getInt("code");
                Object objM1709a = C0476s.m1709a(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
                if (objM1709a != null && (objM1709a instanceof JSONObject)) {
                    JSONObject jSONObject2 = (JSONObject) objM1709a;
                    boolean z = false;
                    if (jSONObject2.has("error")) {
                        JSONObject jSONObject3 = (JSONObject) C0476s.m1709a(jSONObject2, "error", (String) null);
                        String strOptString3 = jSONObject3.optString("type", null);
                        strOptString2 = jSONObject3.optString(VKApiConst.MESSAGE, null);
                        int iOptInt2 = jSONObject3.optInt("code", -1);
                        iOptInt = jSONObject3.optInt("error_subcode", -1);
                        z = true;
                        i = iOptInt2;
                        strOptString = strOptString3;
                    } else if (jSONObject2.has(VKApiConst.ERROR_CODE) || jSONObject2.has(VKApiConst.ERROR_MSG) || jSONObject2.has("error_reason")) {
                        strOptString = jSONObject2.optString("error_reason", null);
                        strOptString2 = jSONObject2.optString(VKApiConst.ERROR_MSG, null);
                        int iOptInt3 = jSONObject2.optInt(VKApiConst.ERROR_CODE, -1);
                        iOptInt = jSONObject2.optInt("error_subcode", -1);
                        i = iOptInt3;
                        z = true;
                    } else {
                        i = -1;
                        strOptString2 = null;
                        strOptString = null;
                    }
                    if (z) {
                        return new C0432ab(i2, i, iOptInt, strOptString, strOptString2, jSONObject2, jSONObject, obj, httpURLConnection);
                    }
                }
                if (!f1036b.m1560a(i2)) {
                    return new C0432ab(i2, -1, -1, null, null, jSONObject.has("body") ? (JSONObject) C0476s.m1709a(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT") : null, jSONObject, obj, httpURLConnection);
                }
            }
        } catch (JSONException e) {
        }
        return null;
    }
}
