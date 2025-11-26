package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.u */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1462u implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f5109a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f5110b;

    DialogInterfaceOnClickListenerC1462u(AMSComposerActivity aMSComposerActivity, int i) {
        this.f5110b = aMSComposerActivity;
        this.f5109a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5110b.m5085i();
        dialogInterface.dismiss();
        this.f5110b.m5072f(this.f5109a);
    }
}
