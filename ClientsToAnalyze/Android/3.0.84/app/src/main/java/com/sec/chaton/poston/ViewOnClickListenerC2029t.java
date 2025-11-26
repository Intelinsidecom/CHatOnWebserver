package com.sec.chaton.poston;

import android.view.View;

/* compiled from: PostONContentsAdapter.java */
/* renamed from: com.sec.chaton.poston.t */
/* loaded from: classes.dex */
class ViewOnClickListenerC2029t implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f7812a;

    /* renamed from: b */
    final /* synthetic */ C2027r f7813b;

    ViewOnClickListenerC2029t(C2027r c2027r, int i) {
        this.f7813b = c2027r;
        this.f7812a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f7813b.f7803a != null) {
            this.f7813b.f7803a.mo8028b(this.f7812a);
        }
    }
}
