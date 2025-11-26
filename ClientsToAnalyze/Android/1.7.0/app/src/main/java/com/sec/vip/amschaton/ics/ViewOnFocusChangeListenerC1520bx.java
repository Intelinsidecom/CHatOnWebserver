package com.sec.vip.amschaton.ics;

import android.view.View;
import com.sec.vip.amschaton.DialogC1379ap;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bx */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC1520bx implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ DialogC1379ap f5347a;

    /* renamed from: b */
    final /* synthetic */ AMSPlayerActivity f5348b;

    ViewOnFocusChangeListenerC1520bx(AMSPlayerActivity aMSPlayerActivity, DialogC1379ap dialogC1379ap) {
        this.f5348b = aMSPlayerActivity;
        this.f5347a = dialogC1379ap;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f5347a.getWindow().setSoftInputMode(5);
        }
    }
}
