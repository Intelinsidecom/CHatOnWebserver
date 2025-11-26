package com.sec.chaton.p055d.p056a;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.p046a.p047a.C0792p;
import com.sec.chaton.p063i.p064a.C2404a;
import com.sec.chaton.p067j.C2454e;
import com.sec.chaton.p067j.EnumC2464o;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4815ag;
import com.sec.chaton.util.C4904y;
import java.util.LinkedHashMap;

/* compiled from: UploadProfileTask2.java */
/* renamed from: com.sec.chaton.d.a.fh */
/* loaded from: classes.dex */
public class C2043fh extends AbstractC1900a {

    /* renamed from: b */
    private C0792p f7477b;

    /* renamed from: c */
    private String f7478c;

    /* renamed from: d */
    private String f7479d;

    public C2043fh(C2454e c2454e, C0792p c0792p, String str) {
        super(c2454e);
        this.f7477b = c0792p;
        this.f7479d = str;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: c */
    public String mo9086c() {
        C4815ag c4815ag = new C4815ag();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.f7477b.m3155a() != null) {
            linkedHashMap.put("name", this.f7477b.m3155a());
        }
        if (this.f7477b.m3157b() != null) {
            linkedHashMap.put("status", this.f7477b.m3157b());
        }
        if (this.f7477b.m3159c() != null) {
            this.f7478c = this.f7477b.m3159c();
            if ("FULL".equals(this.f7479d)) {
                linkedHashMap.put("birthday", this.f7477b.m3159c());
            } else if ("SHORT".equals(this.f7479d)) {
                linkedHashMap.put("birthday", this.f7477b.m3159c().substring(5, 10));
            } else if ("DONT".equals(this.f7479d) || "FULL_HIDE".equals(this.f7479d) || "SHORT_HIDE".equals(this.f7479d)) {
                linkedHashMap.put("birthday", "0000-12-31");
            } else {
                C4904y.m18639b("Unknown birthday option", getClass().getSimpleName());
            }
        }
        if (this.f7477b.m3161d() != null) {
            linkedHashMap.put("email", this.f7477b.m3161d());
        }
        if (this.f7477b.m3162e() != null) {
            linkedHashMap.put("samsungemail", this.f7477b.m3162e());
        }
        String strM18172a = c4815ag.m18172a((Object) linkedHashMap);
        C4904y.m18646e(strM18172a, getClass().getSimpleName());
        return strM18172a;
    }

    @Override // com.sec.chaton.p055d.p056a.AbstractC1900a
    /* renamed from: a */
    public void mo9084a(C0778b c0778b) {
        if (c0778b.m18954n() && c0778b.m3107b() != EnumC2464o.ERROR) {
            if (this.f7477b.m3155a() != null) {
                C4809aa.m18108a("Push Name", this.f7477b.m3155a());
            }
            if (this.f7477b.m3157b() != null) {
                C4809aa.m18108a("status_message", this.f7477b.m3157b());
            }
            if (this.f7477b.m3159c() != null) {
                C4809aa.m18108a("birthday", this.f7478c);
                C4809aa.m18108a("birthday_type", this.f7479d);
                if ("FULL".equals(this.f7479d) || "SHORT".equals(this.f7479d)) {
                    C4809aa.m18105a("birthday_show", (Boolean) true);
                } else {
                    C4809aa.m18105a("birthday_show", (Boolean) false);
                }
                if ("FULL".equals(this.f7479d) || "FULL_HIDE".equals(this.f7479d)) {
                    C4809aa.m18105a("birthday_year_show", (Boolean) true);
                } else {
                    C4809aa.m18105a("birthday_year_show", (Boolean) false);
                }
            }
            if (this.f7477b.m3161d() != null) {
                C4809aa.m18108a("email", this.f7477b.m3161d());
            }
            if (this.f7477b.m3162e() != null) {
                C4809aa.m18108a("samsung_email", this.f7477b.m3162e());
                return;
            }
            return;
        }
        C2404a.m10430a("01000004", "0001", c0778b);
    }
}
