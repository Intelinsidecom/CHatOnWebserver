package com.sec.chaton.p015d.p016a;

import com.sec.chaton.p022h.C0770ab;
import com.sec.chaton.p022h.C0810t;
import com.sec.chaton.p022h.C0816z;
import com.sec.chaton.p022h.InterfaceC0807q;
import com.sec.chaton.util.C1786r;

/* compiled from: AbstractNetTask.java */
/* renamed from: com.sec.chaton.d.a.c */
/* loaded from: classes.dex */
class C0586c implements InterfaceC0807q {

    /* renamed from: a */
    final /* synthetic */ AbstractC0559b f2330a;

    /* renamed from: b */
    private C0770ab f2331b;

    /* renamed from: c */
    private C0816z f2332c;

    public C0586c(AbstractC0559b abstractC0559b, C0770ab c0770ab, C0816z c0816z) {
        this.f2330a = abstractC0559b;
        this.f2331b = c0770ab;
        this.f2332c = c0816z;
    }

    /* renamed from: a */
    public void m2780a() {
        if (this.f2331b != null) {
            C0810t.m3425a(this.f2332c, this.f2331b);
        } else {
            mo2781a(-1, this.f2331b);
        }
    }

    @Override // com.sec.chaton.p022h.InterfaceC0807q
    /* renamed from: a */
    public void mo2782a(int i, Object obj, Object obj2) {
        C1786r.m6061b("onPostExecute - start", getClass().getSimpleName());
        this.f2330a.mo2747a(i, obj, obj2);
        C1786r.m6061b("onPostExecute - end", getClass().getSimpleName());
    }

    @Override // com.sec.chaton.p022h.InterfaceC0807q
    /* renamed from: a */
    public void mo2781a(int i, Object obj) {
        C1786r.m6061b("onPostExecute - start(error)", getClass().getSimpleName());
        this.f2330a.mo2747a(i, obj, null);
        C1786r.m6061b("onPostExecute - end(error)", getClass().getSimpleName());
    }
}
