package com.renren.android.p012c;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import weibo4android.org.json.HTTP;

/* compiled from: UserInfo.java */
/* renamed from: com.renren.android.c.b */
/* loaded from: classes.dex */
public class C0204b {

    /* renamed from: a */
    private String f430a;

    /* renamed from: b */
    private long f431b;

    /* renamed from: a */
    public static ArrayList<C0204b> m547a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<C0204b> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            C0204b c0204bM546a = m546a(jSONArray.optJSONObject(i));
            if (c0204bM546a != null) {
                arrayList.add(c0204bM546a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static C0204b m546a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C0204b c0204b = new C0204b();
        c0204b.f430a = jSONObject.optString("name");
        c0204b.f431b = jSONObject.optLong("grad_year");
        return c0204b;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\t").append("name").append(" = ").append(this.f430a).append(HTTP.CRLF);
        stringBuffer.append("\t").append("grad_year").append(" = ").append(this.f431b).append(HTTP.CRLF);
        return stringBuffer.toString();
    }
}
