package com.sec.chaton.p013a;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.p013a.p014a.C0170i;
import com.sec.chaton.p013a.p014a.C0172k;
import com.sec.chaton.p013a.p014a.C0184w;
import com.sec.chaton.p018c.C0512s;
import com.sec.chaton.p018c.C0519z;
import com.sec.chaton.p018c.EnumC0511r;
import com.sec.chaton.p033io.entry.RegisterSSMServer;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.EnumC1333h;

/* compiled from: RegistrationControl.java */
/* renamed from: com.sec.chaton.a.b */
/* loaded from: classes.dex */
public class C0203b {

    /* renamed from: a */
    private Handler f500a;

    public C0203b(Handler handler) {
        this.f500a = handler;
    }

    /* renamed from: a */
    public void m774a(String str, String str2, String str3, String str4) {
        C0512s.m2577a().offer(new C0170i(this.f500a, new C0519z(EnumC1333h.CONTACT, "/v2/reg").m2581a(EnumC0511r.POST).m2582a(RegisterSSMServer.class).m2580a(201).m2579a(), str, str2, str3, str4));
    }

    /* renamed from: a */
    public void m771a() {
        C0512s.m2577a().offer(new C0184w(this.f500a, new C0519z(EnumC1333h.CONTACT, "/dereg").m2581a(EnumC0511r.GET).m2584a("imei", C1336k.m4621a()).m2584a("uid", C1323bs.m4575a().getString("uid", null)).m2580a(202).m2579a()));
    }

    /* renamed from: a */
    public void m772a(Context context) {
        C0512s.m2577a().offer(new C0184w(this.f500a, new C0519z(EnumC1333h.CONTACT, "/dereg").m2581a(EnumC0511r.GET).m2584a("imei", C1336k.m4621a()).m2584a("uid", context.getSharedPreferences("ChatON", 0).getString("uid", null)).m2580a(202).m2579a()));
    }

    /* renamed from: a */
    public void m773a(String str, String str2, String str3) {
        C0512s.m2577a().offer(new C0172k(this.f500a, new C0519z(EnumC1333h.CONTACT, "/v2/reg/smsv").m2581a(EnumC0511r.POST).m2580a(203).m2579a(), str, str2, str3));
    }
}
