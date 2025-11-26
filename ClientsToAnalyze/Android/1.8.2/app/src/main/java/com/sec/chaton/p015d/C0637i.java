package com.sec.chaton.p015d;

import android.os.Handler;
import com.sec.chaton.p015d.p016a.C0551as;
import com.sec.chaton.p015d.p016a.C0573bn;
import com.sec.chaton.p022h.C0800j;
import com.sec.chaton.p022h.C0802l;
import com.sec.chaton.p022h.EnumC0801k;
import com.sec.chaton.p028io.entry.GetInteractionList;
import com.sec.chaton.userprofile.p054a.C1623a;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.EnumC1765bu;
import java.util.ArrayList;

/* compiled from: InteractionControl.java */
/* renamed from: com.sec.chaton.d.i */
/* loaded from: classes.dex */
public class C0637i {

    /* renamed from: a */
    private Handler f2477a;

    public C0637i(Handler handler) {
        this.f2477a = handler;
    }

    /* renamed from: a */
    public void m2893a() {
        C0802l.m3412a().offer(new C0551as(this.f2477a, new C0800j(EnumC1765bu.CONTACT, "/interaction/excepthide").m3406a(EnumC0801k.GET).m3405a(1101).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3409a("timezone", "+0900").m3409a("week", "0").m3409a("startidx", "0").m3410b(C1623a.class).m3407a(GetInteractionList.class).m3404a()));
    }

    /* renamed from: a */
    public void m2894a(ArrayList arrayList, ArrayList arrayList2) {
        C0802l.m3412a().offer(new C0573bn(this.f2477a, new C0800j(EnumC1765bu.CONTACT, "/interaction/hide").m3406a(EnumC0801k.POST).m3405a(1103).m3409a("uid", C1789u.m6075a().getString("uid", "")).m3409a("imei", C1721ad.m5873a()).m3404a(), arrayList, arrayList2));
    }
}
