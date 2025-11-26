package com.sec.chaton.push;

import com.sec.chaton.push.p039c.C0896h;
import com.sec.chaton.push.p039c.p040a.C0883b;
import com.sec.chaton.push.p039c.p040a.C0885d;
import com.sec.chaton.push.p039c.p040a.C0886e;
import com.sec.chaton.push.p039c.p040a.C0888g;
import com.sec.chaton.push.util.C0921g;
import java.util.ArrayList;

/* compiled from: PushClientService.java */
/* renamed from: com.sec.chaton.push.d */
/* loaded from: classes.dex */
class BinderC0900d extends AbstractBinderC0908j {

    /* renamed from: a */
    final /* synthetic */ PushClientService f3073a;

    BinderC0900d(PushClientService pushClientService) {
        this.f3073a = pushClientService;
    }

    @Override // com.sec.chaton.push.InterfaceC0903g
    /* renamed from: a */
    public void mo3445a(String str, InterfaceC0902f interfaceC0902f) {
        if (C0921g.f3116a) {
            C0921g.m3637a(this.f3073a.f2960a, "PushClientService.registration()");
        }
        if (str == null) {
            throw new IllegalArgumentException("Application id shouldn't be null.");
        }
        try {
            C0886e c0886e = new C0886e(this.f3073a.getApplicationContext(), str);
            c0886e.m3490a(new C0909k(this, interfaceC0902f));
            C0896h.m3520a().m3527a(c0886e);
        } catch (InterruptedException e) {
            if (C0921g.f3119d) {
                C0921g.m3638a(this.f3073a.f2960a, e.getMessage(), e);
            }
        }
    }

    @Override // com.sec.chaton.push.InterfaceC0903g
    /* renamed from: b */
    public String mo3447b(String str) {
        if (C0921g.f3116a) {
            C0921g.m3637a(this.f3073a.f2960a, "PushClientService.getRegId()");
        }
        if (str == null) {
            throw new IllegalArgumentException("Application id shouldn't be null.");
        }
        return C0904h.m3562f((String) null);
    }

    @Override // com.sec.chaton.push.InterfaceC0903g
    /* renamed from: a */
    public void mo3444a(String str, InterfaceC0880c interfaceC0880c) {
        if (C0921g.f3116a) {
            C0921g.m3637a(this.f3073a.f2960a, "PushClientService.deregistration()");
        }
        if (str == null) {
            throw new IllegalArgumentException("Application id shouldn't be null.");
        }
        C0885d c0885d = new C0885d(this.f3073a.getApplicationContext(), str);
        c0885d.m3489a(new C0910l(this, interfaceC0880c));
        try {
            C0896h.m3520a().m3527a(c0885d);
        } catch (InterruptedException e) {
            if (C0921g.f3119d) {
                C0921g.m3638a(this.f3073a.f2960a, e.getMessage(), e);
            }
        }
    }

    @Override // com.sec.chaton.push.InterfaceC0903g
    /* renamed from: a */
    public void mo3443a(String str) {
        if (C0921g.f3116a) {
            C0921g.m3637a(this.f3073a.f2960a, "PushClientService.ackNotification()");
        }
        if (str == null) {
            throw new IllegalArgumentException("Notification id shouldn't be null.");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        try {
            C0896h.m3520a().m3527a(new C0883b(this.f3073a.getApplicationContext(), arrayList));
        } catch (InterruptedException e) {
            if (C0921g.f3119d) {
                C0921g.m3638a(this.f3073a.f2960a, e.getMessage(), e);
            }
        }
    }

    @Override // com.sec.chaton.push.InterfaceC0903g
    /* renamed from: a */
    public boolean mo3446a() {
        if (C0921g.f3116a) {
            C0921g.m3637a(this.f3073a.f2960a, "PushClientService.isPushAvailable()");
        }
        return C0888g.m3496a();
    }
}
