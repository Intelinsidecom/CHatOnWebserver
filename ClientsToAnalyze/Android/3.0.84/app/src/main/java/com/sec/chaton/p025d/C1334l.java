package com.sec.chaton.p025d;

import android.os.Build;
import android.os.Handler;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p025d.p026a.C1173ba;
import com.sec.chaton.p035io.entry.GetSSMServerAddress4;
import com.sec.chaton.p037j.C1582j;
import com.sec.chaton.p037j.C1595w;
import com.sec.chaton.p037j.EnumC1583k;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.EnumC3219cg;
import java.net.URLEncoder;

/* compiled from: GLDControl.java */
/* renamed from: com.sec.chaton.d.l */
/* loaded from: classes.dex */
public class C1334l {

    /* renamed from: a */
    private Handler f5033a;

    public C1334l(Handler handler) {
        this.f5033a = handler;
    }

    /* renamed from: a */
    public void m5775a() {
        C1595w.m6742a().m6745b().m6723a(m5777b());
    }

    /* renamed from: b */
    public C1173ba m5777b() {
        return new C1173ba(this.f5033a, new C1582j(EnumC3219cg.GLD, "/prov4").m6709a(104).m6714a("imei", C3171am.m11045a()).m6714a("imsi", C3171am.m11062e()).m6714a("model", URLEncoder.encode(C3171am.m11055b())).m6714a("clientversion", C0816a.f3112a).m6714a("platform", "android").m6714a("osversion", Build.VERSION.SDK).m6714a("screensize", C3171am.m11076n()).m6712a(GetSSMServerAddress4.class).m6710a(EnumC1583k.GET).m6708a());
    }

    /* renamed from: a */
    public void m5776a(String str, String str2) {
        C1595w.m6742a().m6745b().m6723a(new C1173ba(this.f5033a, new C1582j(EnumC3219cg.GLD, "/prov4").m6709a(104).m6714a("imei", C3171am.m11045a()).m6714a("countrycallingcode", str).m6714a("phonenumber", str2).m6714a("imsi", C3171am.m11062e()).m6714a("model", URLEncoder.encode(C3171am.m11055b())).m6714a("clientversion", C0816a.f3112a).m6714a("platform", "android").m6714a("osversion", Build.VERSION.SDK).m6714a("screensize", C3171am.m11076n()).m6712a(GetSSMServerAddress4.class).m6710a(EnumC1583k.GET).m6708a()));
    }
}
