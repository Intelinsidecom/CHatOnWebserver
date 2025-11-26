package com.renren.android.p012c;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import weibo4android.org.json.HTTP;

/* compiled from: UserInfo.java */
/* renamed from: com.renren.android.c.e */
/* loaded from: classes.dex */
public class C0207e {

    /* renamed from: a */
    private String f438a;

    /* renamed from: b */
    private String f439b;

    /* renamed from: c */
    private String f440c;

    /* renamed from: d */
    private String f441d;

    /* renamed from: a */
    public static ArrayList<C0207e> m553a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<C0207e> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            C0207e c0207eM552a = m552a(jSONArray.optJSONObject(i));
            if (c0207eM552a != null) {
                arrayList.add(c0207eM552a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static C0207e m552a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C0207e c0207e = new C0207e();
        c0207e.f438a = jSONObject.optString("company_name");
        c0207e.f439b = jSONObject.optString("description");
        c0207e.f440c = jSONObject.optString("start_date");
        c0207e.f441d = jSONObject.optString("end_date");
        return c0207e;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\t").append("company_name").append(" = ").append(this.f438a).append(HTTP.CRLF);
        stringBuffer.append("\t").append("description").append(" = ").append(this.f439b).append(HTTP.CRLF);
        stringBuffer.append("\t").append("start_date").append(" = ").append(this.f440c).append(HTTP.CRLF);
        stringBuffer.append("\t").append("end_date").append(" = ").append(this.f441d).append(HTTP.CRLF);
        return stringBuffer.toString();
    }
}
