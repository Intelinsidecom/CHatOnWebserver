package com.sec.chaton.poston;

import android.view.View;

/* compiled from: PostONAdapter.java */
/* renamed from: com.sec.chaton.poston.f */
/* loaded from: classes.dex */
class ViewOnClickListenerC2015f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f7751a;

    /* renamed from: b */
    final /* synthetic */ C2013d f7752b;

    ViewOnClickListenerC2015f(C2013d c2013d, int i) {
        this.f7752b = c2013d;
        this.f7751a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f7752b.f7741a != null) {
            this.f7752b.f7741a.mo3716a(((C2020k) this.f7752b.f7744i.get(this.f7751a)).m8046a(0));
        }
    }
}
