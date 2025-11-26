package com.sec.chaton.poston;

import android.view.View;

/* compiled from: PostONAdapter.java */
/* renamed from: com.sec.chaton.poston.f */
/* loaded from: classes.dex */
class ViewOnClickListenerC3011f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f11147a;

    /* renamed from: b */
    final /* synthetic */ C3009d f11148b;

    ViewOnClickListenerC3011f(C3009d c3009d, int i) {
        this.f11148b = c3009d;
        this.f11147a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11148b.f11137a != null) {
            this.f11148b.f11137a.mo6855a(((C3016k) this.f11148b.f11140i.get(this.f11147a)).m12366a(0));
        }
    }
}
