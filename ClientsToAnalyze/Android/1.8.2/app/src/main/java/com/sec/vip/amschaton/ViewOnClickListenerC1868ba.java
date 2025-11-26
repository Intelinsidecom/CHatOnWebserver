package com.sec.vip.amschaton;

import android.view.View;

/* compiled from: AMSToolTextPopup.java */
/* renamed from: com.sec.vip.amschaton.ba */
/* loaded from: classes.dex */
class ViewOnClickListenerC1868ba implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1862av f6840a;

    ViewOnClickListenerC1868ba(C1862av c1862av) {
        this.f6840a = c1862av;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < 15; i++) {
            if (this.f6840a.f6826i[i] == view) {
                this.f6840a.m6453b(this.f6840a.m6457d(this.f6840a.f6825h), false);
                this.f6840a.m6464b(this.f6840a.m6443e().getResources().getColor(this.f6840a.f6829l[i]));
                this.f6840a.f6816e.mo6436d_();
                return;
            }
        }
    }
}
