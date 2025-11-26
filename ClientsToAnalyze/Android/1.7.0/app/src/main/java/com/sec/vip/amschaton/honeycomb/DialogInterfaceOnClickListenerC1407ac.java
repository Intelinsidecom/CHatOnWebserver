package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.ac */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1407ac implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f5035a;

    DialogInterfaceOnClickListenerC1407ac(AMSComposerActivity aMSComposerActivity) {
        this.f5035a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5035a.m5085i();
        dialogInterface.dismiss();
        this.f5035a.m5082h();
    }
}
