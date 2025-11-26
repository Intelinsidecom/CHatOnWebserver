package com.sec.chaton.push;

import com.sec.chaton.push.p054c.C2088i;
import com.sec.chaton.push.p054c.p055a.C2073a;
import com.sec.chaton.push.p054c.p055a.C2074b;
import com.sec.chaton.push.p054c.p055a.C2075c;
import com.sec.chaton.push.p054c.p055a.C2080h;
import com.sec.chaton.push.util.C2115g;
import java.util.ArrayList;

/* compiled from: PushClientService.java */
/* renamed from: com.sec.chaton.push.n */
/* loaded from: classes.dex */
class BinderC2102n extends AbstractBinderC2093f {

    /* renamed from: a */
    final /* synthetic */ PushClientService f8020a;

    BinderC2102n(PushClientService pushClientService) {
        this.f8020a = pushClientService;
    }

    @Override // com.sec.chaton.push.InterfaceC2092e
    /* renamed from: a */
    public void mo8254a(String str, InterfaceC2095h interfaceC2095h) {
        if (C2115g.f8048a) {
            C2115g.m8359a(this.f8020a.f7884a, "PushClientService.registration()");
        }
        if (str == null) {
            throw new IllegalArgumentException("Application id shouldn't be null.");
        }
        try {
            C2080h c2080h = new C2080h(this.f8020a.getApplicationContext(), str);
            c2080h.m8214a(new C2103o(this, interfaceC2095h));
            C2088i.m8241a().m8248a(c2080h);
        } catch (InterruptedException e) {
            if (C2115g.f8051d) {
                C2115g.m8360a(this.f8020a.f7884a, e.getMessage(), e);
            }
        }
    }

    @Override // com.sec.chaton.push.InterfaceC2092e
    /* renamed from: b */
    public String mo8256b(String str) {
        if (C2115g.f8048a) {
            C2115g.m8359a(this.f8020a.f7884a, "PushClientService.getRegId()");
        }
        if (str == null) {
            throw new IllegalArgumentException("Application id shouldn't be null.");
        }
        return C2099k.m8309f((String) null);
    }

    @Override // com.sec.chaton.push.InterfaceC2092e
    /* renamed from: a */
    public void mo8253a(String str, InterfaceC2056b interfaceC2056b) {
        if (C2115g.f8048a) {
            C2115g.m8359a(this.f8020a.f7884a, "PushClientService.deregistration()");
        }
        if (str == null) {
            throw new IllegalArgumentException("Application id shouldn't be null.");
        }
        C2073a c2073a = new C2073a(this.f8020a.getApplicationContext(), str);
        c2073a.m8196a(new C2104p(this, interfaceC2056b));
        try {
            C2088i.m8241a().m8248a(c2073a);
        } catch (InterruptedException e) {
            if (C2115g.f8051d) {
                C2115g.m8360a(this.f8020a.f7884a, e.getMessage(), e);
            }
        }
    }

    @Override // com.sec.chaton.push.InterfaceC2092e
    /* renamed from: a */
    public void mo8252a(String str) {
        if (C2115g.f8048a) {
            C2115g.m8359a(this.f8020a.f7884a, "PushClientService.ackNotification()");
        }
        if (str == null) {
            throw new IllegalArgumentException("Notification id shouldn't be null.");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        try {
            C2088i.m8241a().m8248a(new C2075c(this.f8020a.getApplicationContext(), arrayList));
        } catch (InterruptedException e) {
            if (C2115g.f8051d) {
                C2115g.m8360a(this.f8020a.f7884a, e.getMessage(), e);
            }
        }
    }

    @Override // com.sec.chaton.push.InterfaceC2092e
    /* renamed from: a */
    public boolean mo8255a() {
        if (C2115g.f8048a) {
            C2115g.m8359a(this.f8020a.f7884a, "PushClientService.isPushAvailable()");
        }
        return C2074b.m8199a(false);
    }

    @Override // com.sec.chaton.push.InterfaceC2092e
    /* renamed from: c */
    public int mo8257c(String str) {
        if (C2115g.f8048a) {
            C2115g.m8359a(this.f8020a.f7884a, "PushClientService.getWifiPort()");
            return 5223;
        }
        return 5223;
    }
}
