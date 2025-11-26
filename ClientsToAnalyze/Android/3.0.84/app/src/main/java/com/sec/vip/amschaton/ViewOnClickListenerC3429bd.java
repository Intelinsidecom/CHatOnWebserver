package com.sec.vip.amschaton;

import android.view.View;

/* compiled from: AMSToolTextPopup.java */
/* renamed from: com.sec.vip.amschaton.bd */
/* loaded from: classes.dex */
class ViewOnClickListenerC3429bd implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C3424az f12562a;

    ViewOnClickListenerC3429bd(C3424az c3424az) {
        this.f12562a = c3424az;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < 5; i++) {
            if (this.f12562a.f12538h[i].equals(view)) {
                this.f12562a.m12263a(i);
                this.f12562a.f12527e.mo12235b();
                return;
            }
        }
    }
}
