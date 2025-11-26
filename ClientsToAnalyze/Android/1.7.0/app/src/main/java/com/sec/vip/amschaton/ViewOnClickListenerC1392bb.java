package com.sec.vip.amschaton;

import android.view.View;

/* compiled from: AMSToolPenPopup.java */
/* renamed from: com.sec.vip.amschaton.bb */
/* loaded from: classes.dex */
class ViewOnClickListenerC1392bb implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1369af f4885a;

    ViewOnClickListenerC1392bb(C1369af c1369af) {
        this.f4885a = c1369af;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < 4; i++) {
            if (this.f4885a.f4800f[i] == view) {
                this.f4885a.m4919a(i);
                this.f4885a.f5418d.mo4927b();
                return;
            }
        }
    }
}
