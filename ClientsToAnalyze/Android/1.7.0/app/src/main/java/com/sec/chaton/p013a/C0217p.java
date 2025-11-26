package com.sec.chaton.p013a;

import android.os.Handler;
import com.sec.chaton.p013a.p014a.C0146av;
import com.sec.chaton.p013a.p014a.C0155bd;
import com.sec.chaton.p013a.p014a.C0163bl;
import com.sec.chaton.p018c.C0512s;
import com.sec.chaton.p018c.C0519z;
import com.sec.chaton.p018c.EnumC0511r;
import com.sec.chaton.p033io.entry.GetBlockBuddyList;
import com.sec.chaton.p033io.entry.UnBlock;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.EnumC1333h;

/* compiled from: BlockControl.java */
/* renamed from: com.sec.chaton.a.p */
/* loaded from: classes.dex */
public class C0217p {

    /* renamed from: a */
    private Handler f528a;

    public C0217p(Handler handler) {
        this.f528a = handler;
    }

    /* renamed from: a */
    public void m796a() {
        C0512s.m2577a().offer(new C0146av(this.f528a, new C0519z(EnumC1333h.CONTACT, "/blockbuddy").m2581a(EnumC0511r.GET).m2582a(GetBlockBuddyList.class).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2580a(601).m2579a()));
    }

    /* renamed from: a */
    public void m798a(String str, int i) {
        C0512s.m2577a().offer(new C0155bd(this.f528a, new C0519z(EnumC1333h.CONTACT, "/block/" + str).m2581a(EnumC0511r.POST).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2580a(602).m2579a(), str, i));
    }

    /* renamed from: a */
    public void m797a(String str) {
        C0512s.m2577a().offer(new C0163bl(this.f528a, new C0519z(EnumC1333h.CONTACT, "/unblock/" + str).m2582a(UnBlock.class).m2581a(EnumC0511r.GET).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2580a(603).m2579a(), str));
    }
}
