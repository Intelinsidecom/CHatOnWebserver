package com.sec.chaton.poston;

import android.view.View;

/* compiled from: PostONAdapter.java */
/* renamed from: com.sec.chaton.poston.e */
/* loaded from: classes.dex */
class ViewOnClickListenerC3010e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f11145a;

    /* renamed from: b */
    final /* synthetic */ C3009d f11146b;

    ViewOnClickListenerC3010e(C3009d c3009d, int i) {
        this.f11146b = c3009d;
        this.f11145a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11146b.f11137a != null && !this.f11146b.f11140i.isEmpty() && this.f11145a > -1 && this.f11145a < this.f11146b.f11140i.size()) {
            this.f11146b.f11137a.mo6854a((C3016k) this.f11146b.f11140i.get(this.f11145a));
        }
    }
}
