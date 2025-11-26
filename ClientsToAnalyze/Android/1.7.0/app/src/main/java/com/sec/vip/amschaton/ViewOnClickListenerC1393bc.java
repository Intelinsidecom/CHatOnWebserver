package com.sec.vip.amschaton;

import android.view.View;

/* compiled from: AMSToolPenPopup.java */
/* renamed from: com.sec.vip.amschaton.bc */
/* loaded from: classes.dex */
class ViewOnClickListenerC1393bc implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1369af f4886a;

    ViewOnClickListenerC1393bc(C1369af c1369af) {
        this.f4886a = c1369af;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < 15; i++) {
            if (this.f4886a.f4805k[i] == view) {
                this.f4886a.m4911c(this.f4886a.m4915e(this.f4886a.f4804j), false);
                this.f4886a.m4921c(this.f4886a.m5646a().getResources().getColor(this.f4886a.f4808n[i]));
                this.f4886a.f5418d.mo4927b();
                return;
            }
        }
    }
}
