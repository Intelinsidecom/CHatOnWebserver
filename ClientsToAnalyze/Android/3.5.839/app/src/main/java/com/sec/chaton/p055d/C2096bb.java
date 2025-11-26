package com.sec.chaton.p055d;

import android.text.TextUtils;
import com.sec.chaton.chat.C1734gg;
import com.sec.chaton.chat.C1755ha;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C2695c;
import com.sec.chaton.msgsend.C2696d;
import com.sec.chaton.p046a.C0818az;
import com.sec.chaton.p046a.C0820ba;
import com.sec.chaton.p046a.C0874da;
import com.sec.chaton.p046a.C0875db;
import com.sec.chaton.p046a.C0889dp;
import com.sec.chaton.p046a.C0947ft;
import com.sec.chaton.p046a.C0948fu;
import com.sec.chaton.p046a.C0950fw;
import com.sec.chaton.p046a.C0951fx;
import com.sec.chaton.p046a.C0973i;
import com.sec.chaton.p046a.C0974j;
import com.sec.chaton.p046a.EnumC0822bc;
import com.sec.chaton.p051c.C1433g;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2198l;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p067j.C2427ap;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4843bh;
import com.sec.chaton.util.C4904y;

/* compiled from: RequestGenerator.java */
/* renamed from: com.sec.chaton.d.bb */
/* loaded from: classes.dex */
public class C2096bb {

    /* renamed from: a */
    private static final String f7614a = C2096bb.class.getSimpleName();

    /* renamed from: b */
    private static C2096bb f7615b;

    /* renamed from: a */
    public static synchronized C2096bb m9360a() {
        if (f7615b == null) {
            f7615b = new C2096bb();
        }
        return f7615b;
    }

    private C2096bb() {
    }

    /* renamed from: a */
    public C2426ao m9365a(String str, String str2) {
        return new C2427ap().m10517a(49).m10519a(C0889dp.newBuilder().m4651b(C4822an.m18228d()).m4655d(str2).m4644a(C4843bh.m18322a()).m4653c(str).m4648a(C4809aa.m18104a().m18121a("uid", "")).build()).m10518a(C1433g.m7531e()).m10522b();
    }

    /* renamed from: a */
    public C2426ao m9364a(String str, long j, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String[] strArr, String str2) {
        C0875db c0875dbM4384e = C0874da.newBuilder().m4368a(j).m4370a(EnumC0822bc.m3576a(enumC2300t.m10210a())).m4373a(C4809aa.m18104a().m18121a("uid", "")).m4378b(C4822an.m18228d()).m4380c(C4809aa.m18104a().m18121a("chaton_id", "")).m4384e(str2);
        c0875dbM4384e.m4372a(C2204r.m10018a(enumC2214ab));
        for (String str3 : strArr) {
            c0875dbM4384e.m4382d(str3);
        }
        C0874da c0874daBuild = c0875dbM4384e.build();
        C1734gg.m8598a(str, c0874daBuild, f7614a);
        return new C2427ap().m10517a(0).m10519a(c0874daBuild).m10518a(C1433g.m7531e()).m10522b();
    }

    /* renamed from: a */
    public C2426ao m9363a(EnumC2300t enumC2300t, String str, String str2, long j, String str3) {
        C0974j c0974jM5813c = C0973i.newBuilder().m5801a(j).m5803a(EnumC0822bc.m3576a(enumC2300t.m10210a())).m5809b(String.valueOf(str2)).m5817d(C4809aa.m18104a().m18121a("uid", "")).m5819e(C4822an.m18228d()).m5800a(100).m5813c(C4809aa.m18104a().m18121a("chaton_id", ""));
        if (C2198l.m9954g(GlobalApplication.m18732r().getContentResolver(), str) || enumC2300t == EnumC2300t.TOPIC) {
            c0974jM5813c.m5806a(true);
        }
        String strM9650h = C2142w.m9606c(str).m9650h();
        if (!TextUtils.isEmpty(strM9650h)) {
            str3 = strM9650h;
        }
        if (enumC2300t == EnumC2300t.BROADCAST || TextUtils.isEmpty(str3)) {
            c0974jM5813c.m5805a("");
        } else {
            c0974jM5813c.m5805a(str3);
        }
        long jM9651i = C2142w.m9606c(str).m9651i();
        if (jM9651i > 0) {
            c0974jM5813c.m5812c(jM9651i);
        }
        C0973i c0973iBuild = c0974jM5813c.build();
        C1734gg.m8607a(str, c0973iBuild, f7614a);
        C2427ap c2427ap = new C2427ap();
        c2427ap.m10517a(2).m10519a(c0973iBuild).m10518a(C1433g.m7529c());
        return c2427ap.m10522b();
    }

    /* renamed from: a */
    public C2426ao m9361a(long j, String str, EnumC2214ab enumC2214ab, EnumC2300t enumC2300t, String str2, String str3, String str4) {
        C1755ha c1755haM9649g;
        if (C2142w.m9606c(str) != null) {
            String strM9650h = C2142w.m9606c(str).m9650h();
            if (!TextUtils.isEmpty(strM9650h)) {
                str2 = strM9650h;
            }
        }
        if (str2 == null) {
            return null;
        }
        if (C2142w.m9606c(str) != null && (c1755haM9649g = C2142w.m9606c(str).m9649g()) != null && !TextUtils.isEmpty(c1755haM9649g.f6583a) && c1755haM9649g.f6583a.equals(str4) && !TextUtils.isEmpty(c1755haM9649g.f6584b)) {
            str4 = c1755haM9649g.f6584b;
            if (C4904y.f17873c) {
                C4904y.m18641c("generateChatRequest() - change receiver old(" + c1755haM9649g.f6583a + "),new(" + c1755haM9649g.f6584b + ")", f7614a);
            }
        }
        C0820ba c0820baM3571f = C0818az.newBuilder().m3554a(j).m3557a(EnumC0822bc.m3576a(enumC2300t.m10210a())).m3559a(str2).m3568d(C4809aa.m18104a().m18121a("uid", "")).m3570e(C4822an.m18228d()).m3563b(C4809aa.m18104a().m18121a("chaton_id", "")).m3571f(str3);
        c0820baM3571f.m3558a(C2204r.m10018a(enumC2214ab));
        long jM9651i = C2142w.m9606c(str).m9651i();
        if (jM9651i > 0) {
            c0820baM3571f.m3562b(jM9651i);
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = C4809aa.m18104a().m18121a("chaton_id", "");
        }
        c0820baM3571f.m3566c(str4);
        C0818az c0818azBuild = c0820baM3571f.build();
        C1734gg.m8591a(str, c0818azBuild, f7614a);
        return new C2427ap().m10517a(4).m10519a(c0818azBuild).m10518a(C1433g.m7530d()).m10522b();
    }

    /* renamed from: a */
    public C2426ao m9362a(long j, String str, EnumC2300t enumC2300t, String str2, String str3, C2695c c2695c) {
        String strM9650h = C2142w.m9606c(str).m9650h();
        if (!TextUtils.isEmpty(strM9650h)) {
            str2 = strM9650h;
        }
        if (str2 == null) {
            return null;
        }
        C0948fu c0948fuM5446b = C0947ft.newBuilder().m5437a(j).m5439a(EnumC0822bc.m3576a(enumC2300t.m10210a())).m5443a(str2).m5451d(C4809aa.m18104a().m18121a("uid", "")).m5453e(C4822an.m18228d()).m5446b(C4809aa.m18104a().m18121a("chaton_id", ""));
        for (C2696d c2696d : c2695c.m11307b()) {
            C0951fx c0951fxNewBuilder = C0950fw.newBuilder();
            c0951fxNewBuilder.m5483a(c2696d.m11311c());
            c0951fxNewBuilder.m5485a(C2204r.m10018a(c2696d.m11310b()));
            c0951fxNewBuilder.m5487a(c2696d.m11309a());
            c0948fuM5446b.m5442a(c0951fxNewBuilder);
        }
        long jM9651i = C2142w.m9606c(str).m9651i();
        if (jM9651i > 0) {
            c0948fuM5446b.m5445b(jM9651i);
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = C4809aa.m18104a().m18121a("chaton_id", "");
        }
        c0948fuM5446b.m5449c(str3);
        C0947ft c0947ftM5450d = c0948fuM5446b.build();
        C1734gg.m8606a(str, c0947ftM5450d, f7614a);
        return new C2427ap().m10517a(27).m10519a(c0947ftM5450d).m10518a(C1433g.m7530d()).m10522b();
    }
}
