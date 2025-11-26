package com.sec.vip.amschaton;

import android.view.View;

/* compiled from: AMSToolPenPopup.java */
/* renamed from: com.sec.vip.amschaton.as */
/* loaded from: classes.dex */
class ViewOnClickListenerC3417as implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3412an f12519a;

    ViewOnClickListenerC3417as(C3412an c3412an) {
        this.f12519a = c3412an;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < 4; i++) {
            if (this.f12519a.f12501h[i].equals(view)) {
                this.f12519a.m12227a(i);
                this.f12519a.f12527e.mo12235b();
                return;
            }
        }
    }
}
