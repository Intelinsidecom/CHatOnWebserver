package com.sec.chaton.userprofile;

import android.view.View;

/* compiled from: CoverStorySampleAdapter.java */
/* renamed from: com.sec.chaton.userprofile.n */
/* loaded from: classes.dex */
class ViewOnClickListenerC3145n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f11407a;

    /* renamed from: b */
    final /* synthetic */ C3144m f11408b;

    ViewOnClickListenerC3145n(C3144m c3144m, int i) {
        this.f11408b = c3144m;
        this.f11407a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11408b.f11406g != null && !this.f11408b.f11400a.isEmpty() && this.f11407a > -1 && this.f11407a < this.f11408b.f11400a.size()) {
            this.f11408b.f11406g.mo10663a((C3147p) this.f11408b.f11400a.get(this.f11407a));
        }
    }
}
