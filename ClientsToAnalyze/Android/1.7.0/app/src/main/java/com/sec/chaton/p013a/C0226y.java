package com.sec.chaton.p013a;

import android.os.Handler;
import com.sec.chaton.p013a.p014a.C0144at;
import com.sec.chaton.p013a.p014a.C0175n;
import com.sec.chaton.p015b.p016a.C0260h;
import com.sec.chaton.p018c.C0512s;
import com.sec.chaton.p018c.C0519z;
import com.sec.chaton.p018c.EnumC0511r;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.EnumC1333h;

/* compiled from: ProfileControl.java */
/* renamed from: com.sec.chaton.a.y */
/* loaded from: classes.dex */
public class C0226y {

    /* renamed from: a */
    private Handler f561a;

    public C0226y(Handler handler) {
        this.f561a = handler;
    }

    /* renamed from: a */
    public void m873a(C0260h c0260h, String str) {
        C0512s.m2577a().offer(new C0144at(this.f561a, new C0519z(EnumC1333h.CONTACT, "/profile").m2581a(EnumC0511r.POST).m2580a(401).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2579a(), c0260h, str));
    }

    /* renamed from: a */
    public void m874a(String str) {
        new AsyncTaskC0189ab(this, str).execute(new String[0]);
    }

    /* renamed from: a */
    public void m872a() {
        C0512s.m2577a().offer(new C0175n(this.f561a, new C0519z(EnumC1333h.CONTACT, "/delprofileimage").m2581a(EnumC0511r.GET).m2580a(403).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2579a()));
    }
}
