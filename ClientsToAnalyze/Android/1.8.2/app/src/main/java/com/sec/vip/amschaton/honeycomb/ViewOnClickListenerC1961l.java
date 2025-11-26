package com.sec.vip.amschaton.honeycomb;

import android.view.View;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.l */
/* loaded from: classes.dex */
class ViewOnClickListenerC1961l implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7108a;

    ViewOnClickListenerC1961l(AMSComposerActivity aMSComposerActivity) {
        this.f7108a = aMSComposerActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f7108a.f6924M) {
            this.f7108a.m6601e(false);
            if (this.f7108a.f6927P != null) {
                this.f7108a.f6927P.m6496c();
                return;
            }
            return;
        }
        if (!this.f7108a.f6932U || !this.f7108a.f6914C.m6327t()) {
            AMSComposerActivity.f6910l = false;
        }
        this.f7108a.m6607g();
    }
}
