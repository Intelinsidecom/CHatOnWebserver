package com.sec.chaton.p013a;

import android.os.Build;
import android.os.Handler;
import com.sec.chaton.p013a.p014a.C0133ai;
import com.sec.chaton.p013a.p014a.C0158bg;
import com.sec.chaton.p018c.C0512s;
import com.sec.chaton.p018c.C0519z;
import com.sec.chaton.p018c.EnumC0511r;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.p033io.entry.GetSSMServerAddress;
import com.sec.chaton.p033io.entry.GetSSMServerAddress3;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.EnumC1333h;
import java.net.URLEncoder;

/* compiled from: GLDControl.java */
/* renamed from: com.sec.chaton.a.x */
/* loaded from: classes.dex */
public class C0225x {

    /* renamed from: a */
    private Handler f560a;

    public C0225x(Handler handler) {
        this.f560a = handler;
    }

    /* renamed from: a */
    public void m869a() {
        C0512s.m2577a().offer(new C0133ai(this.f560a, new C0519z(EnumC1333h.GLD, "/prov").m2580a(101).m2584a("imei", C1336k.m4621a()).m2584a("msisdn", C1323bs.m4575a().getString("msisdn", C1336k.m4627d())).m2584a("imsi", C1336k.m4629f()).m2584a("model", URLEncoder.encode(C1336k.m4625c())).m2584a("clientversion", C0684a.f2331b).m2584a("platform", "android").m2584a("osversion", Build.VERSION.SDK).m2582a(GetSSMServerAddress.class).m2581a(EnumC0511r.GET).m2579a()));
    }

    /* renamed from: a */
    public void m870a(String str, String str2) {
        C0512s.m2577a().offer(new C0158bg(this.f560a, new C0519z(EnumC1333h.GLD, "/prov3").m2580a(103).m2584a("imei", C1336k.m4621a()).m2584a("countrycallingcode", str).m2584a("phonenumber", str2).m2584a("imsi", C1336k.m4629f()).m2584a("model", URLEncoder.encode(C1336k.m4625c())).m2584a("clientversion", C0684a.f2331b).m2584a("platform", "android").m2584a("osversion", Build.VERSION.SDK).m2582a(GetSSMServerAddress3.class).m2581a(EnumC0511r.GET).m2579a()));
    }
}
