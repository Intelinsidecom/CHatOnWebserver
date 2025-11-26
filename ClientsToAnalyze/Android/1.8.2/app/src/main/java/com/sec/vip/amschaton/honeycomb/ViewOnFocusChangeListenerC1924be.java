package com.sec.vip.amschaton.honeycomb;

import android.view.View;
import com.sec.vip.amschaton.DialogC1873bf;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.be */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC1924be implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ DialogC1873bf f7062a;

    /* renamed from: b */
    final /* synthetic */ AMSPlayerActivity f7063b;

    ViewOnFocusChangeListenerC1924be(AMSPlayerActivity aMSPlayerActivity, DialogC1873bf dialogC1873bf) {
        this.f7063b = aMSPlayerActivity;
        this.f7062a = dialogC1873bf;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f7062a.getWindow().setSoftInputMode(5);
        }
    }
}
