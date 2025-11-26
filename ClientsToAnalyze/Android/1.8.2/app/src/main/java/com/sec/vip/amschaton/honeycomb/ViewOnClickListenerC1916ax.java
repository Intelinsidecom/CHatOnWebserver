package com.sec.vip.amschaton.honeycomb;

import android.app.Dialog;
import android.view.View;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.ax */
/* loaded from: classes.dex */
class ViewOnClickListenerC1916ax implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Dialog f7053a;

    /* renamed from: b */
    final /* synthetic */ AMSPlayerActivity f7054b;

    ViewOnClickListenerC1916ax(AMSPlayerActivity aMSPlayerActivity, Dialog dialog) {
        this.f7054b = aMSPlayerActivity;
        this.f7053a = dialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f7054b.f6977E = !this.f7054b.f6978F;
        this.f7053a.dismiss();
    }
}
