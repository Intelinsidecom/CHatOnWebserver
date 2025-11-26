package com.sec.chaton.p015d;

import android.os.Handler;
import com.sec.chaton.buddy.p011b.C0288c;
import com.sec.chaton.p015d.p016a.C0545am;
import com.sec.chaton.p015d.p016a.C0581bv;
import com.sec.chaton.p015d.p016a.C0595k;
import com.sec.chaton.p022h.C0800j;
import com.sec.chaton.p022h.C0802l;
import com.sec.chaton.p022h.EnumC0801k;
import com.sec.chaton.p028io.entry.GetBlockBuddyList;
import com.sec.chaton.p028io.entry.UnBlock;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.EnumC1765bu;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BlockControl.java */
/* renamed from: com.sec.chaton.d.d */
/* loaded from: classes.dex */
public class C0632d {

    /* renamed from: a */
    private Handler f2470a;

    /* renamed from: b */
    private C0545am f2471b = null;

    public C0632d(Handler handler) {
        this.f2470a = handler;
    }

    /* renamed from: a */
    public List m2844a() {
        return m2845a(false);
    }

    /* renamed from: a */
    public List m2845a(boolean z) {
        this.f2471b = new C0545am(this.f2470a, new C0800j(EnumC1765bu.CONTACT, "/blockbuddy").m3406a(EnumC0801k.GET).m3407a(GetBlockBuddyList.class).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3405a(601).m3404a());
        if (z) {
            this.f2471b.m2712e();
            return this.f2471b.m2745f();
        }
        C0802l.m3412a().offer(this.f2471b);
        return null;
    }

    /* renamed from: b */
    public void m2849b() {
        if (this.f2471b != null) {
            this.f2471b.m2710c();
        }
    }

    /* renamed from: a */
    public void m2847a(String str, int i) {
        C0802l.m3412a().offer(new C0595k(this.f2470a, new C0800j(EnumC1765bu.CONTACT, "/block/" + str).m3406a(EnumC0801k.POST).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3405a(602).m3404a(), str, i));
    }

    /* renamed from: a */
    public void m2846a(String str) {
        C0802l.m3412a().offer(new C0581bv(this.f2470a, new C0800j(EnumC1765bu.CONTACT, "/unblock/" + str).m3407a(UnBlock.class).m3406a(EnumC0801k.GET).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3405a(603).m3404a(), str));
    }

    /* renamed from: a */
    public void m2848a(ArrayList arrayList) {
        C0802l.m3412a().offer(new C0581bv(this.f2470a, new C0800j(EnumC1765bu.CONTACT, "/blockbuddy").m3407a(UnBlock.class).m3406a(EnumC0801k.POST).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("startidx", "0").m3409a("count", arrayList.size() + "").m3410b(C0288c.class).m3405a(604).m3404a(), arrayList));
    }

    /* renamed from: b */
    public void m2850b(ArrayList arrayList) {
        C0802l.m3412a().offer(new C0595k(this.f2470a, new C0800j(EnumC1765bu.CONTACT, "/blockbuddy").m3406a(EnumC0801k.POST).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("startidx", "0").m3409a("count", arrayList.size() + "").m3410b(C0288c.class).m3405a(605).m3404a(), arrayList));
    }
}
