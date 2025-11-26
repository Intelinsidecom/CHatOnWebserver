package com.sec.vip.amschaton;

import android.view.View;

/* compiled from: AMSToolPenPopup.java */
/* renamed from: com.sec.vip.amschaton.aq */
/* loaded from: classes.dex */
class ViewOnClickListenerC1857aq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1851ak f6809a;

    ViewOnClickListenerC1857aq(C1851ak c1851ak) {
        this.f6809a = c1851ak;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < 15; i++) {
            if (this.f6809a.f6795l[i] == view) {
                this.f6809a.m6421c(this.f6809a.m6426f(this.f6809a.f6794k), false);
                this.f6809a.m6433c(this.f6809a.m6443e().getResources().getColor(this.f6809a.f6798o[i]));
                this.f6809a.f6816e.mo6436d_();
                return;
            }
        }
    }
}
