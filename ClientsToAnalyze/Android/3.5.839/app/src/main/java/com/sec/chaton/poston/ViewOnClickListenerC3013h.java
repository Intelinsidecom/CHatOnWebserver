package com.sec.chaton.poston;

import android.view.View;

/* compiled from: PostONAdapter.java */
/* renamed from: com.sec.chaton.poston.h */
/* loaded from: classes.dex */
class ViewOnClickListenerC3013h implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f11150a;

    /* renamed from: b */
    final /* synthetic */ C3009d f11151b;

    ViewOnClickListenerC3013h(C3009d c3009d, int i) {
        this.f11151b = c3009d;
        this.f11150a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11151b.f11137a != null) {
            this.f11151b.f11137a.mo6856a(((C3016k) this.f11151b.f11140i.get(this.f11150a)).m12368c(), ((C3016k) this.f11151b.f11140i.get(this.f11150a)).m12369d());
        }
    }
}
