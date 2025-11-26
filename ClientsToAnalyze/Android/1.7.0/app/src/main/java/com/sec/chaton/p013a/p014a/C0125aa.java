package com.sec.chaton.p013a.p014a;

import com.sec.chaton.p018c.C0477ab;
import com.sec.chaton.p018c.C0505l;
import com.sec.chaton.p018c.C0510q;
import com.sec.chaton.p018c.InterfaceC0504k;
import com.sec.chaton.util.C1341p;

/* compiled from: AbstractNetTask.java */
/* renamed from: com.sec.chaton.a.a.aa */
/* loaded from: classes.dex */
class C0125aa implements InterfaceC0504k {

    /* renamed from: a */
    final /* synthetic */ AbstractC0164c f297a;

    /* renamed from: b */
    private C0510q f298b;

    /* renamed from: c */
    private C0505l f299c;

    public C0125aa(AbstractC0164c abstractC0164c, C0510q c0510q, C0505l c0505l) {
        this.f297a = abstractC0164c;
        this.f298b = c0510q;
        this.f299c = c0505l;
    }

    /* renamed from: a */
    public void m667a() {
        if (this.f298b != null) {
            C0477ab.m2445a(this.f299c, this.f298b);
        } else {
            mo668a(-1, this.f298b);
        }
    }

    @Override // com.sec.chaton.p018c.InterfaceC0504k
    /* renamed from: a */
    public void mo669a(int i, Object obj, Object obj2) {
        C1341p.m4658b("onPostExecute - start", getClass().getSimpleName());
        this.f297a.mo666a(i, obj, obj2);
        C1341p.m4658b("onPostExecute - end", getClass().getSimpleName());
    }

    @Override // com.sec.chaton.p018c.InterfaceC0504k
    /* renamed from: a */
    public void mo668a(int i, Object obj) {
        C1341p.m4658b("onPostExecute - start(error)", getClass().getSimpleName());
        this.f297a.mo666a(i, obj, null);
        C1341p.m4658b("onPostExecute - end(error)", getClass().getSimpleName());
    }
}
