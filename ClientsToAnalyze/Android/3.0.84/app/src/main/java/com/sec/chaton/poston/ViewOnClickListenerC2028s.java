package com.sec.chaton.poston;

import android.view.View;

/* compiled from: PostONContentsAdapter.java */
/* renamed from: com.sec.chaton.poston.s */
/* loaded from: classes.dex */
class ViewOnClickListenerC2028s implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f7810a;

    /* renamed from: b */
    final /* synthetic */ C2027r f7811b;

    ViewOnClickListenerC2028s(C2027r c2027r, int i) {
        this.f7811b = c2027r;
        this.f7810a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f7811b.f7803a != null) {
            this.f7811b.f7803a.mo8025a(this.f7810a);
        }
    }
}
