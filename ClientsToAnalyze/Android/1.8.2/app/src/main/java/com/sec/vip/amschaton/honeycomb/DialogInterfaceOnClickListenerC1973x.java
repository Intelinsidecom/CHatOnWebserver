package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.x */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1973x implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f7123a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f7124b;

    DialogInterfaceOnClickListenerC1973x(AMSComposerActivity aMSComposerActivity, int i) {
        this.f7124b = aMSComposerActivity;
        this.f7123a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7124b.m6625j();
        dialogInterface.dismiss();
        this.f7124b.m6608g(this.f7123a);
    }
}
