package com.sec.chaton.trunk;

import com.sec.chaton.p046a.p047a.C0778b;
import com.sec.chaton.trunk.p118a.EnumC4575b;
import java.util.concurrent.Future;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.cg */
/* loaded from: classes.dex */
class C4649cg implements InterfaceC4680n {

    /* renamed from: a */
    final /* synthetic */ C4646cd f16860a;

    C4649cg(C4646cd c4646cd) {
        this.f16860a = c4646cd;
    }

    @Override // com.sec.chaton.trunk.InterfaceC4680n
    /* renamed from: a */
    public Future<C0778b> mo17639a(EnumC4575b enumC4575b, int i, int i2, String str) {
        if (this.f16860a.f16854n != null) {
            this.f16860a.f16854n.m350q();
        }
        if (this.f16860a.f16850j != null) {
            this.f16860a.f16850j.cancel(true);
        }
        this.f16860a.f16850j = this.f16860a.f16849i.m17525a(false, this.f16860a.f16847g, i, enumC4575b, i2, str);
        return this.f16860a.f16850j;
    }
}
