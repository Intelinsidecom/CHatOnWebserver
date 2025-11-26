package com.renren.android.p042c;

import com.p137vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: UserInfo.java */
/* renamed from: com.renren.android.c.c */
/* loaded from: classes.dex */
public class C0717c {

    /* renamed from: a */
    private String f1668a;

    /* renamed from: b */
    private String f1669b;

    /* renamed from: c */
    private String f1670c;

    /* renamed from: a */
    public static ArrayList<C0717c> m2281a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<C0717c> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            C0717c c0717cM2280a = m2280a(jSONArray.optJSONObject(i));
            if (c0717cM2280a != null) {
                arrayList.add(c0717cM2280a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static C0717c m2280a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        C0717c c0717c = new C0717c();
        c0717c.f1668a = jSONObject.optString(VKApiConst.COUNTRY);
        c0717c.f1669b = jSONObject.optString("province");
        c0717c.f1670c = jSONObject.optString(VKApiConst.CITY);
        return c0717c;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\t").append(VKApiConst.COUNTRY).append(" = ").append(this.f1668a).append("\r\n");
        stringBuffer.append("\t").append("province").append(" = ").append(this.f1669b).append("\r\n");
        stringBuffer.append("\t").append(VKApiConst.CITY).append(" = ").append(this.f1670c).append("\r\n");
        return stringBuffer.toString();
    }
}
