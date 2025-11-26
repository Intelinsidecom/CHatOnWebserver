package com.sec.vip.amschaton;

import android.view.View;

/* compiled from: AMSToolTextPopup.java */
/* renamed from: com.sec.vip.amschaton.az */
/* loaded from: classes.dex */
class ViewOnClickListenerC1866az implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1862av f6838a;

    ViewOnClickListenerC1866az(C1862av c1862av) {
        this.f6838a = c1862av;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < 5; i++) {
            if (this.f6838a.f6824g[i] == view) {
                this.f6838a.m6462a(i);
                this.f6838a.f6816e.mo6436d_();
                return;
            }
        }
    }
}
