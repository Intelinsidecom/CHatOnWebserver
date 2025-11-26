package com.sec.chaton.push;

import com.sec.chaton.push.p044c.C1115i;
import com.sec.chaton.push.p044c.p045a.C1100a;
import com.sec.chaton.push.p044c.p045a.C1101b;
import com.sec.chaton.push.p044c.p045a.C1102c;
import com.sec.chaton.push.p044c.p045a.C1107h;
import com.sec.chaton.push.util.C1139g;
import java.util.ArrayList;

/* compiled from: PushClientService.java */
/* renamed from: com.sec.chaton.push.k */
/* loaded from: classes.dex */
class BinderC1127k extends AbstractBinderC1119e {

    /* renamed from: a */
    final /* synthetic */ PushClientService f4110a;

    BinderC1127k(PushClientService pushClientService) {
        this.f4110a = pushClientService;
    }

    @Override // com.sec.chaton.push.InterfaceC1118d
    /* renamed from: a */
    public void mo4209a(String str, InterfaceC1121g interfaceC1121g) {
        if (C1139g.f4142a) {
            C1139g.m4308a(this.f4110a.f3982a, "PushClientService.registration()");
        }
        if (str == null) {
            throw new IllegalArgumentException("Application id shouldn't be null.");
        }
        try {
            C1107h c1107h = new C1107h(this.f4110a.getApplicationContext(), str);
            c1107h.m4169a(new C1128l(this, interfaceC1121g));
            C1115i.m4196a().m4203a(c1107h);
        } catch (InterruptedException e) {
            if (C1139g.f4145d) {
                C1139g.m4309a(this.f4110a.f3982a, e.getMessage(), e);
            }
        }
    }

    @Override // com.sec.chaton.push.InterfaceC1118d
    /* renamed from: b */
    public String mo4211b(String str) {
        if (C1139g.f4142a) {
            C1139g.m4308a(this.f4110a.f3982a, "PushClientService.getRegId()");
        }
        if (str == null) {
            throw new IllegalArgumentException("Application id shouldn't be null.");
        }
        return C1126j.m4264f((String) null);
    }

    @Override // com.sec.chaton.push.InterfaceC1118d
    /* renamed from: a */
    public void mo4208a(String str, InterfaceC1070a interfaceC1070a) {
        if (C1139g.f4142a) {
            C1139g.m4308a(this.f4110a.f3982a, "PushClientService.deregistration()");
        }
        if (str == null) {
            throw new IllegalArgumentException("Application id shouldn't be null.");
        }
        C1100a c1100a = new C1100a(this.f4110a.getApplicationContext(), str);
        c1100a.m4152a(new C1129m(this, interfaceC1070a));
        try {
            C1115i.m4196a().m4203a(c1100a);
        } catch (InterruptedException e) {
            if (C1139g.f4145d) {
                C1139g.m4309a(this.f4110a.f3982a, e.getMessage(), e);
            }
        }
    }

    @Override // com.sec.chaton.push.InterfaceC1118d
    /* renamed from: a */
    public void mo4207a(String str) {
        if (C1139g.f4142a) {
            C1139g.m4308a(this.f4110a.f3982a, "PushClientService.ackNotification()");
        }
        if (str == null) {
            throw new IllegalArgumentException("Notification id shouldn't be null.");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        try {
            C1115i.m4196a().m4203a(new C1102c(this.f4110a.getApplicationContext(), arrayList));
        } catch (InterruptedException e) {
            if (C1139g.f4145d) {
                C1139g.m4309a(this.f4110a.f3982a, e.getMessage(), e);
            }
        }
    }

    @Override // com.sec.chaton.push.InterfaceC1118d
    /* renamed from: a */
    public boolean mo4210a() {
        if (C1139g.f4142a) {
            C1139g.m4308a(this.f4110a.f3982a, "PushClientService.isPushAvailable()");
        }
        return C1101b.m4155d();
    }
}
