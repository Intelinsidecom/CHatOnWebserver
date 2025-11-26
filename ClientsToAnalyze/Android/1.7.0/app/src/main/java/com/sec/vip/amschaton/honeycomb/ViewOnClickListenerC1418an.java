package com.sec.vip.amschaton.honeycomb;

import android.app.Dialog;
import android.view.View;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.an */
/* loaded from: classes.dex */
class ViewOnClickListenerC1418an implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Dialog f5049a;

    /* renamed from: b */
    final /* synthetic */ AMSPlayerActivity f5050b;

    ViewOnClickListenerC1418an(AMSPlayerActivity aMSPlayerActivity, Dialog dialog) {
        this.f5050b = aMSPlayerActivity;
        this.f5049a = dialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5050b.f4990C = !this.f5050b.f4991D;
        this.f5049a.dismiss();
    }
}
