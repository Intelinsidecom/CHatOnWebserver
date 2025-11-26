package com.sec.vip.amschaton;

import android.view.View;

/* compiled from: AMSToolPenPopup.java */
/* renamed from: com.sec.vip.amschaton.at */
/* loaded from: classes.dex */
class ViewOnClickListenerC3418at implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3412an f12520a;

    ViewOnClickListenerC3418at(C3412an c3412an) {
        this.f12520a = c3412an;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < 15; i++) {
            if (this.f12520a.f12506m[i].equals(view)) {
                this.f12520a.m12219c(this.f12520a.m12224f(this.f12520a.f12505l), false);
                this.f12520a.m12231c(this.f12520a.m12242e().getResources().getColor(this.f12520a.f12509p[i]));
                this.f12520a.f12527e.mo12235b();
                return;
            }
        }
    }
}
