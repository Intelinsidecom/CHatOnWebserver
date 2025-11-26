package com.sec.chaton.trunk;

import android.text.TextUtils;

/* compiled from: TrunkCommentPresenter.java */
/* renamed from: com.sec.chaton.trunk.aa */
/* loaded from: classes.dex */
class C2960aa implements InterfaceC3051e {

    /* renamed from: a */
    final /* synthetic */ C3071y f10740a;

    C2960aa(C3071y c3071y) {
        this.f10740a = c3071y;
    }

    @Override // com.sec.chaton.trunk.InterfaceC3051e
    /* renamed from: a */
    public void mo10435a(String str) {
        TrunkDetailActivity trunkDetailActivity;
        if (this.f10740a.f11013h != null) {
            this.f10740a.f11013h.m5493c();
        }
        if (TextUtils.isEmpty(this.f10740a.f11012g) && (trunkDetailActivity = (TrunkDetailActivity) this.f10740a.f11010e) != null) {
            this.f10740a.f11012g = trunkDetailActivity.f10518a;
        }
        this.f10740a.f11013h = this.f10740a.f11014i.m10420a(this.f10740a.f11011f, this.f10740a.f11012g, str);
    }
}
