package com.renren.android.p042c;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: UserInfo.java */
/* renamed from: com.renren.android.c.d */
/* loaded from: classes.dex */
public class C0718d {

    /* renamed from: a */
    private String f1671a;

    /* renamed from: b */
    private long f1672b;

    /* renamed from: c */
    private String f1673c;

    /* renamed from: a */
    public static ArrayList<C0718d> m2283a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<C0718d> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            C0718d c0718dM2282a = m2282a(jSONArray.optJSONObject(i));
            if (c0718dM2282a != null) {
                arrayList.add(c0718dM2282a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static C0718d m2282a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C0718d c0718d = new C0718d();
        c0718d.f1671a = jSONObject.optString("name");
        c0718d.f1672b = jSONObject.optLong("year");
        c0718d.f1673c = jSONObject.optString("department");
        return c0718d;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\t").append("name").append(" = ").append(this.f1671a).append("\r\n");
        stringBuffer.append("\t").append("year").append(" = ").append(this.f1672b).append("\r\n");
        stringBuffer.append("\t").append("department").append(" = ").append(this.f1673c).append("\r\n");
        return stringBuffer.toString();
    }
}
