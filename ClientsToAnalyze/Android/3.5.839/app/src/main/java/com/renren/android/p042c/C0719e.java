package com.renren.android.p042c;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: UserInfo.java */
/* renamed from: com.renren.android.c.e */
/* loaded from: classes.dex */
public class C0719e {

    /* renamed from: a */
    private String f1674a;

    /* renamed from: b */
    private String f1675b;

    /* renamed from: c */
    private String f1676c;

    /* renamed from: d */
    private String f1677d;

    /* renamed from: a */
    public static ArrayList<C0719e> m2285a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<C0719e> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            C0719e c0719eM2284a = m2284a(jSONArray.optJSONObject(i));
            if (c0719eM2284a != null) {
                arrayList.add(c0719eM2284a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static C0719e m2284a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C0719e c0719e = new C0719e();
        c0719e.f1674a = jSONObject.optString("company_name");
        c0719e.f1675b = jSONObject.optString("description");
        c0719e.f1676c = jSONObject.optString("start_date");
        c0719e.f1677d = jSONObject.optString("end_date");
        return c0719e;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\t").append("company_name").append(" = ").append(this.f1674a).append("\r\n");
        stringBuffer.append("\t").append("description").append(" = ").append(this.f1675b).append("\r\n");
        stringBuffer.append("\t").append("start_date").append(" = ").append(this.f1676c).append("\r\n");
        stringBuffer.append("\t").append("end_date").append(" = ").append(this.f1677d).append("\r\n");
        return stringBuffer.toString();
    }
}
