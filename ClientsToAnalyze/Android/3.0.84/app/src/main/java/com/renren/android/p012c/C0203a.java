package com.renren.android.p012c;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
import weibo4android.org.json.HTTP;

/* compiled from: UserInfo.java */
/* renamed from: com.renren.android.c.a */
/* loaded from: classes.dex */
public class C0203a {

    /* renamed from: a */
    private long f415a;

    /* renamed from: b */
    private String f416b;

    /* renamed from: c */
    private int f417c;

    /* renamed from: d */
    private int f418d;

    /* renamed from: e */
    private int f419e;

    /* renamed from: f */
    private int f420f;

    /* renamed from: g */
    private String f421g;

    /* renamed from: h */
    private String f422h;

    /* renamed from: i */
    private String f423i;

    /* renamed from: j */
    private String f424j;

    /* renamed from: k */
    private String f425k;

    /* renamed from: l */
    private ArrayList<C0205c> f426l;

    /* renamed from: m */
    private ArrayList<C0207e> f427m;

    /* renamed from: n */
    private ArrayList<C0206d> f428n;

    /* renamed from: o */
    private ArrayList<C0204b> f429o;

    /* renamed from: a */
    public C0203a m543a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.f415a = jSONObject.optLong("uid");
        this.f416b = jSONObject.optString("name");
        this.f417c = jSONObject.optInt("sex");
        this.f418d = jSONObject.optInt("star");
        this.f419e = jSONObject.optInt("zidou");
        this.f420f = jSONObject.optInt("vip");
        this.f421g = jSONObject.optString("birthday");
        this.f422h = jSONObject.optString("email_hash");
        this.f423i = jSONObject.optString("tinyurl");
        this.f424j = jSONObject.optString("headurl");
        this.f425k = jSONObject.optString("mainurl");
        this.f426l = C0205c.m549a(jSONObject.optJSONArray("hometown_location"));
        this.f427m = C0207e.m553a(jSONObject.optJSONArray("work_history"));
        this.f428n = C0206d.m551a(jSONObject.optJSONArray("university_history"));
        this.f429o = C0204b.m547a(jSONObject.optJSONArray("hs_history"));
        return this;
    }

    /* renamed from: a */
    public long m542a() {
        return this.f415a;
    }

    /* renamed from: b */
    public String m544b() {
        return this.f416b;
    }

    /* renamed from: c */
    public String m545c() {
        return this.f424j;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("uid").append(" = ").append(this.f415a).append(HTTP.CRLF);
        stringBuffer.append("name").append(" = ").append(this.f416b).append(HTTP.CRLF);
        stringBuffer.append("sex").append(" = ").append(this.f417c).append(HTTP.CRLF);
        stringBuffer.append("star").append(" = ").append(this.f418d).append(HTTP.CRLF);
        stringBuffer.append("zidou").append(" = ").append(this.f419e).append(HTTP.CRLF);
        stringBuffer.append("vip").append(" = ").append(this.f420f).append(HTTP.CRLF);
        stringBuffer.append("birthday").append(" = ").append(this.f421g).append(HTTP.CRLF);
        stringBuffer.append("email_hash").append(" = ").append(this.f422h).append(HTTP.CRLF);
        stringBuffer.append("tinyurl").append(" = ").append(this.f423i).append(HTTP.CRLF);
        stringBuffer.append("headurl").append(" = ").append(this.f424j).append(HTTP.CRLF);
        stringBuffer.append("mainurl").append(" = ").append(this.f425k).append(HTTP.CRLF);
        if (this.f426l != null) {
            stringBuffer.append("hometown_location").append(" = ").append(HTTP.CRLF);
            Iterator<C0205c> it = this.f426l.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next().toString()).append(HTTP.CRLF);
            }
        }
        if (this.f427m != null) {
            stringBuffer.append("work_history").append(" = ").append(HTTP.CRLF);
            Iterator<C0207e> it2 = this.f427m.iterator();
            while (it2.hasNext()) {
                stringBuffer.append(it2.next().toString()).append(HTTP.CRLF);
            }
        }
        if (this.f428n != null) {
            stringBuffer.append("university_history").append(" = ").append(HTTP.CRLF);
            Iterator<C0206d> it3 = this.f428n.iterator();
            while (it3.hasNext()) {
                stringBuffer.append(it3.next().toString()).append(HTTP.CRLF);
            }
        }
        if (this.f429o != null) {
            stringBuffer.append("hs_history").append(" = ").append(HTTP.CRLF);
            Iterator<C0204b> it4 = this.f429o.iterator();
            while (it4.hasNext()) {
                stringBuffer.append(it4.next().toString()).append(HTTP.CRLF);
            }
        }
        return stringBuffer.toString();
    }
}
