package com.sec.vip.amschaton;

import android.view.View;

/* compiled from: AMSToolPenPopup.java */
/* renamed from: com.sec.vip.amschaton.ap */
/* loaded from: classes.dex */
class ViewOnClickListenerC1856ap implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1851ak f6808a;

    ViewOnClickListenerC1856ap(C1851ak c1851ak) {
        this.f6808a = c1851ak;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < 4; i++) {
            if (this.f6808a.f6790g[i] == view) {
                this.f6808a.m6429a(i);
                this.f6808a.f6816e.mo6436d_();
                return;
            }
        }
    }
}
