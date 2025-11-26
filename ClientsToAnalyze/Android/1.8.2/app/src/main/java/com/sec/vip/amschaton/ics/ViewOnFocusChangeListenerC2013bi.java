package com.sec.vip.amschaton.ics;

import android.view.View;
import com.sec.vip.amschaton.DialogC1873bf;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bi */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC2013bi implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ DialogC1873bf f7295a;

    /* renamed from: b */
    final /* synthetic */ AMSPlayerActivity f7296b;

    ViewOnFocusChangeListenerC2013bi(AMSPlayerActivity aMSPlayerActivity, DialogC1873bf dialogC1873bf) {
        this.f7296b = aMSPlayerActivity;
        this.f7295a = dialogC1873bf;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f7295a.getWindow().setSoftInputMode(5);
        }
    }
}
