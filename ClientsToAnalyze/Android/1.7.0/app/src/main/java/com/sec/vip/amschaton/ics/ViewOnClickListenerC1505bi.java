package com.sec.vip.amschaton.ics;

import android.app.Dialog;
import android.view.View;

/* compiled from: AMSPlayerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.bi */
/* loaded from: classes.dex */
class ViewOnClickListenerC1505bi implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Dialog f5327a;

    /* renamed from: b */
    final /* synthetic */ AMSPlayerActivity f5328b;

    ViewOnClickListenerC1505bi(AMSPlayerActivity aMSPlayerActivity, Dialog dialog) {
        this.f5328b = aMSPlayerActivity;
        this.f5327a = dialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5328b.f5236C = !this.f5328b.f5237D;
        this.f5327a.dismiss();
    }
}
