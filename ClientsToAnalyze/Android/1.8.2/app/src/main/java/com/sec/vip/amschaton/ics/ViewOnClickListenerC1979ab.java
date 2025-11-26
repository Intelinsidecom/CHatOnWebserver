package com.sec.vip.amschaton.ics;

import android.view.View;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ab */
/* loaded from: classes.dex */
class ViewOnClickListenerC1979ab implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7247a;

    ViewOnClickListenerC1979ab(AMSComposerActivity aMSComposerActivity) {
        this.f7247a = aMSComposerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f7247a.f7161V != null) {
            this.f7247a.f7161V.mo6436d_();
            this.f7247a.m6958j(false);
        }
    }
}
