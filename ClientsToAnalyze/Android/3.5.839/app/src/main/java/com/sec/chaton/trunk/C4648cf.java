package com.sec.chaton.trunk;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.trunk.p118a.EnumC4575b;
import java.util.concurrent.Future;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.cf */
/* loaded from: classes.dex */
class C4648cf implements InterfaceC4682p {

    /* renamed from: a */
    final /* synthetic */ C4646cd f16859a;

    C4648cf(C4646cd c4646cd) {
        this.f16859a = c4646cd;
    }

    @Override // com.sec.chaton.trunk.InterfaceC4682p
    /* renamed from: a */
    public Future<C0778b> mo17638a(boolean z, EnumC4575b enumC4575b, int i, int i2) {
        if (this.f16859a.f16854n != null) {
            this.f16859a.f16854n.m350q();
        }
        if (this.f16859a.f16850j != null) {
            this.f16859a.f16850j.cancel(true);
        }
        if (enumC4575b != this.f16859a.f16846f) {
            this.f16859a.f16848h = true;
        }
        this.f16859a.f16850j = this.f16859a.f16849i.m17524a(z, this.f16859a.f16847g, i, enumC4575b, i2);
        return this.f16859a.f16850j;
    }
}
