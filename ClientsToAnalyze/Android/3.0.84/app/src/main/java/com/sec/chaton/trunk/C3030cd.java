package com.sec.chaton.trunk;

import com.sec.chaton.p025d.p026a.AbstractC1145a;
import java.util.List;

/* compiled from: TrunkPresenter.java */
/* renamed from: com.sec.chaton.trunk.cd */
/* loaded from: classes.dex */
class C3030cd implements InterfaceC3061o {

    /* renamed from: a */
    final /* synthetic */ C3018bz f10911a;

    C3030cd(C3018bz c3018bz) {
        this.f10911a = c3018bz;
    }

    @Override // com.sec.chaton.trunk.InterfaceC3061o
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractC1145a mo10545a(List<String> list, String str) {
        if (this.f10911a.f10888k != null) {
            this.f10911a.f10888k.m5493c();
        }
        this.f10911a.f10888k = this.f10911a.f10886i.m10428a(list, str);
        return this.f10911a.f10888k;
    }
}
