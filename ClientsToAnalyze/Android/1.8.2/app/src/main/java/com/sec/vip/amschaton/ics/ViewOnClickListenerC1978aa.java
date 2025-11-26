package com.sec.vip.amschaton.ics;

import android.view.View;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.aa */
/* loaded from: classes.dex */
class ViewOnClickListenerC1978aa implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7246a;

    ViewOnClickListenerC1978aa(AMSComposerActivity aMSComposerActivity) {
        this.f7246a = aMSComposerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f7246a.f7178am.setButtonEnabled(true);
        if (this.f7246a.f7161V != null) {
            this.f7246a.f7161V.mo6437e_();
        }
    }
}
