package com.sec.chaton.p015d;

import android.os.Handler;
import com.sec.chaton.p015d.p016a.C0546an;
import com.sec.chaton.p015d.p016a.C0562bc;
import com.sec.chaton.p022h.C0800j;
import com.sec.chaton.p022h.C0802l;
import com.sec.chaton.p022h.EnumC0801k;
import com.sec.chaton.p028io.entry.getBuddyIgnoreList;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.EnumC1765bu;
import java.util.ArrayList;
import twitter4j.MediaEntity;

/* compiled from: IgnoreControl.java */
/* renamed from: com.sec.chaton.d.h */
/* loaded from: classes.dex */
public class C0636h {

    /* renamed from: a */
    private Handler f2476a;

    public C0636h(Handler handler) {
        this.f2476a = handler;
    }

    /* renamed from: a */
    public void m2890a(String str, ArrayList arrayList) {
        C0802l.m3412a().offer(new C0562bc(this.f2476a, new C0800j(EnumC1765bu.CONTACT, "/buddyrecommendee/ignorelist").m3406a(EnumC0801k.POST).m3405a(100).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3404a(), str, arrayList));
    }

    /* renamed from: a */
    public void m2891a(ArrayList arrayList) {
        C0802l.m3412a().offer(new C0562bc(this.f2476a, new C0800j(EnumC1765bu.CONTACT, "/buddyrecommendee/ignorelist").m3406a(EnumC0801k.POST).m3405a(MediaEntity.Size.CROP).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3404a(), "false", arrayList));
    }

    /* renamed from: a */
    public void m2889a() {
        C0802l.m3412a().offer(new C0546an(this.f2476a, new C0800j(EnumC1765bu.CONTACT, "/buddyrecommendee/ignorelist").m3406a(EnumC0801k.GET).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3405a(102).m3407a(getBuddyIgnoreList.class).m3404a()));
    }

    /* renamed from: b */
    public void m2892b(ArrayList arrayList) {
        if (arrayList.size() > 0) {
            C0802l.m3412a().offer(new C0562bc(this.f2476a, new C0800j(EnumC1765bu.CONTACT, "/buddyrecommendee/ignorelist").m3406a(EnumC0801k.POST).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3405a(103).m3404a(), "true", arrayList));
        }
    }
}
