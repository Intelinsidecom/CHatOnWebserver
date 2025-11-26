package com.sec.chaton.poston;

import android.view.View;

/* compiled from: PostONContentsAdapter.java */
/* renamed from: com.sec.chaton.poston.t */
/* loaded from: classes.dex */
class ViewOnClickListenerC3025t implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f11210a;

    /* renamed from: b */
    final /* synthetic */ C3023r f11211b;

    ViewOnClickListenerC3025t(C3023r c3023r, int i) {
        this.f11211b = c3023r;
        this.f11210a = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f11211b.f11201a != null) {
            this.f11211b.f11201a.mo12348b(this.f11210a);
        }
    }
}
