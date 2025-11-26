package com.sec.chaton.trunk;

import com.sec.chaton.p046a.p047a.C0778b;
import java.util.List;
import java.util.concurrent.Future;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.ch */
/* loaded from: classes.dex */
class C4650ch implements InterfaceC4681o {

    /* renamed from: a */
    final /* synthetic */ C4646cd f16861a;

    C4650ch(C4646cd c4646cd) {
        this.f16861a = c4646cd;
    }

    @Override // com.sec.chaton.trunk.InterfaceC4681o
    /* renamed from: a */
    public Future<C0778b> mo17640a(List<String> list, String str) {
        if (this.f16861a.f16851k != null) {
            this.f16861a.f16851k.cancel(true);
        }
        this.f16861a.f16851k = this.f16861a.f16849i.m17523a(list, str);
        return this.f16861a.f16851k;
    }
}
