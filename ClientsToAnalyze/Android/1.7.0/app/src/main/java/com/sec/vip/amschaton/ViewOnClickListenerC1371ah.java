package com.sec.vip.amschaton;

import android.view.View;

/* compiled from: AMSToolTextPopup.java */
/* renamed from: com.sec.vip.amschaton.ah */
/* loaded from: classes.dex */
class ViewOnClickListenerC1371ah implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C1395be f4815a;

    ViewOnClickListenerC1371ah(C1395be c1395be) {
        this.f4815a = c1395be;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        for (int i = 0; i < 5; i++) {
            if (this.f4815a.f4889f[i] == view) {
                this.f4815a.m4999a(i);
                this.f4815a.f5418d.mo4927b();
                return;
            }
        }
    }
}
