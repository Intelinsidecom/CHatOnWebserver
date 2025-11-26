package com.renren.android.p042c;

import com.p137vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: UserInfo.java */
/* renamed from: com.renren.android.c.a */
/* loaded from: classes.dex */
public class C0715a {

    /* renamed from: a */
    private long f1651a;

    /* renamed from: b */
    private String f1652b;

    /* renamed from: c */
    private int f1653c;

    /* renamed from: d */
    private int f1654d;

    /* renamed from: e */
    private int f1655e;

    /* renamed from: f */
    private int f1656f;

    /* renamed from: g */
    private String f1657g;

    /* renamed from: h */
    private String f1658h;

    /* renamed from: i */
    private String f1659i;

    /* renamed from: j */
    private String f1660j;

    /* renamed from: k */
    private String f1661k;

    /* renamed from: l */
    private ArrayList<C0717c> f1662l;

    /* renamed from: m */
    private ArrayList<C0719e> f1663m;

    /* renamed from: n */
    private ArrayList<C0718d> f1664n;

    /* renamed from: o */
    private ArrayList<C0716b> f1665o;

    /* renamed from: a */
    public C0715a m2275a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        this.f1651a = jSONObject.optLong("uid");
        this.f1652b = jSONObject.optString("name");
        this.f1653c = jSONObject.optInt(VKApiConst.SEX);
        this.f1654d = jSONObject.optInt("star");
        this.f1655e = jSONObject.optInt("zidou");
        this.f1656f = jSONObject.optInt("vip");
        this.f1657g = jSONObject.optString("birthday");
        this.f1658h = jSONObject.optString("email_hash");
        this.f1659i = jSONObject.optString("tinyurl");
        this.f1660j = jSONObject.optString("headurl");
        this.f1661k = jSONObject.optString("mainurl");
        this.f1662l = C0717c.m2281a(jSONObject.optJSONArray("hometown_location"));
        this.f1663m = C0719e.m2285a(jSONObject.optJSONArray("work_history"));
        this.f1664n = C0718d.m2283a(jSONObject.optJSONArray("university_history"));
        this.f1665o = C0716b.m2279a(jSONObject.optJSONArray("hs_history"));
        return this;
    }

    /* renamed from: a */
    public long m2274a() {
        return this.f1651a;
    }

    /* renamed from: b */
    public String m2276b() {
        return this.f1652b;
    }

    /* renamed from: c */
    public String m2277c() {
        return this.f1660j;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("uid").append(" = ").append(this.f1651a).append("\r\n");
        stringBuffer.append("name").append(" = ").append(this.f1652b).append("\r\n");
        stringBuffer.append(VKApiConst.SEX).append(" = ").append(this.f1653c).append("\r\n");
        stringBuffer.append("star").append(" = ").append(this.f1654d).append("\r\n");
        stringBuffer.append("zidou").append(" = ").append(this.f1655e).append("\r\n");
        stringBuffer.append("vip").append(" = ").append(this.f1656f).append("\r\n");
        stringBuffer.append("birthday").append(" = ").append(this.f1657g).append("\r\n");
        stringBuffer.append("email_hash").append(" = ").append(this.f1658h).append("\r\n");
        stringBuffer.append("tinyurl").append(" = ").append(this.f1659i).append("\r\n");
        stringBuffer.append("headurl").append(" = ").append(this.f1660j).append("\r\n");
        stringBuffer.append("mainurl").append(" = ").append(this.f1661k).append("\r\n");
        if (this.f1662l != null) {
            stringBuffer.append("hometown_location").append(" = ").append("\r\n");
            Iterator<C0717c> it = this.f1662l.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next().toString()).append("\r\n");
            }
        }
        if (this.f1663m != null) {
            stringBuffer.append("work_history").append(" = ").append("\r\n");
            Iterator<C0719e> it2 = this.f1663m.iterator();
            while (it2.hasNext()) {
                stringBuffer.append(it2.next().toString()).append("\r\n");
            }
        }
        if (this.f1664n != null) {
            stringBuffer.append("university_history").append(" = ").append("\r\n");
            Iterator<C0718d> it3 = this.f1664n.iterator();
            while (it3.hasNext()) {
                stringBuffer.append(it3.next().toString()).append("\r\n");
            }
        }
        if (this.f1665o != null) {
            stringBuffer.append("hs_history").append(" = ").append("\r\n");
            Iterator<C0716b> it4 = this.f1665o.iterator();
            while (it4.hasNext()) {
                stringBuffer.append(it4.next().toString()).append("\r\n");
            }
        }
        return stringBuffer.toString();
    }
}
