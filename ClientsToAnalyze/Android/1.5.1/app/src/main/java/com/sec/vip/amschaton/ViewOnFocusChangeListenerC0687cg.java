package com.sec.vip.amschaton;

import android.view.View;

/* renamed from: com.sec.vip.amschaton.cg */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC0687cg implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ TextInputDialog f4308a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f4309b;

    ViewOnFocusChangeListenerC0687cg(AMSComposerActivity aMSComposerActivity, TextInputDialog textInputDialog) {
        this.f4309b = aMSComposerActivity;
        this.f4308a = textInputDialog;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f4308a.getWindow().setSoftInputMode(5);
        }
    }
}
