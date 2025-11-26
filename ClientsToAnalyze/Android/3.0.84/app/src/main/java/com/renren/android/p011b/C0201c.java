package com.renren.android.p011b;

import com.renren.android.p010a.AbstractC0197b;
import org.json.JSONObject;
import weibo4android.org.json.HTTP;

/* compiled from: FriendsGetFriendsResponseBean.java */
/* renamed from: com.renren.android.b.c */
/* loaded from: classes.dex */
public class C0201c extends AbstractC0197b {

    /* renamed from: a */
    final /* synthetic */ C0200b f407a;

    /* renamed from: b */
    private long f408b;

    /* renamed from: c */
    private String f409c;

    /* renamed from: d */
    private String f410d;

    /* renamed from: e */
    private String f411e;

    /* renamed from: f */
    private String f412f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0201c(C0200b c0200b, JSONObject jSONObject) {
        super(null);
        this.f407a = c0200b;
        if (jSONObject != null) {
            this.f408b = jSONObject.optLong("id");
            this.f409c = jSONObject.optString("name");
            this.f410d = jSONObject.optString("headurl");
            this.f411e = jSONObject.optString("headurl_with_logo");
            this.f412f = jSONObject.optString("tinyurl_with_logo");
        }
    }

    /* renamed from: a */
    public long m536a() {
        return this.f408b;
    }

    /* renamed from: b */
    public String m537b() {
        return this.f409c;
    }

    /* renamed from: c */
    public String m538c() {
        return this.f412f;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("id").append(" = ").append(this.f408b).append(HTTP.CRLF);
        stringBuffer.append("name").append(" = ").append(this.f409c).append(HTTP.CRLF);
        stringBuffer.append("headurl").append(" = ").append(this.f410d).append(HTTP.CRLF);
        stringBuffer.append("headurl_with_logo").append(" = ").append(this.f411e).append(HTTP.CRLF);
        stringBuffer.append("tinyurl_with_logo").append(" = ").append(this.f412f).append(HTTP.CRLF);
        return stringBuffer.toString();
    }
}
