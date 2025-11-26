package com.sec.vip.amschaton.fragment;

import android.app.Dialog;
import android.view.View;

/* compiled from: AMSViewerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.dp */
/* loaded from: classes.dex */
class ViewOnClickListenerC3549dp implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ Dialog f12978a;

    /* renamed from: b */
    final /* synthetic */ AMSViewerFragment f12979b;

    ViewOnClickListenerC3549dp(AMSViewerFragment aMSViewerFragment, Dialog dialog) {
        this.f12979b = aMSViewerFragment;
        this.f12978a = dialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f12979b.f12788U = !this.f12979b.f12790W;
        this.f12978a.dismiss();
    }
}
