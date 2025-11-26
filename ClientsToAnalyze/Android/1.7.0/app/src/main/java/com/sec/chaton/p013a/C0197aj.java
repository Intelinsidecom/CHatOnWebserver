package com.sec.chaton.p013a;

import android.os.Handler;
import com.sec.chaton.p013a.p014a.C0135ak;
import com.sec.chaton.p013a.p014a.C0141aq;
import com.sec.chaton.p013a.p014a.C0157bf;
import com.sec.chaton.p018c.C0512s;
import com.sec.chaton.p018c.C0519z;
import com.sec.chaton.p018c.EnumC0511r;
import com.sec.chaton.p033io.entry.GetInteractionHideList;
import com.sec.chaton.p033io.entry.GetInteractionList;
import com.sec.chaton.userprofile.p047a.C1203a;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.EnumC1333h;
import java.util.ArrayList;

/* compiled from: InteractionControl.java */
/* renamed from: com.sec.chaton.a.aj */
/* loaded from: classes.dex */
public class C0197aj {

    /* renamed from: a */
    private Handler f488a;

    public C0197aj(Handler handler) {
        this.f488a = handler;
    }

    /* renamed from: a */
    public void m746a() {
        C0512s.m2577a().offer(new C0141aq(this.f488a, new C0519z(EnumC1333h.CONTACT, "/interaction/excepthide").m2581a(EnumC0511r.GET).m2580a(1101).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2584a("timezone", "+0900").m2584a("week", "0").m2584a("startidx", "0").m2586b(C1203a.class).m2582a(GetInteractionList.class).m2579a()));
    }

    /* renamed from: b */
    public void m748b() {
        C0512s.m2577a().offer(new C0135ak(this.f488a, new C0519z(EnumC1333h.CONTACT, "/interaction/hidelist").m2581a(EnumC0511r.GET).m2580a(1102).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2584a("startidx", "0").m2582a(GetInteractionHideList.class).m2579a()));
    }

    /* renamed from: a */
    public void m747a(ArrayList arrayList, ArrayList arrayList2) {
        C0512s.m2577a().offer(new C0157bf(this.f488a, new C0519z(EnumC1333h.CONTACT, "/interaction/hide").m2581a(EnumC0511r.POST).m2580a(1103).m2584a("uid", C1323bs.m4575a().getString("uid", "")).m2584a("imei", C1336k.m4621a()).m2579a(), arrayList, arrayList2));
    }
}
