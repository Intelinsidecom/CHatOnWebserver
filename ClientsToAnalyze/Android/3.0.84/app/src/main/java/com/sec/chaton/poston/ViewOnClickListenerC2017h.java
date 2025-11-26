package com.sec.chaton.poston;

import android.view.View;

/* compiled from: PostONAdapter.java */
/* renamed from: com.sec.chaton.poston.h */
/* loaded from: classes.dex */
class ViewOnClickListenerC2017h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f7754a;

    /* renamed from: b */
    final /* synthetic */ C2013d f7755b;

    ViewOnClickListenerC2017h(C2013d c2013d, int i) {
        this.f7755b = c2013d;
        this.f7754a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f7755b.f7741a != null) {
            this.f7755b.f7741a.mo3717a(((C2020k) this.f7755b.f7744i.get(this.f7754a)).m8048c(), ((C2020k) this.f7755b.f7744i.get(this.f7754a)).m8049d());
        }
    }
}
