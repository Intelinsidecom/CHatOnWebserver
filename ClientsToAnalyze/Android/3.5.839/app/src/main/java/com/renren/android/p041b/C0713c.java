package com.renren.android.p041b;

import com.renren.android.p040a.AbstractC0709b;
import org.json.JSONObject;

/* compiled from: FriendsGetFriendsResponseBean.java */
/* renamed from: com.renren.android.b.c */
/* loaded from: classes.dex */
public class C0713c extends AbstractC0709b {

    /* renamed from: a */
    final /* synthetic */ C0712b f1643a;

    /* renamed from: b */
    private long f1644b;

    /* renamed from: c */
    private String f1645c;

    /* renamed from: d */
    private String f1646d;

    /* renamed from: e */
    private String f1647e;

    /* renamed from: f */
    private String f1648f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0713c(C0712b c0712b, JSONObject jSONObject) {
        super(null);
        this.f1643a = c0712b;
        if (jSONObject != null) {
            this.f1644b = jSONObject.optLong("id");
            this.f1645c = jSONObject.optString("name");
            this.f1646d = jSONObject.optString("headurl");
            this.f1647e = jSONObject.optString("headurl_with_logo");
            this.f1648f = jSONObject.optString("tinyurl_with_logo");
        }
    }

    /* renamed from: a */
    public long m2268a() {
        return this.f1644b;
    }

    /* renamed from: b */
    public String m2269b() {
        return this.f1645c;
    }

    /* renamed from: c */
    public String m2270c() {
        return this.f1648f;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("id").append(" = ").append(this.f1644b).append("\r\n");
        stringBuffer.append("name").append(" = ").append(this.f1645c).append("\r\n");
        stringBuffer.append("headurl").append(" = ").append(this.f1646d).append("\r\n");
        stringBuffer.append("headurl_with_logo").append(" = ").append(this.f1647e).append("\r\n");
        stringBuffer.append("tinyurl_with_logo").append(" = ").append(this.f1648f).append("\r\n");
        return stringBuffer.toString();
    }
}
