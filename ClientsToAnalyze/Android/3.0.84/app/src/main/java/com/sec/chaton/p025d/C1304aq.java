package com.sec.chaton.p025d;

import android.text.TextUtils;
import com.sec.chaton.chat.C1072en;
import com.sec.chaton.msgsend.C1740a;
import com.sec.chaton.msgsend.C1742b;
import com.sec.chaton.p016a.C0299aw;
import com.sec.chaton.p016a.C0300ax;
import com.sec.chaton.p016a.C0339ci;
import com.sec.chaton.p016a.C0340cj;
import com.sec.chaton.p016a.C0375dr;
import com.sec.chaton.p016a.C0376ds;
import com.sec.chaton.p016a.C0378du;
import com.sec.chaton.p016a.C0379dv;
import com.sec.chaton.p016a.C0391f;
import com.sec.chaton.p016a.C0392g;
import com.sec.chaton.p016a.EnumC0302az;
import com.sec.chaton.p020c.C0822g;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.p027e.p028a.C1373q;
import com.sec.chaton.p037j.C1548ag;
import com.sec.chaton.p037j.C1549ah;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;

/* compiled from: RequestGenerator.java */
/* renamed from: com.sec.chaton.d.aq */
/* loaded from: classes.dex */
public class C1304aq {

    /* renamed from: a */
    private static final String f4934a = C1304aq.class.getSimpleName();

    /* renamed from: b */
    private static C1304aq f4935b;

    /* renamed from: a */
    public static synchronized C1304aq m5604a() {
        if (f4935b == null) {
            f4935b = new C1304aq();
        }
        return f4935b;
    }

    private C1304aq() {
    }

    /* renamed from: a */
    public C1548ag m5608a(String str, long j, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String[] strArr, String str2) {
        C0340cj c0340cjM2183e = C0339ci.newBuilder().m2169a(j).m2171a(EnumC0302az.m1704a(enumC1450r.m6342a())).m2174a(C3159aa.m10962a().m10979a("uid", "")).m2177b(C3171am.m11045a()).m2179c(C3159aa.m10962a().m10979a("chaton_id", "")).m2183e(str2);
        c0340cjM2183e.m2173a(C1373q.m6170a(enumC1455w));
        for (String str3 : strArr) {
            c0340cjM2183e.m2181d(str3);
        }
        C0339ci c0339ciM2180d = c0340cjM2183e.build();
        C1072en.m5303a(str, c0339ciM2180d, f4934a);
        return new C1549ah().m6579a(0).m6581a(c0339ciM2180d).m6580a(C0822g.m4376e()).m6584b();
    }

    /* renamed from: a */
    public C1548ag m5607a(EnumC1450r enumC1450r, String str, String str2, long j, String str3) {
        C0392g c0392gM2811c = C0391f.newBuilder().m2801a(j).m2803a(EnumC0302az.m1704a(enumC1450r.m6342a())).m2808b(String.valueOf(str2)).m2813d(C3159aa.m10962a().m10979a("uid", "")).m2815e(C3171am.m11045a()).m2800a(100).m2811c(C3159aa.m10962a().m10979a("chaton_id", ""));
        String strM5895d = C1337o.m5813d(str).m5895d();
        if (!TextUtils.isEmpty(strM5895d)) {
            str3 = strM5895d;
        }
        if (enumC1450r == EnumC1450r.BROADCAST || TextUtils.isEmpty(str3)) {
            c0392gM2811c.m2805a("");
        } else {
            c0392gM2811c.m2805a(str3);
        }
        long jM5896e = C1337o.m5813d(str).m5896e();
        if (jM5896e > 0) {
            c0392gM2811c.m2810c(jM5896e);
        }
        C0391f c0391fBuild = c0392gM2811c.build();
        C1072en.m5305a(str, c0391fBuild, f4934a);
        C1549ah c1549ah = new C1549ah();
        c1549ah.m6579a(2).m6581a(c0391fBuild).m6580a(C0822g.m4374c());
        return c1549ah.m6584b();
    }

    /* renamed from: a */
    public C1548ag m5606a(long j, String str, EnumC1455w enumC1455w, EnumC1450r enumC1450r, String str2, String str3, String str4) {
        String strM5895d = C1337o.m5813d(str).m5895d();
        if (!TextUtils.isEmpty(strM5895d)) {
            str2 = strM5895d;
        }
        String strM5892c = C1337o.m5813d(str).m5892c();
        if (!TextUtils.isEmpty(strM5892c)) {
            str4 = strM5892c;
        }
        C1337o.m5813d(str).m5872a("");
        if (str2 == null) {
            return null;
        }
        C0300ax c0300axM1702f = C0299aw.newBuilder().m1687a(j).m1690a(EnumC0302az.m1704a(enumC1450r.m6342a())).m1692a(str2).m1699d(C3159aa.m10962a().m10979a("uid", "")).m1701e(C3171am.m11045a()).m1695b(C3159aa.m10962a().m10979a("chaton_id", "")).m1702f(str3);
        c0300axM1702f.m1691a(C1373q.m6170a(enumC1455w));
        long jM5896e = C1337o.m5813d(str).m5896e();
        if (jM5896e > 0) {
            c0300axM1702f.m1694b(jM5896e);
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = C3159aa.m10962a().m10979a("chaton_id", "");
        }
        c0300axM1702f.m1697c(str4);
        C0299aw c0299awM1698d = c0300axM1702f.build();
        C1072en.m5299a(str, c0299awM1698d, f4934a);
        return new C1549ah().m6579a(4).m6581a(c0299awM1698d).m6580a(C0822g.m4375d()).m6584b();
    }

    /* renamed from: a */
    public C1548ag m5605a(long j, String str, EnumC1450r enumC1450r, String str2, String str3, C1740a c1740a) {
        String strM5895d = C1337o.m5813d(str).m5895d();
        if (!TextUtils.isEmpty(strM5895d)) {
            str2 = strM5895d;
        }
        String strM5892c = C1337o.m5813d(str).m5892c();
        if (!TextUtils.isEmpty(strM5892c)) {
            str3 = strM5892c;
        }
        C1337o.m5813d(str).m5872a("");
        if (str2 == null) {
            return null;
        }
        C0376ds c0376dsM2620b = C0375dr.newBuilder().m2611a(j).m2613a(EnumC0302az.m1704a(enumC1450r.m6342a())).m2617a(str2).m2624d(C3159aa.m10962a().m10979a("uid", "")).m2626e(C3171am.m11045a()).m2620b(C3159aa.m10962a().m10979a("chaton_id", ""));
        for (C1742b c1742b : c1740a.m7154b()) {
            C0379dv c0379dvNewBuilder = C0378du.newBuilder();
            c0379dvNewBuilder.m2648a(c1742b.m7160c());
            c0379dvNewBuilder.m2650a(C1373q.m6170a(c1742b.m7159b()));
            c0379dvNewBuilder.m2652a(c1742b.m7158a());
            c0376dsM2620b.m2616a(c0379dvNewBuilder);
        }
        long jM5896e = C1337o.m5813d(str).m5896e();
        if (jM5896e > 0) {
            c0376dsM2620b.m2619b(jM5896e);
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = C3159aa.m10962a().m10979a("chaton_id", "");
        }
        c0376dsM2620b.m2622c(str3);
        C0375dr c0375drM2623d = c0376dsM2620b.build();
        C1072en.m5304a(str, c0375drM2623d, f4934a);
        return new C1549ah().m6579a(27).m6581a(c0375drM2623d).m6580a(C0822g.m4375d()).m6584b();
    }
}
