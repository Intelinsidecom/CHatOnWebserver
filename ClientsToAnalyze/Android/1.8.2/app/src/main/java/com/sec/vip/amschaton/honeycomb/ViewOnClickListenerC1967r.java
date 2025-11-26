package com.sec.vip.amschaton.honeycomb;

import android.view.View;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.r */
/* loaded from: classes.dex */
class ViewOnClickListenerC1967r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7114a;

    ViewOnClickListenerC1967r(AMSComposerActivity aMSComposerActivity) {
        this.f7114a = aMSComposerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f7114a.f6925N != null) {
            this.f7114a.f6925N.mo6436d_();
            this.f7114a.m6630k(false);
        }
    }
}
