package com.sec.chaton.poston;

import android.view.View;

/* compiled from: PostONContentsAdapter.java */
/* renamed from: com.sec.chaton.poston.s */
/* loaded from: classes.dex */
class ViewOnClickListenerC3024s implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f11208a;

    /* renamed from: b */
    final /* synthetic */ C3023r f11209b;

    ViewOnClickListenerC3024s(C3023r c3023r, int i) {
        this.f11209b = c3023r;
        this.f11208a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11209b.f11201a != null) {
            this.f11209b.f11201a.mo12345a(this.f11208a);
        }
    }
}
