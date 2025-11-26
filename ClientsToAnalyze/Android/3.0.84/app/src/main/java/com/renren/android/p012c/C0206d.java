package com.renren.android.p012c;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import weibo4android.org.json.HTTP;

/* compiled from: UserInfo.java */
/* renamed from: com.renren.android.c.d */
/* loaded from: classes.dex */
public class C0206d {

    /* renamed from: a */
    private String f435a;

    /* renamed from: b */
    private long f436b;

    /* renamed from: c */
    private String f437c;

    /* renamed from: a */
    public static ArrayList<C0206d> m551a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<C0206d> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            C0206d c0206dM550a = m550a(jSONArray.optJSONObject(i));
            if (c0206dM550a != null) {
                arrayList.add(c0206dM550a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static C0206d m550a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C0206d c0206d = new C0206d();
        c0206d.f435a = jSONObject.optString("name");
        c0206d.f436b = jSONObject.optLong("year");
        c0206d.f437c = jSONObject.optString("department");
        return c0206d;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\t").append("name").append(" = ").append(this.f435a).append(HTTP.CRLF);
        stringBuffer.append("\t").append("year").append(" = ").append(this.f436b).append(HTTP.CRLF);
        stringBuffer.append("\t").append("department").append(" = ").append(this.f437c).append(HTTP.CRLF);
        return stringBuffer.toString();
    }
}
