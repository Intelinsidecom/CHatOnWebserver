package com.renren.android.p012c;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import twitter4j.GeoQuery;
import weibo4android.org.json.HTTP;

/* compiled from: UserInfo.java */
/* renamed from: com.renren.android.c.c */
/* loaded from: classes.dex */
public class C0205c {

    /* renamed from: a */
    private String f432a;

    /* renamed from: b */
    private String f433b;

    /* renamed from: c */
    private String f434c;

    /* renamed from: a */
    public static ArrayList<C0205c> m549a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<C0205c> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            C0205c c0205cM548a = m548a(jSONArray.optJSONObject(i));
            if (c0205cM548a != null) {
                arrayList.add(c0205cM548a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static C0205c m548a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C0205c c0205c = new C0205c();
        c0205c.f432a = jSONObject.optString("country");
        c0205c.f433b = jSONObject.optString("province");
        c0205c.f434c = jSONObject.optString(GeoQuery.CITY);
        return c0205c;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\t").append("country").append(" = ").append(this.f432a).append(HTTP.CRLF);
        stringBuffer.append("\t").append("province").append(" = ").append(this.f433b).append(HTTP.CRLF);
        stringBuffer.append("\t").append(GeoQuery.CITY).append(" = ").append(this.f434c).append(HTTP.CRLF);
        return stringBuffer.toString();
    }
}
