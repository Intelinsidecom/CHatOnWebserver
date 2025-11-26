package com.sec.chaton.poston;

import android.view.View;

/* compiled from: PostONAdapter.java */
/* renamed from: com.sec.chaton.poston.e */
/* loaded from: classes.dex */
class ViewOnClickListenerC2014e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f7749a;

    /* renamed from: b */
    final /* synthetic */ C2013d f7750b;

    ViewOnClickListenerC2014e(C2013d c2013d, int i) {
        this.f7750b = c2013d;
        this.f7749a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f7750b.f7741a != null && !this.f7750b.f7744i.isEmpty() && this.f7749a > -1 && this.f7749a < this.f7750b.f7744i.size()) {
            this.f7750b.f7741a.mo3715a((C2020k) this.f7750b.f7744i.get(this.f7749a));
        }
    }
}
