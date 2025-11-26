package com.sec.vip.amschaton.honeycomb;

import android.view.View;
import com.sec.vip.amschaton.DialogC1379ap;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.bf */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC1437bf implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ DialogC1379ap f5070a;

    /* renamed from: b */
    final /* synthetic */ AMSPlayerActivity f5071b;

    ViewOnFocusChangeListenerC1437bf(AMSPlayerActivity aMSPlayerActivity, DialogC1379ap dialogC1379ap) {
        this.f5071b = aMSPlayerActivity;
        this.f5070a = dialogC1379ap;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            this.f5070a.getWindow().setSoftInputMode(5);
        }
    }
}
