package com.sec.vip.amschaton.ics;

import android.app.Dialog;
import android.view.View;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ay */
/* loaded from: classes.dex */
class ViewOnClickListenerC2002ay implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Dialog f7283a;

    /* renamed from: b */
    final /* synthetic */ AMSPlayerActivity f7284b;

    ViewOnClickListenerC2002ay(AMSPlayerActivity aMSPlayerActivity, Dialog dialog) {
        this.f7284b = aMSPlayerActivity;
        this.f7283a = dialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f7284b.f7207E = !this.f7284b.f7208F;
        this.f7283a.dismiss();
    }
}
