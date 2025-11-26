package com.sec.chaton.trunk;

import android.text.TextUtils;

/* compiled from: TrunkCommentPresenter.java */
/* renamed from: com.sec.chaton.trunk.aa */
/* loaded from: classes.dex */
class C4576aa implements InterfaceC4671e {

    /* renamed from: a */
    final /* synthetic */ C4691y f16686a;

    C4576aa(C4691y c4691y) {
        this.f16686a = c4691y;
    }

    @Override // com.sec.chaton.trunk.InterfaceC4671e
    /* renamed from: a */
    public void mo17531a(String str) {
        TrunkDetailActivity trunkDetailActivity;
        if (this.f16686a.f16962h != null) {
            this.f16686a.f16962h.cancel(true);
        }
        if (TextUtils.isEmpty(this.f16686a.f16961g) && (trunkDetailActivity = (TrunkDetailActivity) this.f16686a.f16959e) != null) {
            this.f16686a.f16961g = trunkDetailActivity.f16459n;
        }
        this.f16686a.f16962h = this.f16686a.f16963i.m17520a(this.f16686a.f16960f, this.f16686a.f16961g, str);
    }
}
