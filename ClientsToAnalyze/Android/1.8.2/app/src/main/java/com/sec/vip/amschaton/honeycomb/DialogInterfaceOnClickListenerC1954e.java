package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.e */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1954e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7101a;

    DialogInterfaceOnClickListenerC1954e(AMSComposerActivity aMSComposerActivity) {
        this.f7101a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7101a.m6625j();
        this.f7101a.f6934W = true;
        dialogInterface.dismiss();
        this.f7101a.m6615h();
    }
}
