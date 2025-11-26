package com.sec.vip.amschaton;

import android.view.View;

/* renamed from: com.sec.vip.amschaton.ag */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC0633ag implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ TextInputDialog f4243a;

    /* renamed from: b */
    final /* synthetic */ AMSPlayerActivity f4244b;

    ViewOnFocusChangeListenerC0633ag(AMSPlayerActivity aMSPlayerActivity, TextInputDialog textInputDialog) {
        this.f4244b = aMSPlayerActivity;
        this.f4243a = textInputDialog;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f4243a.getWindow().setSoftInputMode(5);
        }
    }
}
