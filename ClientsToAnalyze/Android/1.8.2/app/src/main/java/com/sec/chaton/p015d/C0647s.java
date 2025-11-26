package com.sec.chaton.p015d;

import android.os.Handler;
import com.sec.chaton.p007a.p008a.C0107h;
import com.sec.chaton.p015d.p016a.C0584by;
import com.sec.chaton.p015d.p016a.C0600p;
import com.sec.chaton.p022h.C0800j;
import com.sec.chaton.p022h.C0802l;
import com.sec.chaton.p022h.EnumC0801k;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.EnumC1765bu;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: ProfileControl.java */
/* renamed from: com.sec.chaton.d.s */
/* loaded from: classes.dex */
public class C0647s {

    /* renamed from: a */
    C0584by f2513a;

    /* renamed from: b */
    private Handler f2514b;

    public C0647s(Handler handler) {
        this.f2514b = handler;
    }

    /* renamed from: a */
    public void m2963a(C0107h c0107h, String str) {
        this.f2513a = new C0584by(this.f2514b, new C0800j(EnumC1765bu.CONTACT, "/profile").m3406a(EnumC0801k.POST).m3405a(HttpResponseCode.UNAUTHORIZED).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3404a(), c0107h, str);
        C0802l.m3412a().offer(this.f2513a);
    }

    /* renamed from: a */
    public void m2964a(String str) {
        new AsyncTaskC0648t(this, str).execute(new String[0]);
    }

    /* renamed from: a */
    public void m2962a() {
        C0802l.m3412a().offer(new C0600p(this.f2514b, new C0800j(EnumC1765bu.CONTACT, "/delprofileimage").m3406a(EnumC0801k.GET).m3405a(HttpResponseCode.FORBIDDEN).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3404a()));
    }
}
