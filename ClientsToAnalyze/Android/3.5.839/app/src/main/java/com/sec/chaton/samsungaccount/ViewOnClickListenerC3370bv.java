package com.sec.chaton.samsungaccount;

import android.view.View;

/* compiled from: SamsungAccountLoginDialog.java */
/* renamed from: com.sec.chaton.samsungaccount.bv */
/* loaded from: classes.dex */
class ViewOnClickListenerC3370bv implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DialogC3368bt f12327a;

    ViewOnClickListenerC3370bv(DialogC3368bt dialogC3368bt) {
        this.f12327a = dialogC3368bt;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f12327a.cancel();
    }
}
