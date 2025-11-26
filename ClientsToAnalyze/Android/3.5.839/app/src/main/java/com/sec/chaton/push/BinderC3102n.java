package com.sec.chaton.push;

import com.sec.chaton.push.p094c.C3088i;
import com.sec.chaton.push.p094c.p095a.C3073a;
import com.sec.chaton.push.p094c.p095a.C3074b;
import com.sec.chaton.push.p094c.p095a.C3075c;
import com.sec.chaton.push.p094c.p095a.C3080h;
import com.sec.chaton.push.util.C3115g;
import java.util.ArrayList;

/* compiled from: PushClientService.java */
/* renamed from: com.sec.chaton.push.n */
/* loaded from: classes.dex */
class BinderC3102n extends AbstractBinderC3093f {

    /* renamed from: a */
    final /* synthetic */ PushClientService f11430a;

    BinderC3102n(PushClientService pushClientService) {
        this.f11430a = pushClientService;
    }

    @Override // com.sec.chaton.push.InterfaceC3092e
    /* renamed from: a */
    public void mo12597a(String str, InterfaceC3095h interfaceC3095h) {
        if (C3115g.f11458a) {
            C3115g.m12701a(this.f11430a.f11294a, "PushClientService.registration()");
        }
        if (str == null) {
            throw new IllegalArgumentException("Application id shouldn't be null.");
        }
        try {
            C3080h c3080h = new C3080h(this.f11430a.getApplicationContext(), str);
            c3080h.m12557a(new C3103o(this, interfaceC3095h));
            C3088i.m12584a().m12591a(c3080h);
        } catch (InterruptedException e) {
            if (C3115g.f11461d) {
                C3115g.m12702a(this.f11430a.f11294a, e.getMessage(), e);
            }
        }
    }

    @Override // com.sec.chaton.push.InterfaceC3092e
    /* renamed from: b */
    public String mo12599b(String str) {
        if (C3115g.f11458a) {
            C3115g.m12701a(this.f11430a.f11294a, "PushClientService.getRegId()");
        }
        if (str == null) {
            throw new IllegalArgumentException("Application id shouldn't be null.");
        }
        return C3099k.m12651f((String) null);
    }

    @Override // com.sec.chaton.push.InterfaceC3092e
    /* renamed from: a */
    public void mo12596a(String str, InterfaceC3056b interfaceC3056b) {
        if (C3115g.f11458a) {
            C3115g.m12701a(this.f11430a.f11294a, "PushClientService.deregistration()");
        }
        if (str == null) {
            throw new IllegalArgumentException("Application id shouldn't be null.");
        }
        C3073a c3073a = new C3073a(this.f11430a.getApplicationContext(), str);
        c3073a.m12539a(new C3104p(this, interfaceC3056b));
        try {
            C3088i.m12584a().m12591a(c3073a);
        } catch (InterruptedException e) {
            if (C3115g.f11461d) {
                C3115g.m12702a(this.f11430a.f11294a, e.getMessage(), e);
            }
        }
    }

    @Override // com.sec.chaton.push.InterfaceC3092e
    /* renamed from: a */
    public void mo12595a(String str) {
        if (C3115g.f11458a) {
            C3115g.m12701a(this.f11430a.f11294a, "PushClientService.ackNotification()");
        }
        if (str == null) {
            throw new IllegalArgumentException("Notification id shouldn't be null.");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        try {
            C3088i.m12584a().m12591a(new C3075c(this.f11430a.getApplicationContext(), arrayList));
        } catch (InterruptedException e) {
            if (C3115g.f11461d) {
                C3115g.m12702a(this.f11430a.f11294a, e.getMessage(), e);
            }
        }
    }

    @Override // com.sec.chaton.push.InterfaceC3092e
    /* renamed from: a */
    public boolean mo12598a() {
        if (C3115g.f11458a) {
            C3115g.m12701a(this.f11430a.f11294a, "PushClientService.isPushAvailable()");
        }
        return C3074b.m12542a(false);
    }

    @Override // com.sec.chaton.push.InterfaceC3092e
    /* renamed from: c */
    public int mo12600c(String str) {
        if (C3115g.f11458a) {
            C3115g.m12701a(this.f11430a.f11294a, "PushClientService.getWifiPort()");
            return 5223;
        }
        return 5223;
    }
}
