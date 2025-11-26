package com.renren.android.p042c;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: UserInfo.java */
/* renamed from: com.renren.android.c.b */
/* loaded from: classes.dex */
public class C0716b {

    /* renamed from: a */
    private String f1666a;

    /* renamed from: b */
    private long f1667b;

    /* renamed from: a */
    public static ArrayList<C0716b> m2279a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<C0716b> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            C0716b c0716bM2278a = m2278a(jSONArray.optJSONObject(i));
            if (c0716bM2278a != null) {
                arrayList.add(c0716bM2278a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static C0716b m2278a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C0716b c0716b = new C0716b();
        c0716b.f1666a = jSONObject.optString("name");
        c0716b.f1667b = jSONObject.optLong("grad_year");
        return c0716b;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\t").append("name").append(" = ").append(this.f1666a).append("\r\n");
        stringBuffer.append("\t").append("grad_year").append(" = ").append(this.f1667b).append("\r\n");
        return stringBuffer.toString();
    }
}
