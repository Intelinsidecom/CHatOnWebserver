package com.sec.chaton.p015d;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.p015d.p016a.C0574bo;
import com.sec.chaton.p015d.p016a.C0585bz;
import com.sec.chaton.p015d.p016a.C0598n;
import com.sec.chaton.p022h.C0800j;
import com.sec.chaton.p022h.C0802l;
import com.sec.chaton.p022h.EnumC0801k;
import com.sec.chaton.p028io.entry.RegisterSSMServer;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.EnumC1765bu;

/* compiled from: RegistrationControl.java */
/* renamed from: com.sec.chaton.d.ak */
/* loaded from: classes.dex */
public class C0621ak {

    /* renamed from: a */
    private Handler f2440a;

    public C0621ak(Handler handler) {
        this.f2440a = handler;
    }

    /* renamed from: a */
    public void m2809a(String str, String str2, String str3, String str4) {
        C0802l.m3412a().offer(new C0574bo(this.f2440a, new C0800j(EnumC1765bu.CONTACT, "/v2/reg").m3406a(EnumC0801k.POST).m3407a(RegisterSSMServer.class).m3405a(201).m3404a(), str, str2, str3, str4));
    }

    /* renamed from: a */
    public void m2806a() {
        C0802l.m3412a().offer(new C0598n(this.f2440a, new C0800j(EnumC1765bu.CONTACT, "/dereg").m3406a(EnumC0801k.GET).m3409a("imei", C1721ad.m5873a()).m3409a("uid", C1789u.m6075a().getString("uid", null)).m3405a(202).m3404a()));
    }

    /* renamed from: a */
    public void m2807a(Context context) {
        C0802l.m3412a().offer(new C0598n(this.f2440a, new C0800j(EnumC1765bu.CONTACT, "/dereg").m3406a(EnumC0801k.GET).m3409a("imei", C1721ad.m5873a()).m3409a("uid", context.getSharedPreferences("ChatON", 0).getString("uid", null)).m3405a(202).m3404a()));
    }

    /* renamed from: a */
    public void m2808a(String str, String str2, String str3) {
        C0802l.m3412a().offer(new C0585bz(this.f2440a, new C0800j(EnumC1765bu.CONTACT, "/v2/reg/smsv").m3406a(EnumC0801k.POST).m3405a(203).m3404a(), str, str2, str3));
    }
}
